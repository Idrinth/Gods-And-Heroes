package de.idrinth.gods_and_heroes.services;

import java.math.BigDecimal;
import java.util.List;

import de.idrinth.gods_and_heroes.implementation.*;
import de.idrinth.gods_and_heroes.interfaces.*;

public class QuestFactory {
    public static Quest generate(BigDecimal renownReward,List<Option> options) {
        int number = (int) Math.random()*100;
        if(number < 15) {
        	return new SetbackQuest(renownReward, options, (int)Math.random()*25, renownReward.divide(BigDecimal.TEN));
        }
        if(number < 35) {
        	return new FailQuest(renownReward, options, (int)Math.random()*75);
        }
        return new SimpleQuest(renownReward, options);
    }
}
