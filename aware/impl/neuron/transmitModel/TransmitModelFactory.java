package aware.impl.neuron.transmitModel;

import aware.obj.neuron.ITransmitModel;

public final class TransmitModelFactory {
	
	private TransmitModelFactory(){
		
	}
	
	public static ITransmitModel getDefaultTransmitModel(){
		return new DefaultTransmitModel();
	}
}
