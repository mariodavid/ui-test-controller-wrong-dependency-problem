package io.jmix.problem.utcwdp.spring_integration;

import static org.assertj.core.api.Assertions.assertThat;

import io.jmix.problem.utcwdp.Application;
import io.jmix.problem.utcwdp.app.Environment;
import io.jmix.problem.utcwdp.app.EnvironmentInformation;
import io.jmix.problem.utcwdp.app.EnvironmentService;
import io.jmix.problem.utcwdp.app.ProductionEnvironment;
import io.jmix.problem.utcwdp.screen.main.MainScreen;
import io.jmix.problem.utcwdp.testing.TestingEnvironmentConfig;
import io.jmix.ui.Screens;
import io.jmix.ui.testassist.UiTestAssistConfiguration;
import io.jmix.ui.testassist.junit.UiTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {
    Application.class
})
class ProductionEnvironmentTest {

  @Autowired
  EnvironmentService environmentService;

  @Autowired
  EnvironmentInformation environmentInformation;

  @Test
  void given_productionEnvironmentConfigured_when_isEnvironment_expect_production() {

    assertThat(environmentInformation)
        .isInstanceOf(ProductionEnvironment.class);

    // then:
    assertThat(environmentService.getEnvironment())
        .isEqualTo(Environment.PRODUCTION);
  }

}
