package csci.ooad.polymorphia.stepdefs

import csci.ooad.polymorphia.Maze
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
        int numRooms = gameAttributes.get("number of rooms")
        int numAdventurers = gameAttributes.get("number of adventurers")
        int numKnights = gameAttributes.get("number of knights")
        int numCowards = gameAttributes.get("number of cowards")
        int numGluttons = gameAttributes.get("number of gluttons")
        int numCreatures = gameAttributes.get("number of creatures")
        int numDemons = gameAttributes.get("number of demons")
        int numFoodItems = gameAttributes.get("number of food items")

        world.maze = Maze.getNewBuilder()
                .createFullyConnectedRooms(numRooms)
                .createAndAddAdventurers(numAdventurers)
                .createAndAddKnights(numKnights)
                .createAndAddCowards(numCowards)
                .createAndAddGluttons(numGluttons)
                .createAndAddCreatures(numCreatures)
                .createAndAddDemons(numDemons)
                .createAndAddFoodItems(numFoodItems)
                .build();
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
