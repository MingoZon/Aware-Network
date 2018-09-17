package aware.impl.util.exception;

import aware.obj.util.exception.INetworkException;

public class NeuralException extends Throwable implements INetworkException{

	private static final long serialVersionUID = -1830086135179375949L;

	public NeuralException() {
		super();
	}
	
	public NeuralException(String arg0){
		super(arg0);
	}
}
