package csci.ooad.polymorphia.stepdefs

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class PolymorphiaStepDefs {

    World world


    PolymorphiaStepDefs(World aWorld) {
        world = aWorld
    }


    @When("I play the game in the created maze")
    void iPlayTheGame() {
        // Implement me
    }

    @Then("I should be told that either all the adventurers or all of the creatures have died")
    void iShouldBeToldThatEitherAllTheAdventurersOrAllOfTheCreaturesHaveDied() {
        // Implement me
    }

    @Then("the game should be over")
    void theGameShouldBeOver() {
        // Implement me
    }

}
