package de.idrinth.gods_and_heroes.ui;

import de.idrinth.gods_and_heroes.services.Game;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import de.idrinth.gods_and_heroes.interfaces.God;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class FXMLController implements Initializable {
    private God god;

    @FXML
    private TextField textfield;

    @FXML
    private TabPane tab;

    @FXML
    private void startGame(ActionEvent event) {
        event.consume();
        if(textfield.getText().isEmpty()) {
            return;
        }
        god = Game.startFresh(textfield.getText());
        for(Tab t:tab.getTabs()) {
            t.setDisable(!t.isDisable());
            if(PersonTable.class.isInstance(t.getContent())) {
                ((PersonTable) t.getContent()).setItems(god);
            }
        }
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