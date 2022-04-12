
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class Sort{
    public static void main(String[] args) {
        int numOfnums = 0;
        String sortAlgo = null;
        int[] sorttedNumArr;
        
        if(args.length >= 2){
            numOfnums = Integer.parseInt(args[0]);
            int[] randNumArr = generateRandomNums(numOfnums);
            for(int i = 1; i < args.length; i++){
                if(args[i].equals("bubble")){
                    long start = System.currentTimeMillis();
                    sorttedNumArr = bubbleSort(randNumArr);
                    long end = System.currentTimeMillis();
                    long duration = end - start;
                    printResults(numOfnums, duration, args[i]);
                } else if(args[i].equals("selection")){
                    long start = System.currentTimeMillis();
                    sorttedNumArr = selectionSort(randNumArr);
                    long end = System.currentTimeMillis();
                    long duration = end - start;
                    printResults(numOfnums, duration, args[i]);
                } else if(args[i].equals("insertion")){
                    long start = System.currentTimeMillis();
                    sorttedNumArr = insertionSort(randNumArr);
                    long end = System.currentTimeMillis();
                    long duration = end - start;
                    printResults(numOfnums, duration, args[i]);
                }

            }
        } else {
            System.out.println("Enter at least the number of items to sort followed by one of following sort options: \n1. bubble");
        }
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

    public static void printResults(int numOfnums, long duration, String sortAlgo){
        System.out.println("It took " + sortAlgo + " sort " + duration + " milliseconds to sort " + numOfnums + " items.");
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
        System.out.println("It took " + sortAlgo + " sort " + duration + " milliseconds to sort " + numOfnums + " items.");
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
