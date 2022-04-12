
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Random;


public class Sort{
    public static void main(String[] args) {
        
        if(args.length >= 2 && isInteger(args[0])){
            int numOfnums = Integer.parseInt(args[0]);
            int[] randNumArr = generateRandomNums(numOfnums);
            int[] sorttedNumArr;
            long start;
            long end;
            long duration;
            for(int i = 1; i < args.length; i++){
                if(args[i].equals("bubble")){
                    start = System.nanoTime();
                    sorttedNumArr = bubbleSort(randNumArr);
                    end = System.nanoTime();
                    duration = end - start;
                    if((i + 1) < args.length && args[i + 1].equals("-v")){
                        printResultsVerbose(sorttedNumArr, numOfnums, duration, args[i]);
                    } else {
                        printResults(numOfnums, duration, args[i]);
                    }
                } else if(args[i].equals("selection")){
                    start = System.nanoTime();
                    sorttedNumArr = selectionSort(randNumArr);
                    end = System.nanoTime();
                    duration = end - start;
                    if((i + 1) < args.length && args[i + 1].equals("-v")){
                        printResultsVerbose(sorttedNumArr, numOfnums, duration, args[i]);
                    } else {
                        printResults(numOfnums, duration, args[i]);
                    }
                } else if(args[i].equals("insertion")){
                    start = System.nanoTime();
                    sorttedNumArr = insertionSort(randNumArr);
                    end = System.nanoTime();
                    duration = end - start;
                    if((i + 1) < args.length && args[i + 1].equals("-v")){
                        printResultsVerbose(sorttedNumArr, numOfnums, duration, args[i]);
                    } else {
                        printResults(numOfnums, duration, args[i]);
                    }
                } else if(args[i].equals("merge")){
                    start = System.nanoTime();
                    sorttedNumArr = mergeSort(randNumArr, 0, randNumArr.length - 1);
                    end = System.nanoTime();
                    duration = end - start;
                    if((i + 1) < args.length && args[i + 1].equals("-v")){
                        printResultsVerbose(sorttedNumArr, numOfnums, duration, args[i]);
                    } else {
                        printResults(numOfnums, duration, args[i]);
                    }
                } else if(args[i].equals("shell")){
                    start = System.nanoTime();
                    sorttedNumArr = shellSort(randNumArr);
                    end = System.nanoTime();
                    duration = end - start;
                    if((i + 1) < args.length && args[i + 1].equals("-v")){
                        printResultsVerbose(sorttedNumArr, numOfnums, duration, args[i]);
                    } else {
                        printResults(numOfnums, duration, args[i]);
                    }
                }

            }
        } else {
            System.out.println("Enter the number of items to sort followed by one of following sort options: \n1. bubble\n2. selection\n3. insertion\n4. merge\n5. shell");
        }
    }

    public static int[] shellSort(int[] numbers){
        for(int gapValue = numbers.length/2; gapValue > 0; gapValue /= 2){
            for(int i = 0; i < gapValue; i++){
                numbers = insertionSortInterleaved(numbers, i, gapValue);
            }
        }
        return numbers;
    }

    public static int[] insertionSortInterleaved(int[] numbers, int startIndex, int gap){
        int i = 0;
        int j = 0;
        int temp = 0;

        for(i = startIndex + gap; i < numbers.length; i = i + gap){
            j = i;
            while(j - gap >= startIndex && numbers[j] < numbers[j - gap]){
                temp = numbers[j];
                numbers[j] = numbers[j - gap];
                numbers[j - gap] = temp;
                j = j - gap;
            }
        }
        return numbers;
    }

    public static int[] mergeSort(int[] numbers, int i, int k){
        int j = 0;

        if(i < k){
            j = (i + k)/2;
            mergeSort(numbers, i, j);
            mergeSort(numbers, j + 1, k);

            merge(numbers, i, j, k);
        }
        return numbers;
    }

    public static int[] merge(int[] numbers, int i, int j, int k){
        int mergedSize = k - i + 1;
        int mergePos = 0;
        int leftPos = i;
        int rightPos = j + 1;
        int[] mergedNumbers = new int[mergedSize];

        while(leftPos <= j && rightPos <= k){
            if(numbers[leftPos] <= numbers[rightPos]){
                mergedNumbers[mergePos] = numbers[leftPos];
                ++leftPos;
            } else {
                mergedNumbers[mergePos] = numbers[rightPos];
                ++rightPos;
            }
            ++mergePos;
        }
        while(leftPos <= j){
            mergedNumbers[mergePos] = numbers[leftPos];
            ++leftPos;
            ++mergePos;
        }
        while(rightPos <= k){
            mergedNumbers[mergePos] = numbers[rightPos];
            ++rightPos;
            ++mergePos;
        }
        for(mergePos = 0; mergePos < mergedSize; ++mergePos){
            numbers[i + mergePos] = mergedNumbers[mergePos];
        }
        return numbers;
    }

    public static int[] insertionSort(int[] numbers){
        int i = 0;
        int j = 0;
        int temp = 0;

        for(i = 1; i < numbers.length; ++i){
            j = i;
            while(j > 0 && numbers[j] < numbers[j - 1]){
                temp = numbers[j];
                numbers[j] = numbers[j - 1];
                numbers[j - 1] = temp;
                --j;
            }
        }
        return numbers;
    }

    public static int[] selectionSort(int[] numbers){
        int i = 0;
        int j = 0;
        int indexSmallest = 0;
        int temp = 0;

        for(i = 0; i < numbers.length -1; i++){
            if(numbers[j] < numbers[indexSmallest]){
                indexSmallest = j;
            }
        }

        temp = numbers[i];
        numbers[i] = numbers[indexSmallest];
        numbers[indexSmallest] = temp;
        return numbers;
    }

    public static int[] bubbleSort(int[] numbers){
        int temp;
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = 0; j < numbers.length - 1; j++){
                if(numbers[j] > numbers[j + 1]){
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        return numbers;
    }
    
    public static int[] generateRandomNums(int size) {
        int numbers[];
        numbers = new int[size];
        Random random = new Random();
        int counter = 0;
        while (counter < size) {
            int randomNumber = random.nextInt(size * 10);
            if (!check(numbers, randomNumber)) {
                numbers[counter] = randomNumber;
                counter++;
            }
        }
        return numbers;
    }
    
    public static boolean check(int[] arr, int toCheck){
        for(int element : arr){
            if(element == toCheck){
                return true;
            }
        }
        return false;
    }

    public static boolean isInteger(String string){
        try{
            int intValue = Integer.parseInt(string);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static void printResults(int numOfnums, long duration, String sortAlgo){
        System.out.println("It took " + sortAlgo + " sort " + duration + " nanoseconds to sort " + numOfnums + " items.");
    }

    public static void printResultsVerbose(int[] arr, int numOfnums, long duration, String sortAlgo){
        System.out.print("[");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if(i != arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("It took " + sortAlgo + " sort " + duration + " nanoseconds to sort " + numOfnums + " items.");
    }

    public static void createNumsFile(int[] numbers, String fileName){
        try {
            File file = new File(fileName + ".txt");
            if(file.createNewFile()){
                System.out.println("File created: " + file.getName() + "...");
            } else {
                System.out.println("Previous numberFile rewriten...");
            }
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try{
            FileWriter writer = new FileWriter(fileName + ".txt");
            for (int i = 0; i < numbers.length; i++) {
                writer.write(String.valueOf(numbers[i]) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
}
