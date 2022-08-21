# Jmix UI Controller Test Wrong Dependency problem

When crating UI Integration tests from Jmix (using `@UiTest`), the controller potentially end up with the wrong dependencies.

## Precondition

Given there is an Interface `EnvironmentInformation`, which has a method `getEnvironment()`.
There is a default implementation `ProductionEnvironment` which is defined as a Spring bean in the main application class:

```java
@SpringBootApplication
public class Application {

  // ...
  
  @Bean
  EnvironmentInformation environmentInformation() {
    return new ProductionEnvironment();
  }

}
```

In the test sources there is another implementation for testing purposes: `TestingEnvironment`. Configured as the bean using the `TestingEnvironmentConfig` class:

```java
@TestConfiguration
public class TestingEnvironmentConfig {

    @Bean
    @Primary
    public EnvironmentInformation environmentInformation() {
        return new TestingEnvironment();
    }
}
```

### Behaviour

When accessing this bean through a Controller in a UI integration test, the bean configuration will not be updated per test. Instead the first running test will determine which bean will be used. The next test that also accesses this bean through a Controller, will receive the originally configured bean, independent which `@ContextConfiguration` is specified for this test case.


### Example

In the `ProductionEnvironmentUiTest` / `TestingEnvironmentUiTest` the `MainScreen` will be used to identify the current environment (via its method `getEnvironment()`). The `MainScreen` has a dependency to the `EnvironmentInformation` bean to delegate the logic to.

When running the both tests, one of them will always fail. Which one depends on the execution order. If the `TestingEnvironmentUiTest` will go first, the `MainScreen` will get the `EnvironmentInformation` dependency injected as `TestingEnvironment`. Therefore the `ProductionEnvironmentUiTest` afterwards fails, since the `MainScreen` will keep the old reference.

If the `ProductionEnvironmentUiTest` it will be the other way around.

### Observations

The behaviour is independent of:

* which actual Controller is used (there are test cases for different screens)

The behaviour only happens when access logic through the Controller:
* the reference to the `EnvironmentInformation` in the test case itself has the correct type. 
* the reference to the `EnvironmentInformation` in the Service Layer has the correct type.

This brings up the conclusion, that this behaviour is only related to the Jmix UI controller logic.
