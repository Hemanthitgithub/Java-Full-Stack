package day27;



import org.junit.jupiter.api.*;



import static org.junit.jupiter.api.Assertions.*;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class MathOperations1 {



    private MathOperations mathOps;



    @BeforeAll

    public void setUpBeforeClass() {

        System.out.println("Setup before all tests");

        
    }



    @AfterAll

    public void tearDownAfterClass() {

        System.out.println("Cleanup after all tests");

        

    }



    @BeforeEach

    public void setUp() {

        System.out.println("Setup before each test");

        mathOps = new MathOperations();

    }



    @AfterEach

    public void tearDown() {

        System.out.println("Cleanup after each test");

        

    }



    @Test

    public void testAdd() {

        assertEquals(5, mathOps.add(2, 3));

        assertEquals(-1, mathOps.add(2, -3));

        assertEquals(0, mathOps.add(-2, 2));

    }



    @Test

    public void testSubtract() {

        assertEquals(1, mathOps.subtract(3, 2));

        assertEquals(5, mathOps.subtract(2, -3));

        assertEquals(-4, mathOps.subtract(-2, 2));

    }



    @Test

    public void testMultiply() {

        assertEquals(6, mathOps.multiply(2, 3));

        assertEquals(-6, mathOps.multiply(2, -3));

        assertEquals(4, mathOps.multiply(-2, -2));

    }



    @Test

    public void testDivide() {

        assertEquals(2, mathOps.divide(6, 3));

        assertEquals(-2, mathOps.divide(6, -3));

        assertEquals(1, mathOps.divide(-3, -3));

    }



    @Test

    public void testDivideByZero() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {

            mathOps.divide(1, 0);

        });

        assertEquals("Division by zero is not allowed.", exception.getMessage());

    }
}
