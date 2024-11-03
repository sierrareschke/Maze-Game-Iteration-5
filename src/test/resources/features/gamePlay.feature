Feature: # Enter feature name here
  # Enter feature description here

    Scenario: Play a complicated game
      Given I have a maze with the following attributes:
        | number of rooms       | 7 |
        | number of adventurers | 1 |
        | number of knights     | 2 |
        | number of cowards     | 2 |
        | number of gluttons    | 2 |
        | number of creatures   | 5 |
        | number of demons      | 2 |
        | number of food items  | 9 |
      And the maze is successfully created

      When I play the game in the created maze

      Then I should be told that either all the adventurers or all of the creatures have died
      And the game should be over


    Scenario: Coward will fight a Creature if he cannot run away
      Given a room named "Only Room" with no neighbors
      And a Coward "Sir Run Away"
      And a Creature "Ogre"
      And all characters are in room "Only Room"
      And the maze is successfully created

      When adventurer "Sir Run Away" executes his turn

      Then a fight took place
      And creature "Ogre" lost some health

    Scenario: Coward will fight a Creature if he cannot run away - version 2
      Given I have a maze with the following attributes:
        | number of rooms       | 1 |
        | number of creatures   | 1 |
      And a Coward "Sir Run Away"
      And the maze is successfully created

      When adventurer "Sir Run Away" executes his turn

      Then a fight took place
      And creature lost some health

      # TODO - test that the behavior of the glutton, coward, knight, demon, creature, and adventurer is correct

      # TODO - test that glutton behavior is correct

      # TODO - test that coward behavior is correct

      # TODO - test that knight behavior is correct

      # TODO - test that demon behavior is correct

      # TODO - test that creature behavior is correct

      # TODO - test that adventurer behavior is correct



      # TODO - that the maze observer is notified of the correct number of death events

