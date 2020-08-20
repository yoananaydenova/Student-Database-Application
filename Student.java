import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;

    // Constructor: prompt user to enter student`s name and year
    public Student() {
        Scanner in = new Scanner(System.in);
        setFirstName(in);
        setLastName(in);
        setGradeYear(in);
        setStudentID();
    }

    private void setFirstName(Scanner in) {
        do {
            System.out.print("Enter student first name: ");
            String currentName = in.nextLine();
            if (currentName.trim().equals("")) {
                System.out.println("You can`t input empty space for student name! Try again!");
            } else {
                this.firstName = currentName;
                break;
            }
        } while (true);
    }

    private void setLastName(Scanner in) {
        do {
            System.out.print("Enter student last name: ");
            String currentLastName = in.nextLine();
            if (currentLastName.trim().equals("")) {
                System.out.println("You can`t input empty space for student last name! Try again!");
            } else {
                this.lastName = currentLastName;
                break;
            }
        } while (true);
    }

    private void setGradeYear(Scanner in) {
        do {
            System.out.print("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student class level: ");
            int currentGrade = in.nextInt();
            if (currentGrade < 1 || currentGrade > 4) {
                System.out.println("You can`t input grade out of range for student class level! Try again!");
            } else {
                this.gradeYear = currentGrade;
                break;
            }
        } while (true);

    }

    // Generate an ID
    private void setStudentID() {
        // Grade level + ID
        id++;
        this.studentID = this.gradeYear + "" + id;
    }

    // Enroll in courses
    public void enroll() {
        // Get inside of loop, user hits 0
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            String course = in.nextLine();
            if (!course.equals("Q")) {
                if (course.trim().equals("")) {
                    System.out.println("You can`t input empty space for course name! Try again!");
                    continue;
                }
                courses = courses + "\n - " + course;
                tuitionBalance += costOfCourse;
            } else {
                break;
            }
        } while (true);
    }

    // View balance
    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    // Pay Tuition
    public void payTuition() {
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        while (payment < 0 || payment > tuitionBalance) {
            if (payment < 0) {
                System.out.println("You can`t input negative payment of $" + payment);
            } else {
                System.out.println("You tried to pay $" + payment + ". Your have to pay $" + tuitionBalance + " or less. Try again!");
            }
            System.out.print("Enter your payment: $");
            payment = in.nextInt();
        }
        tuitionBalance -= payment;
        System.out.println("Your payment of $" + payment);
        viewBalance();
    }

    // Show Status
    public void showInfo() {
        String printCourses = courses.length() == 0 ? "none" : courses;
        System.out.println("------------------\nName: " + firstName + " " + lastName +
                "\nGrade level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled: " + printCourses +
                "\nBalance: $" + tuitionBalance);
    }

}
