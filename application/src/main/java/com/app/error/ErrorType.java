package com.app.error;

public enum ErrorType {
	
	NOT_EMPTY(Type.NOT_EMPTY);

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
	}
}
