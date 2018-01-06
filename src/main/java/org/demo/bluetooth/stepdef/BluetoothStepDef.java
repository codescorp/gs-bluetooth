package org.demo.bluetooth.stepdef;

import static org.junit.Assert.fail;

import java.util.List;

import org.demo.bluetooth.conf.BluetoothAppConfig;
import org.demo.bluetooth.models.BluetoothDeviceResponse;
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
		Given("I discover the below bluetooth devices", (DataTable devices) -> {
			List<BluetoothDeviceTableRow> deviceList = devices.asList(BluetoothDeviceTableRow.class);
			BluetoothDeviceResponse response = bluetoothService.discoverBTDevice(deviceList);
			if(!response.isSuccess()) {
				fail(response.getErrorMessage());
			}
		});
		
		/**
		 * 
		 */
		And("the bluetooth devices have the below services", (DataTable devices) -> {
			List<BluetoothDeviceTableRow> deviceList = devices.asList(BluetoothDeviceTableRow.class);
			
	    });
	}
	
}
