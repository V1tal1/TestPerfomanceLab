import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Количество аргументов должно быть 1");
            return;
        }
        System.out.print(minMoves(args[0]));
    }

    public static int minMoves(String path){
        ArrayList<Integer> nums = readFile(path);
        Collections.sort(nums);
        int steps = 0;
        int half = nums.size()/2;
        int median = nums.get(half);
        for (int i:nums) {
            steps += Math.abs(i-median);
        }
        return steps;
    }

    public static  ArrayList<Integer> readFile(String path){
        ArrayList<Integer> nums = new ArrayList<>();

        try ( Scanner input  = new Scanner(new File(path));){
            while (input.hasNextInt()) {
                nums.add(input.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        return nums;
    }
}