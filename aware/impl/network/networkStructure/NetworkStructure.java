package aware.impl.network.networkStructure;

import java.util.HashMap;
import java.util.Map;

import aware.obj.network.INetworkStructure;
import aware.obj.neuron.INeuron;

public class NetworkStructure implements INetworkStructure{

	private static final long serialVersionUID = 874824414249160574L;
	
	private Map<String, INeuron[]> inputList;
	private Map<String, INeuron[]> outputList;
	private INeuron[][] neurons;
	
	public NetworkStructure() {
		inputList = new HashMap<String, INeuron[]>();
		outputList = new HashMap<String, INeuron[]>();
	}
	
	@Override
	public void putInputLayer(String inputID, INeuron[] neurons) {
		inputList.put(inputID, neurons);
	}

	@Override
	public void removeInputLayer(String inputID) {
		inputList.remove(inputID);
	}

	@Override
	public void putOutputLayer(String outputID, INeuron[] neurons) {
		outputList.put(outputID, neurons);
	}

	@Override
	public void removeOutputLayer(String outputID) {
		outputList.remove(outputID);
	}

	@Override
	public void setNeurons(INeuron[][] neurons) {
		this.neurons = neurons;
	}

	@Override
	public Map<String, INeuron[]> getInputList() {
		return this.inputList;
	}

	@Override
	public Map<String, INeuron[]> getOutputList() {
		return this.outputList;
	}

	@Override
	public INeuron[][] getNeurons() {
		return this.neurons;
	}

	@Override
	public void setInputList(Map<String, INeuron[]> inputList) {
		this.inputList = inputList;
	}

	@Override
	public void setOutputputList(Map<String, INeuron[]> outputputList) {
		this.outputList = outputputList;
	}

	@Override
	public void removeAllLink() {
		for(int i = 0 ; i < neurons.length ; i ++){
			for(int j = 0 ; j < neurons[i].length ; j ++){
				neurons[i][j].getAxon().clear();
			}
		}
	}
}
