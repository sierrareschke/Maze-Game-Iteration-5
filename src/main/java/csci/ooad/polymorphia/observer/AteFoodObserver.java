package csci.ooad.polymorphia.observer;

import csci.ooad.polymorphia.IObserver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AteFoodObserver implements IObserver {
    private static final Pattern EATING_PATTERN = Pattern.compile("^([\\w\\s]+) just ate ([\\w\\s]+)$");
    private String nameOfCharacterWhoAteFood;

    @Override
    public void update(String eventDescription) {

        // Extract the character's name from the event description
        Matcher matcher = EATING_PATTERN.matcher(eventDescription);
        if (matcher.find()) {
            String characterName = matcher.group(1);
            nameOfCharacterWhoAteFood = characterName;
        }
    }

    public String getNameOfCharacterWhoAteFood() {
        return nameOfCharacterWhoAteFood;
    }

    public void reset(){
        nameOfCharacterWhoAteFood = null;
    }
}

