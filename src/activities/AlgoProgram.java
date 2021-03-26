package activities;

import utility.List;
import utility.ArrayList;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import static utility.Module.quickSort;

public class AlgoProgram {

    public static void write(String location, StringBuilder builder) throws IOException {
        File file           = new File(location);
        PrintWriter writer  = new PrintWriter(file);

        writer.println(builder);
        writer.close();
    }
    public static void main(String[] args) throws IOException {
        String outputLocation = "data" + File.separator + "Retirement.txt";
        StringBuilder builder = new StringBuilder("\n");


        List<Person> peoplelist = new ArrayList<Person>();
        Person mike1 = new Person("Mike Jones", 42);
        Person mike2 = new Person("Mike Green", 42);
        Person mike3 = new Person("Mike Brown", 42);
        Person sam2 = new Person("Sam Long", 35);
        Person sam1 = new Person ("Sam Jones", 26);
        Person minh = new Person("Ming Jones", 26);

        peoplelist.add(mike3);
        peoplelist.add(sam1);
        peoplelist.add(mike2);
        peoplelist.add(minh);
        peoplelist.add(mike1);
        peoplelist.add(sam2);

        System.out.println();
        System.out.println();
        System.out.println("            Test Program");
        System.out.println("-----------Before Sorting--------------");
        System.out.println(peoplelist);
        quickSort(peoplelist);
        System.out.println();
        System.out.println("------------After Sorting---------------");
        System.out.println(peoplelist);
        builder.append(peoplelist);

        write(outputLocation, builder);




    }

}
