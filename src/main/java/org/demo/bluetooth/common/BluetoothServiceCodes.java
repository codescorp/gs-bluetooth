/**
 * 
 */
package org.demo.bluetooth.common;

/**
 * @author arixion
 *
 */
public enum BluetoothServiceCodes {

	
	HANDS_FREE("Handsfree", 0x111E),
	HEADSET("Headset", 0x1131),
	HEADSET_HS("Headset - HS", 0x1131);
	
	private String name;	// Service class name. See https://www.bluetooth.com/specifications/assigned-numbers/service-discovery
	private long code;
	/**
	 * @param name
	 * @param code
	 */
	private BluetoothServiceCodes(String name, long code) {
		this.name = name;
		this.code = code;
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
	 * @return the code
	 */
	public long getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(long code) {
		this.code = code;
	}
	
}
