import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите длину интервала:");
        int n = scan.nextInt();
        System.out.println("Введите количество интервалов:");
        int m = scan.nextInt();
        System.out.println(circularArray(n, m));
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
            if (answer.length() > 6) {
                break;
            }
            i += m - 1;
            if (i > n) {
                i = i - n;
            }
        }
        return answer;
    }
}
