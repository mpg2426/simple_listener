package com.example;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.util.CollectionUtils;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    public RestResponseEntityExceptionHandler() {
        super();
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
                                                                     HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<MediaType> mediaTypes = ex.getSupportedMediaTypes();
        if (!CollectionUtils.isEmpty(mediaTypes)) {
            headers.setAccept(mediaTypes);
        }
        logger.error("Non-XML file uploaded: 415 Status code", ex);
        return handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.OK, request);
    }

    @ExceptionHandler({ NullPointerException.class})
    public ResponseEntity<Object> handleInternal(final RuntimeException ex, final WebRequest request) {
        logger.error("NullPointerException: 500 Status Code", ex);
        return handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.OK, request);
    }

    @ExceptionHandler(value = { CustomXmlNotReadableException.class })
    protected ResponseEntity<Object> handleCustomXmlNotReadableException(RuntimeException ex, WebRequest request){
        logger.error("CustomXmlNotReadableException, cannot parse xml file", ex);
        String response = "Problem parsing the XML file";
        return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
