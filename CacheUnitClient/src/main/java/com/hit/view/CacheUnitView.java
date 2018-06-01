package com.hit.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CacheUnitView extends Observable implements View {

	public JButton buttonLoad;
	public JButton buttonStatistics;
	public JButton connect;
	public JButton login;
	public JTextField textWindow;
	JFrame frame;
	
	public CacheUnitView() {
		frame = new JFrame("Cache Unit UI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonLoad = new JButton("Load a Request");
		buttonStatistics = new JButton("Show Statistics");
		connect = new JButton("Connect");
		login = new JButton("Login");
		JPanel panel = new JPanel();
		panel.add(connect);
		panel.add(login);
		panel.add(buttonLoad);
		panel.add(buttonStatistics);
		frame.add("North", panel);
		
		textWindow = new JTextField();
		textWindow.setPreferredSize(new Dimension(500, 500));
		frame.add("South", textWindow);
		
		frame.pack();
		
	}
	
	public void start() {
		frame.setVisible(true);
	}
	
	public void addController (ActionListener controller) {
		buttonLoad.addActionListener(controller);
		buttonStatistics.addActionListener(controller);
		connect.addActionListener(controller);
		login.addActionListener(controller);
	}
	
	public <T> void updateUIData(T t) {
		if(t == "connect" || t == "request" || t == "login" || t == "stat") {
			setChanged();
			notifyObservers(t);
		}
	}
}
