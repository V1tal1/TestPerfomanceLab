package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        if (args.length != 2)
        {
            System.out.println("Количество аргументов должно быть 2");
            return;
        }
        String pathTests = args[0];
        String pathValues = args[1];
        testReport(pathTests,pathValues);

    }

    public static void testReport (String pathTests, String pathValues)  {

        try (FileReader fileReader = new FileReader(pathTests);
             FileReader fileReader1 = new FileReader(pathValues);
             Writer writer = Files.newBufferedWriter(Paths.get("report.json"))) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Tests tests = gson.fromJson(fileReader, Tests.class);
            Values values = gson.fromJson(fileReader1, Values.class);

            HashMap<Integer, String> map = new HashMap<>();
            for (int i = 0; i < values.values.size(); i++) {
                map.put(values.values.get(i).id, values.values.get(i).value);
            }

            insert(map, tests.tests);
            gson.toJson(tests, writer);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insert(HashMap map, List<Test> testList) {
        for (int i = 0; i < testList.size(); i++) {
            if (map.containsKey(testList.get(i).id))
                testList.get(i).value = (String) map.get(testList.get(i).id);
            if (testList.get(i).values != null)
                insert(map, testList.get(i).values);
        }

    }
}