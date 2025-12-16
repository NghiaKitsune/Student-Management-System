package student.management.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ManagementStudent {
    private static Scanner scanner = new Scanner(System.in);
    public static List<Person> students = new ArrayList<>();

    public static List<Person> getStudents() {
        return students;
    }

    public static double inputMark(String subjectName) {
        double mark = -1;
        while (true) {
            System.out.print("Enter " + subjectName + " Mark (0-10): ");
            try {
                String input = scanner.nextLine();
                mark = Double.parseDouble(input);
                if (mark >= 0 && mark <= 10) return mark;
                else System.out.println("Mark must be between 0 and 10.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    public static void inputListStudent() {
        while (true) {
            System.out.println("\n--- Enter information for a new student ---");
            System.out.print("Enter ID: ");
            String id = scanner.nextLine().trim().toUpperCase();
            while(id.isEmpty()) {
                System.out.print("ID cannot be empty. Enter ID: ");
                id = scanner.nextLine().trim();
            }

            boolean isExist = false;
            for(Person p : students) {
                if(p.getId().equalsIgnoreCase(id)) {
                    isExist = true; 
                    break;
                }
            }
            if(isExist) {
                System.out.println("ID " + id + " already exists! Please input again.");
                continue;
            }

            String name = "";
            while (true) {
                System.out.print("Enter Name: ");
                name = scanner.nextLine().trim();
                if (name.matches("[a-zA-Z\\s]+")) break;
                else System.out.println("Invalid Name! Name must not contain numbers.");
            }

            System.out.print("Enter Age: ");
            int age = 0;
            try {
                age = scanner.nextInt();
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Invalid Age! Defaulting to 18.");
                age = 18;
                scanner.nextLine();
            }

            System.out.print("Enter Major (IT/Biz/GD): ");
            String majorInput = scanner.nextLine().trim();
            String majorNormalized = majorInput.toUpperCase();

            Person student = null;
            switch (majorNormalized) {
                case "IT":
                    double html = inputMark("HTML");
                    double css = inputMark("CSS");
                    double math = inputMark("Math");
                    student = new IT(id, name, age, "IT", html, css, math);
                    break;
                case "BIZ":
                    double sale = inputMark("Sale");
                    double marketing = inputMark("Marketing");
                    student = new Biz(id, name, age, "Biz", sale, marketing);
                    break;
                case "GD":
                    double color = inputMark("Color");
                    double pts = inputMark("PTS");
                    double ai = inputMark("AI");
                    student = new GD(id, name, age, "GD", color, pts, ai);
                    break;
                default:
                    System.out.println("Unknown major. Defaulting to IT.");
                    student = new IT(id, name, age, "IT", 0, 0, 0);
                    break;
            }

            if (student != null) {
                students.add(student);
                System.out.println("Student added successfully!");
            }

            System.out.print("Do you want to continue adding? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("n")) break;
        }
    }

    public static void outputListStudent(List<Person> students) {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-5s | %-5s | %-12s | %-10s |\n", 
                "ID", "FULL NAME", "AGE", "MAJOR", "RANK", "AVG MARK");
        System.out.println("------------------------------------------------------------------------------------------");
        for (Person s : students) {
            System.out.printf("| %-10s | %-20s | %-5d | %-5s | %-12s | %-10.2f |\n", 
                    s.getId(), s.getName(), s.getAge(), s.getMajor(), s.getRank(), s.calculateAverageMark());
        }
        System.out.println("------------------------------------------------------------------------------------------");
    }

    public static void searchStudentByNameLinear() {
        System.out.print("Enter the name to search: ");
        String searchName = scanner.nextLine();
        boolean found = false;
        for (Person student : students) {
            if (student.getName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println("Found: " + student);
                found = true;
            }
        }
        if (!found) System.out.println("Not found.");
    }

    public static void searchStudentById() {
        System.out.print("Enter ID to search: ");
        String searchId = scanner.nextLine().trim();
        boolean found = false;
        for (Person s : students) {
            if (s.getId().equalsIgnoreCase(searchId)) {
                System.out.println("Found: " + s);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Not found.");
    }

    public static void deleteStudentById() {
        System.out.print("Enter ID to delete: ");
        String id = scanner.nextLine().trim();
        boolean removed = students.removeIf(s -> s.getId().equalsIgnoreCase(id));
        if (removed) {
            System.out.println("Deleted successfully.");
        } else {
            System.out.println("ID not found.");
        }
    }

    public static void updateStudentById() {
        System.out.print("Enter ID to update: ");
        String id = scanner.nextLine().trim();
        Person foundStudent = null;
        for (Person s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                foundStudent = s;
                break;
            }
        }

        if (foundStudent != null) {
            System.out.println("Found: " + foundStudent);
            System.out.print("Enter new name (Enter to skip): ");
            String newName = scanner.nextLine();
            if (!newName.trim().isEmpty()) foundStudent.setName(newName);

            System.out.print("Enter new age (0 to skip): ");
            try {
                String ageInput = scanner.nextLine();
                if (!ageInput.isEmpty()) {
                    int newAge = Integer.parseInt(ageInput);
                    if (newAge > 0) foundStudent.setAge(newAge);
                }
            } catch (Exception e) {}

            System.out.print("Update marks? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                if (foundStudent instanceof IT) {
                    IT s = (IT) foundStudent;
                    s.setHtml(inputMark("New HTML"));
                    s.setCss(inputMark("New CSS"));
                    s.setMath(inputMark("New Math"));
                } else if (foundStudent instanceof Biz) {
                    Biz s = (Biz) foundStudent;
                    s.setSale(inputMark("New Sale"));
                    s.setMarketing(inputMark("New Marketing"));
                } else if (foundStudent instanceof GD) {
                    GD s = (GD) foundStudent;
                    s.setColor(inputMark("New Color"));
                    s.setPts(inputMark("New PTS"));
                    s.setAi(inputMark("New AI"));
                }
            }
            System.out.println("Updated successfully!");
        } else {
            System.out.println("ID not found.");
        }
    }

    public static void sortStudentsByMarksInsertion() {
        int n = students.size();
        if (n == 0) return;
        
        for (int i = 1; i < n; ++i) {
            Person key = students.get(i);
            double keyMark = key.calculateAverageMark();
            int j = i - 1;
            while (j >= 0 && students.get(j).calculateAverageMark() < keyMark) {
                students.set(j + 1, students.get(j));
                j = j - 1;
            }
            students.set(j + 1, key);
        }
        System.out.println("Sorted by Mark (Descending).");
    }


    public static void mainMenu() {
        
        while (true) {
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Input Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search by Name");
            System.out.println("4. Search by ID");
            System.out.println("5. Sort by Mark( Insertion Sort )");
            System.out.println("6. Delete by ID");
            System.out.println("7. Update by ID");
            System.out.println("8. Exit");
            
            System.out.print("Choose (1-8): ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1: inputListStudent(); break;
                    case 2: outputListStudent(students); pressEnterToContinue(); break;
                    case 3: searchStudentByNameLinear(); pressEnterToContinue(); break;
                    case 4: searchStudentById(); break;
                    case 5: sortStudentsByMarksInsertion(); outputListStudent(students); break;
                    case 6: deleteStudentById(); pressEnterToContinue(); break;
                    case 7: updateStudentById(); break;
                    case 8: 
                        System.out.println("Goodbye!"); 
                        return;
                    default: System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Please enter a number.");
                scanner.nextLine();
            }
        }
    }
    
    public static void pressEnterToContinue() {
        System.out.print("\n>> Press Enter to return to menu...");
        scanner.nextLine();
    }
    
    public static void main(String[] args) {
        mainMenu();
    }
}