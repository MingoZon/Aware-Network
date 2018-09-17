package aware.impl.util.standardNetworkData;

import aware.obj.util.INeuralData;
import aware.obj.util.IStandardNetworkData;

public class StandardNetworkData implements IStandardNetworkData{

	private static final long serialVersionUID = -8674707745601145118L;
	
	private INeuralData<?>[] data;
	private int feedbackCode;
	
	@Override
	public INeuralData<?>[] getData() {
		return data;
	}

	@Override
	public void setData(INeuralData<?>[] data) {
		this.data = data;
	}

	@Override
	public int getFeedbackCode() {
		return this.feedbackCode;
	}

	@Override
	public void setFeedbackCode(int feedbackCode) {
		this.feedbackCode = feedbackCode;
	}

}
