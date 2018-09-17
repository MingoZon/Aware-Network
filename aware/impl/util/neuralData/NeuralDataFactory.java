package aware.impl.util.neuralData;

import aware.obj.util.INeuralData;

public final class NeuralDataFactory {
	
	private NeuralDataFactory() {
		
	}
	
	public static INeuralData<Double> getNeuralData(){
		return new DefaultNeuralData();
	}
}
