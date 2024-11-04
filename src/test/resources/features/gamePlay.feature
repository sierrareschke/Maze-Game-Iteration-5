Feature: Test gameplay outcomes

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



    Scenario: Deaths should be properly tracked assuming Adventurers die
      Given I have a maze with the following attributes:
        | number of rooms       | 3 |
        | number of adventurers | 3 |
        | number of demons      | 20 |
      And the maze is successfully created

      When I play the game in the created maze

      Then I should be told that either all the adventurers or all of the creatures have died
      And the game should be over
      And there should be at least 3 deaths



  Scenario: Maze observer is notified of the correct number of death events
    Given I have a maze with the following attributes:
      | number of rooms       | 3 |
      | number of adventurers | 3 |
      | number of creatures   | 2 |
    And the maze is successfully created
    When I play the game until all adventurers or all creatures have died
    Then the maze observer is notified of at least 2 death events
