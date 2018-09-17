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
	 * ����������ṹ
	 * @param number
	 * @return
	 */
	public void setNetworkStructure(INetworkStructure networkStructure);
	
	/**
	 * �������紫��ģ��
	 * @param networkTransmitModel
	 */
	public void setNetworkNetworkTransmitModel(INetworkTransmitModel networkTransmitModel);
	
	/**
	 * ��ȡ������ṹ
	 * @return
	 */
	public INetworkStructure getNetworkStructure();
	
	/**
	 * ����һ������
	 */
	public void runACycle();
	
	/**
	 * ������ֹͣ����
	 */
	public void stop();
	
	/**
	 * 
	 * ��������
	 * @param inputID
	 * @throws NetworkException 
	 * @throws NeuralException 
	 */
	public void input(String inputID,IStandardNetworkData data) throws NetworkException, NeuralException;
	
	/**
	 * �������
	 * @param outputID
	 * @throws NetworkException 
	 */
	public IStandardNetworkData output(String outputID) throws NetworkException;
}
