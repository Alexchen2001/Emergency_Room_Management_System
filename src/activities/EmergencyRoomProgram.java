package activities;

import static utility.Module.quickSort;

import utility.ArrayList;
import utility.MyQueue;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class EmergencyRoomProgram {

    public static void write(String location, StringBuilder builder) throws IOException {
        File file           = new File(location);
        PrintWriter writer  = new PrintWriter(file);

        writer.println(builder);
        writer.close();
    }

    public static void organize(MyQueue<Patient> wLine) {
        ArrayList<Patient> list = new ArrayList<Patient>();

        while (!wLine.isEmpty()) {
            list.add(wLine.remove());
        }

        quickSort(list);

        for (int i = list.size() -1; i > 0; i--) {
            wLine.add(list.get(i));
        }

    }

    public static void main(String[] args) throws IOException {
        String outputLocation = "data" + File.separator + "WaitingLine.txt";
        StringBuilder builder = new StringBuilder("\n");

        //Initilization of random level of Injury, and random time
        MyQueue<Patient> pLine = new MyQueue<Patient>();
        Patient mike1 = new Patient("Mike Jones", 42, 315, 2);
        Patient mike2 = new Patient("Mike Green", 6, 750, 4 );
        Patient mike3 = new Patient("Mike Brown", 42,704,4);
        Patient sam2 = new Patient("Sam Long", 35,802,1);
        Patient sam1 = new Patient ("Sam Jones", 26,1012,10);
        Patient minh = new Patient("Ming Jones", 19, 505, 5);

        //All people are added randomly into the Queue
        pLine.add(minh);
        pLine.add(mike2);
        pLine.add(sam2);
        pLine.add(mike3);
        pLine.add(sam1);
        pLine.add(mike1);

        System.out.println();
        System.out.println(pLine);
        System.out.println("----------------------");
        organize(pLine);
        System.out.println(pLine);
        builder.append(pLine);

        write(outputLocation, builder);

    }
}