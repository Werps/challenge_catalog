package com.vass.challenge.catalog.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.MessageFormat;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    PRODUCT_PRICE_NOT_FOUND("001","No hay precio para el producto {0} de la marca {1} para la fecha {2}");

    private final String code;

    private final String message;

    public String getMessageFormatted(Object[] params){
        return MessageFormat.format(this.message, params);
    }

}
