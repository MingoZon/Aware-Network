package aware.impl.network.networkTransmitModel;

import java.util.Iterator;

import aware.obj.neuron.INeuron;
import aware.obj.util.INeuralData;

public class DefaultNetworkTransmitModel extends ANetworkTransmitModel{
	
	private static final long serialVersionUID = 3963685983967252621L;
	
	private boolean[][] neuronsActivationNow ;
	private INeuralData<?>[][] neuronsActivationData ;
	
	private boolean runFlag;
	
	public DefaultNetworkTransmitModel() {
		super();
	}
	
	@Override
	public void runACycle() {
		/*
		 *  如果激活就传递
		 *  否则就不传递
		 */
		//输出口清空
		for (Iterator<String> iterator = outputList.keySet().iterator(); iterator.hasNext();) {
			INeuron[] output = outputList.get(iterator.next());
			for(int i = 0 ; i < output.length ; i++){
				output[i].silent();
			}
		}
		
		for(int i = 0 ; i < neurons.length; i ++){
			for(int j = 0 ; j < neurons[i].length; j ++){
				//获取激活信息及数据
				neuronsActivationNow[i][j] = neurons[i][j].isActivate();
				neuronsActivationData[i][j] = neurons[i][j].getData();
				neurons[i][j].silent();
			}
		}
		INeuralData<?> temp;
		for(int i = 0 ; i < neurons.length; i ++){
			for(int j = 0 ; j < neurons[i].length; j ++){
				if(neuronsActivationNow[i][j]){
					temp = neurons[i][j].getData();
					neurons[i][j].setData(neuronsActivationData[i][j]);
					neurons[i][j].transmit();
					neurons[i][j].setData(temp);
				}
			}
		}
		//输入层传递
		for (Iterator<String> iterator = inputList.keySet().iterator(); iterator.hasNext();) {
			INeuron[] input = inputList.get(iterator.next());
			for(int i = 0 ; i < input.length ; i++){
				if(input[i].isActivate()) input[i].transmit();
				input[i].silent();
			}
		}
	}

	@Override
	public void run() {
		runFlag = true;
		while(runFlag){
			runACycle();
		}
	}

	@Override
	public void stop() {
		runFlag = false;
	}

	@Override
	public void networkStructureChange() {
		if(neurons == null) return;
		neuronsActivationNow = new boolean[neurons.length][];
		neuronsActivationData = new INeuralData[neurons.length][];
		
		for(int i = 0 ; i < neurons.length; i ++){
			neuronsActivationNow[i] = new boolean[neurons[i].length];
			neuronsActivationData[i] = new INeuralData[neurons[i].length];
		}
	}
}
