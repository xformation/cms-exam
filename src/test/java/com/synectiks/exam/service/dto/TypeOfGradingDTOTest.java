package com.synectiks.exam.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.synectiks.exam.web.rest.TestUtil;

public class TypeOfGradingDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TypeOfGradingDTO.class);
        TypeOfGradingDTO typeOfGradingDTO1 = new TypeOfGradingDTO();
        typeOfGradingDTO1.setId(1L);
        TypeOfGradingDTO typeOfGradingDTO2 = new TypeOfGradingDTO();
        assertThat(typeOfGradingDTO1).isNotEqualTo(typeOfGradingDTO2);
        typeOfGradingDTO2.setId(typeOfGradingDTO1.getId());
        assertThat(typeOfGradingDTO1).isEqualTo(typeOfGradingDTO2);
        typeOfGradingDTO2.setId(2L);
        assertThat(typeOfGradingDTO1).isNotEqualTo(typeOfGradingDTO2);
        typeOfGradingDTO1.setId(null);
        assertThat(typeOfGradingDTO1).isNotEqualTo(typeOfGradingDTO2);
    }
}
