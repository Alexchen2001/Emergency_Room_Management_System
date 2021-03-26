package activities;

public class Patient implements Comparable<Patient> {
    String firstName;
    String lastName;
    int age;
    int arrivalTime;
    int levelOfInjury;

    public Patient(String name, int age, int arrivalTime, int levelOfInjury) {
        this.firstName = name.substring(0, name.indexOf(" "));
        this.lastName = name.substring(name.indexOf(" "));
        this.age = age;
        this.arrivalTime = arrivalTime;
        this.levelOfInjury = levelOfInjury;
    }

    @Override
    public int compareTo(Patient other) {
        if (levelOfInjury != other.levelOfInjury) {
            return levelOfInjury - other.levelOfInjury;
        } else if (arrivalTime != other.arrivalTime) {
            return other.arrivalTime - arrivalTime;
        } else {
            return age - other.age;
        }
    }

    public String toString() {
        String _name = String.format(" \nName: \t  %s, %s\n", lastName, firstName);
        String _age = String.format("Age: \t %s\n", age);
        String _arrivalTime = String.format("Arrival Time: \t %s\n", arrivalTime);
        String _levelOfInjury = String.format("Injury leve: \t %s\n", levelOfInjury);
        return _name + _age + _arrivalTime + _levelOfInjury + "\n";
    }
}
