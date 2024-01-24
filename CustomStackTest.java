import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomStackTest {

    @Test
    public void testPushAndPop() {
        CustomStack<Integer> stack = new CustomStack<>();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        stack.push(1);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());

        int poppedValue = stack.pop();
        assertEquals(1, poppedValue);
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testIsEmpty() {
        CustomStack<Double> stack = new CustomStack<>();
        assertTrue(stack.isEmpty());

        stack.push(3.14);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSize() {
        CustomStack<Character> stack = new CustomStack<>();
        assertEquals(0, stack.size());

        stack.push('a');
        stack.push('b');
        assertEquals(2, stack.size());

        stack.pop();
        assertEquals(1, stack.size());

        stack.pop();
        assertEquals(0, stack.size());
    }
}
