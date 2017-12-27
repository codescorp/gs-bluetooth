/**
 * 
 */
package org.demo.bluetooth.stepdef.table;

/**
 * @author arpan
 *
 */
public class BluetoothDeviceTableRow {

	private String name;
	private String address;
	
	/**
	 * @param name
	 * @param address
	 */
	public BluetoothDeviceTableRow(String name, String address) {
		this.name = name;
		this.address = address;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}
