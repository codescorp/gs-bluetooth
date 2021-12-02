/**
 * 
 */
package org.demo.bluetooth.driver;

import org.demo.bluetooth.models.BluetoothDeviceResponse;

/**
 * @author arpan
 *
 */
public interface I_BluetoothDriver {

	/**
	 * 
	 * @return
	 */
	public BluetoothDeviceResponse discoverBTDevices();
}
