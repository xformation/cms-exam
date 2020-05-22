package com.synectiks.exam.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CompetitiveExamMapperTest {

    private CompetitiveExamMapper competitiveExamMapper;

    @BeforeEach
    public void setUp() {
        competitiveExamMapper = new CompetitiveExamMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(competitiveExamMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(competitiveExamMapper.fromId(null)).isNull();
    }
}
