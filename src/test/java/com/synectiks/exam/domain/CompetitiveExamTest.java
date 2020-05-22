package com.synectiks.exam.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.synectiks.exam.web.rest.TestUtil;

public class CompetitiveExamTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CompetitiveExam.class);
        CompetitiveExam competitiveExam1 = new CompetitiveExam();
        competitiveExam1.setId(1L);
        CompetitiveExam competitiveExam2 = new CompetitiveExam();
        competitiveExam2.setId(competitiveExam1.getId());
        assertThat(competitiveExam1).isEqualTo(competitiveExam2);
        competitiveExam2.setId(2L);
        assertThat(competitiveExam1).isNotEqualTo(competitiveExam2);
        competitiveExam1.setId(null);
        assertThat(competitiveExam1).isNotEqualTo(competitiveExam2);
    }
}
