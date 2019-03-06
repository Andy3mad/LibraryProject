package edu.mum.library.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.mum.library.model.AuthorizationLevel;
import edu.mum.library.service.SessionManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class RootController extends BaseFxController {

	@FXML
	private Menu adminMenu;
	@FXML
	private Menu librarianMenu;

	@FXML
	void logout() {
		adminMenu.setVisible(true);
		librarianMenu.setVisible(true);

		sessionManager.logout();
		if(libraryUiManager.showLoginDialog())
		{
			menuInit();
		}
	}

	@FXML
	void shutdown() {
		Platform.exit();
	}

	@Autowired
	private SessionManager sessionManager;

	@Autowired
	private LibraryUiManager libraryUiManager;

	public void menuInit() {
		AuthorizationLevel authorizationLevel = sessionManager.getLoginUser().getAuthorizationLevel();
		if (authorizationLevel == AuthorizationLevel.ADMIN) {
			librarianMenu.setVisible(false);
		} else if (authorizationLevel == AuthorizationLevel.LIBRARIAN) {
			adminMenu.setVisible(false);
		}
	}

	public void showMemberUi(){
		AnchorPane personOverview = this.application.importLayout("/edu/mum/library/view/MemberOverview.fxml");

		// Set person overview into the center of root layout.
		((BorderPane)this.getCurrentStage().getScene().getRoot()).setCenter(personOverview);
	}
}
