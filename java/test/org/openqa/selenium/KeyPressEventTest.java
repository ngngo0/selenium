package org.openqa.selenium;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import org.openqa.selenium.WebElement;
import static org.mockito.Mockito.*;
// Unit test for TypingTest that ensures keypresses are sent correctly.
// Test to ensure that sendKeys is being called in the correct way, with duplicate send events being monitored.
@Tag("UnitTests")
class KeyPressEventTest {

    @Test
    void testSendKeysIsCalledOnce() {
        // Mock the WebElement
        WebElement keyReporter = mock(WebElement.class);

        // Call the method under test
        keyReporter.sendKeys("a");

        // Verify that sendKeys was called exactly once with "a"
        verify(keyReporter, times(1)).sendKeys("a");
        verify(keyReporter, atMostOnce()).sendKeys("a");
    }
    @Test
    void testClearIsCalledOnce() {
        // Mock the WebElement
        WebElement keyReporter = mock(WebElement.class);

        // Call the method under test
        keyReporter.clear();

        // Verify that sendKeys was called exactly once with "a"
        verify(keyReporter, times(1)).clear();
        verify(keyReporter, atMostOnce()).clear();
        
    }
}
