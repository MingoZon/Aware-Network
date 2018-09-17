package aware.impl.neuron.transmitModel;

import java.util.HashMap;
import java.util.Map;

import aware.impl.neuron.synapse.SynapseFactory;
import aware.impl.util.exception.NeuralException;
import aware.impl.util.neuralData.NeuralDataFactory;
import aware.obj.neuron.INeuron;
import aware.obj.neuron.ISynapse;
import aware.obj.neuron.ITransmitModel;
import aware.obj.util.INeuralData;

public final class DefaultTransmitModel implements ITransmitModel{
	
	private static final long serialVersionUID = 4125690551186357719L;

	public static final double THRESHOLD = 0.5;
	public static double INIT_DATA = 0;	
	
	private Map<INeuron, ISynapse> axon;
	
	private double bias;

	private INeuralData<Double> tempData;
	
	public DefaultTransmitModel() {
		init();
	}
	
	private void init() {
		axon = new HashMap<>();
		tempData = NeuralDataFactory.getNeuralData();
		tempData.setData(INIT_DATA);
		bias = -Math.random();
	}

	@Override
	public Map<INeuron, ISynapse> getAxon() {
		return this.axon;
	}

	@Override
	public void setAxon(Map<INeuron, ISynapse> axon) {
		this.axon = axon;
	}

	@Override
	public boolean isActivate() {
		return 1.0/(1.0 + Math.exp(-((Double)tempData.getData() + bias))) > THRESHOLD;
	}

	@Override
	public synchronized void transmit() {
		INeuralData<Double> data = NeuralDataFactory.getNeuralData(); 
		double innerData = 1.0/(1.0 + Math.exp(-((Double)this.tempData.getData())));
		data.setData(innerData);
		try {
			for(INeuron neuron:axon.keySet()){
				neuron.input(axon.get(neuron).output(data));
			}
		} catch (NeuralException e) {
			e.printStackTrace();
		}
	} 

	@Override
	public void silent() {
		tempData.setData(0.0);
	}

	@Override
	public void input(INeuralData<?> data) throws NeuralException {
		if(!(data.getData() instanceof Double)){
			throw new NeuralException(data.getClass() + "传递的类型不匹配。"); 
		}
		tempData.setData((Double)this.tempData.getData() + (Double)data.getData());
	}

	@Override
	public void setData(INeuralData<?> data) {
		if(data.getClass() == this.tempData.getClass()){
			this.tempData.setData((Double) data.getData());
		}
	}

	@Override
	public INeuralData<Double> getData() {
		return tempData.clone();
	}
	
	@Override
	public ISynapse getSynapse() {
		return SynapseFactory.getDefaultSynapse();
	}
	
	@Override
	public ISynapse getSynapse(double weight) {
		return SynapseFactory.getDefaultSynapse(weight);
	}
	
	public double getBias() {
		return bias;
	}

	public void setBias(double bias) {
		this.bias = bias;
	}

}
