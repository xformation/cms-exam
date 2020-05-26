package com.synectiks.exam.graphql.types.StudentExamReport;

import com.synectiks.exam.domain.StudentExamReport;

import java.util.List;

public class RemoveStudentExamReportPayload {
    private final List<StudentExamReport> studentExamReports;

    public RemoveStudentExamReportPayload(List<StudentExamReport> studentExamReports)
    {
        this.studentExamReports = studentExamReports;
    }
    public List<StudentExamReport> getStudentExamReports(){
        return studentExamReports;
    }
}
