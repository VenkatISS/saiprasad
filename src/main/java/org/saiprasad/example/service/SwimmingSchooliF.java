package org.saiprasad.example.service;

import org.saiprasad.example.exceptions.*;
import org.saiprasad.example.modal.*;


import java.util.List;

public interface SwimmingSchooliF {

    void timeTableByDayView(SessionsDay day);
    void timeTableByGradeView(int grade);
    void timeTableByCoachView(Coach coach);

    void bookSession(Learner learner, SwimmingSession session) throws SesionNotElgibleExcptions, SesionAlrdyBookedExptions, SesionFullBookedExcptions;
    void cancelSession(Learner learner, SwimmingSession session) throws SesionNotBookedExcptions, SesionAtndedExcptions;
    void attendSession(Learner learner, SwimmingSession session) throws SesionNotBookedExcptions;

    void assignCoachToSession(Coach coach, SwimmingSession session) throws SwimingSesionAlrdyHasCochExcptions;

    void addLearner(Learner learner) throws LearnrExistsExptions;
    void removeLearner(Learner learner);

    void addCoach(Coach coach) throws CoachExistsExceptions;
    void removeCoach(Coach coach);

    void addSession(SwimmingSession session);
    void removeSession(SwimmingSession session);

    void writeReview(Learner learner, SwimmingSession session, int rating) throws InvaldRtingsExceptions, SesionWrteRevewExcptions;

    void generateLearnersReport();
    void generateCoachsReport();

    List<SwimmingSession> getSessions();

    List<Coach> getCoaches();

    List<Learner> getLearners();

    List<Review> getReviews();
}
