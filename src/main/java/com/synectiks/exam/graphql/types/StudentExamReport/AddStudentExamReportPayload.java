package com.synectiks.exam.graphql.types.StudentExamReport;

import com.synectiks.exam.domain.StudentExamReport;

public class AddStudentExamReportPayload extends AbstractStudentExamReportPayload {
    public AddStudentExamReportPayload(StudentExamReport studentExamReport){
        super(studentExamReport);
    }
}
