package day27;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class MathOperationsTest {

	
	private final MathOperations mathOperations = new MathOperations();

	    @Test
	    public void testAdd() {
	        assertEquals(5, mathOperations.add(2, 3));
	        assertEquals(0, mathOperations.add(-2, 2));
	        assertEquals(-5, mathOperations.add(-2, -3));
	    }

	    @Test
	    public void testSubtract() {
	        assertEquals(1, mathOperations.subtract(3, 2));
	        assertEquals(-4, mathOperations.subtract(-2, 2));
	        assertEquals(1, mathOperations.subtract(-2, -3));
	    }

	    @Test
	    public void testMultiply() {
	        assertEquals(6, mathOperations.multiply(2, 3));
	        assertEquals(-4, mathOperations.multiply(-2, 2));
	        assertEquals(6, mathOperations.multiply(-2, -3));
	    }

	    @Test
	    public void testDivide() {
	        assertEquals(2.0, mathOperations.divide(6, 3), 0.001);
	        assertEquals(-2.0, mathOperations.divide(-6, 3), 0.001);
	        assertEquals(2.0, mathOperations.divide(-6, -3), 0.001);

	        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
	            mathOperations.divide(1, 0);
	        });

	        assertEquals("Cannot divide by zero", exception.getMessage());
	    }
	}