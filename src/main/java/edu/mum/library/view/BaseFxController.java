package edu.mum.library.view;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.stage.Stage;

public abstract class BaseFxController extends BaseUI {

	@Autowired
	protected FxViewManager fxViewManager;

	protected Stage currentStage;

	public Stage getCurrentStage() {
		return currentStage;
	}

	public void setCurrentStage(Stage currentStage) {
		this.currentStage = currentStage;
	}

	protected Object closeResult;

	public Object getCloseResult() {
		return closeResult;
	}

	public void setCloseResult(Object closeResult) {
		this.closeResult = closeResult;
	}

	public void windowClose() {

		this.getCurrentStage().setUserData(this);

	}

	public void postInit() {

	}
}
