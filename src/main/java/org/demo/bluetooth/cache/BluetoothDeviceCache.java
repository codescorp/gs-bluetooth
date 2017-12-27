/**
 * 
 */
package org.demo.bluetooth.cache;

import java.util.HashMap;
import java.util.Map;

import javax.bluetooth.RemoteDevice;

import org.demo.bluetooth.models.BluetoothDevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author arpan
 *
 */
public class BluetoothDeviceCache {

	private static final Logger LOGGER = LoggerFactory.getLogger(BluetoothDeviceCache.class);
	
	private static BluetoothDeviceCache INSTANCE;
	
	private Map<String, BluetoothDevice> cache;
	
	private BluetoothDeviceCache() {
		initializeCache();
	}
	
	/**
	 * 
	 * @return
	 */
	public static final BluetoothDeviceCache getInstance() {
		LOGGER.info("Initializing bluetooth device cache");
		if(null == INSTANCE) {
			synchronized (BluetoothDeviceCache.class) {
				if(null == INSTANCE) {
					INSTANCE = new BluetoothDeviceCache();
				}
			}
		}
		return INSTANCE;
	}
	
	/**
	 * 
	 */
	private void initializeCache() {
		if(null == cache) {
			LOGGER.info("Creating the internal cache");
			cache = new HashMap<>();
		}
		else {
			LOGGER.info("Cache already initialized");
		}
	}
	
	/**
	 * 
	 * @param deviceName
	 * @param device
	 */
	public void putDevice(String deviceName, RemoteDevice device) {
		BluetoothDevice btDevice = new BluetoothDevice(device);
		cache.put(deviceName, btDevice);
	}
	
	/**
	 * 
	 * @param deviceName
	 * @param device
	 */
	public void putDevice(String deviceName, BluetoothDevice device) {
		cache.put(deviceName, device);
	}
	
	/**
	 * 
	 * @param deviceName
	 * @return
	 */
	public BluetoothDevice getDevice(String deviceName) {
		return cache.get(deviceName);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BluetoothDeviceCache [cache=");
		builder.append(cache);
		builder.append("]");
		return builder.toString();
	}
}
