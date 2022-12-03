import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2)
        {
            System.out.println("Количество аргументов должно быть 2");
            return;
        }
        String path1 = args[0];
        String path2 = args[1];

        checkPointsIsCircle(path1, path2);
    }

    public static void checkPointsIsCircle(String path1, String path2){
        ArrayList<ArrayList<Float>> сenter = readFile(path1);
        ArrayList<ArrayList<Float>> points = readFile(path2);
        Float cX = сenter.get(0).get(0);
        Float cY = сenter.get(0).get(1);
        Float radius = сenter.get(1).get(0);
        for(int i = 0;i<points.size();i++){
            if(((points.get(i).get(0) - cX) *(points.get(i).get(0)-cX)) + ((points.get(i).get(1)-cY)*(points.get(i).get(1)-cY)) == (radius * radius)){
                System.out.println(0);
            } else if (((points.get(i).get(0) - cX) *(points.get(i).get(0)-cX)) + ((points.get(i).get(1)-cY)*(points.get(i).get(1)-cY)) < (radius * radius)) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }
    public static  ArrayList<ArrayList<Float>> readFile(String path){
        ArrayList<ArrayList<Float>> a = new ArrayList<>();

        Scanner input = null;
        try {
            input = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        while(input.hasNextLine()) {
            Scanner colReader = new Scanner(input.nextLine());
            colReader.useLocale(Locale.US);
            ArrayList col = new ArrayList();
            while (colReader.hasNextFloat()) {
                col.add(colReader.nextFloat());

            }
            a.add(col);
        }
        input.close();
       return a;
    }
}

