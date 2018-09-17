package aware.impl.network.networkTransmitModel;

import java.util.Map;

import aware.obj.network.INetworkTransmitModel;
import aware.obj.neuron.INeuron;

public abstract class ANetworkTransmitModel implements INetworkTransmitModel{
	
	private static final long serialVersionUID = -1309400388377395742L;
	
	protected Map<String, INeuron[]> inputList;
	protected Map<String, INeuron[]> outputList;
	protected INeuron[][] neurons;
	
	@Override
	public void setInputList(Map<String, INeuron[]> inputList) {
		this.inputList = inputList;
	}

	@Override
	public void setOutputputList(Map<String, INeuron[]> outputputList) {
		this.outputList = outputputList;
	}

	@Override
	public void setNeurons(INeuron[][] neurons) {
		this.neurons = neurons;
	}
}
