/**
 * 
 */
package org.demo.bluetooth.models;

import java.util.ArrayList;
import java.util.List;

import javax.bluetooth.RemoteDevice;
import javax.bluetooth.UUID;

/**
 * @author arixion
 *
 */
public class BluetoothDevice {

	private RemoteDevice device;
	private List<UUID> services = new ArrayList<UUID>();
	
	public BluetoothDevice(RemoteDevice device) {
		this.device = device;
	}
	
	/**
	 * 
	 * @return
	 */
	public RemoteDevice getRemoteDevice() {
		return this.device;
	}
	
	/**
	 * 
	 * @param serviceCode
	 */
	public void addService(UUID serviceCode) {
		services.add(serviceCode);
	}
	
	/**
	 * 
	 * @param serviceName
	 */
	public void addService(String serviceName) {
		
	}
}
