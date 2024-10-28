package csci.ooad.polymorphia.characters;

public class Coward extends Adventurer {
    public Coward(String name) {
        super(name);
    }

    public Coward(String name, Double initialHealth) {
        super(name, initialHealth);
    }

    @Override
    Boolean shouldFight() {
        return cannotMove();
    }

    @Override
    public Boolean isCoward() {
        return true;
    }

    @Override
    public void move() {
        if (getCurrentLocation().hasLivingCreatures()) {
            loseHealth(0.25);
        }
        super.move();
    }
}
