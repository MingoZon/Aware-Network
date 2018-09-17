package aware.impl.util.exception;

import aware.obj.util.exception.INetworkException;

public class NetworkException extends Throwable implements INetworkException{

	private static final long serialVersionUID = -4813394670095475414L;
	
	public NetworkException(){
		super();
	}
	
	public NetworkException(String arg0){
		super(arg0);
	}
}
