public class person {
    private String name;
    private int age;
    private String address;

    public person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
}

class Staff extends person {
    private String staffId;
    private String department;

    public Staff(String name, int age, String address, String staffId, String department) {
        super(name, age, address);
        this.staffId = staffId;
        this.department = department;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Staff ID: " + staffId);
        System.out.println("Department: " + department);
    }
}

class Professor extends Staff {
    private String specialization;

    public Professor(String name, int age, String address, String staffId, String department, String specialization) {
        super(name, age, address, staffId, department);
        this.specialization = specialization;
    }

    public void conductLecture() {
        System.out.println("Conducting lecture on " + specialization);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Specialization: " + specialization);
    }
}

class Student extends person {
    private String studentId;
    private String course;

    public Student(String name, int age, String address, String studentId, String course) {
        super(name, age, address);
        this.studentId = studentId;
        this.course = course;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
    }
}

class GraduateStudent extends Student {
    private String researchTopic;

    public GraduateStudent(String name, int age, String address, String studentId, String course, String researchTopic) {
        super(name, age, address, studentId, course);
        this.researchTopic = researchTopic;
    }

    public void submitThesis() {
        System.out.println("Submitting thesis on " + researchTopic);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Research Topic: " + researchTopic);
    }
}

// UniversityManagementSystem class moved to its own file
