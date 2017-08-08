package test;

import org.junit.*;
import src.*;
import static org.junit.Assert.assertArrayEquals;

public class SortingTest {
	
	private final int[] sorted = {-8,-6,-5,-4,1,4,6,8,18,20,21,21,23,26,27};
	private final int[] notSorted1 = {-5,-8,27,-6,-4,20,26,23,18,4,8,1,6,21,21};
	private Sortable sorting;
	private int[] array1;
	private int[] array2;
	
	@Before
    public void setUp() {
		sorting = null;
		array1 = java.util.Arrays.copyOfRange(notSorted1, 0, 15);
		array2 = java.util.Arrays.copyOfRange(sorted, 0, 15);
    }
	
	@Test
    public void testMergesort() {
        sorting = new Mergesort();
        sorting.sort(array1);
        sorting.sort(array2);
        assertArrayEquals(sorted, array1);
        assertArrayEquals(sorted, array2);
    }
	
	@Test
    public void testQuicksort() {
        sorting = new Quicksort();
        sorting.sort(array1);
        sorting.sort(array2);
        assertArrayEquals(sorted, array1);
        assertArrayEquals(sorted, array2);
    }
	
	@Test
    public void testHeapsort() {
        sorting = new Heapsort();
        sorting.sort(array1);
        sorting.sort(array2);
        assertArrayEquals(sorted, array1);
        assertArrayEquals(sorted, array2);
    }
}