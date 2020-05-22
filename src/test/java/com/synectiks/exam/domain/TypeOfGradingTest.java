package com.synectiks.exam.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.synectiks.exam.web.rest.TestUtil;

public class TypeOfGradingTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TypeOfGrading.class);
        TypeOfGrading typeOfGrading1 = new TypeOfGrading();
        typeOfGrading1.setId(1L);
        TypeOfGrading typeOfGrading2 = new TypeOfGrading();
        typeOfGrading2.setId(typeOfGrading1.getId());
        assertThat(typeOfGrading1).isEqualTo(typeOfGrading2);
        typeOfGrading2.setId(2L);
        assertThat(typeOfGrading1).isNotEqualTo(typeOfGrading2);
        typeOfGrading1.setId(null);
        assertThat(typeOfGrading1).isNotEqualTo(typeOfGrading2);
    }
}
