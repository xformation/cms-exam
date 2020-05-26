package com.synectiks.exam.graphql.types.CompetitiveExam;

import java.util.Objects;

public class AddCompetitiveExamInput extends AbstractCompetitiveExamInput{
    private Long studentId;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddCompetitiveExamInput)) return false;
        if (!super.equals(o)) return false;
        AddCompetitiveExamInput that = (AddCompetitiveExamInput) o;
        return Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentId);
    }

    @Override
    public String toString() {
        return "AddCompetitiveExamInput{" +
            "studentId=" + studentId +
            '}';
    }
}
