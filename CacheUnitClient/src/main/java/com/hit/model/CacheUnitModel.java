package com.hit.model;

import java.util.Observable;

public class CacheUnitModel extends Observable implements Model {
	
	CacheUnitClient connect;
	
	public CacheUnitModel() {
		connect = new CacheUnitClient();
	}
	
	public <T> void updateModelData(T t) {
		if(t == "connect") {
			
		}
	}
}
