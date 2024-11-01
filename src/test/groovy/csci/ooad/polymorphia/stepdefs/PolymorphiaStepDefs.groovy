package csci.ooad.polymorphia.stepdefs

import io.cucumber.java.en.Then
import io.cucumber.java.en.When

import static org.junit.jupiter.api.Assertions.*;

class PolymorphiaStepDefs {

    World world


    PolymorphiaStepDefs(World aWorld) {
        world = aWorld
    }


    @When("I play the game in the created maze")
    void iPlayTheGame() {
        world.polymorphia.play();
    }

    @Then("I should be told that either all the adventurers or all of the creatures have died")
    void iShouldBeToldThatEitherAllTheAdventurersOrAllOfTheCreaturesHaveDied() {
        // Implement me
    }

    @Then("the game should be over")
    void theGameShouldBeOver() {
        assertTrue(world.polymorphia.isOver());
    }

    @Then("creature lost some health")
    public void creature_lost_some_health() {
        // TODO - how to access creature variable and check health changed
        throw new io.cucumber.java.PendingException();
    }

}
