package de.idrinth.gods_and_heroes.implementation;

import de.idrinth.gods_and_heroes.interfaces.Alignment;
import de.idrinth.gods_and_heroes.interfaces.Option;
import de.idrinth.gods_and_heroes.interfaces.Quest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleQuestTest {
    
    public SimpleQuestTest() {
    }

    @Test
    public void testGetRenownReward() {
        System.out.println("getRenownReward");
        assertTrue(BigDecimal.TEN.compareTo(get().getRenownReward()) == 0);
    }

    @Test
    public void testGetOptions() {
        System.out.println("getOptions");
        assertEquals(3, get().getOptions().size());
    }

    @Test
    public void testChooseOption() {
        System.out.println("chooseOption + getChosenOption");
        SimpleQuest instance = get();
        Option option = instance.getOptions().get(1);
        instance.chooseOption(option);
        assertEquals(option, instance.getChosenOption());
    }

    @Test
    public void testIsReady() {
        System.out.println("isReady");
        SimpleQuest instance = get();
        assertFalse(instance.isReady());
        instance.chooseOption(instance.getOptions().get(0));
        assertTrue(instance.isReady());
    }

    @Test
    public void testIsDone() {
        System.out.println("isDone + addProgress");
        SimpleQuest instance = get();
        instance.chooseOption(instance.getOptions().get(0));
        assertFalse(instance.isDone());
        instance.addProgress(BigDecimal.ONE);
        assertTrue(instance.isDone());
    }

    private SimpleQuest get() {
        List<Option> list = new ArrayList<>();
        list.add(new OptionImpl("one"));
        list.add(new OptionImpl("two"));
        list.add(new OptionImpl("three"));
        return new SimpleQuest(
            BigDecimal.TEN,
            BigDecimal.ONE,
            list
        );
    }
    private class OptionImpl implements Option {
        private final String title;

        public OptionImpl(String title) {
            this.title = title;
        }

        @Override
        public Alignment getAlignmentShift() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getDescription() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getTitle() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
