package com.fingo.ecourse.courses.controller.exception.handler;

import com.fingo.ecourse.courses.controller.exception.model.CourseDuplicateException;
import com.fingo.ecourse.courses.controller.exception.model.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CourseExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger LOGGER = LogManager.getLogger(CourseExceptionHandler.class);

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<String> handleNotFound(Exception e) {
        LOGGER.error("NotFoundException handler executed");
        return new ResponseEntity<>(
                e.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(CourseDuplicateException.class)
    public final ResponseEntity<String> handleCourseDuplicateException(Exception e) {
        LOGGER.error("CourseDuplicate handler executed");
        return new ResponseEntity<>(
                e.getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }
}
