import java.util.Scanner;

class Institution {

    String institutionName = "ABC Institution";

    class Student {

        String studentName;
        int rollNo;
        int[] marks;
        double average;
        char grade;

        void addStudent(Scanner sc) {

            System.out.print("Enter Student Name: ");
            studentName = sc.nextLine();

            System.out.print("Enter Roll No: ");
            rollNo = sc.nextInt();

            System.out.print("Enter Number of Subjects: ");
            int n = sc.nextInt();

            marks = new int[n];

            System.out.println("Student Added Successfully");
        }

        void addMarks(Scanner sc) {

            if (marks == null) {
                System.out.println("Please Add Student First");
                return;
            }

            System.out.println("Enter Marks:");

            for (int i = 0; i < marks.length; i++) {
                marks[i] = sc.nextInt();
            }

            System.out.println("Marks Added Successfully");
        }

        void calculateGrade() {

            if (marks == null) {
                System.out.println("Please Add Student and Marks First");
                return;
            }

            int total = 0;

            for (int i = 0; i < marks.length; i++) {
                total = total + marks[i];
            }

            average = (double) total / marks.length;

            if (average >= 90) {
                grade = 'A';
            }
            else if (average >= 75) {
                grade = 'B';
            }
            else if (average >= 50) {
                grade = 'C';
            }
            else {
                grade = 'F';
            }

            System.out.println("Grade Calculated Successfully");
        }

        void displayDetails() {

            if (marks == null) {
                System.out.println("Please Add Student First");
                return;
            }

            System.out.println();
            System.out.println("Institution Name: " + institutionName);
            System.out.println("Student Name: " + studentName);
            System.out.println("Roll No: " + rollNo);

            System.out.print("Marks: ");

            for (int i = 0; i < marks.length; i++) {
                System.out.print(marks[i] + " ");
            }

            System.out.println();
            System.out.printf("Average: %.2f\n", average);
            System.out.println("Grade: " + grade);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Institution institution = new Institution();
        Institution.Student student = institution.new Student();

        int choice;

        do {

            System.out.println();
            System.out.println("1. Add Student");
            System.out.println("2. Add Marks");
            System.out.println("3. Calculate Grade");
            System.out.println("4. Display Student Details");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    student.addStudent(sc);
                    break;

                case 2:
                    student.addMarks(sc);
                    break;

                case 3:
                    student.calculateGrade();
                    break;

                case 4:
                    student.displayDetails();
                    break;

                case 5:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);
    }
}