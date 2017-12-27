/**
 * 
 */
package org.demo.bluetooth.service.impl;

import java.util.List;

import org.demo.bluetooth.driver.I_BluetoothDriver;
import org.demo.bluetooth.models.BluetoothDeviceResponse;
import org.demo.bluetooth.service.I_BluetoothService;
import org.demo.bluetooth.stepdef.table.BluetoothDeviceTableRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arixion
 *
 */
@Component(value = "bluetoothService")
public class BluetoothService implements I_BluetoothService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BluetoothService.class);
	
	@Autowired
	private I_BluetoothDriver bluetoothDriver;
	
	public BluetoothService() {
		LOGGER.debug("initializing bluetooth service");
		initialize();
	}
	
	private void initialize() {
		LOGGER.debug("Empty initialization block");
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.demo.bluetooth.service.I_BluetoothService#discoverBTDevice(java.util.List)
	 */
	@Override
	public BluetoothDeviceResponse discoverBTDevice(List<BluetoothDeviceTableRow> btDeviceRows) {
		BluetoothDeviceResponse response = new BluetoothDeviceResponse();
		
		return response;
	}
	
}
