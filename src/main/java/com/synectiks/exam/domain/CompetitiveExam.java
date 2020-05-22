package com.synectiks.exam.domain;


import javax.persistence.*;

import java.io.Serializable;

/**
 * A CompetitiveExam.
 */
@Entity
@Table(name = "competitive_exam")
public class CompetitiveExam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "test_score")
    private Integer testScore;

    @Column(name = "enrollment_no")
    private Long enrollmentNo;

    @Column(name = "rank")
    private Long rank;

    @Column(name = "student_id")
    private Long studentId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public CompetitiveExam testName(String testName) {
        this.testName = testName;
        return this;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Integer getTestScore() {
        return testScore;
    }

    public CompetitiveExam testScore(Integer testScore) {
        this.testScore = testScore;
        return this;
    }

    public void setTestScore(Integer testScore) {
        this.testScore = testScore;
    }

    public Long getEnrollmentNo() {
        return enrollmentNo;
    }

    public CompetitiveExam enrollmentNo(Long enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
        return this;
    }

    public void setEnrollmentNo(Long enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }

    public Long getRank() {
        return rank;
    }

    public CompetitiveExam rank(Long rank) {
        this.rank = rank;
        return this;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Long getStudentId() {
        return studentId;
    }

    public CompetitiveExam studentId(Long studentId) {
        this.studentId = studentId;
        return this;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CompetitiveExam)) {
            return false;
        }
        return id != null && id.equals(((CompetitiveExam) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "CompetitiveExam{" +
            "id=" + getId() +
            ", testName='" + getTestName() + "'" +
            ", testScore=" + getTestScore() +
            ", enrollmentNo=" + getEnrollmentNo() +
            ", rank=" + getRank() +
            ", studentId=" + getStudentId() +
            "}";
    }
}
