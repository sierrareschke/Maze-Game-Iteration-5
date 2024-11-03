package csci.ooad.polymorphia.stepdefs

import csci.ooad.polymorphia.Food
import csci.ooad.polymorphia.Maze
import csci.ooad.polymorphia.Polymorphia
import io.cucumber.java.Before
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then

class MazeStepDefs {
    Maze maze
    World world
    Maze.Builder mazeBuilder;

    MazeStepDefs(World world) {
        this.world = world
    }

    // Step 1: Initialize MazeBuilder before all @Given steps
    @Before(order = 0)
    void setupMazeBuilder() {
        mazeBuilder = Maze.getNewBuilder().create2x2Grid()
        System.out.println("Setup maze builder")
    }


    @Given("I have a maze with the following attributes:")
    public void iHaveAGameWithTheFollowingAttributes(Map<String, Integer> gameAttributes) {

        int numRooms = gameAttributes.getOrDefault("number of rooms", 0);
        int numAdventurers = gameAttributes.getOrDefault("number of adventurers", 0);
        int numKnights = gameAttributes.getOrDefault("number of knights", 0);
        int numCowards = gameAttributes.getOrDefault("number of cowards", 0);
        int numGluttons = gameAttributes.getOrDefault("number of gluttons", 0);
        int numCreatures = gameAttributes.getOrDefault("number of creatures", 0);
        int numDemons = gameAttributes.getOrDefault("number of demons", 0);
        int numFoodItems = gameAttributes.getOrDefault("number of food items", 0);

        mazeBuilder.createFullyConnectedRooms(numRooms)
                .createAndAddAdventurers(numAdventurers)
                .createAndAddKnights(numKnights)
                .createAndAddCowards(numCowards)
                .createAndAddGluttons(numGluttons)
                .createAndAddCreatures(numCreatures)
                .createAndAddDemons(numDemons)
                .createAndAddFoodItems(numFoodItems)

        System.out.println("Maze with attributes")
    }

    @Given("a room named {string} with no neighbors")
    public void createRoomWithNoNeighbors(String roomName) {
        System.out.println("Room with no neighbors")
        mazeBuilder.createFullyConnectedRooms(roomName)
    }

    @Given("all characters are in room {string}")
    public placeAllCharactersInRoom(String roomName) {
        System.out.println(roomName)
        System.out.println("Place characters in a room")
    }

    @Given(/^a ([A-Z][a-zA-Z]*) "([^"]+)"$/)
    void addCharacterWithName(String typeOfCharacter, String characterName) {
        println "Character Type: $typeOfCharacter"
        println "Character Name: $characterName"

        switch (typeOfCharacter) {
            case 'Coward':
                mazeBuilder.createAndAddCowards(new String[]{characterName});
                break;
            case 'Glutton':
                mazeBuilder.createAndAddGluttons(characterName);
                break;
            case 'Adventurer':
                mazeBuilder.createAndAddAdventurers(characterName);
                break;
            case 'Knight':
                mazeBuilder.createAndAddKnights(characterName);
                break;
            case 'Creature':
                mazeBuilder.createAndAddCreatures(characterName);
                break;
            case 'Demon':
                mazeBuilder.createAndAddDemons(characterName);
                break;
            default:
                System.out.println("Unknown character type: " + typeOfCharacter);
                break;
        }

        System.out.println("Add character with name")

    }

    @And(/^there is a Food "([^"]+)" added to Room "([^"]+)"$/)
    void addFoodItem(String foodName, String roomName) {
        println "Food ($foodName) added to ($roomName)"
        mazeBuilder.addToRoom(roomName, new Food(foodName))

        System.out.println("$foodName added to Room $roomName in the maze")
    }

    // Step 2: Finalize maze with .build() after @Given but before @When
    @Given("the maze is successfully created")
    void finalizeMaze() {
        maze = mazeBuilder.build();
        world.polymorphia = new Polymorphia("Polymorphia Maze", maze);
        System.out.println("Finalize maze")
    }


}
