package de.idrinth.gods_and_heroes;

import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Test;

public class MainAppTest {
    /**
     * Test of start method, of class MainApp.
     * @throws java.lang.NoSuchMethodException
     */
    @Test
    public void testStart() throws NoSuchMethodException {
        System.out.println("start");
        Assert.assertNotNull("Can't find start method", MainApp.class.getMethod("start",Stage.class));
    }

    /**
     * Test of main method, of class MainApp.
     * @throws java.lang.NoSuchMethodException
     */
    @Test
    public void testMain() throws NoSuchMethodException {
        System.out.println("main");
        Assert.assertNotNull("Can't find main method", MainApp.class.getMethod("main",String[].class));
    }

    /**
     * Test of MainApp method, of class MainApp.
     * @throws java.lang.NoSuchMethodException
     */
    @Test
    public void testInstantiation() throws NoSuchMethodException {
        System.out.println("MainApp");
        Assert.assertNotNull("Can't construct MainApp", new MainApp());
    }
}
