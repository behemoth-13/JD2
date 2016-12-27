package by.pvt.exception;

public class OperationNotExecutedException extends Exception{
	
	private static final long serialVersionUID = -8451615670859033233L;

	public OperationNotExecutedException(String message){
		super(message);
	}
}
