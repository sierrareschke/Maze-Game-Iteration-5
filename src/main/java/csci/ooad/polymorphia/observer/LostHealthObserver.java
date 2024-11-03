package csci.ooad.polymorphia.observer;

import csci.ooad.polymorphia.IObserver;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LostHealthObserver implements IObserver {
    private String nameOfCharacterWhoLostHealth;
    private static final Pattern LOST_HEALTH_PATTERN = Pattern.compile("^(.*?) just lost \\d+\\.\\d+ points$");

    @Override
    public void update(String eventDescription) {
        System.out.println("Lost health event observed: " + eventDescription);

        // Extract the character's name from the event description
        Matcher matcher = LOST_HEALTH_PATTERN.matcher(eventDescription);
        if (matcher.find()) {
            String characterName = matcher.group(1);
            nameOfCharacterWhoLostHealth = characterName;
        } else {
            System.out.println("Failed to parse event description for lost health.");
        }
    }

    public String getNameOfCharacterWhoLostHealth() {
        return nameOfCharacterWhoLostHealth;
    }

    public void reset(){
        nameOfCharacterWhoLostHealth = null;
    }

}

