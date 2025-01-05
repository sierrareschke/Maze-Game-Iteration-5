## Adding Encapsulation and Behavior-Driven-Design

Room encapsulation can be done via package protected (not really, as we can add any class to that package), an inner class of the Maze (so that we can use the private methods), or we can make the objects immutable (return deep copy of Maze), or have the Maze handle the contents of each room internally.


### Introduction
#### Team Members: 
Grace Ohlsen, Sierra Reschke and Nolan Brady 

#### Java Version: 21

#### Comments/Assumptions: 

The maze was encapsulated by protecting any method or value within the class that wasn't imperative to expose. 
The maze and room classes were then also packaged for increased encapsulation. Any method that returned information from the class was
also made to be immutable to increase the protection of the state within the object returning the data.

The BDD tests were split into a game test and a character test. The files are `gamePlay.feature` and `characterDynamics.feature` respectively.
Each type of observer is tested in the `gamePlay.feature` file utilizing maze and polymorphia stepdefs to ensure they are receiving data correctly.

### Required Capabilities

* Encapsulate your maze object.
* Create a new TestObserver 
* Write BDD tests that test: 
  * Implement the BDD tests in the repository
  * a maze can be built with any number of adventurers, knights, cowards, gluttons, creatures, demons, and food
  * that the behavior of the glutton, coward, knight, demon, creature, and adventurer is correct
  * that the maze observer is notified of the correct number of death events
* Create step definitions to implement these tests. You must use at least two separate step definition files.

## Encapsulation

Encapsulate your maze object. Once created, a client should not be able to add or remove rooms, change any connections, 
or add any new (not already in the maze) items to any room. In lecture we talked about a number of different approaches
to encapsulation. This will likely involve encapsulating the Room object in this repository, though if you are 
extending your previous repository and don't have a Room object, that is fine. Also, if you prefer to not use a Room
object, you can remove this object from this repository, though that will add more work. You are free to change
anything about this repository to achieve this goal.

## Test Observer

Create an observer that is automatically added to the BDD tests (no explicit step doing this in the feature file), so
that you can assert that the correct events are occurring by querying this observer. Since this is a test observer,
the source code for it will exist only in the src/test/java directory.

## BDD Tests

You should start by writing clear, readable, understandable-by-a-non-programmer scenarios in your feature files. Use
the two examples that you have to get working as guidelines. Once the scenarios are written, you'll have to implement
the step definitions. There are currently two groovy files created for writing your step definitions, but you'll need to
create at least one additional step definition file. A good way to approach this is to have steps that deal with 
maze creation in the MazeStepDefinition class and steps that deal with Character creation and play in the 
CharacterDefinitionFile, etc., but that's up to you.

While the given step definition files (e.ge. _PolymorphiaStepDefs_) are written in Groovy, you can write you step 
definitions in Java if you prefer. You can even do this (with some restrictions) in the existing Groovy file.
