package aware.impl.neuron.synapse;

import aware.obj.neuron.ISynapse;

public class SynapseFactory {
	
	private SynapseFactory(){
		
	}
	
	public static ISynapse getDefaultSynapse(){
		return new DefaultSynapse();
	}
	
	public static ISynapse getDefaultSynapse(double weight){
		return new DefaultSynapse(weight);
	}
	
	public static ISynapse getConstSynapse(){
		return new DefaultSynapse(1);
	}
}
