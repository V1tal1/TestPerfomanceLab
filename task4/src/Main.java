import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String path = scan.next();
        System.out.print(minMoves(path));
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

        Scanner input = null;
        try {
            input = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        while (input.hasNextInt()) {
            nums.add(input.nextInt());
        }
        input.close();
        return nums;
    }
}