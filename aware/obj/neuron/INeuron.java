package aware.obj.neuron;

import java.io.Serializable;
import java.util.Map;

import aware.impl.util.exception.NeuralException;
import aware.obj.util.INeuralData;

public interface INeuron extends Serializable{
	
	/**
	 * ������Ԫ
	 * @param neuron
	 * @throws NeuralException 
	 */
	public void connect(INeuron neuron) throws NeuralException;
	
	/**
	 * ������Ԫ
	 * @param neuron
	 * @throws NeuralException 
	 */
	public void connect(INeuron neuron,double weight) throws NeuralException;

	/**
	 * �Ͽ���Ԫ
	 * @param neuron
	 */
	public boolean disconnect(INeuron neuron);
	
	/************************************************************************/
	
	/**
	 * ���ô���ģ��
	 */
	public void setTransmitModel(ITransmitModel transmitModel);
	
	/**
	 * ��ȡ����ģ��
	 * @return
	 */
	public ITransmitModel getTransmitModel();
	
	/**
	 * ����
	 * @param arg
	 * @throws NeuralException 
	 */
	public void input(INeuralData<?> arg) throws NeuralException;

	/**
	 * ���������Ϣ
	 */
	public boolean isActivate();
	
	/**
	 * ���õ�ǰ������
	 */
	public void setData(INeuralData<?> data);
	/**
	 * ��ȡ��ǰ������
	 * @return
	 */
	public INeuralData<?> getData();
	
	/**
	 * ������Ϣ
	 */
	public void transmit();
	
	/**
	 * ��ȡ��������
	 * @return
	 */
	public Map<INeuron, ISynapse> getAxon();
	
	/**
	 * ������������
	 * @param axon
	 */
	public void setAxon(Map<INeuron, ISynapse> axon);
	
	/**
	 * ��Ԫ�ع龲Ĭ״̬
	 */
	public void silent();
}
