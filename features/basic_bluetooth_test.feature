Feature: Basic Bluetooth Discovery Test
  """
    This feature file will test the basic connectivity of the discovered
    bluetooth devices
  """

  Scenario: Discover Devices
    Given I discover the below bluetooth devices within 5 seconds
      | name       | address      |
      | Moto G (4) | CC61E5277F59 |