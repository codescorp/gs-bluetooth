/**
 * 
 */
package org.demo.bluetooth.service.impl;

import java.io.IOException;
import java.util.List;

import org.demo.bluetooth.cache.BluetoothDeviceCache;
import org.demo.bluetooth.driver.I_BluetoothDriver;
import org.demo.bluetooth.models.BluetoothDevice;
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
	private BluetoothDeviceCache cache = BluetoothDeviceCache.getInstance();
	
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
		BluetoothDeviceResponse response;
		boolean matchFound = false;
		if( null != btDeviceRows && !btDeviceRows.isEmpty()) {
			response = bluetoothDriver.discoverBTDevices();
			if(response.isSuccess()) {
				// Now check the size of the cache. If it is empty then devices found.
				if(cache.isEmpty()) {
					LOGGER.error("No device found.");
					response.setErrorMessage("No devices found.");
					response.setSuccess(false);
				} else {
					List<BluetoothDevice> discoveredBTDeviceList = cache.getAllDevices();
					for(BluetoothDeviceTableRow row : btDeviceRows) {
						String expectedName = row.getName();
						String expectedAddress = row.getAddress();
						for(BluetoothDevice discoveredBTDevice : discoveredBTDeviceList) {
							// Match both name and address
							try {
								String discoveredName = discoveredBTDevice.getRemoteDevice().getFriendlyName(false);
								String discoveredAddress = discoveredBTDevice.getRemoteDevice().getBluetoothAddress();
								if(expectedName.equals(discoveredName) && expectedAddress.equals(discoveredAddress)) {
									LOGGER.info("Discovered device matched with expected");
									LOGGER.info("Name    - expected : {}\t discoverd : {} \t| Address - expected : {}\t discoverd : {}", expectedName, discoveredName, expectedAddress, discoveredAddress);
									
									response.setSuccess(true);
									matchFound = true;
									break;
								} else {
									response.setSuccess(false);
									matchFound = false;
								}
							} catch (IOException e) {
								LOGGER.error(e.getMessage());
								response.setSuccess(false);
								response.setErrorMessage(e.getMessage());
								return response;
							}
						}
						
						if(!matchFound) {
							response.setErrorMessage("No matching device found with name " + expectedName + " and address " + expectedAddress);
							response.setSuccess(false);
							break;
						}
					}
				}
			}
		} else {
			response = new BluetoothDeviceResponse();
			response.setSuccess(false);
			response.setErrorMessage("Empty name address pair provided from feature file.");
			LOGGER.error("Empty name address pair provided from feature file.");
		}
		
		return response;
	}
	
}
