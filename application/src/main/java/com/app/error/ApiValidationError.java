package com.app.error;

import java.io.Serializable;

import javax.lang.model.type.ErrorType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ApiValidationError implements Serializable{
	private String fieldName;
	private String errorMessageCode;
	private ErrorType errorType;

}
