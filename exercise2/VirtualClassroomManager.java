import java.util.*;

class VirtualClassroomManager {

    private Map<String, Classroom> classrooms;

    // Constructor
    public VirtualClassroomManager() {
        classrooms = new HashMap<>();
    }

    // Add Classroom
    public void addClassroom(String className) {
        if (classrooms.containsKey(className)) {
            System.out.println("Classroom " + className + " already exists.");
            return;
        }
        classrooms.put(className, new Classroom(className));
        System.out.println("Classroom " + className + " has been created.");
    }

    // Add Student to Classroom
    public void addStudent(String studentID, String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom " + className + " does not exist.");
            return;
        }
        classroom.enrollStudent(studentID);
    }

    // Schedule Assignment for Classroom
    public void scheduleAssignment(String className, String assignmentDetails) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom " + className + " does not exist.");
            return;
        }
        classroom.scheduleAssignment(assignmentDetails);
    }

    // Submit Assignment by Student
    public void submitAssignment(String studentID, String className, String assignmentDetails) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom " + className + " does not exist.");
            return;
        }
        classroom.submitAssignment(studentID, assignmentDetails);
    }

    // List all Classrooms
    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms available.");
            return;
        }
        System.out.println("Classrooms:");
        for (String className : classrooms.keySet()) {
            System.out.println("- " + className);
        }
    }

    // List Students in a Classroom
    public void listStudents(String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Classroom " + className + " does not exist.");
            return;
        }
        classroom.listStudents();
    }

    // Remove a Classroom
    public void removeClassroom(String className) {
        if (classrooms.remove(className) != null) {
            System.out.println("Classroom " + className + " has been removed.");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    // Inner Class for Classroom
    class Classroom {
        private String name;
        private Set<String> students;
        private List<String> assignments;

        public Classroom(String name) {
            this.name = name;
            this.students = new HashSet<>();
            this.assignments = new ArrayList<>();
        }

        // Enroll Student
        public void enrollStudent(String studentID) {
            if (students.contains(studentID)) {
                System.out.println("Student " + studentID + " is already enrolled in " + name + ".");
                return;
            }
            students.add(studentID);
            System.out.println("Student " + studentID + " has been enrolled in " + name + ".");
        }

        // Schedule Assignment
        public void scheduleAssignment(String assignmentDetails) {
            assignments.add(assignmentDetails);
            System.out.println("Assignment for " + name + " has been scheduled.");
        }

        // Submit Assignment
        public void submitAssignment(String studentID, String assignmentDetails) {
            if (!students.contains(studentID)) {
                System.out.println("Student " + studentID + " is not enrolled in " + name + ".");
                return;
            }
            if (!assignments.contains(assignmentDetails)) {
                System.out.println("Assignment does not exist for this classroom.");
                return;
            }
            System.out.println("Assignment submitted by Student " + studentID + " in " + name + ".");
        }

        // List Students
        public void listStudents() {
            if (students.isEmpty()) {
                System.out.println("No students enrolled in " + name + ".");
                return;
            }
            System.out.println("Students in " + name + ":");
            for (String studentID : students) {
                System.out.println("- " + studentID);
            }
        }
    }

    // Main Method
    public static void main(String[] args) {
        VirtualClassroomManager manager = new VirtualClassroomManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command:");
            String input = scanner.nextLine();
            String[] tokens = input.split(" ", 3); // Splitting input into command and arguments

            try {
                switch (tokens[0].toLowerCase()) {
                    case "add_classroom":
                        manager.addClassroom(tokens[1]);
                        break;
                    case "add_student":
                        manager.addStudent(tokens[1], tokens[2]);
                        break;
                    case "schedule_assignment":
                        manager.scheduleAssignment(tokens[1], tokens[2]);
                        break;
                    case "submit_assignment":
                        String[] submitDetails = tokens[2].split(" ", 2);
                        manager.submitAssignment(tokens[1], submitDetails[0], submitDetails[1]);
                        break;
                    case "list_classrooms":
                        manager.listClassrooms();
                        break;
                    case "list_students":
                        manager.listStudents(tokens[1]);
                        break;
                    case "remove_classroom":
                        manager.removeClassroom(tokens[1]);
                        break;
                    case "exit":
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Unknown command.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid command format.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
