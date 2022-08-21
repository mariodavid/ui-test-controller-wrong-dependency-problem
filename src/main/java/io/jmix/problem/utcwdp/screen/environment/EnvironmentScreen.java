package io.jmix.problem.utcwdp.screen.environment;

import io.jmix.problem.utcwdp.app.EnvironmentInformation;
import io.jmix.ui.component.Label;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("EnvironmentScreen")
@UiDescriptor("environment-screen.xml")
public class EnvironmentScreen extends Screen {

  @Autowired
  private Label<String> currentEnvironment;

  @Autowired
  EnvironmentInformation environmentInformation;

  @Subscribe
  public void onAfterShow(AfterShowEvent event) {
    currentEnvironment.setValue(environmentInformation.getEnvironment().toString());
  }


  public String getEnvironment() {
    return currentEnvironment.getValue();
  }

}
