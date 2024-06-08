package day27;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringUtilsTest {

    private StringUtils stringUtils;

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
        stringUtils = new StringUtils();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Cleanup after each test");
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stringUtils.isEmpty(null));
        assertTrue(stringUtils.isEmpty(""));
        assertFalse(stringUtils.isEmpty("abc"));
    }

    @Test
    public void testReverse() {
        assertEquals("cba", stringUtils.reverse("abc"));
        assertEquals("", stringUtils.reverse(""));
        assertEquals(null, stringUtils.reverse(null));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertFalse(stringUtils.isPalindrome("hello"));
        assertFalse(stringUtils.isPalindrome(null));
        assertTrue(stringUtils.isPalindrome(""));  // Considering empty string as palindrome
    }
}