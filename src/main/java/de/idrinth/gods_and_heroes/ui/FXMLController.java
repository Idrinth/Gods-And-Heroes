package de.idrinth.gods_and_heroes.ui;

import de.idrinth.gods_and_heroes.implementation.Philosophy;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;

import de.idrinth.gods_and_heroes.implementation.Player;
import de.idrinth.gods_and_heroes.interfaces.God;
import de.idrinth.gods_and_heroes.services.TaskHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class FXMLController implements Initializable {
    private final Timer timer = new Timer(true);
    private God god;

    @FXML
    private TextField textfield;

    @FXML
    private TabPane tab;

    @FXML
    private void startGame(ActionEvent event) {
        god = new Player(textfield.getText(),new Philosophy());
        timer.scheduleAtFixedRate(new TaskHandler(god), 0, 1000);
        for(Tab t:tab.getTabs()) {
            t.setDisable(false);
            Node firstChild = t.getContent();
            if(PersonTable.class.isInstance(firstChild)) {
                ((PersonTable) firstChild).setItems(god);
            }
        }
        tab.getTabs().get(0).setDisable(true);
        tab.getSelectionModel().clearAndSelect(1);
    }

    @FXML
    private void createWonder(ActionEvent event) {
        event.consume();
        System.out.println(god.getName()+" tries to create a wonder.");
    }

    @FXML
    private void begetHero(ActionEvent event) {
        event.consume();
        System.out.println(god.getName()+" tries to beget a hero.");
    }

    @FXML
    private void proselytizeBeliever(ActionEvent event) {
        event.consume();
        System.out.println(god.getName()+" tries to proselytize a believer.");
    }

    @FXML
    private void consecratePriest(ActionEvent event) {
        event.consume();
        System.out.println(god.getName()+" tries to consecrate a priest.");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //No need to do anything here for now
    }
}