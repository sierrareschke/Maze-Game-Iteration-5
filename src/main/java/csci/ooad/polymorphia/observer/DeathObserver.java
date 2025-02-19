package csci.ooad.polymorphia.observer;

import csci.ooad.polymorphia.IObserver;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeathObserver implements IObserver {
    private static final Pattern DEATH_PATTERN = Pattern.compile("^(.*?) just died!$");
    private int numDeaths = 0;
    private ArrayList<String> deadCharacters;

    public DeathObserver() {
        deadCharacters = new ArrayList<>();
    }

    @Override
    public void update(String eventDescription) {

        // Extract the character's name from the event description
        Matcher matcher = DEATH_PATTERN.matcher(eventDescription);
        if (matcher.find()) {
            String deadCharacter = matcher.group(1);
            deadCharacters.add(deadCharacter);
            numDeaths++;
        }

        numDeaths++;
    }

    public int getNumDeaths() {return numDeaths;}

    public ArrayList<String> getDeadCharacters() {return deadCharacters;}

    public void reset() {numDeaths = 0; deadCharacters.clear();}
}

