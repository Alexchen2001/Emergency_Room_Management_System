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

    public static void organize(MyQueue<Patient> waitingLine) {
        ArrayList<Patient> templist = new ArrayList<Patient>();

        while (!waitingLine.isEmpty()) {
            templist.add(waitingLine.remove());
        }

        quickSort(templist);

        for (int i = templist.size() - 1; i >= 0; i--) {
            waitingLine.add(templist.get(i));
        }

    }

    public static void main(String[] args) throws IOException {
        String outputLocation = "data" + File.separator + "WaitingLine.txt";
        StringBuilder builder = new StringBuilder("\n");

        //Initilization of random level of Injury, and random time
        MyQueue<Patient> patientLine = new MyQueue<Patient>();
        Patient mike1 = new Patient("Mike Jones", 42, 315, 2);
        Patient mike2 = new Patient("Mike Green", 6, 750, 4 );
        Patient mike3 = new Patient("Mike Brown", 42,704,4);
        Patient sam2 = new Patient("Sam Long", 35,802,1);
        Patient sam1 = new Patient ("Sam Jones", 26,1012,10);
        Patient minh = new Patient("Ming Jones", 19, 505, 5);
        Patient alan1 = new Patient("Alan Tudela", 59,315,2);

        //All people are added randomly into the Queue
        patientLine.add(minh);
        patientLine.add(mike2);
        patientLine.add(mike3);
        patientLine.add(sam1);
        patientLine.add(mike1);
        patientLine.add(sam2);
        patientLine.add(alan1);

        System.out.println();
        System.out.println(patientLine);
        System.out.println("----------------------");
        organize(patientLine);
        System.out.println(patientLine);
        builder.append(patientLine);

        write(outputLocation, builder);

    }
}