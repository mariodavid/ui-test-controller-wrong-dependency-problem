package io.jmix.problem.utcwdp.spring_integration;

import static org.assertj.core.api.Assertions.assertThat;

import io.jmix.problem.utcwdp.Application;
import io.jmix.problem.utcwdp.app.Environment;
import io.jmix.problem.utcwdp.app.EnvironmentInformation;
import io.jmix.problem.utcwdp.app.EnvironmentService;
import io.jmix.problem.utcwdp.testing.TestingEnvironment;
import io.jmix.problem.utcwdp.testing.TestingEnvironmentConfig;
import io.jmix.ui.testassist.UiTestAssistConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {
    Application.class,
    TestingEnvironmentConfig.class
})
class TestingEnvironmentTest {

  @Autowired
  EnvironmentService environmentService;

  @Autowired
  EnvironmentInformation environmentInformation;

  @Test
  void given_testingEnvironmentConfigured_when_isEnvironment_expect_testing() {

    assertThat(environmentInformation)
        .isInstanceOf(TestingEnvironment.class);

    // then:
    assertThat(environmentService.getEnvironment())
        .isEqualTo(Environment.TESTING);
  }

}
