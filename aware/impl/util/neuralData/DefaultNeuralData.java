package aware.impl.util.neuralData;

import aware.obj.util.INeuralData;

public class DefaultNeuralData implements INeuralData<Double>{
	
	private static final long serialVersionUID = 974660163513911473L;
	
	private double data;
	

	@Override
	public Double getData() {
		return data;
	}
	
	@Override
	public void setData(Double data) {
		this.data = data;
	}

	@Override
	public INeuralData<Double> clone() {
		DefaultNeuralData temp = new DefaultNeuralData();
		temp.setData(data);
		return temp;
	}

}
