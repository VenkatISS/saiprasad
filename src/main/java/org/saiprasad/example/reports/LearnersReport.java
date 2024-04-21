package org.saiprasad.example.reports;

import org.saiprasad.example.service.SwimmingSchooliF;
import org.saiprasad.example.modal.Learner;
import java.util.List;

public class LearnersReport implements Report {

    @Override
    public void getReport(SwimmingSchooliF hjSwimmingSchool) {
        List<Learner> learners = hjSwimmingSchool.getLearners();
        System.out.println("============================================");
        System.out.println("Learners Report");
        System.out.println("============================================");
        for (Learner learner : learners) {
            System.out.println(learner);
        }
        System.out.println("============================================");
    }
}
