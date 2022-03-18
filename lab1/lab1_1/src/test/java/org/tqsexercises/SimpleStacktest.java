package org.tqsexercises;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleStacktest {
    int N = 10;
    Stack<String> stack;

    @BeforeEach
    public void createStack(){
        stack = new SimpleStack();
    }

    @Test
    @DisplayName("A stack has size 0 on construction.")
    public void testStacksize0Init(){
        assertEquals(0, stack.size());
    }

    @Test
    @DisplayName("A stack is empty on construction.")
    public void testIsEmptyInit(){ assertEquals(true, stack.isEmpty()); }

    @Test
    @DisplayName("After n pushes to an empty stack, n > 0, the stack is not empty and its size is n.")
    public void testNPushes() {

        assertEquals(true, stack.isEmpty());

        for (int n = 0; n < N; n++) {
            stack.push("Hello World! " + n);
        }

        assertEquals(false, stack.isEmpty());
        assertEquals(N,stack.size());

    }

    @Test
    @DisplayName("If one pushes x then pops, the value popped is x.")
    public void testPushesXPOPSX() {

        stack.push("x");
        assertEquals("x", stack.pop());

    }

    @Test
    @DisplayName("If one pushes x then peeks, the value returned is x, but the size stays the same.")
    public void testPushesXPeeksXSizeStay() {

        stack.push("x");

        int size = stack.size();

        assertEquals("x", stack.peek());
        assertEquals(size,stack.size());

    }

    @Test
    @DisplayName("If the size is n, then after n pops, the stack is empty and has a size 0.")
    public void testAfterLastPopSize0() {

        for (int n = 0; n < N; n++) {
            stack.push("test" + n);
        }

        assertEquals(N,stack.size());

        for (int n = 0; n < N; n++) {
            stack.pop();
        }

        assertEquals(0, stack.size());

    }

    @Test
    @DisplayName("Popping from an empty stack does throw a NoSuchElementException.")
    public void testPopFromEmptyReturnsNoSuchElementException (){
        assertThrows(NoSuchElementException.class, () -> stack.pop());
    }

    @Test
    @DisplayName("Peeking into an empty stack does throw a NoSuchElementException")
    public void testPeekFromEmptyReturnsNoSuchElementException (){
        assertThrows(NoSuchElementException.class, () -> stack.peek());
    }

    @Test
    @DisplayName("For bounded stacks only:pushing onto a full stack does throw an IllegalStateException")
    public void testBoundedStackLimit (){
        stack = new BoundedStack(3);

        stack.push("Object 0");
        stack.push("Object 1");
        stack.push("Object 2");

        assertThrows(IllegalStateException.class, () -> stack.push("Object 3"));
    }
}
