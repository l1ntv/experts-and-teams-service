package ru.rsreu.lint.expertsandteams.Validation;

public class ValidationData {
	
	private boolean isCorrectData;
	private String errorMessage;
	
	public ValidationData(boolean isCorrectData, String errorMessage) {
		this.isCorrectData = isCorrectData;
		this.errorMessage = errorMessage;
	}
	
	public boolean getIsCorrectData() {
		return this.isCorrectData;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}
	
	public void setIsCorrectData(boolean isCorrectData) {
		this.isCorrectData = isCorrectData;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
