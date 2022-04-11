import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class Sort{
    public static void main(String[] args) {
        int numberOfItems = 10;
        int[] arrOfItems = generateRandomNums(numberOfItems);
        int[] sorrtedArr = bubbleSort(arrOfItems);
        System.out.println("made it");
        createNumsFile(sorrtedArr, "bubble");
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