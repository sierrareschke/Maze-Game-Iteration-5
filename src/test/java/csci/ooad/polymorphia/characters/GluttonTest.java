package csci.ooad.polymorphia.characters;

import csci.ooad.polymorphia.Food;
import csci.ooad.polymorphia.maze.Maze;
import csci.ooad.polymorphia.NoSuchRoomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GluttonTest {

    @Test
    void testEating() {
        // Arrange
        Double initialHealth = 3.0;
        Adventurer glutton = new Glutton("Glutton", initialHealth);
        Maze.getNewBuilder()
                .createFullyConnectedRooms(1)
                .addAdventurers(glutton)
                .createAndAddCreatures("Ogre")
                .createAndAddFoodItems("Cake")
                .build();

        // Act - the glutton should not fight. It should eat
        glutton.doAction();

        // Assert – the glutton ate the cake and gain 1 health point
        assertEquals(initialHealth + 1, glutton.getHealth());
    }

    @Test
    void testFighting() throws NoSuchRoomException {
        // Arrange - put Demon in room with Glutton
        Adventurer glutton = new Glutton("Glutton");
        Creature satan = new Demon("Satan");
        Food steak = new Food("Steak");
        Maze twoRoomMaze = Maze.getNewBuilder()
                .createFullyConnectedRooms("initial", "final")
                .addToRoom("initial", glutton)
                .addToRoom("initial", satan)
                .addToRoom("initial", steak)
                .build();

        // Act - the coward must fight a Demon
        glutton.doAction();

        // Assert – the coward ran to the other room
        assertNotEquals(Demon.INITIAL_HEATH, satan.getHealth());
        assertTrue(twoRoomMaze.getRoom("initial").hasFood());
    }
}
