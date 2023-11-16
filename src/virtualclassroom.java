import java.util.*;
import java.util.logging.Logger;
// Class representing the Virtual Classroom
class VC {
    // Logger for the VC class
    private static final Logger LOGGER = Logger.getLogger(VC.class.getName());
    // Maps to store student lists and assignments for each classroom
    Map<String, List<String>> stringListHashMap = new HashMap<>();
    Map<String, List<String>> assignmentMap = new HashMap<>();
    // Method to add a new classroom
    public void addClassroom(String className) {
        // Initialize an empty list for students in the new classroom
        stringListHashMap.put(className, new ArrayList<>());
        // Log the creation of the new classroom
        LOGGER.info("Classroom " + className + " has been created.");
    }
    // Method to display a list of existing classrooms
    public void classroomList() {
        // Iterate through classrooms and log each classroom name
        for (String className : stringListHashMap.keySet()) {
            LOGGER.info(className);
        }
    }
    // Method to remove a classroom
    public void removeclass(String removeclasses) {

        // Check if the class exists
        if (stringListHashMap.containsKey(removeclasses)) {
            // Log the removal of the class
            LOGGER.info("The class {} is removed".format(removeclasses));
            // Remove the class from the map
            stringListHashMap.remove(removeclasses);

        }
        // If the class was not found, log a message
        else {
            LOGGER.info("No class found with the name to remove.");
        }
        // Log the remaining classrooms after removal
        LOGGER.info("The remaining classrooms are:");
        for (String i : stringListHashMap.keySet()) {
            LOGGER.info(i);
        }
    }
    // add a student to a specific classroom
    public void addStudent(String studentId, String className) {
        // Check if the classroom exists
        if (stringListHashMap.containsKey(className)) {
            // Add the student to the list
            List<String> students = stringListHashMap.get(className);
            students.add(studentId);
            stringListHashMap.put(className, students);
            // Log the enrollment of the student
            LOGGER.info("Student %s has been enrolled in {}".format(studentId, className));
        } else {
            // Log a message if the classroom is not found
            LOGGER.info("Classroom not found to add student ");
        }
    }
    // Method to display the list of students for a specific classroom
    public void displaythestudentsofclassroom(String listofclassstudents) {
        int flag = 0;
        // Iterate through classrooms to find the required.
        for (String className : stringListHashMap.keySet()) {
            if (className.equals(listofclassstudents)) {
                // Log the list of students for the specified classroom
                LOGGER.info(String.valueOf(stringListHashMap.get(className)));
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
            List<String> assignments = assignmentMap.get(className);
            assignments.add(assignmentDetails);
            assignmentMap.put(className, assignments);
            // Log the scheduling of the assignment
            LOGGER.info("Assignment for {} has been scheduled.".format(className));
        } else {
            // Log a message if the classroom is not found
            LOGGER.info("Classroom not found to schedule assignment.");
        }
    }
    // To submit an assignment by a student for a specific classroom
    public void assignmentSubmission(String studentId, String className, String assignmentDetails) {
        // TO check if the student and classroom both there in the list
        if (stringListHashMap.containsKey(className) && stringListHashMap.get(className).contains(studentId)) {
            // To get the list of assignments for the classroom
            List<String> assignments = assignmentMap.get(className);
            if (assignments == null) {
                assignments = new ArrayList<>();
            }
            // To add the assignment to the list and update the map
            assignments.add(assignmentDetails);
            assignmentMap.put(className, assignments);
            // Log the submission of the assignment
            LOGGER.info("Assignment submitted by Student {} in {}".format(studentId, className));
        } else {
            // Log a message if the student or classroom is not found
            LOGGER.info("Student or class not found for assignment submission.");
        }
    }
    // To display assignments for a classroom
    public void displayAssignments(String className) {
        // To get the list of assignments for the classroom or an empty list
        List<String> assignments = assignmentMap.getOrDefault(className, Collections.emptyList());
        // Log the assignments for the specified classroom
        LOGGER.info("Assignments for {}: {}".format(className, assignments));
    }
}
// Main class
public class virtualclassroom {
    // Logger
    private static final Logger LOGGER1= Logger.getLogger(virtualclassroom.class.getName());
    // Main method for java file
    public static void main(String[] args) {
        //for user input
        Scanner scanner = new Scanner(System.in);
        // Creating an instance of the Virtual Classroom
        VC virtualClassroom = new VC();
        while (true) {
            LOGGER1.info("VIRTUAL CLASSROOM");
            LOGGER1.info("Choose an action:");
            LOGGER1.info("1. Add Classroom");
            LOGGER1.info("2. Add Student");
            LOGGER1.info("3. Remove class");
            LOGGER1.info("4. Display classrooms");
            LOGGER1.info("5. Display students in classroom");
            LOGGER1.info("6. Schedule Assignment");
            LOGGER1.info("7. Submit Assignment");
            LOGGER1.info("8. Display Assignments");
            LOGGER1.info("9. Exit");
            try {
                // Read user input from 1-9
                int choice = scanner.nextInt();
                // To check that the user input is within the valid range of 1-9
                if (choice < 1 || choice > 9) {
                    LOGGER1.warning("Please enter a number between 1 and 9.");
                    continue; // Skip the rest of the loop and go  for switch statement
                }
                // Switch case  as per input given
                switch (choice) {
                    case 1:
                        LOGGER1.info("Enter Classroom Name: ");
                        String classroomName = scanner.next();
                        virtualClassroom.addClassroom(classroomName);
                        break;
                    case 2:
                        LOGGER1.info("Enter Student ID: ");
                        String studentId = scanner.next();
                        LOGGER1.info("Enter Classroom for Student: ");
                        String studentClassroom = scanner.next();
                        virtualClassroom.addStudent(studentId, studentClassroom);
                        break;
                    case 3:
                        LOGGER1.info("Enter the class name you want to remove:");
                        String remove = scanner.next();
                        virtualClassroom.removeclass(remove);
                        break;
                    case 4:
                        virtualClassroom.classroomList();
                        break;
                    case 5:
                        LOGGER1.info("Enter Classroom Name to display students: ");
                        String listofstudentsofaclassroom = scanner.next();
                        virtualClassroom.displaythestudentsofclassroom(listofstudentsofaclassroom);
                        break;
                    case 6:
                        LOGGER1.info("Enter Classroom for Assignment: ");
                        String assignmentClassroom = scanner.next();
                        LOGGER1.info("Enter Assignment Details: ");
                        String assignmentDetails = scanner.next();
                        virtualClassroom.scheduleAssignment(assignmentClassroom, assignmentDetails);
                        break;
                    case 7:
                        LOGGER1.info("Enter Student ID for Assignment Submission: ");
                        String submissionStudentId = scanner.next();
                        LOGGER1.info("Enter Classroom for Assignment Submission: ");
                        String submissionClassroom = scanner.next();
                        LOGGER1.info("Enter Assignment Details for Submission: ");
                        String submissionAssignmentDetails = scanner.next();
                        virtualClassroom.assignmentSubmission(submissionStudentId, submissionClassroom, submissionAssignmentDetails);
                        break;
                    case 8:
                        LOGGER1.info("Enter Classroom to display assignments: ");
                        String displayClassroom = scanner.next();
                        virtualClassroom.displayAssignments(displayClassroom);
                        break;
                    case 9:
                        LOGGER1.info("Exiting the program.");
                        System.exit(0);
                        break;
                    default:
                        LOGGER1.warning("Enter a valid number to proceed.");
                }
            } catch (InputMismatchException e) {
                LOGGER1.warning("Please enter a valid number.");
                scanner.next();
            }
        }
    }
}
