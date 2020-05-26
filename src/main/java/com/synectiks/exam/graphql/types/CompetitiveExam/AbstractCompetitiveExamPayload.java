package com.synectiks.exam.graphql.types.CompetitiveExam;

import com.synectiks.exam.domain.CompetitiveExam;

public class AbstractCompetitiveExamPayload {

    private final CompetitiveExam competitiveExam;

    public AbstractCompetitiveExamPayload(CompetitiveExam competitiveExam) {
        this.competitiveExam = competitiveExam;
    }
    public CompetitiveExam getCompetitiveExam() {
        return competitiveExam;
    }


}

