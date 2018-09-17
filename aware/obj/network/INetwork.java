package aware.obj.network;

import java.io.Serializable;

import aware.impl.util.exception.NetworkException;
import aware.impl.util.exception.NeuralException;
import aware.obj.util.IStandardNetworkData;


public interface INetwork extends Runnable,Serializable{
	
	public static final int SUCCESS = 0x0001;
	
	public static final int OVERFLOW_ERROR = 0x0101;
	public static final int INPUT_LESS_ERROR = 0x0102;
	public static final int NULL_ID_ERROR = 0x0103;
	
	/**
	 * 设置神经网络结构
	 * @param number
	 * @return
	 */
	public void setNetworkStructure(INetworkStructure networkStructure);
	
	/**
	 * 设置网络传递模型
	 * @param networkTransmitModel
	 */
	public void setNetworkNetworkTransmitModel(INetworkTransmitModel networkTransmitModel);
	
	/**
	 * 获取神经网络结构
	 * @return
	 */
	public INetworkStructure getNetworkStructure();
	
	/**
	 * 运行一个周期
	 */
	public void runACycle();
	
	/**
	 * 神经网络停止运行
	 */
	public void stop();
	
	/**
	 * 
	 * 输入数据
	 * @param inputID
	 * @throws NetworkException 
	 * @throws NeuralException 
	 */
	public void input(String inputID,IStandardNetworkData data) throws NetworkException, NeuralException;
	
	/**
	 * 输出数据
	 * @param outputID
	 * @throws NetworkException 
	 */
	public IStandardNetworkData output(String outputID) throws NetworkException;
}
