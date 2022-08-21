package io.jmix.problem.utcwdp.ui_test;

import static org.assertj.core.api.Assertions.assertThat;

import io.jmix.problem.utcwdp.app.Environment;
import io.jmix.problem.utcwdp.screen.environment.EnvironmentScreen;
import io.jmix.problem.utcwdp.testing.TestingEnvironmentConfig;
import io.jmix.problem.utcwdp.testing.TestingEnvironment;
import io.jmix.problem.utcwdp.Application;
import io.jmix.problem.utcwdp.app.EnvironmentInformation;
import io.jmix.problem.utcwdp.screen.main.MainScreen;
import io.jmix.ui.Screens;
import io.jmix.ui.testassist.UiTestAssistConfiguration;
import io.jmix.ui.testassist.junit.UiTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@UiTest(mainScreenId = "MainScreen", screenBasePackages = "io.jmix.problem.utcwdp.screen.main")
@ContextConfiguration(classes = {
    Application.class,
    UiTestAssistConfiguration.class,
    TestingEnvironmentConfig.class
})
class TestingEnvironmentUiTest {

  @Autowired
  EnvironmentInformation environmentInformation;


  @Test
  void given_testingEnvironmentConfigured_when_isEnvironmentThroughController_expect_testing(Screens screens) {

    assertThat(environmentInformation)
        .isInstanceOf(TestingEnvironment.class);


    MainScreen screen = (MainScreen) screens.getOpenedScreens().getRootScreen();

    assertThat(screen.getEnvironment())
        .isEqualTo(Environment.TESTING);
  }

  @Test
  void given_differentScreen_and_testingEnvironmentConfigured_when_isEnvironmentThroughController_expect_testing(Screens screens) {

    assertThat(environmentInformation)
        .isInstanceOf(TestingEnvironment.class);

    EnvironmentScreen screen = screens.create(EnvironmentScreen.class);
    screen.show();

    assertThat(screen.getEnvironment())
        .isEqualTo(Environment.TESTING.toString());
  }

}
