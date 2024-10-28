package csci.ooad.polymorphia.stepdefs

import io.cucumber.java.en.Given

class MazeStepDefs {
    World world


    MazeStepDefs(World aWorld) {
        world = aWorld
    }

    @Given("I have a maze with the following attributes:")
    public void iHaveAGameWithTheFollowingAttributes(Map<String, Integer> gameAttributes) {
        // Implement me
    }

}
