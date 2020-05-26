package com.synectiks.exam.graphql.types.StudentExamReport;

import com.synectiks.exam.domain.StudentExamReport;

public class UpdateStudentExamReportPayload extends AddStudentExamReportPayload {
    public UpdateStudentExamReportPayload(StudentExamReport studentExamReport) {
        super(studentExamReport);
    }
}
