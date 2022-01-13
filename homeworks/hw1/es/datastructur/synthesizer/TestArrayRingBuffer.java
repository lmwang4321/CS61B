package es.datastructur.synthesizer;
import org.junit.Test;
import edu.princeton.cs.introcs.*;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    private static final double DECAY = .996; // energy decay factor

    @Test
    public void someTest() {

        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(10);
        while(!arb.isFull()){
            arb.enqueue(0.0);
        }
        for(int i = 0; i < arb.capacity(); i++){
            arb.dequeue();
            arb.enqueue(Math.random()-0.5);
        }
        double first = arb.dequeue();
        double sec = arb.peek();
        double res = DECAY*0.5*(first+sec);
        arb.enqueue(res);
        int i = 0;





    }
}
