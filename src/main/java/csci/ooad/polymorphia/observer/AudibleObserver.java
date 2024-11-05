package csci.ooad.polymorphia.observer;

import csci.ooad.polymorphia.EventType;
import csci.ooad.polymorphia.IObservable;
import csci.ooad.polymorphia.IObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.List;

public class AudibleObserver implements IObserver {
    private static final Logger logger = LoggerFactory.getLogger(AudibleObserver.class);
    private static final String synthesizer = null;

    public AudibleObserver(IObservable observableGame, List<EventType> interestingEvents) {
        for (EventType eventType : interestingEvents) {
            observableGame.attach(this, eventType);
        }
    }

    public AudibleObserver(IObservable observableGame, EventType eventType) {
        observableGame.attach(this, eventType);
    }

    @Override
    public void update(String eventDescription) {
        speak(eventDescription);
    }

    private void speak(String message) {
        try {
            if (synthesizer == null && System.getProperty("os.name").contains("Mac")) {
                String[] cmd = {"say", message};
                Process sayProcess = Runtime.getRuntime().exec(cmd);
                sayProcess.waitFor();
            } else {
//                synthesizer.speakPlainText(message, null);
//                synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
                logger.error("Shit's fucked. Try again later.");
            }
        } catch (IOException | InterruptedException e) {
            logger.error("Could not speak message: {}", message);
        }
    }

}
