package student.management.system;
public abstract class Person {
    private String id;
    private String name;
    private int age;
    private String major;

    // Constructor
    public Person(String id, String name, int age, String major) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
    }
    // --- GETTERS ---
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getMajor() { return major; }
    // --- SETTERS
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setMajor(String major) { this.major = major; }

    //Ranking 
    public String getRank() {
        double avg = calculateAverageMark();
        if (avg < 5.0) return "Fail";
        if (avg < 6.5) return "Medium";
        if (avg < 7.5) return "Good";
        if (avg < 9.0) return "Very Good";
        return "Excellent";
    }
    public abstract double calculateAverageMark();
    
    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + major + "," + calculateAverageMark();
    }
}