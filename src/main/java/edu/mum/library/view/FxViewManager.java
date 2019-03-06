package edu.mum.library.view;

import org.springframework.stereotype.Component;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

@Component
public class FxViewManager extends BaseUI {

	public void showError(Stage stage, String errorMessage, String title, String headerText){
		Alert alert = new Alert(AlertType.ERROR);
		alert.initOwner(stage);
//		alert.setTitle("Invalid Fields");
//		alert.setHeaderText("Please correct invalid fields");
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(errorMessage);

		alert.showAndWait();
	}
}
