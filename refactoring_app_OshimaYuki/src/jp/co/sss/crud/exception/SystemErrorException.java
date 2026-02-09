package jp.co.sss.crud.exception;

public class SystemErrorException extends Exception{

	public SystemErrorException() {
		
	}
	
	public SystemErrorException(String message, Exception e) {
		super(message);
	}

}
