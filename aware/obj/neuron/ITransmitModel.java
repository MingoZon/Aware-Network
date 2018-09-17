package aware.obj.neuron;

import java.io.Serializable;
import java.util.Map;

import aware.impl.util.exception.NeuralException;
import aware.obj.util.INeuralData;

public interface ITransmitModel extends Serializable{
	
	public Map<INeuron, ISynapse> getAxon();
	
	public void setAxon(Map<INeuron, ISynapse> axon);
	
	public boolean isActivate();
	
	public void transmit();

	public void silent();
	
	public void input(INeuralData<?> data) throws NeuralException;
	
	public void setData(INeuralData<?> data);
	
	public INeuralData<?> getData();
	
	public ISynapse getSynapse();

	public ISynapse getSynapse(double weight);
}
