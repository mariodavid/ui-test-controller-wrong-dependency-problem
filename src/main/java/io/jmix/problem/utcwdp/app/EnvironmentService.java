package io.jmix.problem.utcwdp.app;

import org.springframework.stereotype.Component;

@Component
public class EnvironmentService {

  private final EnvironmentInformation environmentInformation;

  public EnvironmentService(EnvironmentInformation environmentInformation) {
    this.environmentInformation = environmentInformation;
  }

  public boolean isEnvironment(Environment environment) {
      return environmentInformation.getEnvironment().equals(environment);
  }

  public Environment getEnvironment() {
    return environmentInformation.getEnvironment();
  }
}
