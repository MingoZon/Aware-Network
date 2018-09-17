package aware.obj.network;

import java.io.Serializable;
import java.util.Map;

import aware.obj.neuron.INeuron;

public interface INetworkStructure extends Serializable{
	
	/**
	 * ���/���������
	 * @param inputID
	 * @param neurons
	 */
	public void putInputLayer(String inputID,INeuron[] neurons);
	
	/**
	 * ɾ�������
	 * @param inputID
	 */
	public void removeInputLayer(String inputID);
	
	/**
	 * ���/���������
	 * @param outputID
	 * @param neurons
	 */
	public void putOutputLayer(String outputID,INeuron[] neurons);
	
	/**
	 * ɾ�������
	 * @param inputID
	 */
	public void removeOutputLayer(String outputID);
	
	/**
	 * ������Ԫ����
	 * @param neurons
	 */
	public void setNeurons(INeuron[][] neurons);
	
	/**
	 * ���������б�
	 * @param inputList
	 */
	public void setInputList(Map<String,INeuron[]> inputList);
	
	/**
	 * ��ȡ�����б�
	 * @return
	 */
	public Map<String,INeuron[]> getInputList();
	
	/**
	 * ��������б�
	 * @param outputputList
	 */
	public void setOutputputList(Map<String,INeuron[]> outputputList);
	
	/**
	 * ��ȡ����б�
	 * @return
	 */
	public Map<String,INeuron[]> getOutputList();
	
	/**
	 * ��ȡ��Ԫ����
	 * @return
	 */
	public INeuron[][] getNeurons();

	/**
	 * �����������
	 */
	public void removeAllLink();
	
}
