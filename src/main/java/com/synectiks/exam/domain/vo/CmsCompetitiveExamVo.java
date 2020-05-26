package com.synectiks.exam.domain.vo;

import java.io.Serializable;

public class CmsCompetitiveExamVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String testName;
    private Integer testScore;
    private Long enrollmentNo;
    private Long rank;
    private Long studentId;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Integer getTestScore() {
        return testScore;
    }

    public void setTestScore(Integer testScore) {
        this.testScore = testScore;
    }

    public Long getEnrollmentNo() {
        return enrollmentNo;
    }

    public void setEnrollmentNo(Long enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "CmsCompetitiveExamVo{" +
            "id=" + id +
            ", testName='" + testName + '\'' +
            ", testScore=" + testScore +
            ", enrollmentNo=" + enrollmentNo +
            ", rank=" + rank +
            ", studentId=" + studentId +
            '}';
    }
}
