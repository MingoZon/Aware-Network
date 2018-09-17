package aware.impl.network;

import java.util.Map;

import aware.impl.network.networkTransmitModel.NetworkTransmitModelFactory;
import aware.impl.util.exception.NetworkException;
import aware.impl.util.exception.NeuralException;
import aware.impl.util.standardNetworkData.StandardNetworkDataFactory;
import aware.obj.network.INetwork;
import aware.obj.network.INetworkStructure;
import aware.obj.network.INetworkTransmitModel;
import aware.obj.neuron.INeuron;
import aware.obj.util.INeuralData;
import aware.obj.util.IStandardNetworkData;

public class Network implements INetwork{
	
	private static final long serialVersionUID = -5367386451746574700L;
	
	private INetworkStructure networkStructure;
	private INetworkTransmitModel networkTransmitModel;
	
	private Map<String,INeuron[]> inputLayerList;
	private Map<String,INeuron[]> outputLayerList;

	public Network() {
		this.networkTransmitModel = NetworkTransmitModelFactory.getDefaultNetworkTransmitModel();
	}
	
	@Override
	public void run() {
		networkTransmitModel.run();
	}

	@Override
	public void setNetworkStructure(INetworkStructure networkStructure) {
		if(this.networkStructure != networkStructure){
			this.networkStructure = networkStructure;
		}else return;
		this.networkTransmitModel.setNeurons(networkStructure.getNeurons());
		this.inputLayerList = networkStructure.getInputList();
		this.outputLayerList = networkStructure.getOutputList();
		this.networkTransmitModel.networkStructureChange();
	}

	@Override
	public void setNetworkNetworkTransmitModel(INetworkTransmitModel networkTransmitModel) {
		if(this.networkTransmitModel != networkTransmitModel){
			this.networkTransmitModel = networkTransmitModel;
		}else return;
		this.networkTransmitModel.setInputList(inputLayerList);
		this.networkTransmitModel.setOutputputList(outputLayerList);
		this.networkTransmitModel.setNeurons(networkStructure.getNeurons());
		this.networkTransmitModel.networkStructureChange();
	}
	
	@Override
	public INetworkStructure getNetworkStructure() {
		return this.networkStructure;
	}

	@Override
	public synchronized void runACycle() {
		this.networkTransmitModel.runACycle();
	}

	@Override
	public void input(String inputID, IStandardNetworkData data) throws NetworkException, NeuralException {
		if(!inputLayerList.containsKey(inputID)){
			throw new NetworkException("输入层中 " + inputID + " 不存在!");
		}
		INeuron[] inputNeuron = this.inputLayerList.get(inputID);
		INeuralData<?>[] inputData = data.getData();
		if(inputData.length > inputNeuron.length) {
			throw new NetworkException("传入输入层的数据溢出！");
		}
		if(inputData.length < inputNeuron.length) {
			throw new NetworkException("传入输入层的数据不足！");
		}
		
		for(int i = 0 ; i < inputData.length; i++){
			inputNeuron[i].input(inputData[i]);
		}
	}
	
	@Override
	public IStandardNetworkData output(String outputID) throws NetworkException {
		if(!outputLayerList.containsKey(outputID)){
			throw new NetworkException("出入层中 " + outputID +" 不存在！");
		}
		INeuron[] outputNeuron = this.outputLayerList.get(outputID);
		INeuralData<?>[] outputData = new INeuralData[outputNeuron.length];
		for(int i = 0 ; i < outputData.length; i++){
			outputData[i] = outputNeuron[i].getData();
		}
		//TODO 应该做成映射数据
		IStandardNetworkData temp = StandardNetworkDataFactory.getStandardNetworkData();
		temp.setData(outputData);
		return temp;
	}

	@Override
	public void stop() {
		networkTransmitModel.stop();
	}

}
