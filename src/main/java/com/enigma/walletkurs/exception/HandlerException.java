package com.enigma.walletkurs.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.enigma.walletkurs.helper.response.CommonResponse;


@ControllerAdvice
public class HandlerException {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(HandlerException.class);
    
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<CommonResponse> resp(NotFoundException e){
        LOGGER.info("catchUserException");
        LOGGER.error(e.getMessage());
        LOGGER.warn(e.getMessage());
        LOGGER.info(e.getMessage());
        LOGGER.debug(e.getMessage());
        return new ResponseEntity<CommonResponse>(new CommonResponse(e.getCode(), e.getDescription()), HttpStatus.OK);
    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<CommonResponse> respExc(Exception e){
        LOGGER.info("catchException");
        LOGGER.error(e.getMessage());
        LOGGER.warn(e.getMessage());
        LOGGER.info(e.getMessage());
        LOGGER.debug(e.getMessage());
        return new ResponseEntity<CommonResponse>(new CommonResponse(Integer.parseInt("50"), "Not Allowed"), HttpStatus.OK);
    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<CommonResponse> respHttpMethod(HttpRequestMethodNotSupportedException e){
        LOGGER.info("catchHttpRequestMethodNotSupportedException");
        LOGGER.error(e.getMessage());
        LOGGER.warn(e.getMessage());
        LOGGER.info(e.getMessage());
        LOGGER.debug(e.getMessage());
        return new ResponseEntity<CommonResponse>(new CommonResponse(Integer.parseInt("45"), e.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<CommonResponse> respNullPointerException(NullPointerException e){
        LOGGER.info("catchNullPointerException");
        LOGGER.error(e.getMessage());
        LOGGER.warn(e.getMessage());
        LOGGER.info(e.getMessage());
        LOGGER.debug(e.getMessage());
        return new ResponseEntity<CommonResponse>(new CommonResponse(Integer.parseInt("51"), "Null pointer"), HttpStatus.OK);
    }

}
