import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class SortTest{
    @Test
    public void BubbleSort(){
        int[] sortArr = new int[]{1,2,3,4,5};
        int[] randArr = new int[]{3,1,5,2,4};
        assertArrayEquals(sortArr, Sort.bubbleSort(randArr));
    }
}