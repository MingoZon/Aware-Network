package aware.impl.neuron.synapse;


import aware.impl.util.exception.NeuralException;
import aware.obj.neuron.ISynapse;
import aware.obj.util.INeuralData;

public abstract class ASynapse implements ISynapse{
	
	private static final long serialVersionUID = 6845722797721949L;
	
	protected double weight;
	
	public ASynapse() {
		init();
	}
	
	public ASynapse(double weight) {
		this.setWeight(weight);
	}
	
	private void init() {
		this.weight = Math.random()*(Math.random()>0.5?1:-1);
	}
	
	@Override
	public double getWeight() {
		return weight;
	}
	
	@Override
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public abstract INeuralData<?> output(INeuralData<?> in) throws NeuralException;
}
