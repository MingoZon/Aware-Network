package aware.impl.util.standardNetworkData;

import aware.obj.util.IStandardNetworkData;

public final class StandardNetworkDataFactory {
	
	private StandardNetworkDataFactory(){
		
	}
	
	public static IStandardNetworkData getStandardNetworkData(){
		return new StandardNetworkData();
	}
}
