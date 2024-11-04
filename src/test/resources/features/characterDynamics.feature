Feature: Test Character Gameplay Behaviors

  # Glutton Scenarios

  Scenario: Glutton is alone and will eat food if available
    Given a room named "Only Room" with 0 neighbors
    And a Glutton "Hungry Smurf"
    And there is a Food "Hamburger" added to Room "Only Room"
    And the maze is successfully created

    When adventurer "Hungry Smurf" executes his turn

    Then "Hungry Smurf" eats the food

  Scenario: Glutton doesn't fight because no demon or food
    Given a room named "Origin" with 1 neighbors
    And a Glutton "Hungry Smurf"
    And a Creature "Scary Spider"
    And the maze is successfully created

    When all characters are in room "Origin"
    When adventurer "Hungry Smurf" executes his turn

    Then "Hungry Smurf" runs

  Scenario: Glutton must fight because of Demon presence
    Given a room named "Origin" with 1 neighbors
    And a Glutton "Hungry Smurf"
    And a Demon "Death Eater"
    And the maze is successfully created

    When all characters are in room "Origin"
    When adventurer "Hungry Smurf" executes his turn

    Then a fight took place



  # Coward Scenarios

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


  # Knight Scenarios

  Scenario: Knight is in the same room as a creature and will fight
    Given a room named "Only Room" with 0 neighbors
    And a Knight "Lancealot"
    And a Creature "Ogre"
    And the maze is successfully created

    When all characters are in room "Only Room"
    And adventurer "Lancealot" executes his turn

    Then a fight took place


  # Demon Scenarios

  Scenario: Demon is in the same room as multiple adventurers and will fight all of them
    Given a room named "Chamber of Secrets" with 0 neighbors
    And a Coward "Ron"
    And a Adventurer "Harry"
    And a Adventurer "Hermoine"
    And a Demon "Voldemort"
    And the maze is successfully created

    When all characters are in room "Chamber of Secrets"
    And a turn of gameplay takes place

    Then all characters fight

  # Creature & Adventure Scenario

  Scenario: Creature is in the same room as an adventurer and fights
    Given a room named "Only Room" with 0 neighbors
    And a Adventurer "Steve"
    And a Creature "Zombie"
    And the maze is successfully created

    When all characters are in room "Only Room"
    And adventurer "Steve" executes his turn
    
    Then a fight took place
