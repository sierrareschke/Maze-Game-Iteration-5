package csci.ooad.polymorphia.stepdefs

import csci.ooad.polymorphia.Maze
import csci.ooad.polymorphia.Polymorphia
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then

class MazeStepDefs {
    World world


    MazeStepDefs(World aWorld) {
        world = aWorld
    }

    @Given("I have a maze with the following attributes:")
    public void iHaveAGameWithTheFollowingAttributes(Map<String, Integer> gameAttributes) {
        /* GAME ATTRIBUTES:
            * number of rooms
            * number of adventurers
            * number of knights
            * number of cowards
            * number of gluttons
            * number of creatures
            * number of demons
            * number of food items
        */
        int numRooms = gameAttributes.getOrDefault("number of rooms", 0);
        int numAdventurers = gameAttributes.getOrDefault("number of adventurers", 0);
        int numKnights = gameAttributes.getOrDefault("number of knights", 0);
        int numCowards = gameAttributes.getOrDefault("number of cowards", 0);
        int numGluttons = gameAttributes.getOrDefault("number of gluttons", 0);
        int numCreatures = gameAttributes.getOrDefault("number of creatures", 0);
        int numDemons = gameAttributes.getOrDefault("number of demons", 0);
        int numFoodItems = gameAttributes.getOrDefault("number of food items", 0);


        Maze maze = Maze.getNewBuilder()
                .createFullyConnectedRooms(numRooms)
                .createAndAddAdventurers(numAdventurers)
                .createAndAddKnights(numKnights)
                .createAndAddCowards(numCowards)
                .createAndAddGluttons(numGluttons)
                .createAndAddCreatures(numCreatures)
                .createAndAddDemons(numDemons)
                .createAndAddFoodItems(numFoodItems)
                .build();

        Polymorphia game = new Polymorphia("gameWithAttributes", maze);
        world.polymorphia = game;
    }

    @Given("a room named \"Only Room\" with no neighbors")
    public createRoomWithNoNeighbors(String roomName){
        myMaze = Maze.getNewBuilder()
                .create2x2Grid()
                .createAndAddAdventurers("Frodo")
                .createAndAddCreatures("Ogre")
                .createAndAddFoodItems("Cookie")
                .build();
    }

    @Given("all characters are in room \"Only Roo\"")
    public placeAllCharactersInRoom(String roomName){
    }

    @Given(/^a ([A-Z][a-zA-Z]*) "([^"]+)"$/)
    void addCharacterWithName(String typeOfCharacter, String characterName) {
        println "Character Type: $typeOfCharacter"
        println "Character Name: $characterName"


        // Additional code for adding the character can go here
    }

    @Then("a fight took place")
    public void fightOutcome(){}

}
