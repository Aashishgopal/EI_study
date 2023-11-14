import java.util.*;
import java.util.logging.Logger;
class VC {
    private static final Logger LOGGER = Logger.getLogger(VC.class.getName());
    Map<String, List<String>> studentListMap = new HashMap<>();
    Map<String, List<String>> assignmentMap = new HashMap<>();
    public void addClassroom(String className) {
        studentListMap.put(className, new ArrayList<>());
        LOGGER.info("Classroom " + className + " has been created.");
    }
    public void classroomList() {
        for (String className : studentListMap.keySet()) {
            LOGGER.info(className);
        }
    }
    public void removeclass(String removeclasses){
        int flag = 0;
        if(studentListMap.containsKey(removeclasses)){
            LOGGER.info("The class " + removeclasses  + " is removed");
            studentListMap.remove(removeclasses);
            flag =1;
        }
        if (flag ==0){
           LOGGER.info("No class found with the name to remove.");
        }
        System.out.println("The remaining classrooms are:");
        for(String i : studentListMap.keySet()){
            LOGGER.info(i);
        }
    }
    public void addStudent(String studentId, String className) {
        if (studentListMap.containsKey(className)) {
            List<String> students = studentListMap.get(className);
            students.add(studentId);
            studentListMap.put(className, students);
            LOGGER.info("Student " + studentId + " has been enrolled in " + className);
        } else {
            LOGGER.info("Classroom not found to add student ");
        }
    }
    public void displaythestudentsofclassroom(String listofclassstudents){
        int flag =0;
        for(String className : studentListMap.keySet()){
            if(className.equals(listofclassstudents)){
                LOGGER.info(String.valueOf(studentListMap.get(className)));
                flag =1;
            }
        }
        if(flag == 0){
            LOGGER.info("No class with name.");
        }
        LOGGER.info("\n");
    }
    public void scheduleAssignment(String className, String assignmentDetails) {
        if (assignmentMap.containsKey(className)) {
            List<String> assignments = assignmentMap.get(className);
            assignments.add(assignmentDetails);
            assignmentMap.put(className, assignments);
            LOGGER.info("Assignment for " + className + " has been scheduled.");
        } else {
            LOGGER.info("Classroom not found to schedule assignment.");
        }
    }
    public void assignmentSubmission(String studentId, String className, String assignmentDetails) {
        if (studentListMap.containsKey(className) && studentListMap.get(className).contains(studentId)) {
            List<String> assignments = assignmentMap.get(className);
            if (assignments == null) {
                assignments = new ArrayList<>();
            }
            assignments.add(assignmentDetails);
            assignmentMap.put(className, assignments);
            LOGGER.info("Assignment submitted by Student " + studentId + " in " + className);


        } else {
            LOGGER.info("Student or class not found for assignment submission.");
        }
    }

    public void displayAssignments(String className) {
        List<String> assignments = assignmentMap.getOrDefault(className, Collections.emptyList());
        LOGGER.info("Assignments for " + className + ": " + assignments);
    }
}
public class virtualclassroom {
    private static final Logger LOGGER1= Logger.getLogger(virtualclassroom.class.getName());
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VC virtualClassroom = new VC();
        while (true) {
            LOGGER1.info("VIRTUAL CLASSROOM");
            LOGGER1.info("Choose an action:");
            LOGGER1.info("1. Add Classroom");
            LOGGER1.info("2. Add Student");
            LOGGER1.info("3. Remove class");
            LOGGER1.info("4. display classrooms");
            LOGGER1.info("5. display students in classroom");
            LOGGER1.info("6. Schedule Assignment");
            LOGGER1.info("7. Submit Assignment");
            LOGGER1.info("8. Display Assignments");
            LOGGER1.info("9. Exit");


            try {
                int choice = scanner.nextInt();
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
                        LOGGER1.info("Enter a valid number to proceed.");
                }
            }catch(InputMismatchException e){
                LOGGER1.info("Please enter a valid number.");
                scanner.next();
            }
            }
        }
}
