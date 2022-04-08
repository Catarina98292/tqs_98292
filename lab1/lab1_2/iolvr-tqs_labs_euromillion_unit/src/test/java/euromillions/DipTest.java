package euromillions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import sets.SetOfNaturals;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * @author ico0
 */
public class DipTest {

    private Dip instance;


    public DipTest() {}

    @BeforeEach
    public void setUp() {
        instance = new Dip(new int[]{10, 20, 30, 40, 50}, new int[]{1, 2});
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testConstructorFromBadArrays() {
        assertThrows( IllegalArgumentException.class, () -> new Dip(new int[]{2, 4, 6, 8}, new int[]{4, 6}));
        assertThrows( IllegalArgumentException.class, () -> new Dip(new int[]{2, 4, 6, 8}, new int[]{4}));
        assertThrows( IllegalArgumentException.class, () -> new Dip(new int[]{2, 4, 6, 8}, new int[]{2, 4, 6}));
        assertThrows( IllegalArgumentException.class, () -> new Dip(new int[]{2, 4, 6, 8, 10, 12}, new int[]{2, 4, 6}));
        assertThrows( IllegalArgumentException.class, () -> new Dip(new int[]{2, 4, 6, 8, 10, 12}, new int[]{2}));
        assertThrows( IllegalArgumentException.class, () -> new Dip(new int[]{2, 4, 6, 8, 10, 12}, new int[]{4, 6}));
        assertThrows( IllegalArgumentException.class, () -> new Dip(new int[]{2, 4, 6, 8, 10}, new int[]{2, 4, 6}));
        assertThrows( IllegalArgumentException.class, () -> new Dip(new int[]{2, 4, 6, 8, 10}, new int[]{6}));

        assertDoesNotThrow(() -> new Dip(new int[]{2, 4, 6, 8, 10}, new int[]{2, 4}));


    }



    @Test
    public void testFormat() {
        String result = instance.format();
        assertEquals("N[ 10 20 30 40 50] S[  1  2]", result, "format as string: formatted string not as expected. ");
    }

    @Test
    @DisplayName("Test Stars are between 1 and 12")
    public void testStarsNumbers() {

        SetOfNaturals possibilities = new SetOfNaturals();
        possibilities.add(IntStream.rangeClosed(1, Dip.Different_STARTS).boxed().mapToInt(i->i).toArray());
        instance.getStarsColl().forEach(integer -> assertTrue(possibilities.contains(integer)));

    }

    @Test
    @DisplayName("Test Numbers are between 1 and 50")
    public void testNumbersNumbers() {

        SetOfNaturals possibilities = new SetOfNaturals();
        possibilities.add(IntStream.rangeClosed(1, Dip.Different_STARTS).boxed().mapToInt(i->i).toArray());

        instance.getStarsColl().forEach(integer -> assertTrue(possibilities.contains(integer)));

    }
}
