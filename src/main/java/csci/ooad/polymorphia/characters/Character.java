package csci.ooad.polymorphia.characters;

import csci.ooad.polymorphia.Die;
import csci.ooad.polymorphia.EventBus;
import csci.ooad.polymorphia.EventType;
import csci.ooad.polymorphia.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;

import static csci.ooad.polymorphia.EventBus.post;


public abstract class Character implements Comparable<Character> {
    private static final Logger logger = LoggerFactory.getLogger(Character.class);
    private static final DecimalFormat formatter = new DecimalFormat("0.0");

    static final Double DEFAULT_INITIAL_HEALTH = 5.0;
    static final Double HEALTH_LOST_IN_FIGHT_REGARDLESS_OF_OUTCOME = 0.5;
    static final Double HEALTH_LOST_IN_MOVING_ROOMS = 0.25;

    protected String name;
    private Double health;

    private Room currentLocation;

    public Room getCurrentLocation() {
        return currentLocation;
    }

    public Character(String name) {
        this(name, DEFAULT_INITIAL_HEALTH);
    }

    public Character(String name, Double initialHealth) {
        this.name = name;
        this.health = initialHealth;
    }

    @Override
    public int compareTo(Character otherCharacter) {
        return getHealth().compareTo(otherCharacter.getHealth());
    }

    public void enterRoom(Room room) {
        this.currentLocation = room;
    }

    @Override
    public String toString() {
        return getName() + "(health: " + formatter.format(getHealth()) + ")";
    }

    public void loseHealth(Double healthPoints) {
        if (health <= 0) {
            return;     // already dead, probably called for mandatory health loss for having a fight
        }

        health -= healthPoints;

        if (health <= 0) {
            String eventDescription = this.getName() + " just died!";
            logger.info(eventDescription);
            EventBus.getInstance().postMessage(EventType.Death, eventDescription);
        }
    }

    public Double getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public Boolean isAlive() {
        return getHealth() > 0;
    }

    public void loseFightDamage(double fightDamage) {
        loseHealth(fightDamage);
    }

    protected boolean cannotMove() {
        return getCurrentLocation().getNeighbors().isEmpty();
    }

    public Boolean isAdventurer() {
        return false;
    }
    public Boolean isCreature() {
        return false;
    }
    public Boolean isDemon() {
        return false;
    }
    public Boolean isCoward() {
        return false;
    }

    public void fight(Character opponent) {
        Integer adventurerRoll = Die.rollSixSided();
        Integer creatureRoll = Die.rollSixSided();
        logger.info(getName() + " is fighting " + opponent);

        logger.info(getName() + " rolled " + adventurerRoll);
        logger.info(opponent + " rolled " + creatureRoll);

        if (adventurerRoll > creatureRoll) {
            post(EventType.FightOutcome, this.getName() + " won a battle against " + opponent.getName());
            opponent.loseFightDamage(adventurerRoll - creatureRoll);
        } else if (creatureRoll > adventurerRoll) {
            post(EventType.FightOutcome, opponent.getName() + " won a battle against " + this.getName());
            loseFightDamage(creatureRoll - adventurerRoll);
        }

        loseHealth(Character.HEALTH_LOST_IN_FIGHT_REGARDLESS_OF_OUTCOME);
        opponent.loseHealth(Character.HEALTH_LOST_IN_FIGHT_REGARDLESS_OF_OUTCOME);
    }

    public void doAction() {
        // Do nothing by default
    }

    protected void move() {
        Room nextLocation = getCurrentLocation().getRandomNeighbor();
        if (nextLocation != null) {
            String message = getName() + " moved from " + getCurrentLocation().getName() + " to " + nextLocation.getName();
            logger.info(message);
            post(EventType.Moved, message);
            nextLocation.enter(this);
            loseHealth(HEALTH_LOST_IN_MOVING_ROOMS);
        } else {
            logger.warn("{} has no neighbors!", getCurrentLocation().getName());
        }
    }

    protected void gainHealth(double healthValue) {
        this.health += healthValue;
        logger.info("{} gained health: {}", getName(), formatter.format(getHealth()));
    }
}
