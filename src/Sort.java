package src;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

class Sort{
    public static void main(String[] args) {
        int numberOfItems = 0;
        String sortAlgo = null;
        String verbos = null;

        int[] randNumArr;
        int[] sorttedNumArr;
        if(args.length >= 2){
            numberOfItems = Integer.parseInt(args[0]);
            randNumArr = generateRandomNums(numberOfItems);
            sortAlgo = args[1];
            System.out.println(sortAlgo);
            if(sortAlgo.equals(args[1])){
                sorttedNumArr = bubbleSort(randNumArr);
                printArr(sorttedNumArr);
            }
        } else {
            System.out.println("Enter at least the number of items to sort followed by one of following sort options: \n1. bubble");
        }
    }

    public static void printArr(int[] arr){
        System.out.print("[");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if(i != arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
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
            }
            counter++;
        }
        return numbers;
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

    public static boolean check(int[] arr, int toCheck){
        for(int element : arr){
            if(element == toCheck){
                return true;
            }
        }
        return false;
    }
}