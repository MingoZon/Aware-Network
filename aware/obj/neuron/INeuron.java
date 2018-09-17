package aware.obj.neuron;

import java.io.Serializable;
import java.util.Map;

import aware.impl.util.exception.NeuralException;
import aware.obj.util.INeuralData;

public interface INeuron extends Serializable{
	
	/**
	 * 连接神经元
	 * @param neuron
	 * @throws NeuralException 
	 */
	public void connect(INeuron neuron) throws NeuralException;
	
	/**
	 * 连接神经元
	 * @param neuron
	 * @throws NeuralException 
	 */
	public void connect(INeuron neuron,double weight) throws NeuralException;

	/**
	 * 断开神经元
	 * @param neuron
	 */
	public boolean disconnect(INeuron neuron);
	
	/************************************************************************/
	
	/**
	 * 设置传递模型
	 */
	public void setTransmitModel(ITransmitModel transmitModel);
	
	/**
	 * 获取传递模型
	 * @return
	 */
	public ITransmitModel getTransmitModel();
	
	/**
	 * 输入
	 * @param arg
	 * @throws NeuralException 
	 */
	public void input(INeuralData<?> arg) throws NeuralException;

	/**
	 * 输出激活信息
	 */
	public boolean isActivate();
	
	/**
	 * 设置当前的数据
	 */
	public void setData(INeuralData<?> data);
	/**
	 * 获取当前的数据
	 * @return
	 */
	public INeuralData<?> getData();
	
	/**
	 * 传递信息
	 */
	public void transmit();
	
	/**
	 * 获取连接数据
	 * @return
	 */
	public Map<INeuron, ISynapse> getAxon();
	
	/**
	 * 设置连接数据
	 * @param axon
	 */
	public void setAxon(Map<INeuron, ISynapse> axon);
	
	/**
	 * 神经元回归静默状态
	 */
	public void silent();
}
