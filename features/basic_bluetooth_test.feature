Feature: Basic Bluetooth Discovery Test
  """
    This feature file will test the basic connectivity of the discovered
    bluetooth devices
  """

  Scenario: Discover Devices
    #Change name and address as per the device
    Given I discover the below bluetooth devices
      | name       | address      |
      | Moto G (4) | CC61E5277F59 |
		
		#Change name and service as per the device
    And the bluetooth devices have the below services
      | name       | service  |
      | Moto G (4) | Handsfree |
