/**
 * 
 */
package org.demo.bluetooth.listener;

import java.io.IOException;

import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;

import org.demo.bluetooth.cache.BluetoothDeviceCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author arixion
 *
 */
public class BluetoothDeviceDiscoverer implements DiscoveryListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BluetoothDeviceDiscoverer.class);

	private BluetoothDeviceCache cache = BluetoothDeviceCache.getInstance();
	
	private Object eventLock;
	
	/**
	 * 
	 * @param InquiryEvent
	 */
	public BluetoothDeviceDiscoverer(final Object eventLock) {
		this.eventLock = eventLock;
	}
	
	/* (non-Javadoc)
	 * @see javax.bluetooth.DiscoveryListener#deviceDiscovered(javax.bluetooth.RemoteDevice, javax.bluetooth.DeviceClass)
	 */
	@Override
	public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
		try {
            String deviceFriendlyName = btDevice.getFriendlyName(false);
            LOGGER.info("Device discovered {} - {}", deviceFriendlyName, btDevice.getBluetoothAddress());
            cache.putDevice(deviceFriendlyName, btDevice);
        } catch (IOException exp) {
            LOGGER.error(exp.getMessage());
        }
	}

	/* (non-Javadoc)
	 * @see javax.bluetooth.DiscoveryListener#servicesDiscovered(int, javax.bluetooth.ServiceRecord[])
	 */
	@Override
	public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.bluetooth.DiscoveryListener#serviceSearchCompleted(int, int)
	 */
	@Override
	public void serviceSearchCompleted(int transID, int respCode) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.bluetooth.DiscoveryListener#inquiryCompleted(int)
	 */
	@Override
	public void inquiryCompleted(int discType) {
		LOGGER.info("Device inquiry is completed");
        synchronized (this.eventLock) {
            this.eventLock.notifyAll();
        }
	}

}
