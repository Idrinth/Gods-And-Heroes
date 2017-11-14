package de.idrinth.gods_and_heroes;

import org.junit.Assert;
import org.junit.Test;

public class FXMLControllerTest {
    @Test
    public void testInitialize() {
        Assert.assertNotNull("Can't construct MainApp", new FXMLController());
    }
}
