package aware.obj.util;

import java.io.Serializable;

public interface INeuralData<Neurotransmitter extends Serializable> extends Serializable{
	
	/**
	 * �񾭴�����������
	 * ��Ԫ�������ݵ������ɱ����װ��ͨ���ı䷺�͵ķ�����������Ԫ����
	 * ����������
	 * 
	 * @author Mingo
	 */
	
	/**
	 * ��ȡ��Ԫ��������
	 * @return ��Ԫ��������
	 */
	public Neurotransmitter  getData();
	
	/**
	 * ������Ԫ��������
	 * @param data ��Ԫ��������
	 */
	public void setData(Neurotransmitter  data);
	
	/**
	 * ��������
	 * 
	 * �˷�����Ϊ�����ݴ��ݿ��������в���������ƫ����趨
	 * @return
	 */
	public INeuralData<Neurotransmitter> clone();
}
