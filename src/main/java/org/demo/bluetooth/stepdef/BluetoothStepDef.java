package org.demo.bluetooth.stepdef;

import java.util.List;

import org.demo.bluetooth.conf.BluetoothAppConfig;
import org.demo.bluetooth.service.I_BluetoothService;
import org.demo.bluetooth.stepdef.table.BluetoothDeviceTableRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.DataTable;
import cucumber.api.java8.En;

/**
 * 
 * @author arpan
 *
 */
@ContextConfiguration(classes = BluetoothAppConfig.class)
public class BluetoothStepDef implements En {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BluetoothStepDef.class);
	
	@Autowired
	private I_BluetoothService bluetoothService;
	
	public BluetoothStepDef() {
		
		/**
		 * 
		 */
		Given("I discover the below bluetooth devices within (\\d+) seconds", (Integer timeOut, DataTable devices) -> {
			List<BluetoothDeviceTableRow> deviceList = devices.asList(BluetoothDeviceTableRow.class);
			for(BluetoothDeviceTableRow device : deviceList) {
				LOGGER.debug("\n{} - {}", device.getName(), device.getAddress());
			}
		});
		
		/**
		 * 
		 */
		And("I connect device with id(\\s+)", (String deviceId) -> {
	        LOGGER.debug("Implementation pending");
	    });
	}
	
}
