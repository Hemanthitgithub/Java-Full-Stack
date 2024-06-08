package day27;

import org.junit.*;

import static org.junit.Assert.*;

class CalculatorTest {

private static Calculator calculator;

public static void setUpBeforeClass() throws Exception {


	        System.out.println("Setting up before class...");

	        calculator = new Calculator();

	    }

	        public static void tearDownAfterClass() throws Exception {


	            System.out.println("Tearing down after class...");

	            calculator = null;

	        }

	            public void setUp() throws Exception {


	                System.out.println("Setting up before each test...");

	            }

	            public void tearDown() throws Exception {


	                System.out.println("Tearing down after each test...");

	            }

	            public void testAdd() {

	                System.out.println("Running testAdd...");

	                int result = calculator.add(2, 3);

	                assertEquals(5, result);

	            }

	            public void testSubtract() {

	                System.out.println("Running testSubtract...");

	                int result = calculator.subtract(5, 3);

	                assertEquals(2, result);

	            }

	            public void testMultiply() {

	                System.out.println("Running testMultiply...");

	                int result = calculator.multiply(4, 2);

	                assertEquals(8, result);

	            }



	            @Test(expected = IllegalArgumentException.class)

	            public void testDivideByZero() {

	                System.out.println("Running testDivideByZero...");

	                calculator.divide(10, 0);

	            }

	            public void testDivide() {

	                System.out.println("Running testDivide...");

	                int result = calculator.divide(10, 2);

	                assertEquals(5, result);

	             

	    

	}



}