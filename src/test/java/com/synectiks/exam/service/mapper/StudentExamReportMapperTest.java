package com.synectiks.exam.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StudentExamReportMapperTest {

    private StudentExamReportMapper studentExamReportMapper;

    @BeforeEach
    public void setUp() {
        studentExamReportMapper = new StudentExamReportMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(studentExamReportMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(studentExamReportMapper.fromId(null)).isNull();
    }
}
