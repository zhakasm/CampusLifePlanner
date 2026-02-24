import java.util.ArrayList;
import java.util.HashMap;

public class CampusLifeApp {

    public static void main(String[] args) {

        // Create courses
        Course oop = new Course("OOP", "Dr. Lee", 6);
        Course discrete = new Course("Discrete Math", "Dr. Kim", 5);
        Course english = new Course("English", "Ms. Brown", 3);

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(oop);
        courses.add(discrete);
        courses.add(english);

        // Create assignments
        ArrayList<AssignmentTask> tasks = new ArrayList<>();
        tasks.add(new AssignmentTask("Lab 1", oop, 3, 1));
        tasks.add(new AssignmentTask("Project Proposal", oop, 5, 5));
        tasks.add(new AssignmentTask("Homework 2", discrete, 4, 2));
        tasks.add(new AssignmentTask("Essay Draft", english, 2, 0));
        tasks.add(new AssignmentTask("Quiz Prep", discrete, 2, 4));

        // Create study sessions
        ArrayList<StudySession> sessions = new ArrayList<>();
        sessions.add(new StudySession(oop, 120));
        sessions.add(new StudySession(discrete, 90));
        sessions.add(new StudySession(oop, 60));
        sessions.add(new StudySession(english, 45));

        // Print courses
        System.out.println("=== COURSES ===");
        for (Course c : courses) {
            System.out.println(c);
        }

        // Print assignments + highlight urgent
        System.out.println("\n=== ASSIGNMENTS ===");
        for (AssignmentTask t : tasks) {
            if (t.isUrgent()) {
                System.out.println("URGENT → " + t);
            } else {
                System.out.println(t);
            }
        }

        // Total estimated hours remaining
        int totalRemaining = 0;
        for (AssignmentTask t : tasks) {
            if (!t.isCompleted()) {
                totalRemaining += t.getEstimatedHours();
            }
        }

        System.out.println("\nTotal remaining estimated hours: " + totalRemaining);

        // Total study time per course
        System.out.println("\n=== STUDY TIME PER COURSE ===");
        HashMap<String, Double> studyHours = new HashMap<>();

        for (StudySession s : sessions) {
            String courseName = s.getCourse().getName();
            studyHours.put(courseName,
                    studyHours.getOrDefault(courseName, 0.0) + s.hours());
        }

        for (String name : studyHours.keySet()) {
            System.out.println(name + ": " + studyHours.get(name) + " hours");
        }

        // Mark one assignment completed
        AssignmentTask taskToComplete = tasks.get(0);
        taskToComplete.markCompleted();

        System.out.println("\n=== AFTER COMPLETION ===");
        System.out.println("Updated task: " + taskToComplete);

        int newRemaining = 0;
        for (AssignmentTask t : tasks) {
            if (!t.isCompleted()) {
                newRemaining += t.getEstimatedHours();
            }
        }

        System.out.println("New remaining estimated hours: " + newRemaining);
    }
}
