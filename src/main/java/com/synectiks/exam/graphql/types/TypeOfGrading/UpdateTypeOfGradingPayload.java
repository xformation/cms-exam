package com.synectiks.exam.graphql.types.TypeOfGrading;

import com.synectiks.exam.domain.TypeOfGrading;

public class UpdateTypeOfGradingPayload extends AddTypeOfGradingPayload{
    public UpdateTypeOfGradingPayload(TypeOfGrading typeOfGrading){
        super(typeOfGrading);
    }
}
