package com.synectiks.exam.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.synectiks.exam.web.rest.TestUtil;

public class CompetitiveExamDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CompetitiveExamDTO.class);
        CompetitiveExamDTO competitiveExamDTO1 = new CompetitiveExamDTO();
        competitiveExamDTO1.setId(1L);
        CompetitiveExamDTO competitiveExamDTO2 = new CompetitiveExamDTO();
        assertThat(competitiveExamDTO1).isNotEqualTo(competitiveExamDTO2);
        competitiveExamDTO2.setId(competitiveExamDTO1.getId());
        assertThat(competitiveExamDTO1).isEqualTo(competitiveExamDTO2);
        competitiveExamDTO2.setId(2L);
        assertThat(competitiveExamDTO1).isNotEqualTo(competitiveExamDTO2);
        competitiveExamDTO1.setId(null);
        assertThat(competitiveExamDTO1).isNotEqualTo(competitiveExamDTO2);
    }
}
