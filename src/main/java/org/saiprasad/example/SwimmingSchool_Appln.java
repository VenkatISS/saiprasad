package org.saiprasad.example;
import java.util.Scanner;

import static org.saiprasad.example.ApplicationUtilPackage.addingLearners;

public class SwimmingSchool_Appln {
    private static final Scanner SC = new Scanner(System.in);
    public static final boolean Val= true;

    //Starts the application from main method.
    public static void main(String[] args) {
        System.out.println("============================");
        System.out.println("============================");
        System.out.println("Welcome to the Swimming School System");
        System.out.println("============================");
        System.out.println("============================");
        while (Val) {
            System.out.println(" select an number from below ");
            System.out.println("=====================================");
            System.out.println("=====================================");
            System.out.println("1. New Learners");
            System.out.println("2. Remove the Learners");
            System.out.println("3. Adding Coach");
            System.out.println("4. Removing Coach");
            System.out.println("5. Adding Session");
            System.out.println("6. Removing Session");
            System.out.println("7. You View Timetable by Daywise");
            System.out.println("8. You View TimeTable by Grade");
            System.out.println("9. You View TimeTable by Coach");
            System.out.println("10. Book a Session");
            System.out.println("11. Cancel a Session");
            System.out.println("12. Attend a Session");
            System.out.println("13. Write a Review");
            System.out.println("14. Generate Learnr Report");
            System.out.println("15. Generate Coach Report");
            System.out.println("0. Exit");
            System.out.println("===========================");
            System.out.println("===========================");

            System.out.print("Please Enter your option number respectively: ");
            int ch = SC.nextInt();
            SC.nextLine();
            _GotoUserChoice(ch);
        }
    }

    private static void _GotoUserChoice(int ch) {
        switch (ch) {
            case 1:
                _displayHeadingText("You selected the New Learner option.");
                ApplicationUtilPackage.addingLearners();
                break;
            case 2:
                _displayHeadingText("You  selected the Remove Learner option.");
                ApplicationUtilPackage.removedLearners();
                break;
            case 3:
                _displayHeadingText("Add a Coach");
                ApplicationUtilPackage.addingCoach();
                break;
            case 4:
                _displayHeadingText("Remove a Coach");
                ApplicationUtilPackage.removingCoach();
                break;
            case 5:
                _displayHeadingText("Add a Session");
                ApplicationUtilPackage.addSession();
                break;
            case 6:
                _displayHeadingText("Remove a Session");
                ApplicationUtilPackage.removingSession();
                break;
            case 7:
                _displayHeadingText(" View Timetable by Day");
                ApplicationUtilPackage.timeTbleByDayView();
                break;
            case 8:
                _displayHeadingText(" view Timetable by Grade");
                ApplicationUtilPackage.timeTbleByGradeView();
                break;
            case 9:
                _displayHeadingText(" view Timetable by Coach");
                ApplicationUtilPackage.timeTbleByCochView();
                break;
            case 10:
                _displayHeadingText("Book a Session");
                ApplicationUtilPackage.bookingSession();
                break;
            case 11:
                _displayHeadingText("Cancel a Session");
                ApplicationUtilPackage.cancelingSession();
                break;
            case 12:
                _displayHeadingText("Attend a Session");
                ApplicationUtilPackage.attendingSession();
                break;
            case 13:
                _displayHeadingText("Write a Review");
                ApplicationUtilPackage.writeAReview();
                break;
            case 14:
                _displayHeadingText("Learners Report");
                ApplicationUtilPackage.getLearnersReportData();
                break;
            case 15:
                _displayHeadingText("Coach Report");
                ApplicationUtilPackage.getCoachsReportData();
                break;
            case 0:
                _displayHeadingText("Exit.");
                return;
            default:
                _displayHeadingText("Choice Invalid! Please try again.");
                SC.nextLine();

        }
    }

    private static void _displayHeadingText(String msg) {
        System.out.println("==========================");
        System.out.println("==========================");
        System.out.println(msg);
        System.out.println("==========================");
        System.out.println("==========================");

    }
}
