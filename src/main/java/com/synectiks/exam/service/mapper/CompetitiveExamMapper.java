package com.synectiks.exam.service.mapper;


import com.synectiks.exam.domain.*;
import com.synectiks.exam.service.dto.CompetitiveExamDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link CompetitiveExam} and its DTO {@link CompetitiveExamDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CompetitiveExamMapper extends EntityMapper<CompetitiveExamDTO, CompetitiveExam> {



    default CompetitiveExam fromId(Long id) {
        if (id == null) {
            return null;
        }
        CompetitiveExam competitiveExam = new CompetitiveExam();
        competitiveExam.setId(id);
        return competitiveExam;
    }
}
