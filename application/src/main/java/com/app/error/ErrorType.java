package com.app.error;

public enum ErrorType {
	
	NOT_EMPTY(Type.NOT_EMPTY),
	INPUT_RANGE_VOILATION(Type.INPUT_RANGE_VOILATION),
	NOT_FOUND(Type.NOT_FOUND),
	NOT_NULL(Type.NOT_NULL),
	FIELD_MISMATCH(Type.FIELD_MISMATCH),
	USER_REQUEST_NOT_PERMITED(Type.USER_REQUEST_NOT_PERMITED),
	INVALID_INPUT(Type.INVALID_INPUT),
	WRONG_FORMAT(Type.WRONG_FORMAT);

	private final String errorType;
	
	ErrorType(String errorType){
		this.errorType = errorType;
	}
	
	public String getErrorType() {return this.errorType;}
	
	public static class Type{
		public static final String NOT_EMPTY = "NOT_EMPTY";
		public static final String WRONG_FORMAT = "WRONG_FORMAT";
		public static final String INPUT_RANGE_VOILATION = "INPUT_RANGE_VOILATION";
		public static final String NOT_FOUND = "NOT_FOUND";
		public static final String NOT_NULL = "NOT_NULL";
		public static final String FIELD_MISMATCH = "FIELD_MISMATCH";
		public static final String USER_REQUEST_NOT_PERMITED = "USER_REQUEST_NOT_PERMITED";
		public static final String INVALID_INPUT = "INVALID_INPUT";
	}
}
