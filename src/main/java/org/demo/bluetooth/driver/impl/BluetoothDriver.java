/**
 * 
 */
package org.demo.bluetooth.driver.impl;

import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;

import org.demo.bluetooth.cache.BluetoothDeviceCache;
import org.demo.bluetooth.driver.I_BluetoothDriver;
import org.demo.bluetooth.listener.BluetoothDeviceDiscoverer;
import org.demo.bluetooth.models.BluetoothDeviceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author arixion
 *
 */
@Component(value = "bluetoothDriver")
public class BluetoothDriver implements I_BluetoothDriver{

	private static final Logger LOGGER = LoggerFactory.getLogger(BluetoothDriver.class);
	private BluetoothDeviceCache cache = BluetoothDeviceCache.getInstance();
	private Object InquieryEvent = new Object();
	
	public BluetoothDriver() {
		LOGGER.debug("Initializing bluetooth driver");
		initialize();
	}
	
	private void initialize() {
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.demo.bluetooth.driver.I_BluetoothDriver#discoverBTDevices()
	 */
	public BluetoothDeviceResponse discoverBTDevices() {
		BluetoothDeviceResponse response = new BluetoothDeviceResponse();
		
		synchronized (InquieryEvent) {
			LocalDevice localDevice;
			try {
				localDevice = LocalDevice.getLocalDevice();
		        DiscoveryAgent localDiscoveryAgent = localDevice.getDiscoveryAgent();
		        LOGGER.info("Starting device discovery...");
		        boolean inqStarted = localDiscoveryAgent.startInquiry(DiscoveryAgent.GIAC, new BluetoothDeviceDiscoverer(InquieryEvent));
		        if(inqStarted) {
		        	try {
		        		InquieryEvent.wait();
		        	} catch (InterruptedException e) {
						LOGGER.error(e.getMessage());
						response.setErrorMessage(e.getMessage());
						return response;
					}
		        }
		        LOGGER.info("Bluetooth device cache after remote device discovery - \n{}\n", cache);
		        // Device list can be empty though search is success.
		        response.setSuccess(true);
			} catch(BluetoothStateException e) {
				LOGGER.error(e.getMessage());
				response.setErrorMessage(e.getMessage());
			}
		}
		
		return response;
	}
}
