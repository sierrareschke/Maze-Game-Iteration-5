package csci.ooad.polymorphia.characters;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class CharacterFactory {
    public static String[] ADVENTURER_NAMES = new String[]{"Frodo", "Arwen", "Nikhil", "Sierra", "Matt", "Fran"};
    public static String[] KNIGHT_NAMES = new String[]{"Sir Lancelot", "Lady Brienne", "King Arthur", "Sir Jamey", "Aragorn", "Isildur"};
    public static String[] COWARD_NAMES = new String[]{"Sir Robin", "Sir Scaredy Cat", "Lady Faints-a-lot", "Lady Runaway", "Sir Chicken", "Lady Hides-a-lot"};
    public static String[] GLUTTON_NAMES = new String[]{"Sir Eats-a-lot", "Sir Gobbles", "Lady Munches", "Lady Snacks", "Sir Nibbles", "Lady Noshes"};
    public static String[] CREATURE_NAMES = new String[]{"Dragon", "Ogre", "Orc", "Shelob", "Troll", "Evil Wizard"};
    public static String[] DEMON_NAMES = new String[]{"Satan", "Beelzebub", "Devil", "Incubus", "Lucifer", "Succubus"};

    Random random = new Random();

    public List<Adventurer> createNumberOfAdventurers(Integer numAdventurers) {
        return IntStream.range(0, numAdventurers)
                .mapToObj(i -> new Adventurer(ADVENTURER_NAMES[i % ADVENTURER_NAMES.length]))
                .map(Adventurer.class::cast)
                .toList();
    }

    public List<Creature> createNumberOfCreatures(Integer numCreatures) {
        return IntStream.range(0, numCreatures)
                .mapToObj(i -> new Creature(CREATURE_NAMES[i % CREATURE_NAMES.length]))
                .map(Creature.class::cast)
                .toList();
    }

    public List<Creature> createNumberOfDemons(Integer numDemons) {
        return IntStream.range(0, numDemons)
                .mapToObj(i -> new Demon(DEMON_NAMES[i % DEMON_NAMES.length]))
                .map(Creature.class::cast)
                .toList();
    }

    public List<Adventurer> createNumberOfKnights(Integer numAdventurers) {
        return IntStream.range(0, numAdventurers)
                .mapToObj(i -> new Knight(KNIGHT_NAMES[random.nextInt(KNIGHT_NAMES.length)]))
                .map(Adventurer.class::cast)
                .toList();
    }

    public List<Adventurer> createNumberOfCowards(Integer numAdventurers) {
        return IntStream.range(0, numAdventurers)
                .mapToObj(i -> new Coward(COWARD_NAMES[random.nextInt(COWARD_NAMES.length)]))
                .map(Adventurer.class::cast)
                .toList();
    }

    public List<Adventurer> createNumberOfGluttons(Integer numAdventurers) {
        return IntStream.range(0, numAdventurers)
                .mapToObj(i -> new Glutton(GLUTTON_NAMES[random.nextInt(GLUTTON_NAMES.length)]))
                .map(Adventurer.class::cast)
                .toList();
    }

    public Adventurer createAdventurer(String name) {
        return new Adventurer(name);
    }
    public Adventurer createKnight(String name) {
        return new Knight(name);
    }
    public Adventurer createCoward(String name) {
        return new Coward(name);
    }
    public Adventurer createGlutton(String name) {
        return new Glutton(name);
    }
    public Creature createCreature(String name) { return new Creature(name);}
    public Creature createDemon(String name) { return new Demon(name);}
}
