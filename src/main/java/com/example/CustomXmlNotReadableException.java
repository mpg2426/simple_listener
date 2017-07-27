package com.example;

import org.springframework.http.converter.HttpMessageNotReadableException ;

public class CustomXmlNotReadableException extends HttpMessageNotReadableException   {

    public CustomXmlNotReadableException(String msg){
        super(msg);
    }

    public CustomXmlNotReadableException(String msg, Throwable cause){
        super(msg, cause);
    }
}
