//IMPORTANT: this file depends on the junit-platform-console-standalone-*.*.*.jar found on Junit5's website
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class SortTest{
    @Test
    public void testBubbleSort(){
        int[] randArr = Sort.generateRandomNums(100);
        int[] sortArr = Sort.quickSort(randArr, 0, randArr.length - 1);
        assertArrayEquals(sortArr, Sort.bubbleSort(randArr));
    }
    @Test
    public void testSelectionSort(){
        int[] randArr = Sort.generateRandomNums(100);
        int[] sortArr = Sort.bubbleSort(randArr);
        assertArrayEquals(sortArr, Sort.selectionSort(randArr));
    }

    @Test
    public void testInsertionSort(){
        int[] randArr = Sort.generateRandomNums(100);
        int[] sortArr = Sort.selectionSort(randArr);
        assertArrayEquals(sortArr, Sort.insertionSort(randArr));
    }
    @Test
    public void testMergeSort(){
        int[] randArr = Sort.generateRandomNums(100);
        int[] sortArr = Sort.insertionSort(randArr);
        assertArrayEquals(sortArr, Sort.mergeSort(randArr, 0, randArr.length - 1));
    }
    @Test
    public void testShellSort(){
        int[] randArr = Sort.generateRandomNums(100);
        int[] sortArr = Sort.mergeSort(randArr, 0, randArr.length - 1);
        assertArrayEquals(sortArr, Sort.shellSort(randArr));
    }
    @Test
    public void testQuickSort(){
        int[] randArr = Sort.generateRandomNums(100);
        int[] sortArr = Sort.shellSort(randArr);
        assertArrayEquals(sortArr, Sort.quickSort(randArr, 0, randArr.length - 1));
    }
}