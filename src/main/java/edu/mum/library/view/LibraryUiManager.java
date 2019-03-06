package edu.mum.library.view;

import org.springframework.stereotype.Component;

import edu.mum.library.modelbb.Person;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

@Component
public class LibraryUiManager extends BaseUI {

	/**
	 * Show a person Dialog
	 *
	 * @param person
	 * @return
	 */
	public boolean showPersonEditDialog(Person person) {

		// Create the dialog Stage.
		Stage dialogStage = new Stage();
		// Load the fxml file and create a new stage for the popup dialog.
		dialogStage.setUserData(person);
		AnchorPane page = this.application.importLayout("/edu/mum/library/view/PersonEditDialog.fxml", dialogStage);

		dialogStage.setTitle("Edit Person");
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(this.application.getPrimaryStage());
		Scene scene = new Scene(page);
		dialogStage.setScene(scene);

		page.setUserData(person);
		dialogStage.setUserData(person);
		// Show the dialog and wait until the user closes it
		dialogStage.showAndWait();
		BaseFxModalController controller = (BaseFxModalController) dialogStage.getUserData();
		return controller.isOkClicked();
	}

	/**
	 * Show a Login Dialog
	 *
	 * @param person
	 * @return
	 */
	public boolean showLoginDialog() {

		// Create the dialog Stage.
		Stage dialogStage = new Stage();
		// Load the fxml file and create a new stage for the popup dialog.
		AnchorPane page = this.application.importLayout("/edu/mum/library/view/LoginDialog.fxml", dialogStage);

		dialogStage.setTitle("Login");
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(this.application.getPrimaryStage());
		Scene scene = new Scene(page);
		dialogStage.setScene(scene);
		// Show the dialog and wait until the user closes it
		dialogStage.showAndWait();
		BaseFxModalController controller = (BaseFxModalController) dialogStage.getUserData();
		return controller.isOkClicked();
	}
}
