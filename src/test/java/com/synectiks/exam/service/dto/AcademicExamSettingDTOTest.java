package com.synectiks.exam.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.synectiks.exam.web.rest.TestUtil;

public class AcademicExamSettingDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AcademicExamSettingDTO.class);
        AcademicExamSettingDTO academicExamSettingDTO1 = new AcademicExamSettingDTO();
        academicExamSettingDTO1.setId(1L);
        AcademicExamSettingDTO academicExamSettingDTO2 = new AcademicExamSettingDTO();
        assertThat(academicExamSettingDTO1).isNotEqualTo(academicExamSettingDTO2);
        academicExamSettingDTO2.setId(academicExamSettingDTO1.getId());
        assertThat(academicExamSettingDTO1).isEqualTo(academicExamSettingDTO2);
        academicExamSettingDTO2.setId(2L);
        assertThat(academicExamSettingDTO1).isNotEqualTo(academicExamSettingDTO2);
        academicExamSettingDTO1.setId(null);
        assertThat(academicExamSettingDTO1).isNotEqualTo(academicExamSettingDTO2);
    }
}
