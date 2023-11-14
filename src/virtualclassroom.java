import java.util.*;
class VC {
    Map<String, List<String>> studentListMap = new HashMap<>();
    Map<String, List<String>> assignmentMap = new HashMap<>();
    public void addClassroom(String className) {
        studentListMap.put(className, new ArrayList<>());
        System.out.println("Classroom " + className + " has been created.");
    }
    public void classroomList() {
        for (String className : studentListMap.keySet()) {
            System.out.println(className);
        }
    }
    public void removeclass(String removeclass){
        int flag = 0;
        if(studentListMap.containsKey(removeclass)){
            System.out.println("The class " + removeclass  + " is removed");
            studentListMap.remove(removeclass);
            flag =1;
        }
        if (flag ==0){
            System.out.println("No class found with the name to remove.");
        }
        System.out.println("The remaining classrooms are:");
        for(String i : studentListMap.keySet()){
            System.out.println(i);
        }
    }
    public void addStudent(String studentId, String className) {
        if (studentListMap.containsKey(className)) {
            List<String> students = studentListMap.get(className);
            students.add(studentId);
            studentListMap.put(className, students);
            System.out.println("Student " + studentId + " has been enrolled in " + className);
        } else {
            System.out.println("Classroom not found to add student ");
        }
    }
    public void displaythestudentsofclassroom(String listofclassstudents){
        int flag =0;
        for(String className : studentListMap.keySet()){
            if(className.equals(listofclassstudents)){
                System.out.print(studentListMap.get(className));
                flag =1;
            }
        }
        if(flag == 0){
            System.out.println("No class with name.");
        }
        System.out.println("\n");
    }
    public void scheduleAssignment(String className, String assignmentDetails) {
        if (assignmentMap.containsKey(className)) {
            List<String> assignments = assignmentMap.get(className);
            assignments.add(assignmentDetails);
            assignmentMap.put(className, assignments);
            System.out.println("Assignment for " + className + " has been scheduled.");
        } else {
            System.out.println("Classroom not found to schedule assignment.");
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
            System.out.println("Assignment submitted by Student " + studentId + " in " + className);


        } else {
            System.out.println("Student or class not found for assignment submission.");
        }
    }

    public void displayAssignments(String className) {
        List<String> assignments = assignmentMap.getOrDefault(className, Collections.emptyList());
        System.out.println("Assignments for " + className + ": " + assignments);
    }
}
public class virtualclassroom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VC virtualClassroom = new VC();
        while (true) {
            System.out.println("VIRTUAL CLASSROOM");
            System.out.println("Choose an action:");
            System.out.println("1. Add Classroom");
            System.out.println("2. Add Student");
            System.out.println("3. Remove class");
            System.out.println("4. display classrooms");
            System.out.println("5. display students in classroom");
            System.out.println("6. Schedule Assignment");
            System.out.println("7. Submit Assignment");
            System.out.println("8. Display Assignments");
            System.out.println("9. Exit");


            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter Classroom Name: ");
                        String classroomName = scanner.next();
                        virtualClassroom.addClassroom(classroomName);
                        break;
                    case 2:
                        System.out.print("Enter Student ID: ");
                        String studentId = scanner.next();
                        System.out.print("Enter Classroom for Student: ");
                        String studentClassroom = scanner.next();
                        virtualClassroom.addStudent(studentId, studentClassroom);
                        break;
                    case 3:
                        System.out.println("Enter the class name you want to remove:");
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
                        System.out.print("Enter Classroom for Assignment: ");
                        String assignmentClassroom = scanner.next();
                        System.out.print("Enter Assignment Details: ");
                        String assignmentDetails = scanner.next();
                        virtualClassroom.scheduleAssignment(assignmentClassroom, assignmentDetails);
                        break;
                    case 7:
                        System.out.print("Enter Student ID for Assignment Submission: ");
                        String submissionStudentId = scanner.next();
                        System.out.print("Enter Classroom for Assignment Submission: ");
                        String submissionClassroom = scanner.next();
                        System.out.print("Enter Assignment Details for Submission: ");
                        String submissionAssignmentDetails = scanner.next();
                        virtualClassroom.assignmentSubmission(submissionStudentId, submissionClassroom, submissionAssignmentDetails);
                        break;
                    case 8:
                        System.out.print("Enter Classroom to display assignments: ");
                        String displayClassroom = scanner.next();
                        virtualClassroom.displayAssignments(displayClassroom);
                        break;
                    case 9:
                        System.out.println("Exiting the program.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Enter a valid number to proceed.");
                }
            }catch(InputMismatchException e){
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
            }
        }
}
