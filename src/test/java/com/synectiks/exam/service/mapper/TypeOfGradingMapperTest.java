package com.synectiks.exam.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TypeOfGradingMapperTest {

    private TypeOfGradingMapper typeOfGradingMapper;

    @BeforeEach
    public void setUp() {
        typeOfGradingMapper = new TypeOfGradingMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(typeOfGradingMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(typeOfGradingMapper.fromId(null)).isNull();
    }
}
