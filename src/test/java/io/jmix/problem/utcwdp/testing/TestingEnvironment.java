package io.jmix.problem.utcwdp.testing;

import io.jmix.problem.utcwdp.app.Environment;
import io.jmix.problem.utcwdp.app.EnvironmentInformation;

public class TestingEnvironment implements EnvironmentInformation {

  @Override
  public Environment getEnvironment() {
    return Environment.TESTING;
  }
}
