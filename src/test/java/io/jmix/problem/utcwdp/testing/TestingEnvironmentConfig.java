package io.jmix.problem.utcwdp.testing;

import io.jmix.problem.utcwdp.app.EnvironmentInformation;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@TestConfiguration
public class TestingEnvironmentConfig {

    @Bean
    @Primary
    public EnvironmentInformation environmentInformation() {
        return new TestingEnvironment();
    }
}
