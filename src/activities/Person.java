package activities;

public class Person implements Comparable<Person>{
    private String firstName;
    private String lastName;
    private int age;
    private int years;


    public Person(String name, int age){
        this.firstName = name.substring(0, name.indexOf(" "));
        this.lastName = name.substring(name.indexOf(" "));
        this.age = age;
        this.years = yearsToRetirement();

    }

    @Override
    public int compareTo(Person other){
        if (years != other. years){
            return years - other.years;
        }else if( age != other.age){
            return age - other.age;
        }else if(lastName.equals(other.lastName)){
            return lastName.compareTo(other.lastName);
        }else {
            return firstName.compareTo(other.firstName);
        }
    }

    public int yearsToRetirement(){

        return 65 - age;
    }

    public String toString(){
        String _name = String.format("\nName: \t  %s, %s\n", lastName, firstName);
        String _age = String.format("Age: \t \t \t %s\n", age);
        String _retire = String.format("Years To GO! : \t %s\n",years);
        return _name + _age + _retire + "\n";

    }




}
