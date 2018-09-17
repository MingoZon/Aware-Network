package aware.impl.neuron;

import java.util.Map;

import aware.impl.neuron.transmitModel.TransmitModelFactory;
import aware.impl.util.exception.NeuralException;
import aware.obj.neuron.INeuron;
import aware.obj.neuron.ISynapse;
import aware.obj.neuron.ITransmitModel;
import aware.obj.util.INeuralData;

public class Neuron implements INeuron{
	
	private static final long serialVersionUID = -6866988288409636298L;

	private Map<INeuron, ISynapse> axon;
	private ITransmitModel transmitModel;
	
	public Neuron() {
		this.setTransmitModel(TransmitModelFactory.getDefaultTransmitModel());
	}
	
	public Neuron(ITransmitModel transmitModel) {
		this.setTransmitModel(transmitModel);
	}
	
	private void init(){
		this.axon = transmitModel.getAxon();
	}
	
	@Override
	public void connect(INeuron neuron) throws NeuralException {
		if(axon.containsKey(neuron)){
			throw new NeuralException("已存在连接的神经元对象");
		}
		if(neuron == null){
			throw new NeuralException("连接的神经元对象为空");
		}
		this.axon.put(neuron,transmitModel.getSynapse());
	}

	@Override
	public void connect(INeuron neuron, double weight) throws NeuralException {
		if(axon.containsKey(neuron)){
			throw new NeuralException("已存在连接的神经元对象");
		}
		if(neuron == null){
			throw new NeuralException("连接的神经元对象为空");
		}
		this.axon.put(neuron,transmitModel.getSynapse(weight));
	}
	
	@Override
	public boolean disconnect(INeuron neuron) {
		if(neuron != null){
			this.axon.remove(neuron);
			return true;
		}else return false;
	}
	
	@Override 
	public void input(INeuralData<?> arg) throws NeuralException {
		this.transmitModel.input(arg);
	}

	@Override
	public boolean isActivate() {
		return this.transmitModel.isActivate();
	}
	
	@Override
	public INeuralData<?> getData(){
		return this.transmitModel.getData();
	}

	@Override
	public synchronized void transmit() {
		this.transmitModel.transmit();
	}
	
	@Override
	public Map<INeuron, ISynapse> getAxon() {
		return this.axon;
	}

	@Override
	public void setAxon(Map<INeuron, ISynapse> axon) {
		this.transmitModel.setAxon(axon);
	}

	@Override
	public void silent() {
		this.transmitModel.silent();
	}

	@Override
	public void setData(INeuralData<?> data) {
		this.transmitModel.setData(data);
	}

	@Override
	public void setTransmitModel(ITransmitModel transmitModel) {
		this.transmitModel = transmitModel;
		init();
	}

	@Override
	public ITransmitModel getTransmitModel() {
		return this.transmitModel;
	}
	
}
