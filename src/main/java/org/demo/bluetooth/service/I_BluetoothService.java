package org.demo.bluetooth.service;

import java.util.List;

import org.demo.bluetooth.models.BluetoothDeviceResponse;
import org.demo.bluetooth.stepdef.table.BluetoothDeviceTableRow;

public interface I_BluetoothService {

	/**
	 * 
	 * @param btDeviceRows
	 * @return
	 */
	public BluetoothDeviceResponse discoverBTDevice(List<BluetoothDeviceTableRow> btDeviceRows);
}