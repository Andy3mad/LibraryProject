package edu.mum.library.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.mum.library.service.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class LoginController extends BaseFxModalController {

	@FXML
	private TextField username;

	@FXML
	private PasswordField password;

	@Autowired
	private LoginService loginService;
	private boolean isLogin = false;

	public void login() {
		// empty check
		isLogin = loginService.login(username.getText(), password.getText());
		if (isLogin) {
			this.getCurrentStage().close();
		}
		else{
			fxViewManager.showError(this.getCurrentStage(), "username and/or password incorrect",
					"Error", "Login Error");
		}
	}

	@Override
	public boolean isOkClicked() {
		return isLogin;
	}
}
