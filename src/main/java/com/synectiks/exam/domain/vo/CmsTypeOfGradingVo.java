package com.synectiks.exam.domain.vo;

import javax.persistence.*;
import java.io.Serializable;

public class CmsTypeOfGradingVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer minMarks;
    private Integer maxMarks;
    private String grades;
    private Long groupvalue;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMinMarks() {
        return minMarks;
    }

    public void setMinMarks(Integer minMarks) {
        this.minMarks = minMarks;
    }

    public Integer getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(Integer maxMarks) {
        this.maxMarks = maxMarks;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public Long getGroupvalue() {
        return groupvalue;
    }

    public void setGroupvalue(Long groupvalue) {
        this.groupvalue = groupvalue;
    }

    @Override
    public String toString() {
        return "CmsTypeOfGradingVo{" +
            "id=" + id +
            ", minMarks=" + minMarks +
            ", maxMarks=" + maxMarks +
            ", grades='" + grades + '\'' +
            ", groupvalue=" + groupvalue +
            '}';
    }
}
