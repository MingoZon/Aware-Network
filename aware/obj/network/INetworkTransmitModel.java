package aware.obj.network;

import java.io.Serializable;
import java.util.Map;

import aware.obj.neuron.INeuron;

public interface INetworkTransmitModel extends Serializable{
	
	public void setInputList(Map<String,INeuron[]> inputList);
	
	public void setOutputputList(Map<String,INeuron[]> outputputList);
	
	public void setNeurons(INeuron[][] neurons);
	
	public void networkStructureChange();
	
	public void runACycle();
	
	public void run();
	
	public void stop(); 
	
}
