package com.vass.challenge.catalog.domain.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NotFoundException extends RuntimeException{

    private String code;

    public NotFoundException(ErrorCode errorCode, Object... params){
        super(errorCode.getMessageFormatted(params));
        this.code = errorCode.getCode();
    }

}
