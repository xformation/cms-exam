package com.synectiks.exam.graphql.types.TypeOfGrading;

import com.synectiks.exam.domain.TypeOfGrading;

public class AbstractTypeOfGradingPayload {

    private final TypeOfGrading typeOfGrading;

    public AbstractTypeOfGradingPayload(TypeOfGrading typeOfGrading) {
        this.typeOfGrading = typeOfGrading;
    }

    public TypeOfGrading getTypeOfGrading() {
        return typeOfGrading;
    }
}
