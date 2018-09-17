package aware.obj.neuron;

import java.io.Serializable;

import aware.impl.util.exception.NeuralException;
import aware.obj.util.INeuralData;

public interface ISynapse extends Serializable{
	
	public double getWeight();
	
	public void setWeight(double weight);

	public INeuralData<?> output(INeuralData<?> in) throws NeuralException;

}
