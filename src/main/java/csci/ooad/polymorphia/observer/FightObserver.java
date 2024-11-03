package csci.ooad.polymorphia.observer;

import csci.ooad.polymorphia.IObserver;

public class FightObserver implements IObserver {
    private boolean fightOccurred = false;
    private int numFights = 0;

    @Override
    public void update(String eventDescription) {
        fightOccurred = true;
        numFights++;
        System.out.println("Fight event observed: " + eventDescription);
    }

    public boolean hasFightOccurred() {
        return fightOccurred;
    }

    public int getNumFights() {return numFights;}

    public void reset() {
        fightOccurred = false;
        numFights = 0;
    }
}

