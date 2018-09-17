package aware.obj.network;

import java.io.Serializable;
import java.util.Map;

import aware.obj.neuron.INeuron;

public interface INetworkStructure extends Serializable{
	
	/**
	 * 添加/设置输入层
	 * @param inputID
	 * @param neurons
	 */
	public void putInputLayer(String inputID,INeuron[] neurons);
	
	/**
	 * 删除输入层
	 * @param inputID
	 */
	public void removeInputLayer(String inputID);
	
	/**
	 * 添加/设置输出层
	 * @param outputID
	 * @param neurons
	 */
	public void putOutputLayer(String outputID,INeuron[] neurons);
	
	/**
	 * 删除输入层
	 * @param inputID
	 */
	public void removeOutputLayer(String outputID);
	
	/**
	 * 设置神经元连接
	 * @param neurons
	 */
	public void setNeurons(INeuron[][] neurons);
	
	/**
	 * 设置输入列表
	 * @param inputList
	 */
	public void setInputList(Map<String,INeuron[]> inputList);
	
	/**
	 * 获取输入列表
	 * @return
	 */
	public Map<String,INeuron[]> getInputList();
	
	/**
	 * 设置输出列表
	 * @param outputputList
	 */
	public void setOutputputList(Map<String,INeuron[]> outputputList);
	
	/**
	 * 获取输出列表
	 * @return
	 */
	public Map<String,INeuron[]> getOutputList();
	
	/**
	 * 获取神经元连接
	 * @return
	 */
	public INeuron[][] getNeurons();

	/**
	 * 清除所有链接
	 */
	public void removeAllLink();
	
}
