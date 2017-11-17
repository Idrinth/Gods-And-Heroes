package de.idrinth.gods_and_heroes.ui;

import de.idrinth.gods_and_heroes.services.Game;
import de.idrinth.gods_and_heroes.services.TimelessScheduler;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Test;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isNotNull;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

public class FXMLControllerTest extends ApplicationTest {
    @Test
    public void testInitialize() {
        Assert.assertNotNull("Can't construct FXMLController", new FXMLController());
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent sceneRoot = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        Scene scene = new Scene(sceneRoot, 1024, 768);
        stage.setScene(scene);
        stage.show();
        Game.setTimer(new TimelessScheduler());
    }

    @Test
    public void testBase() {
        //Tabs
        //Text
        verifyThat("#tab_setup", isNotNull());
        verifyThat("#tab_god", isNotNull());
        verifyThat("#tab_believer", isNotNull());
        verifyThat("#tab_hero", isNotNull());
        verifyThat("#tab_priest", isNotNull());
        //focus
        verifyThat("#tab_setup", isVisible());

        //Buttons
        //Existance
        verifyThat("#button_start", isNotNull());
        verifyThat("#textfield", isNotNull());
        //click
        clickOn("#button_start", MouseButton.PRIMARY);
        //focus
        verifyThat("#tab_setup", isVisible());
        //set and click
        ((TextField) lookup("#textfield").query()).setText("Example");
        clickOn("#button_start", MouseButton.PRIMARY);
        //focus
        verifyThat("#tab_god", isVisible());
    }
}
