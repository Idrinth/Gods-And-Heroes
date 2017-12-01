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
import javafx.scene.layout.AnchorPane;

public class FXMLController implements Initializable {
    public static GameHandler game;

    @FXML
    private TextField textfield;

    @FXML
    private TabPane tab;

    @FXML
    private AttributeTable attributes;

    @FXML
    private PartingLog log;

    @FXML
    private void startGame(ActionEvent event) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        event.consume();
        if(textfield.getText().isEmpty()) {
            return;
        }
        game = new Game(textfield.getText(), log);
        for(Tab t:tab.getTabs()) {
            t.setDisable(!t.isDisable());
            if(AnchorPane.class.isInstance(t.getContent())) {
                AnchorPane p = (AnchorPane) t.getContent();
                if(PersonTable.class.isInstance(p.getChildren().get(0))) {
                    ((PersonTable) p.getChildren().get(0)).setItems(game.getGod());
                }
            }
        }
        attributes.setItems(game.getAttributeList());
        tab.getSelectionModel().clearAndSelect(1);
    }

    @FXML
    private void createWonder(ActionEvent event) {
        event.consume();
        System.out.println(game.getGod().getName()+" tries to create a wonder.");
    }

    @FXML
    private void createQuest(ActionEvent event) {
        event.consume();
        System.out.println(game.getGod().getName()+" tries to create a wonder.");
    }

    @FXML
    private void begetHero(ActionEvent event) {
        event.consume();
        new Thread(()-> {
            game.getGod().addHero();
        }).start();
    }

    @FXML
    private void proselytizeBeliever(ActionEvent event) {
        event.consume();
        new Thread(()-> {
            game.getGod().addBeliever();
        }).start();
    }

    @FXML
    private void consecratePriest(ActionEvent event) {
        event.consume();
        new Thread(()-> {
            game.getGod().addPriest();
        }).start();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // no need
    }
}