package com.hit.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Observable;

import com.hit.model.Model;
import com.hit.view.View;

public class LoginController extends Object implements Controller, ActionListener {

	View view;
	Model model;
	
	public LoginController(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println(ae.getActionCommand());
		switch (ae.getActionCommand()) {
		case "Cancel":
			view.updateUIData("cancel");
			break;
		case "Login":
			view.updateUIData("login");
			break;
		default:
			break;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable obs, Object obj) {
		if(obs instanceof Model) {
			if(obj instanceof Map<?,?>) {
				Map<String, Object> ud = (Map<String, Object>) obj;
				if(ud.containsKey("mainView") && ud.get("mainView").equals("login")) {
					view.updateUIData("login");
				}
			}
		}
		
	}

}
