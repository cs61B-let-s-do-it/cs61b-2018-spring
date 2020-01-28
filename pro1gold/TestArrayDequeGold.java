import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TestArrayDequeGold {
    @Test
    public void testArrayDeque() {
        ArrayDequeSolution<Integer> ad = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> cd = new StudentArrayDeque<>();

        // addLast()
        for(int i = 0; i < 10; i++){
            int random = StdRandom.uniform(100);
            ad.addLast(random);
            cd.addLast(random);
        }
        for(int i = 0; i < 10; i++){
            int expected = ad.get(i);
            int actual = cd.get(i);
            assertEquals("Oh noooo!\nThis is bad in addLast():\n   Random number " + actual
                            + " not equal to " + expected + "!",
                    expected, actual);
        }

        // addFirst
        for(int i = 0; i < 10; i++) {
            int random = StdRandom(100);
            ad.addFirst(random);
            cd.addFirst(random);
        }
        for(int i = 0; i < 10; i++) {
            int expected = ad.get(i);
            int actual = cd.get(i);
            assertEquals("Oh noooo!\nThis is bad in addFirst():\n   Random number " + actual
                            + " not equal to " + expected + "!",
                    expected, actual);
        }

        // removeFirst
        List<Integer> actualList = new ArrayList<>();
        List<Integer> expectedList = new ArrayList<>();
        for (int i=0; i < 10; i++) {
            actualList.add(ad.removeFirst());
            expectedList.add(cd.removeFirst());
        }
        for(int i = 0; i < 10; i++) {
            int actual = ad.get(i);
            int expected = cd.get(i);
            System.out.println("excepted: " + expected + ", actual: " + actual);
        }
        for(int i = 0; i < 10; i++) {
            int actual = actualList.get(i);
            int expected = expectedList.get(i);
            assertEquals("Oh noooo!\nThis is bad in removeFirst():\n   Random number " + actual
                            + " not equal to " + expected + "!",
                    expected, actual);
        }

        // removeLast
        actualList.clear();
        expectedList.clear();
        for (int i = 0; i < 10; i++) {
            actualList.add(ad.removeLast());
            expectedList.add(cd.removeLast());
        }
        int actual = ad.size();
        int expected = cd.size();
        assertEquals("Oh noooo!\nThis is bad in removeLast():\n   actual size " + actual
                        + " not equal to " + expected + "!",
                expected, actual);
        for (int i = 0; i < 10; i++) {
            assertEquals("Oh noooo!\nThis is bad in removeLast():\n   Random number " + actualList.get(i)
                            + " not equal to " +  expectedList.get(i) + "!",
                    expectedList.get(i), actualList.get(i));
        }
    }
}
