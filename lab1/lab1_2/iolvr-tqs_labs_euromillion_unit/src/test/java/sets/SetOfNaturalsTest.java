/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * @author ico0
 */
public class SetOfNaturalsTest {
    private SetOfNaturals setA;
    private SetOfNaturals setB;
    private SetOfNaturals setC;
    private SetOfNaturals setD;

    @BeforeEach
    public void setUp() {
        setA = new SetOfNaturals();
        setB = SetOfNaturals.fromArray(new int[]{10, 20, 30, 40, 50, 60});

        setC = new SetOfNaturals();
        for (int i = 5; i < 50; i++) {
            setC.add(i * 10);
        }
        setD = SetOfNaturals.fromArray(new int[]{30, 40, 50, 60, 10, 20});
    }

    @AfterEach
    public void tearDown() {
        setA = setB = setC = setD = null;
    }

    @Test
    public void testAddElement() {

        setA.add(99);
        assertTrue(setA.contains(99), "add: added element not found in set.");
        assertEquals(1, setA.size());

        setB.add(11);
        assertTrue(setB.contains(11), "add: added element not found in set.");
        assertEquals(7, setB.size(), "add: elements count not as expected.");
    }

    @Test
    public void testAddBadArray() {
        int[] elems = new int[]{10, 20, -30};

        // must fail with exception
        assertThrows(IllegalArgumentException.class, () -> setA.add(elems));
    }


    @Test
    public void testIntersectForNoIntersection() {
        assertFalse(setA.intersects(setB), "no intersection but was reported as existing");
        assertTrue(setB.intersects(setD), "has intersection but was reported as non-existing");
        assertTrue(setC.intersects(setB), "has intersection but was reported as non-existing");

    }

    @Test
    void testSetSize() {
        assertEquals(0, setA.size(), "n values were entered in the set, but the size is not n");
        assertEquals(6, setB.size(), "n values were entered in the set, but the size is not n");
        assertEquals(45, setC.size(), "n values were entered in the set, but the size is not n");
        assertEquals(6, setD.size(), "n values were entered in the set, but the size is not n");
    }

    @Test
    void testSetContains() {
        assertFalse(setB.contains(80), "a value that was never added to the set, is inside the set");
        assertTrue(setB.contains(50), "a value that was added to the set, is not within the set");
        assertFalse(setC.contains(2), "a value that was never added to the set, is inside the set");
        assertFalse(setC.contains(71), "a value that was never added to the set, is inside the set");
        assertTrue(setC.contains(90), "a value that was added to the set, is not within the set");
        assertTrue(setC.contains(250), "a value that was added to the set, is not within the set");
        assertFalse(setD.contains(88), "a value that was never added to the set, is inside the set");
        assertTrue(setD.contains(50), "a value that was added to the set, is not within the set");

    }

    @Test
    public void testAddDuplicate() {
        assertThrows(IllegalArgumentException.class, () -> setB.add(30), "duplication exception is missing");
        assertThrows(IllegalArgumentException.class, () -> setC.add(90), "duplication exception is missing");
        assertThrows(IllegalArgumentException.class, () -> setD.add(60), "duplication exception is missing");

        assertThrows(IllegalArgumentException.class, () -> setB.add(new int[] {50, 12, 10}), "duplication exception is missing");
        assertThrows(IllegalArgumentException.class, () -> setC.add(new int[] {91, 60, 210}), "duplication exception is missing");
        assertThrows(IllegalArgumentException.class, () -> setD.add(new int[] {20, 22, 21}), "duplication exception is missing");
    }

    @Test
    void testAdd0orNegative() {

        assertThrows(IllegalArgumentException.class, () -> setA.add(0), "no exception for entering 0");
        assertThrows(IllegalArgumentException.class, () -> setA.add(-2),"no exception for entering negative values");
        assertThrows(IllegalArgumentException.class, () -> setB.add(0), "no exception for entering 0");
        assertThrows(IllegalArgumentException.class, () -> setB.add(-7), "no exception for entering negative values");
        assertThrows(IllegalArgumentException.class, () -> setC.add(0), "no exception for entering 0");
        assertThrows(IllegalArgumentException.class, () -> setC.add(-90), "no exception for entering negative values");
        assertThrows(IllegalArgumentException.class, () -> setD.add(0), "no exception for entering 0");
        assertThrows(IllegalArgumentException.class, () -> setC.add(-9), "no exception for entering negative values");

        assertThrows(IllegalArgumentException.class, () -> setA.add(new int[] {9,-9,0}), "no exception for entering negative values or 0");
        assertThrows(IllegalArgumentException.class, () -> setB.add(new int[] {-8,0}), "no exception for entering negative values or 0");
        assertThrows(IllegalArgumentException.class, () -> setC.add(new int[] {10,-2}), "no exception for entering negative values");
        assertThrows(IllegalArgumentException.class, () -> setD.add(new int[] {22,55,0}), "no exception for entering 0");

    }

    @Test
    void testFromArray() {
        assertEquals(setD, SetOfNaturals.fromArray(new int[]{30, 40, 50, 60, 10, 20}));
    }



}
