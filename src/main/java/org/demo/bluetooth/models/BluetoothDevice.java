/**
 * 
 */
package org.demo.bluetooth.models;

import javax.bluetooth.RemoteDevice;

/**
 * @author arixion
 *
 */
public class BluetoothDevice {

	private RemoteDevice device;
	
	public BluetoothDevice(RemoteDevice device) {
		this.device = device;
	}
}
