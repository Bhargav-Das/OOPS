import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class PersonSerilization {
    public static void main(String[] args) {
        Person person = new Person("Arnav", 20);
        
        // Serialize object
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.txt"))) {
            out.writeObject(person);
            System.out.println("Person object serialized.");
        } catch (IOException e) {
            System.out.println("Error during serialization.");
        }

        // Deserialize object
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.txt"))) {
            Person deserializedPerson = (Person) in.readObject();
            System.out.println("Deserialized Person:");
            deserializedPerson.display();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization.");
        }
    }
}
