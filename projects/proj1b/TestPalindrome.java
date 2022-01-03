import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        Boolean bool = palindrome.isPalindrome("geeksskeeg");
        assertEquals(true, bool);
    }

    @Test
    public void testIsPalindromeTwo(){
        CharacterComparator offByOne = new OffByOne();
        Boolean bool = palindrome.isPalindrome("ac", offByOne);
        assertEquals(true, bool);
    }
}