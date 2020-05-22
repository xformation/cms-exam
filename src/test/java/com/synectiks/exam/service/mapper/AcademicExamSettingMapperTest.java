package com.synectiks.exam.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AcademicExamSettingMapperTest {

    private AcademicExamSettingMapper academicExamSettingMapper;

    @BeforeEach
    public void setUp() {
        academicExamSettingMapper = new AcademicExamSettingMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(academicExamSettingMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(academicExamSettingMapper.fromId(null)).isNull();
    }
}
