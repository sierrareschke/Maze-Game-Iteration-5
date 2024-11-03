package csci.ooad.polymorphia.observer;

import csci.ooad.polymorphia.IObserver;

public class GameOverObserver implements IObserver {
    private boolean isGameOverMessage = false;

    @Override
    public void update(String eventDescription) {
        isGameOverMessage = true;
    }

    public boolean receivedGameOverMessage() {
        return isGameOverMessage;
    }

    public void reset() {isGameOverMessage = false;}
}

