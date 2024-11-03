package csci.ooad.polymorphia.stepdefs

import csci.ooad.polymorphia.EventType
import csci.ooad.polymorphia.characters.Adventurer
import csci.ooad.polymorphia.characters.Creature
import csci.ooad.polymorphia.observer.AteFoodObserver
import csci.ooad.polymorphia.observer.FightObserver
import csci.ooad.polymorphia.observer.LostHealthObserver
import csci.ooad.polymorphia.observer.MovedObserver
import io.cucumber.java.en.And
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

import static org.junit.jupiter.api.Assertions.*;

class PolymorphiaStepDefs {

    World world
    FightObserver fightObserver = new FightObserver()
    LostHealthObserver lostHealthObserver = new LostHealthObserver()
    AteFoodObserver ateFoodObserver = new AteFoodObserver()
    MovedObserver moveObserver = new MovedObserver();


    PolymorphiaStepDefs(World aWorld) {
        world = aWorld
        world.polymorphia.attach(fightObserver, EventType.FightOutcome)
        world.polymorphia.attach(lostHealthObserver,EventType.LostHealth)
        world.polymorphia.attach(ateFoodObserver,EventType.AteSomething)
        world.polymorphia.attach(moveObserver,EventType.Moved)
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

    @Then("all characters fight")
    public void allCharactersFight() {
        // TODO - Need to figure out how to check that all characters fought
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

    @Then("the Coward dies")
    public void cowardDies() {

    }

    @Then("Coward and Creature fight to the death")
    public void cowardAndCreatureFightToTheDeath() {
        lostHealthObserver.nameOfCharacterWhoLostHealth()
    }

    // TODO - Need to figure out how to get character to eat
    @Then("{string} eats the food")
    public void gluttonEatsTheFood(String adventurerName) {
        assertEquals(adventurerName, ateFoodObserver.getNameOfCharacterWhoAteFood(), "Expected '$adventurerName' to have eaten food, but it did not.")
        ateFoodObserver.reset();
    }

    // TODO - Need to figure out how to check the room for foor
    @Then("{string} does not eat the food")
    public void gluttonDoesNotEatTheFood(String adventurerName) {
        assertNotEquals(adventurerName, ateFoodObserver.getNameOfCharacterWhoAteFood(), "Expected '$adventurerName' to have not eaten food, but it did.")
        ateFoodObserver.reset();
    }

    @Then("{string} runs")
    public void theCowardRuns(String adventurerName) {
        String characterWhoRan = moveObserver.getNameOfCharacterWhoMoved();
        String origin = moveObserver.getOrigin()
        String destination = moveObserver.getDestination()
        assertEquals(adventurerName,characterWhoRan,"Character who moved did not match $adventurerName.")
        assertNotEquals(origin,destination,"Origin and Destination were supposed to be different, but were not.")
        moveObserver.reset()
    }

    @And("all characters are in the same room")
    public void allCharactersAreInTheSameRoom() {
        // TODO - Implement this
    }

}
