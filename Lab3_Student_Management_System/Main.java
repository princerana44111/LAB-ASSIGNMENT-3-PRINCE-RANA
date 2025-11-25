import model.Student;
import service.StudentManager;
import exception.StudentNotFoundException;
import thread.Loader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        try {
            System.out.print("Enter Roll No (Integer): ");
            Integer roll = Integer.valueOf(sc.nextLine());

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Marks (Double): ");
            Double marks = Double.valueOf(sc.nextLine());

            if (name.isEmpty() || course.isEmpty()) {
                throw new IllegalArgumentException("Name or course cannot be empty.");
            }

            if (marks < 0 || marks > 100) {
                throw new IllegalArgumentException("Invalid input: Marks must be 0–100.");
            }

            Thread t = new Thread(new Loader());
            t.start();
            t.join();

            Student s = new Student(roll, name, email, course, marks);
            manager.addStudent(s);

            s.display();

        } catch (NumberFormatException e) {
            System.out.println("Input Error: Please enter valid numbers!");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted!");
        } finally {
            System.out.println("\nProgram execution completed.");
            sc.close();
        }
    }
}
