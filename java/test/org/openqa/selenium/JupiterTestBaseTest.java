package org.openqa.selenium;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.testing.JupiterTestBase;

// Dylan Molly and Geo test coverage. Calls create/remove driver, increasing coverage of JupiterTestBase.java from 60% to 80% (function calls)
class JupiterTestBaseTest extends JupiterTestBase {

    @Test
    void canCreateNewDriver() {

        WebDriver originalDriver = driver;
        
        // Create capabilities
        Capabilities capabilities = new DesiredCapabilities();
        
        // Create new driver
        createNewDriver(capabilities);
        
        // Verify the new driver is created and different from the original
        assertNotNull(driver, "New driver should not be null");
        assertThat(driver).isNotSameAs(originalDriver);
        
        // Verify wait objects are properly initialized
        assertNotNull(wait, "Wait object should not be null");
        assertNotNull(shortWait, "Short wait object should not be null");
        
    }

    @Test
    void canCreateAndDestroyDriver() {
        WebDriver originalDriver = driver;

        // Create new driver with basic capability
        Capabilities capabilities = new DesiredCapabilities();
        createNewDriver(capabilities);

        // Make sure driver exists
        assertNotNull(driver, "New driver should not be null");
        assertThat(driver).isNotSameAs(originalDriver);

        // Destroy the driver
        removeDriver();

        assertNull(driver, "Driver should be null after removal");
    }

    @Test 
    void testCreateDriverWithNullCapabilities() {
        WebDriver originalDriver = driver;

        // Assert that creating a null capability driver doesn't work
        assertThrows(NullPointerException.class, () -> {
            createNewDriver(null);
        }, "Create driver should fail with null params");
    }
}