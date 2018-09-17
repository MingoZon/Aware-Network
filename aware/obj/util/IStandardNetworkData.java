package aware.obj.util;

import java.io.Serializable;

public interface IStandardNetworkData extends Serializable{
	
	/**
	 * ������
	 * @return
	 */
	public int getFeedbackCode();
	public void setFeedbackCode(int feedbackCode);
	
	public INeuralData<?>[] getData();
	public void setData(INeuralData<?>[] data);
	
}
