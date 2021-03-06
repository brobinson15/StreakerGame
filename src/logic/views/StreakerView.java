package logic.views;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import logic.controllers.ViewFactory;

public abstract class StreakerView {
	
	protected ViewFactory viewController;
	
	
	/* 
	 * The constructor for a class which
	 * extends StreakerView includes a reference
	 * to the ViewController instantiated initially in 
	 * the Client class.
	 */
	public StreakerView(ViewFactory v) {
		viewController = v;
	}
	/*
	 * extending view classes must implement this method.
	 * It creates a new instance of a Scene and 
	 * sets up any necessary elements in the scene 
	 * (e.g. loading from an fxml file, or manually adding
	 * javafx elements) before returning the scene reference.
	 */
	public abstract Scene setupScene();
	
	public void setAnchors(VBox box, double b, double t, double l, double r) {
		AnchorPane.setBottomAnchor(box, b);
		AnchorPane.setTopAnchor(box, t);
		AnchorPane.setLeftAnchor(box, l);
		AnchorPane.setRightAnchor(box, r);
	}
}
