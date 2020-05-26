package com.synectiks.exam.graphql.types.CompetitiveExam;

import com.synectiks.exam.domain.CompetitiveExam;

import java.util.List;

public class RemoveCompetitiveExamPayload {
    private final List<CompetitiveExam> CompetitiveExams;

    public List<CompetitiveExam> getCompetitiveExams() {
        return CompetitiveExams;
    }

    public RemoveCompetitiveExamPayload(List<CompetitiveExam> competitiveExams) {
        CompetitiveExams = competitiveExams;
    }
}
