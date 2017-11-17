package de.idrinth.gods_and_heroes.ui;

import de.idrinth.gods_and_heroes.services.Game;
import de.idrinth.gods_and_heroes.services.GameHandler;
import java.lang.reflect.InvocationTargetException;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class FXMLController implements Initializable {
    private GameHandler game;

    @FXML
    private TextField textfield;

    @FXML
    private TabPane tab;

    @FXML
    private void startGame(ActionEvent event) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        event.consume();
        if(textfield.getText().isEmpty()) {
            return;
        }
        game = getGame(textfield.getText());
        for(Tab t:tab.getTabs()) {
            t.setDisable(!t.isDisable());
            if(PersonTable.class.isInstance(t.getContent())) {
                ((PersonTable) t.getContent()).setItems(game.getGod());
            }
        }
        tab.getSelectionModel().clearAndSelect(1);
    }
    protected GameHandler getGame(String text) {
        return new Game(text);
    }

    @FXML
    private void createWonder(ActionEvent event) {
        event.consume();
        System.out.println(game.getGod().getName()+" tries to create a wonder.");
    }

    @FXML
    private void begetHero(ActionEvent event) {
        event.consume();
        System.out.println(game.getGod().getName()+" tries to beget a hero.");
    }

    @FXML
    private void proselytizeBeliever(ActionEvent event) {
        event.consume();
        System.out.println(game.getGod().getName()+" tries to proselytize a believer.");
    }

    @FXML
    private void consecratePriest(ActionEvent event) {
        event.consume();
        System.out.println(game.getGod().getName()+" tries to consecrate a priest.");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // no need
    }
}