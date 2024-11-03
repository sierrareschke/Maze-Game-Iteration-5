Feature: Test Character Gameplay Behaviors
  # test that the behavior of the glutton, coward, knight, demon, creature, and adventurer is correct


  Scenario: Glutton is alone and will eat food
    Given a room named "Only Room" with 0 neighbors
    And a Glutton "Hungry Smurf"
    And there is a Food "Hamburger" added to Room "Only Room"
    And all characters are in room "Only Room"
    And the maze is successfully created

    When adventurer "Hungry Smurf" executes his turn

    Then "Hungry Smurf" eats the food


  # TODO - test that coward behavior is correct
  # Cowards always run from creature but can't run from demon
  Scenario: Coward is in the same room as a creature and will flee
    And a room named "Origin" with 1 neighbors
    Given a Creature "Boogie Man"
    And a Coward "Scaredy Cat"
    And the maze is successfully created

    When all characters are in room "Origin"
    And adventurer "Scaredy Cat" executes his turn

    Then "Scaredy Cat" runs

  Scenario: Coward is in the same room as a Demon and will fight
    And a room named "Origin" with 1 neighbors
    Given a Demon "Satan"
    And a Coward "Scaredy Cat"
    And the maze is successfully created

    When all characters are in room "Origin"
    And adventurer "Scaredy Cat" executes his turn

    Then a fight took place

  # TODO - test that knight behavior is correct
  # Knight always fights creature
  Scenario: Knight is in the same room as a creature
    Given a room named "Only Room" with 0 neighbors
    And a Knight "Lancealot"
    And a Creature "Ogre"
    And all characters are in room "Only Rom"
    And the maze is successfully created
    Then a fight took place

  # TODO - test that demon behavior is correct
  # Demon always fights all adventurers in the room at the same time
  Scenario: Demon is in the same room as multiple adventurers
    Given a room named "Only Room" with 0 neighbors
    And a Coward "Harold"
    And a Glutton "Richard"
    And all characters are in room "Only Rom"
    And the maze is successfully created
    Then all characters fight

  # TODO - test that creature behavior is correct
  # Creatures fight the adventurers
  Scenario: Creature is in the same room as an adventurer
    Given a room named "Only Room" with 0 neighbors
    And a Glutton "Richard"
    And all characters are in room "Only Rom"
    And the maze is successfully created
    Then a fight took place

  # TODO - test that adventurer behavior is correct
  Scenario: Coward will fight a Creature and die
  Given a room named "Only Room" with 0 neighbors
  And a Coward "Howard"
  And all characters are in room "Only Room"
  Then a fight took place
  Then the Coward dies