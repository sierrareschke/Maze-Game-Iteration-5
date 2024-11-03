package csci.ooad.polymorphia.stepdefs

import csci.ooad.polymorphia.EventType
import csci.ooad.polymorphia.characters.Adventurer
import csci.ooad.polymorphia.characters.Creature
import csci.ooad.polymorphia.observer.FightObserver
import csci.ooad.polymorphia.observer.LostHealthObserver
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

import static org.junit.jupiter.api.Assertions.*;

class PolymorphiaStepDefs {

    World world
    FightObserver fightObserver = new FightObserver()
    LostHealthObserver lostHealthObserver = new LostHealthObserver()


    PolymorphiaStepDefs(World aWorld) {
        world = aWorld
        world.polymorphia.attach(fightObserver, EventType.FightOutcome)
        world.polymorphia.attach(lostHealthObserver,EventType.LostHealth)
    }


    @When("I play the game in the created maze")
    void iPlayTheGame() {
        world.polymorphia.play();
    }

    @When("adventurer {string} executes his turn")
    public void adventurerExecutesHisTurn(String adventurerName) {
        List<Adventurer> adventurers = world.polymorphia.getLivingAdventurers();
        Adventurer specifiedAdventurer = adventurers.find { it.name == adventurerName }

        if (specifiedAdventurer) {
            specifiedAdventurer.doAction()
        } else {
            System.out.println("Adventurer '$adventurerName' not found in the maze")
        }
    }


    @Then("a fight took place")
    public void aFightTookPlace() {
        assertTrue(fightObserver.hasFightOccurred(), "Expected a fight to have taken place, but no fight was observed.")
        fightObserver.reset();
    }

    @Then("I should be told that either all the adventurers or all of the creatures have died")
    void iShouldBeToldThatEitherAllTheAdventurersOrAllOfTheCreaturesHaveDied() {
        // Implement me
    }

    @Then("the game should be over")
    void theGameShouldBeOver() {
        assertTrue(world.polymorphia.isOver());
    }

    @Then("creature {string} lost some health")
    public void creatureLostSomeHealth(String creatureName) {
        assertEquals(creatureName, lostHealthObserver.getNameOfCharacterWhoLostHealth(), "Expected '$creatureName' to have lost health, but it did not.")
        lostHealthObserver.reset(); // Reset for future checks
    }


    @Then("creature lost some health")
    public void creatureLostSomeHealth() {
        String characterWithLostHealth = lostHealthObserver.getNameOfCharacterWhoLostHealth()
        assertTrue(characterWithLostHealth != null)
        lostHealthObserver.reset()
    }

}
