package csci.ooad.polymorphia.characters;

import csci.ooad.polymorphia.Maze;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class KnightTest {
    static final Double INITIAL_KNIGHT_HEATH = 8.0;
    static final Double INITIAL_CREATURE_HEATH = 8.0;

    @Test
    void testFighting() {
        // Arrange - put creature in room with two adventurers
        Double lowHealth = 2.0;
        Adventurer strongMan = new Adventurer("StrongMan", INITIAL_KNIGHT_HEATH);
        Adventurer weakKnight = new Knight("WeakKnight", lowHealth);
        Creature creature = new Creature("Ogre", INITIAL_CREATURE_HEATH);
        Maze.getNewBuilder()
                .createRoom("only room")
                .addAdventurers(strongMan)
                .addAdventurers(weakKnight)
                .addCreatures(creature)
                .build();

        // Act - the weak knight should fight
        weakKnight.doAction();

        // Assert – the fight did occur and changed the health of both combatants
        assertNotEquals(lowHealth, weakKnight.getHealth());
        assertNotEquals(INITIAL_CREATURE_HEATH, creature.getHealth());
    }
}
