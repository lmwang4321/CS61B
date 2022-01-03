import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testOffByOne(){

        char a = 'a';
        char b = 'c';
        boolean res = offByOne.equalChars(a, b);
        assertEquals(true, res);
    }

}