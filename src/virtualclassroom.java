import java.util.*;
import java.util.logging.Logger;
// Class representing the Virtual Classroom
class  vc {
    // Logger for the  vc class
    private static final Logger LOGGER = Logger.getLogger(vc.class.getName());
    // Maps to store student lists and assignments for each classroom
    private Map<String, List<String>> studentMap = new HashMap<>();
    private Map<String, List<AbstractMap.SimpleEntry<String, List<String>>>> assignmentMap = new HashMap<>();
    // Method to add a new classroom
    public void addClassroom(String className) {
        // Initialize an empty list for students in the new classroom
        studentMap.put(className, new ArrayList<>());
        assignmentMap.put(className, new ArrayList<>());
        // Log the creation of the new classroom
        LOGGER.info("Classroom " + className + " has been created.");
    }
    // Method to display a list of existing classrooms
    public void displayClassrooms() {
        // Iterate through classrooms and log each classroom name
        for (String className : studentMap.keySet()) {
            LOGGER.info(className);
        }
    }
    // Method to remove a classroom
    public void removeClassroom(String removeClassroom) {
        // Check if the class exists
        if (studentMap.containsKey(removeClassroom)) {
            // Log the removal of the class
            LOGGER.info("The class " + removeClassroom + " is removed");
            // Remove the class from the map
            studentMap.remove(removeClassroom);
        }
        // If the class was not found, log a message
        else {
            LOGGER.info("No class found with the name to remove.");
        }
        // Log the remaining classrooms after removal
        LOGGER.info("The remaining classrooms are:");
        for (String className : studentMap.keySet()) {
            LOGGER.info(className);
        }
    }
    // Add a student to a specific classroom
    public void addStudent(String studentId, String className) {
        // Check if the classroom exists
        if (studentMap.containsKey(className)) {
            // Add the student to the list
            List<String> students = studentMap.get(className);
            students.add(studentId);
            studentMap.put(className, students);
            // Log the enrollment of the student
            LOGGER.info("Student " + studentId + " has been enrolled in " + className);
        } else {
            // Log a message if the classroom is not found
            LOGGER.info("Classroom not found to add student ");
        }
    }
    // Method to display the list of students for a specific classroom
    public void displayStudentsOfClassroom(String classroomName) {
        int flag = 0;
        // Iterate through classrooms to find the required.
        for (String className : studentMap.keySet()) {
            if (className.equals(classroomName)) {
                // Log the list of students for the specified classroom
                LOGGER.info(String.valueOf(studentMap.get(className)));
                flag = 1;
            }
        }
        // Log a message if the specified classroom is not found
        if (flag == 0) {
            LOGGER.info("No class with the given name.");
        }
        // Add a newline for better formatting
        LOGGER.info("\n");
    }
    // Schedule an assignment for a specific classroom
    public void scheduleAssignment(String className, String assignmentDetails) {
        // Checking if the classroom exists
        if (assignmentMap.containsKey(className)) {
            // Add the assignment to the classroom's list
            List<AbstractMap.SimpleEntry<String, List<String>>> assignments = assignmentMap.get(className);
            assignments.add(new AbstractMap.SimpleEntry<>(assignmentDetails, new ArrayList<>()));
            assignmentMap.put(className, assignments);
            // Log the scheduling of the assignment
            LOGGER.info("Assignment for " + className + " has been scheduled.");
        } else {
            // Log a message if the classroom is not found
            LOGGER.info("Classroom not found to schedule assignment.");
        }
    }
    // To submit an assignment by a student for a specific classroom
    public void assignmentSubmission(String studentId, String className, String assignmentDetails) {
        // TO check if the student and classroom both there in the list
        if (studentMap.containsKey(className) && studentMap.get(className).contains(studentId)) {
            // To get the list of assignments for the classroom
            List<AbstractMap.SimpleEntry<String, List<String>>> assignments = assignmentMap.get(className);
            for (AbstractMap.SimpleEntry<String, List<String>> entry : assignments) {
                if (entry.getKey().equals(assignmentDetails)) {
                    entry.getValue().add(studentId);
                    break;
                }
            }
            // Log the submission of the assignment
            LOGGER.info("Assignment submitted by Student " + studentId + " in " + className);
        } else {
            // Log a message if the student or classroom is not found
            LOGGER.info("Student or class not found for assignment submission.");
        }
    }
    // To display assignments for a classroom
    public void displayAssignments(String className) {
        // To get the list of assignments for the classroom or an empty list
        List<AbstractMap.SimpleEntry<String, List<String>>> assignments = assignmentMap.getOrDefault(className, Collections.emptyList());
        // Log the assignments for the specified classroom
        LOGGER.info(assignments.toString());
    }
}
// Main class
public class virtualclassroom {
    // Logger
    private static final Logger LOGGER = Logger.getLogger(virtualclassroom.class.getName());
    // Main method for java file
    public static void main(String[] args) {
        //for user input
        Scanner scanner = new Scanner(System.in);
        // Creating an instance of the Virtual Classroom
        vc virtualClassroom = new vc();
        while (true) {
            LOGGER.info("VIRTUAL CLASSROOM");
            LOGGER.info("Choose an action:");
            LOGGER.info("1. Add Classroom");
            LOGGER.info("2. Add Student");
            LOGGER.info("3. Remove class");
            LOGGER.info("4. Display classrooms");
            LOGGER.info("5. Display students in classroom");
            LOGGER.info("6. Schedule Assignment");
            LOGGER.info("7. Submit Assignment");
            LOGGER.info("8. Display Assignments");
            LOGGER.info("9. Exit");
            try {
                // Read user input from 1-9
                int choice = Integer.parseInt(scanner.nextLine().trim());
                // To check that the user input is within the valid range of 1-9
                if (choice < 1 || choice > 9) {
                    LOGGER.warning("Please enter a number between 1 and 9.");
                    continue; // Skip the rest of the loop and go for switch statement
                }
                // Switch case as per input given
                switch (choice) {
                    case 1:
                        LOGGER.info("Enter Classroom Name: ");
                        String classroomName = scanner.nextLine().trim();
                        virtualClassroom.addClassroom(classroomName);
                        break;
                    case 2:
                        LOGGER.info("Enter Student ID: ");
                        String studentId = scanner.nextLine().trim();
                        LOGGER.info("Enter Classroom for Student: ");
                        String studentClassroom = scanner.nextLine().trim();
                        virtualClassroom.addStudent(studentId, studentClassroom);
                        break;
                    case 3:
                        LOGGER.info("Enter the class name you want to remove:");
                        String remove = scanner.nextLine().trim();
                        virtualClassroom.removeClassroom(remove);
                        break;
                    case 4:
                        virtualClassroom.displayClassrooms();
                        break;
                    case 5:
                        LOGGER.info("Enter Classroom Name to display students: ");
                        String listofStudentsOfClassroom = scanner.nextLine().trim();
                        virtualClassroom.displayStudentsOfClassroom(listofStudentsOfClassroom);
                        break;
                    case 6:
                        LOGGER.info("Enter Classroom for Assignment: ");
                        String assignmentClassroom = scanner.nextLine().trim();
                        LOGGER.info("Enter Assignment Details: ");
                        String assignmentDetails = scanner.nextLine().trim();
                        virtualClassroom.scheduleAssignment(assignmentClassroom, assignmentDetails);
                        break;
                    case 7:
                        LOGGER.info("Enter Student ID for Assignment Submission: ");
                        String submissionStudentId = scanner.nextLine().trim();
                        LOGGER.info("Enter Classroom for Assignment Submission: ");
                        String submissionClassroom = scanner.nextLine().trim();
                        LOGGER.info("Enter Assignment Details for Submission: ");
                        String submissionAssignmentDetails = scanner.nextLine().trim();
                        virtualClassroom.assignmentSubmission(submissionStudentId, submissionClassroom, submissionAssignmentDetails);
                        break;
                    case 8:
                        LOGGER.info("Enter Classroom to display assignments: ");
                        String displayClassroom = scanner.nextLine().trim();
                        virtualClassroom.displayAssignments(displayClassroom);
                        break;
                    case 9:
                        LOGGER.info("Exiting the program.");
                        System.exit(0);
                        break;
                    default:
                        LOGGER.warning("Enter a valid number to proceed.");
                }
            } catch (InputMismatchException e) {
                LOGGER.warning("Please enter a valid number.");
                scanner.next();
            } catch (Exception e) {
                LOGGER.warning("Please enter a valid number.");
                scanner.next();
            }
        }
    }
}
