package aware.impl.network;

import aware.impl.network.networkStructure.NetworkStructure;
import aware.impl.util.exception.NetworkException;
import aware.impl.util.exception.NeuralException;
import aware.impl.util.neuralData.DefaultNeuralData;
import aware.impl.util.neuralData.NeuralDataFactory;
import aware.impl.util.standardNetworkData.StandardNetworkDataFactory;
import aware.obj.util.INeuralData;
import aware.obj.util.IStandardNetworkData;

public class Test {
	public static void main(String[] args) {
		Network network = new Network();
		NetworkStructure net = new NetworkStructure();
		network.setNetworkStructure(net);
		
		IStandardNetworkData data = StandardNetworkDataFactory.getStandardNetworkData();
		
		INeuralData<Double> in[] = new DefaultNeuralData[10];
		for(int i = 0; i < in.length ; i++){
			in[i] = NeuralDataFactory.getNeuralData();
			in[i].setData(i*1.0);
		}
		
		data.setData(in);
		try {
			network.input("Ain", data );
		} catch (NetworkException | NeuralException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0 ; i < 4 ; i ++){
			network.runACycle();
		}
		
		IStandardNetworkData lout = null;
		try {
			lout = network.output("Aout");
		} catch (NetworkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		INeuralData<?>[] out = lout.getData();
		
		for(int j = 0; j < out.length ; j++){
			System.out.print(out[j].getData() + " ");
		}
	}
}
