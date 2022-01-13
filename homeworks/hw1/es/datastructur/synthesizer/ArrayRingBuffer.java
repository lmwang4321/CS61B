package es.datastructur.synthesizer;
import org.testng.internal.junit.ArrayAsserts;

import javax.swing.text.html.HTMLDocument;
import java.security.DrbgParameters;
import java.util.Iterator;

//TODO: Make sure to that this class and all of its methods are public
//TODO: Make sure to add the override tag for all overridden methods
//TODO: Make sure to make this class implement BoundedQueue<T>

public class ArrayRingBuffer<T> implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator implements Iterator<T> {
        private int idxPos;

        public ArrayRingBufferIterator(){
            idxPos = first;
        }
        @Override
        public T next(){
            if(!hasNext()){return null;}
            idxPos++;
            return rb[idxPos];
        }

        @Override
        public boolean hasNext(){
            int nextPos = idxPos+1;
            if (nextPos > rb.length-1){
                nextPos = 0;
            }
            return (rb[nextPos]!=null);
        }
    }

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        first = last = fillCount = 0;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public int capacity() {
        return rb.length;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update
        //       last. Don't worry about throwing the RuntimeException until you
        //       get to task 4.
        if (isFull()) {
            throw new RuntimeException("Buffer is full! Stop inserting any more items");
        }
        if (last == rb.length) {
            last = 0;
        }
        rb[last++] = x;
        fillCount++;

    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and
        //       update first. Don't worry about throwing the RuntimeException until you
        //       get to task 4.
        if (isEmpty()) {
            throw new RuntimeException("Buffer is Empty. Nothing to dequeue.");
        }
        T temp = rb[first];
        rb[first++] = null;
        fillCount--;
        if (first == rb.length) {
            first = 0;
        }
        return temp;

    }

    @Override
    public T peek(){
        return rb[first];
    }

        /**
         * Return oldest item, but don't remove it. If the buffer is empty, then
         * throw new RuntimeException("Ring buffer underflow").
         */

        // TODO: When you get to part 4, implement the needed code to support
        //       iteration and equals.

}
    // TODO: Remove all comments that say TODO when you're done.