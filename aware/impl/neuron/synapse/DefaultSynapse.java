package aware.impl.neuron.synapse;

import aware.impl.util.exception.NeuralException;
import aware.impl.util.neuralData.NeuralDataFactory;
import aware.obj.util.INeuralData;

public final class DefaultSynapse extends ASynapse{

	private static final long serialVersionUID = 8048897370092109319L;

	public DefaultSynapse(double weight) {
		super(weight);
	}

	public DefaultSynapse() {
		super();
	}

	@Override
	public INeuralData<Double> output(INeuralData<?> in) throws NeuralException {
		if(!(in.getData() instanceof Double)){
			throw new NeuralException(in.getClass() + "���ݵ����Ͳ�ƥ�䡣");
		}
		double temp = weight*(Double)in.getData();
		INeuralData<Double> out = NeuralDataFactory.getNeuralData();
		out.setData(temp);
		return out;
	}

}
