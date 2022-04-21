import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class SortTest{
    @Test
    public void testBubbleSort(){
        int[] randArr = new int[] {1, 5, 2, 4, 3};
        int[] sortArr = new int[] {1, 2, 3, 4, 5};
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
    @Test
    public void testHeapSort(){
        int[] randArr = Sort.generateRandomNums(100);
        int[] sortArr = Sort.quickSort(randArr, 0, randArr.length - 1);
        Sort.createNumsFile(Sort.heapSort(randArr, randArr.length), "heap");
        assertArrayEquals(sortArr, Sort.heapSort(randArr, randArr.length));
    }
}