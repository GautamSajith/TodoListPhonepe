package com.gautam.config;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TLSConfigurationTest {
    @Test
    void testTLSConfigurationInitialization() {
        TLSConfiguration config = new TLSConfiguration();
        assertNotNull(config, "TLSConfiguration should be initialized");
    }
}
