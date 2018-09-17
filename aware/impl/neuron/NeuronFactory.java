package aware.impl.neuron;

import aware.obj.neuron.INeuron;

public final class NeuronFactory {
	private NeuronFactory() {
	}
	
	public static INeuron getNeuron(){
		return new Neuron();
	}
}
