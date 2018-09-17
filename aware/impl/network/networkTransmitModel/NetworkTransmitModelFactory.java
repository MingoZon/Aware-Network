package aware.impl.network.networkTransmitModel;

import aware.obj.network.INetworkTransmitModel;

public final class NetworkTransmitModelFactory {
	
	private NetworkTransmitModelFactory(){
		
	}
	
	public static INetworkTransmitModel getDefaultNetworkTransmitModel(){
		return new DefaultNetworkTransmitModel();
	}

}
