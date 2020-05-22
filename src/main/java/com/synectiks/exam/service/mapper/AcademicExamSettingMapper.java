package com.synectiks.exam.service.mapper;


import com.synectiks.exam.domain.*;
import com.synectiks.exam.service.dto.AcademicExamSettingDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AcademicExamSetting} and its DTO {@link AcademicExamSettingDTO}.
 */
@Mapper(componentModel = "spring", uses = {TypeOfGradingMapper.class})
public interface AcademicExamSettingMapper extends EntityMapper<AcademicExamSettingDTO, AcademicExamSetting> {

    @Mapping(source = "typeOfGrading.id", target = "typeOfGradingId")
    AcademicExamSettingDTO toDto(AcademicExamSetting academicExamSetting);

    @Mapping(source = "typeOfGradingId", target = "typeOfGrading")
    AcademicExamSetting toEntity(AcademicExamSettingDTO academicExamSettingDTO);

    default AcademicExamSetting fromId(Long id) {
        if (id == null) {
            return null;
        }
        AcademicExamSetting academicExamSetting = new AcademicExamSetting();
        academicExamSetting.setId(id);
        return academicExamSetting;
    }
}
