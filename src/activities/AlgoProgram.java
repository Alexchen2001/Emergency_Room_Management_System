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

        System.out.println();
        System.out.println();
        List<String> list = new ArrayList<String>(6);
        list.add("Sam");
        list.add("Cam");
        list.add("Joe");
        list.add("Bob");
        list.add("Abe");

        System.out.println(list);
        quickSort(list);
        System.out.println();
        System.out.println(list);

        List<Person> plist = new ArrayList<Person>();
        Person mike1 = new Person("Mike Jones", 42);
        Person mike2 = new Person("Mike Green", 42);
        Person mike3 = new Person("Mike Brown", 42);
        Person sam2 = new Person("Sam Long", 35);
        Person sam1 = new Person ("Sam Jones", 26);
        Person minh = new Person("Ming JOnes", 19);

        plist.add(mike3);
        plist.add(sam1);
        plist.add(mike2);
        plist.add(minh);
        plist.add(mike1);
        plist.add(sam2);

        System.out.println(plist);
        quickSort(plist);
        System.out.println();
        System.out.println(plist);
        builder.append(plist);

        write(outputLocation, builder);




    }

}
