package de.idrinth.gods_and_heroes;

import de.idrinth.gods_and_heroes.ui.FXMLController;
import org.junit.Assert;
import org.junit.Test;

public class FXMLControllerTest {
    @Test
    public void testInitialize() {
        Assert.assertNotNull("Can't construct MainApp", new FXMLController());
    }
}
