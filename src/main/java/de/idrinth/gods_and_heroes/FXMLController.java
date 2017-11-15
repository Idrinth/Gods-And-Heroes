package de.idrinth.gods_and_heroes;

import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;

import de.idrinth.gods_and_heroes.implementation.Player;
import de.idrinth.gods_and_heroes.services.TaskHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FXMLController implements Initializable {
	
    private final Timer timer = new Timer(true);
    
    @FXML
    private Label label;
    @FXML
    private TextField textfield;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
    	timer.scheduleAtFixedRate(new TaskHandler(new Player(textfield.getText(),null)), 0, 1000);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
