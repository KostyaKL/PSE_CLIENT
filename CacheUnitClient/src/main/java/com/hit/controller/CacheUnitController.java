package com.hit.controller;

import java.util.Observable;

import com.hit.model.Model;
import com.hit.view.View;

public class CacheUnitController extends Object implements Controller {

	View view;
	Model model;
	
	public CacheUnitController(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	public void update(Observable obs, Object obj) {
		if(obs instanceof View) {
			if(obj == "connect") {
				model.updateModelData(obj);
			}
		}
		else if (obs instanceof Model) {
			view.updateUIData(" ");
		}
	}
}
