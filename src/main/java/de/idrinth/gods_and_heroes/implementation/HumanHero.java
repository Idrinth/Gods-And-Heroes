package de.idrinth.gods_and_heroes.implementation;

import de.idrinth.gods_and_heroes.interfaces.God;
import de.idrinth.gods_and_heroes.interfaces.Hero;
import de.idrinth.gods_and_heroes.interfaces.Quest;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;

public class HumanHero extends HigherServant implements Hero {
    private final Queue<Quest> tasks = new LinkedList<>();

    public HumanHero(God god) {
        super(god);
    }

    @Override
    protected BigDecimal getDeathFactor() {
        return BigDecimal.ONE;
    }

    @Override
    public void addTask(Quest quest) {
        if(quest.isReady()) {
            tasks.add(quest);
        }
    }

    @Override
    public void processIdle() {
        super.processIdle();
        if(isDead) {
            return;
        }
        tasks.removeIf(new QuestDoneRemover());
        if(tasks.isEmpty()) {
            return;
        }
        Quest one = tasks.poll();
        if(!one.addProgress(getLevel())) {
            tasks.add(one);
        }
    }
    private class QuestDoneRemover implements Predicate<Quest> {
        @Override
        public boolean test(Quest t) {
            return t.isDone();
        }
    }
}
