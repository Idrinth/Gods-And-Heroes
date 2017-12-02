package de.idrinth.gods_and_heroes.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.idrinth.gods_and_heroes.interfaces.Alignment;
import de.idrinth.gods_and_heroes.interfaces.Option;

public class SetbackQuestTest {
    @Test
    public void testGetRenownReward() {
        System.out.println("getRenownReward");
        assertTrue(BigDecimal.TEN.multiply(BigDecimal.TEN).compareTo(get().getRenownReward()) == 0);
    }
    
    @Test
    public void testGetChance() {
        System.out.println("getChance");
        assertEquals( 0.5, get().getChance(), 0.0000001);
    }
    
    @Test
    public void testGetOptions() {
        System.out.println("getOptions");
        assertEquals(3, get().getOptions().size());
    }

    @Test
    public void testChooseOption() {
        System.out.println("chooseOption + getChosenOption");
        SetbackQuest instance = get();
        Option option = instance.getOptions().get(1);
        instance.chooseOption(option);
        assertEquals(option, instance.getChosenOption());
    }

    @Test
    public void testIsReady() {
        System.out.println("isReady");
        SetbackQuest instance = get();
        assertFalse(instance.isReady());
        instance.chooseOption(instance.getOptions().get(0));
        assertTrue(instance.isReady());
    }

    @Test
    public void testIsDone() {
        System.out.println("isDone + addProgress");
        SetbackQuest instance = get();
        instance.chooseOption(instance.getOptions().get(0));
        for(int i = 0; i < 10000; ++i) {
            instance.addProgress(BigDecimal.ONE);
        }
        assertFalse(instance.isDone());
    }

    private SetbackQuest get() {
        List<Option> list = new ArrayList<>();
        list.add(new OptionImpl());
        list.add(new OptionImpl());
        list.add(new OptionImpl());
        return new SetbackQuest(
            BigDecimal.TEN.multiply(BigDecimal.TEN),
            list, 
            0.5,
            BigDecimal.ONE.negate()
        );
    }
    private class OptionImpl implements Option {
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
