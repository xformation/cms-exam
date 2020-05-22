package com.synectiks.exam.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.synectiks.exam.web.rest.TestUtil;

public class StudentExamReportTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(StudentExamReport.class);
        StudentExamReport studentExamReport1 = new StudentExamReport();
        studentExamReport1.setId(1L);
        StudentExamReport studentExamReport2 = new StudentExamReport();
        studentExamReport2.setId(studentExamReport1.getId());
        assertThat(studentExamReport1).isEqualTo(studentExamReport2);
        studentExamReport2.setId(2L);
        assertThat(studentExamReport1).isNotEqualTo(studentExamReport2);
        studentExamReport1.setId(null);
        assertThat(studentExamReport1).isNotEqualTo(studentExamReport2);
    }
}
