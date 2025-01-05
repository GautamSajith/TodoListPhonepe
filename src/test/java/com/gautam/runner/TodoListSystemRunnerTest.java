package com.gautam.runner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TodoListSystemRunnerTest {
    @Test
    void testRunnerExecution() {
        assertDoesNotThrow(() -> TodoListSystemRunner.main(new String[]{}),
                "SystemRunner should execute without exceptions");
    }
}
