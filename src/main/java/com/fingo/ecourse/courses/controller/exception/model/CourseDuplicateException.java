package com.fingo.ecourse.courses.controller.exception.model;

public class CourseDuplicateException extends RuntimeException {
	public CourseDuplicateException(String msg) {
		super(msg);
	}

}
