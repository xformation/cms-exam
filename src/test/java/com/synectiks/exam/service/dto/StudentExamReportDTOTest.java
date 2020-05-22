package com.synectiks.exam.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.synectiks.exam.web.rest.TestUtil;

public class StudentExamReportDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(StudentExamReportDTO.class);
        StudentExamReportDTO studentExamReportDTO1 = new StudentExamReportDTO();
        studentExamReportDTO1.setId(1L);
        StudentExamReportDTO studentExamReportDTO2 = new StudentExamReportDTO();
        assertThat(studentExamReportDTO1).isNotEqualTo(studentExamReportDTO2);
        studentExamReportDTO2.setId(studentExamReportDTO1.getId());
        assertThat(studentExamReportDTO1).isEqualTo(studentExamReportDTO2);
        studentExamReportDTO2.setId(2L);
        assertThat(studentExamReportDTO1).isNotEqualTo(studentExamReportDTO2);
        studentExamReportDTO1.setId(null);
        assertThat(studentExamReportDTO1).isNotEqualTo(studentExamReportDTO2);
    }
}
