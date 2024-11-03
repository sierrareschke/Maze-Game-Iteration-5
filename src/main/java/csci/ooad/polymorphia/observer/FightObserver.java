package csci.ooad.polymorphia.observer;

import csci.ooad.polymorphia.IObserver;

public class FightObserver implements IObserver {
    private boolean fightOccurred = false;

    @Override
    public void update(String eventDescription) {
        fightOccurred = true;
        System.out.println("Fight event observed: " + eventDescription);
    }

    public boolean hasFightOccurred() {
        return fightOccurred;
    }

    public void reset() {
        fightOccurred = false;
    }
}

