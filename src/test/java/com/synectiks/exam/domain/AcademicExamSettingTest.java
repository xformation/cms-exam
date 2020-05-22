package com.synectiks.exam.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.synectiks.exam.web.rest.TestUtil;

public class AcademicExamSettingTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AcademicExamSetting.class);
        AcademicExamSetting academicExamSetting1 = new AcademicExamSetting();
        academicExamSetting1.setId(1L);
        AcademicExamSetting academicExamSetting2 = new AcademicExamSetting();
        academicExamSetting2.setId(academicExamSetting1.getId());
        assertThat(academicExamSetting1).isEqualTo(academicExamSetting2);
        academicExamSetting2.setId(2L);
        assertThat(academicExamSetting1).isNotEqualTo(academicExamSetting2);
        academicExamSetting1.setId(null);
        assertThat(academicExamSetting1).isNotEqualTo(academicExamSetting2);
    }
}
