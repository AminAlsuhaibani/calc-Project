package com.example.calc;

import com.example.calc.controller.CalculatorController;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = CalcApplication.class)
public class CalculatorTest {
    CalculatorController controller = new CalculatorController();

    @Test
    public void testAddPositive() {
        int result = controller.add(1, 2);
        assertEquals(3, result);
    }

    @Test
    public void testAddNegative() {
        int result = controller.add(-1, 2);
        assertEquals(1, result);
    }

    @Test
    public void testSubPositive() {
        int result = controller.sub(4, 2);
        assertEquals(2, result);
    }

    @Test
    public void testSubNegative() {
        int result = controller.sub(-4, 2);
        assertEquals(-6, result);
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> controller.div(1, 0));
    }

    @Test
    public void testDivisionPositive() {
        assertEquals(2, controller.div(4, 2));
    }
    @Test
    public void testDivisionNegative() {
        assertEquals(-2, controller.div(-4, 2));
    }

}
