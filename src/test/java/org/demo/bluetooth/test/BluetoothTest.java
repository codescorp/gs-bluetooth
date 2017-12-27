/**
 * 
 */
package org.demo.bluetooth.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author arpan
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "features", plugin = {"pretty", "html: target/report"}, glue = "org.demo.bluetooth")
public class BluetoothTest {}
