package org.saiprasad.example;


import org.saiprasad.example.exceptions.CoachExistsExceptions;

import org.saiprasad.example.exceptions.LearnrAgeLimtExptions;
import org.saiprasad.example.exceptions.LearnrExistsExptions;
import org.saiprasad.example.modal.*;
import org.saiprasad.example.service.SwimmingSchool_ApplnImpl;
import org.saiprasad.example.service.SwimmingSchooliF;

import java.util.Scanner;

public class ApplicationUtilPackage {
    public static final Scanner SC1 = new Scanner(System.in);

    public static final SwimmingSchooliF SwimmingSchool = new SwimmingSchool_ApplnImpl();

    public static void addingLearners() {
        System.out.print("Enter New Learners Name: ");
        String FullName = SC1.nextLine();
        System.out.print("Enter New Learner Gender: ");
        String gender = SC1.nextLine();
        System.out.print("Enter New Learner Age: ");
        int age = SC1.nextInt();
        SC1.nextLine();
        System.out.print("Enter Learner Emergency Contact number: ");
        String emergencyContact_number = SC1.nextLine();
        System.out.print("Enter a Learner Grade: ");
        int grades = SC1.nextInt();
        SC1.nextLine();
        try {
            SwimmingSchool.addLearner(
                    new Learner(
                            FullName,
                            gender,
                            age,
                            emergencyContact_number,
                            grades
                    )
            );
            System.out.println("Learner " +FullName+ " Added Successfully!");
            SC1.nextLine();
        } catch (LearnrExistsExptions | LearnrAgeLimtExptions e) {
            System.out.println(e.getMessage());
            SC1.nextLine();
        }
    }


    public static void removedLearners() {
        System.out.print("Enter learners Full name: ");
        Learner learnr = SwimmingSchool.getLearners().stream().filter(
                l -> l.getFullName().equals(SC1.nextLine())
        ).findFirst().orElse(null);
        if (learnr == null) {
            System.out.println("Learners not found!");
            SC1.nextLine();
            return;
        }
        SwimmingSchool.removeLearner(learnr);
        System.out.println("Learners "+learnr.getFullName()+" removed successfully!");
        SC1.nextLine();
    }

    public static void addingCoach() {
        System.out.print("Enter new coach name: ");
        String cochFullName = SC1.nextLine();
        try {
            SwimmingSchool.addCoach(
                    new Coach(
                            cochFullName
                    )
            );
            System.out.println("New Coach added successfully!");
            SC1.nextLine();
        } catch (CoachExistsExceptions e) {
            System.out.println(e.getMessage());
            SC1.nextLine();
        }
    }

    public static void removingCoach() {
        System.out.print("Enter coachs name: ");
        Coach cochFullName = SwimmingSchool.getCoaches().stream().filter(
                cName -> cName.getName().equals(SC1.nextLine())
        ).findFirst().orElse(null);
        if (cochFullName == null) {
            System.out.println("Coach was not found!");
            SC1.nextLine();
            return;
        }
        SwimmingSchool.removeCoach(cochFullName);
        System.out.println("Coachs removed successfully!");
        SC1.nextLine();
    }

    public static void addSession() {
        System.out.print("Days We have");
        System.out.println("1. "+ SessionsDay.MNDAY);
        System.out.println("2. "+ SessionsDay.WDNSDAY);
        System.out.println("3. "+ SessionsDay.FDAY);
        System.out.println("4. "+ SessionsDay.SATDAY);
        System.out.println("0. Exit");
        SessionsDay day = null;
        System.out.print("Enter day: ");
        int choice = SC1.nextInt();
        SC1.nextLine();
        switch (choice) {
            case 1:
                day = SessionsDay.MNDAY;
                break;
            case 2:
                day = SessionsDay.WDNSDAY;
                break;
            case 3:
                day = SessionsDay.FDAY;
                break;
            case 4:
                day = SessionsDay.SATDAY;
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice!");
                SC1.nextLine();
                return;
        }
        System.out.print("Times");
        System.out.println("1. "+ BookTimeSlots.From2PMTo3PM);
        System.out.println("2. "+ BookTimeSlots.From3PMTo4PM);
        System.out.println("3. "+ BookTimeSlots.From4PMTo5PM);
        System.out.println("4. "+ BookTimeSlots.From5PMTo6PM);
        System.out.println("5. "+ BookTimeSlots.From6PMTo7PM);
        System.out.println("0. Exit");
        BookTimeSlots time = null;
        System.out.print("Enter time: ");
        choice = SC1.nextInt();
        SC1.nextLine();
        switch (choice) {
            case 1:
                time = BookTimeSlots.From2PMTo3PM;
                break;
            case 2:
                time = BookTimeSlots.From3PMTo4PM;
                break;
            case 3:
                time = BookTimeSlots.From4PMTo5PM;
                break;
            case 4:
                time = BookTimeSlots.From5PMTo6PM;
                break;
            case 5:
                time = BookTimeSlots.From6PMTo7PM;
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice!");
                SC1.nextLine();
                return;
        }
        System.out.print("Enter grades: ");
        int grde = SC1.nextInt();
        SC1.nextLine();
        System.out.println("Enter coach name: ");
        String cochName = SC1.nextLine();
        Coach coach = SwimmingSchool.getCoaches().stream().filter(
                c1 -> c1.getName().equals(cochName)
        ).findFirst().orElse(null);
        if (coach == null) {
            System.out.println("Coach not found!");
            SC1.nextLine();
            return;
        }
        SC1.nextLine();
        SwimmingSchool.addSession(
                new SwimmingSession(
                        (int) (Math.random() * 1000),
                        time,
                        coach,
                        day,
                        grde
                )
        );
        System.out.println("Session was added successfully!");
        SC1.nextLine();
    }

    public static void removingSession() {
        System.out.print("Enter the session id: ");
        int idVal = SC1.nextInt();
        SC1.nextLine();
        SwimmingSession sesion = SwimmingSchool.getSessions().stream().filter(
                l -> l.getId() == idVal
        ).findFirst().orElse(null);
        if (sesion == null) {
            System.out.println("Session was not found!");
            SC1.nextLine();
            return;
        }
        SwimmingSchool.removeSession(
                sesion
        );
        System.out.println("Session was removed successfully!");
        SC1.nextLine();
    }

    public static void timeTbleByDayView() {
        System.out.print("Days");
        System.out.println("1. "+ SessionsDay.MNDAY);
        System.out.println("2. "+ SessionsDay.WDNSDAY);
        System.out.println("3. "+ SessionsDay.FDAY);
        System.out.println("4. "+ SessionsDay.SATDAY);
        System.out.println("0. Exit");
        SessionsDay day = null;
        System.out.print("Enter a day: ");
        int choice = SC1.nextInt();
        SC1.nextLine();
        switch (choice) {
            case 1:
                day = SessionsDay.MNDAY;
                break;
            case 2:
                day = SessionsDay.WDNSDAY;
                break;
            case 3:
                day = SessionsDay.FDAY;
                break;
            case 4:
                day = SessionsDay.SATDAY;
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice");
                SC1.nextLine();
                return;
        }
        SwimmingSchool.timeTableByDayView(day);
        SC1.nextLine();
    }

    public static void timeTbleByGradeView() {
        System.out.print("Enter a grade: ");
        int grde = SC1.nextInt();
        SC1.nextLine();
        SwimmingSchool.timeTableByGradeView(grde);
        SC1.nextLine();
    }

    public static void timeTbleByCochView() {
        System.out.print("Enter a coach name: ");
        String cochFullName = SC1.nextLine();
        Coach coach = SwimmingSchool.getCoaches().stream().filter(
                c -> c.getName().equals(cochFullName)
        ).findFirst().orElse(null);

        if (coach == null) {
            System.out.println("Coach was not found!");
            SC1.nextLine();
            return;
        }

        SwimmingSchool.timeTableByCoachView(
                coach
        );
        SC1.nextLine();
        SC1.nextLine();
    }

    public static void bookingSession() {
        System.out.print("Enter  a learners name: ");
        String learnerFullName = SC1.nextLine();
        Learner learnr = SwimmingSchool.getLearners().stream().filter(
                l -> l.getFullName().equalsIgnoreCase(learnerFullName)
        ).findFirst().orElse(null);
        if (learnr == null) {
            System.out.println("Learner was not found!");
            SC1.nextLine();
            return;
        }
        System.out.print("Enter a session id please: ");
        int idVal = SC1.nextInt();
        SC1.nextLine();
        SwimmingSession session = SwimmingSchool.getSessions().stream().filter(
                l -> l.getId() == idVal
        ).findFirst().orElse(null);
        if (session == null) {
            System.out.println("Session not found!");
            SC1.nextLine();
            return;
        }
        try {
            SwimmingSchool.bookSession(
                    learnr,
                    session
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            SC1.nextLine();
        }
        System.out.println("Session was booked successfully!");
        SC1.nextLine();
    }

    public static void cancelingSession() {
        System.out.print("Enter a learner name: ");
        String learnerFullName = SC1.nextLine();
        Learner learnr = SwimmingSchool.getLearners().stream().filter(
                l -> l.getFullName().equals(learnerFullName)
        ).findFirst().orElse(null);
        if (learnr == null) {
            System.out.println("Learner not found!");
            SC1.nextLine();
            return;
        }
        System.out.print("Enter session id: ");
        int id = SC1.nextInt();
        SC1.nextLine();
        SwimmingSession sesion = SwimmingSchool.getSessions().stream().filter(
                l -> l.getId() == id
        ).findFirst().orElse(null);
        if (sesion == null) {
            System.out.println("Session not found!");
            SC1.nextLine();
            return;
        }
        try {
            SwimmingSchool.cancelSession(
                    learnr,
                    sesion
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            SC1.nextLine();
        }
        System.out.println("Session was cancelled successfully!");
        SC1.nextLine();
    }

    public static void attendingSession() {
        System.out.print("Enter a learner name: ");
        String learnerFullName = SC1.nextLine();
        Learner learnr = SwimmingSchool.getLearners().stream().filter(
                l -> l.getFullName().equals(learnerFullName)
        ).findFirst().orElse(null);
        if (learnr == null) {
            System.out.println("Learner not found!");
            SC1.nextLine();
            return;
        }
        System.out.print("Enter a session id: ");
        int id = SC1.nextInt();
        SC1.nextLine();
        SwimmingSession sesion1 = SwimmingSchool.getSessions().stream().filter(
                ls -> ls.getId() == id
        ).findFirst().orElse(null);
        if (sesion1 == null) {
            System.out.println("Session not found!");
            return;
        }
        try {
            SwimmingSchool.attendSession(
                    learnr,
                    sesion1
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            SC1.nextLine();
        }
        System.out.println("Session attended successfully!");
        SC1.nextLine();
    }

    public static void writeAReview() {
        System.out.print("Enter a learner name: ");
        String learnerFullName = SC1.nextLine();
        Learner learnr = SwimmingSchool.getLearners().stream().filter(
                ls1 -> ls1.getFullName().equalsIgnoreCase(learnerFullName)
        ).findFirst().orElse(null);
        if (learnr == null) {
            System.out.println("Learner was not found!");
            SC1.nextLine();
            return;
        }
        System.out.println("Enter Session ID: ");
        int id_Val= SC1.nextInt();
        SC1.nextLine();
        SwimmingSession session11 = SwimmingSchool.getSessions().stream().filter(
                ls2 -> ls2.getId() == id_Val
        ).findFirst().orElse(null);
        if (session11 == null) {
            System.out.println("Session not found!");
            SC1.nextLine();
            return;
        }
        System.out.print("Enter review: 1-5");
        int reviewData = SC1.nextInt();
        SC1.nextLine();
        try {
            SwimmingSchool.writeReview(
                    learnr,
                    session11,
                    reviewData
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            SC1.nextLine();
        }
        System.out.println("Review a written successfully!");
        SC1.nextLine();
    }

    public static void getLearnersReportData(){
        SwimmingSchool.generateLearnersReport();
    }

    public static void getCoachsReportData(){
        SwimmingSchool.generateCoachsReport();
    }

    public static String getRatingDescription(int rating) {
        return switch (rating) {
            case 1 -> "Very dissatisfied";
            case 2 -> "Dissatisfied";
            case 3 -> "Ok";
            case 4 -> "Satisfied";
            case 5 -> "Very Satisfied";
            default -> "Not rated";
        };
    }
}
