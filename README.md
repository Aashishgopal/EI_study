# Virtual Classroom Java Application

This Java application simulates a virtual classroom environment, allowing users to perform various actions such as adding classrooms, enrolling students, scheduling assignments, submitting assignments, and more.

## Usage

1. **Add Classroom**
   - Choose option 1 and enter the name for the new classroom when prompted.

2. **Add Student**
   - Choose option 2, enter the student ID, and specify the classroom where the student should be enrolled.

3. **Remove Classroom**
   - Choose option 3 and provide the name of the classroom you want to remove.

4. **Display Classrooms**
   - Choose option 4 to see a list of existing classrooms.

5. **Display Students in Classroom**
   - Choose option 5 and enter the classroom name to display a list of students in that classroom.

6. **Schedule Assignment**
   - Choose option 6, specify the classroom, and provide details for the assignment.

7. **Submit Assignment**
   - Choose option 7, enter the student ID, classroom, and assignment details to submit an assignment.

8. **Display Assignments**
   - Choose option 8 and enter the classroom name to view the scheduled assignments.

9. **Exit**
   - Choose option 9 to exit the program.

## How to Run

1. Clone the repository.
2. Compile the Java files:
   ```bash
   javac virtualclassroom.java
   ```
3. Run the application:
   ```bash
   java virtualclassroom
   ```
4. Follow the on-screen instructions to interact with the virtual classroom.

## Notes

- The application utilizes a simple console-based interface.
- Logging is implemented using Java's `Logger` class for better visibility of actions and errors.
