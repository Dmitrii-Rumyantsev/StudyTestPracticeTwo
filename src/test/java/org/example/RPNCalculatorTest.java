package org.example;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RPNCalculatorTest {

    private RPNCalculator calculator;

    @Before
    public void setUp() {
        calculator = new RPNCalculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void evaluateRPNWithEmptyString() {
        try {
            assertThrows(IllegalArgumentException.class, () -> calculator.evaluateRPN(" "));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void evaluateRPNWithOneNumber() {
        try {
            assertThrows(IllegalArgumentException.class, () -> calculator.evaluateRPN("1 /"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void evaluateRPNWithNotIntegerDate() {
        try {
            assertThrows(NumberFormatException.class, () -> calculator.evaluateRPN("1.0 1.2 /"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void plusOperation() {
        RPNCalculator.stack.push(1);
        RPNCalculator.stack.push(2);
        calculator.plusOperation();
        assertEquals(3, RPNCalculator.stack.pop(), 0.001);
    }

    @Test
    public void minusOperation() {
        RPNCalculator.stack.push(1);
        RPNCalculator.stack.push(2);
        calculator.minusOperation();
        assertEquals(1, RPNCalculator.stack.pop(), 0.001);
    }

    @Test
    public void divisionOperation() {
        RPNCalculator.stack.push(1);
        RPNCalculator.stack.push(2);
        calculator.divisionOperation();
        assertEquals(2, RPNCalculator.stack.pop(), 0.001);
    }

    @Test
    public void multiplicationOperation() {
        RPNCalculator.stack.push(1);
        RPNCalculator.stack.push(2);
        calculator.multiplicationOperation();
        assertEquals(2, RPNCalculator.stack.pop(), 0.001);
    }
}