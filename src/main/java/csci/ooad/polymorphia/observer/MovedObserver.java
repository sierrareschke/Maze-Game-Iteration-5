package csci.ooad.polymorphia.observer;

import csci.ooad.polymorphia.IObserver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovedObserver implements IObserver {
    private static final Pattern MOVEMENT_PATTERN = Pattern.compile("^([\\w\\s]+) moved from ([\\w\\s]+) to ([\\w\\s]+)$");
    private String nameOfCharacterWhoMoved;
    private String origin;
    private String destination;

    @Override
    public void update(String eventDescription) {

        // Extract the character's name from the event description
        Matcher matcher = MOVEMENT_PATTERN.matcher(eventDescription);
        if (matcher.find()) {
            nameOfCharacterWhoMoved = matcher.group(1);
            origin = matcher.group(2);
            destination = matcher.group(3);
        }
    }

    public String getNameOfCharacterWhoMoved() {
        return nameOfCharacterWhoMoved;
    }

    public String getOrigin() {return origin;}

    public String getDestination() {return destination;}

    public void reset(){
        nameOfCharacterWhoMoved = null;
        origin = null;
        destination = null;
    }
}