import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByN = new OffByN(5);

    @Test
    public void testOffByOne(){

        char a = 'a';
        char b = 'f';
        boolean res = offByN.equalChars(a, b);
        assertEquals(true, res);
    }

}