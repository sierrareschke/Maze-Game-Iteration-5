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

    @Then("a fight took place")
    public void fightOutcome(){}

}
