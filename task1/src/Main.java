import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2)
        {
            System.out.println("Количество аргументов должно быть 2");
            return;
        }
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        System.out.println(circularArray(n,m));
    }

    public static String circularArray(int n, int m) {
        String answer = "1";
        if (m < 1 || n < 1) {
            return answer;
        }
        if (n==1){
            return answer;
        }

        int i = 1;
        i += m - 1;
        while (i != 1) {
            answer += String.valueOf(i);
            i += m - 1;
            if (i > n) {
                i = i - n;
            }
        }
        return answer;
    }
}
