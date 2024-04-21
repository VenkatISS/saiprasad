package org.saiprasad.example.modal;


import org.saiprasad.example.exceptions.LearnrAgeLimtExptions;

import java.util.ArrayList;
import java.util.List;

public class Learner {


    private String FullName;
    private String gender;
    private int age;
    private String emergencyContact_Number;
    private int grades;
    private List<SwimmingSession> sessionsBooked;
    private List<SwimmingSession> sessionsAttended;
    private List<SwimmingSession> sessionsCancelled;

    public Learner(String FullName, String gender , int age, String emergencyContact_Number, int grades) throws LearnrAgeLimtExptions {
        if(age < 4 || age > 11) {
            throw new LearnrAgeLimtExptions("Age should be between 4 and 11");
        }
        this.FullName = FullName;
        this.gender = gender;
        this.age = age;
        this.emergencyContact_Number = emergencyContact_Number;
        this.grades = grades;
        this.sessionsBooked = new ArrayList<>();
        this.sessionsAttended = new ArrayList<>();
        this.sessionsCancelled = new ArrayList<>();
    }

    public boolean isSessionAttended(SwimmingSession session) {
        return sessionsAttended.contains(session);
    }

    public boolean isSessionBooked(SwimmingSession session) {
        return sessionsBooked.contains(session);
    }

    public boolean isEligibleForSession(SwimmingSession session){
        return grades == session.getGrade() || grades == session.getGrade() - 1;
    }

    public void bookSession(SwimmingSession session) {
        sessionsBooked.add(session);
    }

    public void attendSession(SwimmingSession session) {
        sessionsBooked.remove(session);
        sessionsAttended.add(session);
        setGrades(session.getGrade());
    }

    public void cancelSession(SwimmingSession session) {
        sessionsBooked.remove(session);
        sessionsCancelled.add(session);
    }
    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEmergencyContact_Number() {
        return emergencyContact_Number;
    }

    public void setEmergencyContact_Number(String emergencyContact_Number) {
        this.emergencyContact_Number = emergencyContact_Number;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<SwimmingSession> getSessionsBooked() {
        return sessionsBooked;
    }

    public List<SwimmingSession> getSessionsAttended() {
        return sessionsAttended;
    }


    public List<SwimmingSession> getSessionsCancelled() {
        return sessionsCancelled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Learner learner = (Learner) o;
        return FullName.equals(learner.FullName);
    }


    @Override
    public String toString() {
        String sb = "Name: " + FullName + "\n" +
                "Gender: " + gender + "\n" +
                "Age: " + age + "\n" +
                "Emergency Contact: " + emergencyContact_Number + "\n" +
                "Grade: " + grades + "\n" +
                "Sessions Booked: " + sessionsBooked.size() + "\n" +
                "Sessions Attended: " + sessionsAttended.size() + "\n" +
                "Sessions Cancelled: " + sessionsCancelled.size() + "\n";
        return sb;
    }
}
