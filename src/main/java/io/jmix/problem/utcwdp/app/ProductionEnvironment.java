package io.jmix.problem.utcwdp.app;

public class ProductionEnvironment implements EnvironmentInformation {

  @Override
  public Environment getEnvironment() {
    return Environment.PRODUCTION;
  }
}
