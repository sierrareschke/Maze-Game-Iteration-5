package csci.ooad.polymorphia.stepdefs

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

import static org.junit.jupiter.api.Assertions.*;

class CharacterStepDefs {

    World world


    CharacterStepDefs(World aWorld) {
        world = aWorld
    }

    @Given("a Coward 'Sir Run Away'")
    public void createCowardWithName(String cowardName){

    }

    @Given("a Creature 'Ogre")
    public void createCreatureWithName(String creatureName){

    }

    @When("adventurer \"Sir Run Away\" executes his turn")
    public void adventurerExecutesTurn(String adventurerName){

    }

    @Then("creature \"Ogre\" lost some health")
    public validateCreatureLostHealth(String creatureName){

    }


}
