Feature:
  # test that the behavior of the glutton, coward, knight, demon, creature, and adventurer is correct
  # TODO - test that glutton behavior is correct
  Scenario: Glutton is alone and will eat food
    Given a room named "Only Room" with no neighbors
    And a Glutton "Hungry Smurf"
    And there is a Food "Hamburger" added to Room "Only Room"
    And all characters are in room "Only Room"
    And the maze is successfully created

    Then Glutton eats the food

  # TODO - test that coward behavior is correct

  # TODO - test that knight behavior is correct

  # TODO - test that demon behavior is correct

  # TODO - test that creature behavior is correct

  # TODO - test that adventurer behavior is correct
  Scenario: Coward will fight a Creature and die
  Given a room named "Only Room" with no neighbors
  And a Coward "Howard"
  And all characters are in room "Only Room"
  Then a fight took place
  Then the Coward dies