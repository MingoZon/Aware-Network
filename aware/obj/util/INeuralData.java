package aware.obj.util;

import java.io.Serializable;

public interface INeuralData<Neurotransmitter extends Serializable> extends Serializable{
	
	/**
	 * 神经传递数据类型
	 * 神经元传递数据的内容由本类封装，通过改变泛型的方法来构造神经元传递
	 * 的数据类型
	 * 
	 * @author Mingo
	 */
	
	/**
	 * 获取神经元传递数据
	 * @return 神经元传递数据
	 */
	public Neurotransmitter  getData();
	
	/**
	 * 设置神经元传递数据
	 * @param data 神经元传递数据
	 */
	public void setData(Neurotransmitter  data);
	
	/**
	 * 拷贝方法
	 * 
	 * 此方法是为了数据传递拷贝过程中不出现数据偏差而设定
	 * @return
	 */
	public INeuralData<Neurotransmitter> clone();
}
