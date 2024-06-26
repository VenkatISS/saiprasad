package org.saiprasad.example.modal;

import java.util.ArrayList;
import java.util.List;

public class SwimmingSession {
    private int id;
    private BookTimeSlots bookTimeSlot;
    private Coach coach;
    private SessionsDay day;
    private int grade;
    private List<Learner> attendees;

    // only for testing
    public SwimmingSession(int id) {
        this.id = id;
        this.grade = 2;
        this.attendees = new ArrayList<>();
    }
    // only for testing purpose
    public SwimmingSession(int id, int grade) {
        this.id = id;
        this.grade = grade;
        this.attendees = new ArrayList<>();
    }

    public SwimmingSession(int id, BookTimeSlots bookTimeSlot, SessionsDay day, int grade) {
        this.id = id;
        this.bookTimeSlot = bookTimeSlot;
        this.day = day;
        this.grade = grade;
        this.attendees = new ArrayList<>();
    }

    public SwimmingSession(int id, BookTimeSlots bookTimeSlot, Coach coach, SessionsDay day, int grade) {
        this.id = id;
        this.bookTimeSlot = bookTimeSlot;
        this.coach = coach;
        this.day = day;
        this.grade = grade;
        this.attendees = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFull() {
        return this.attendees.size() == 4;
    }

    public void addAttendee(Learner learner) {
        this.attendees.add(learner);
    }

    public void removeAttendee(Learner learner) {
        this.attendees.remove(learner);
    }

    public BookTimeSlots getTimeSlot() {
        return bookTimeSlot;
    }

    public void setTimeSlot(BookTimeSlots bookTimeSlot) {
        this.bookTimeSlot = bookTimeSlot;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public SessionsDay getDay() {
        return day;
    }

    public void setDay(SessionsDay day) {
        this.day = day;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Learner> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Learner> attendees) {
        this.attendees = attendees;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SwimmingSession other = (SwimmingSession) obj;
        return id == other.id;
    }

    @Override
    public String toString() {
        return "SwimmingSession{" +
                "id=" + id +
                ", timeSlot=" + bookTimeSlot +
                ", coach=" + coach +
                ", day=" + day +
                ", grade=" + grade +
                ", attendees=" + attendees +
                '}';
    }
}
