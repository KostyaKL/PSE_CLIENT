package com.hit.view;

import java.awt.Dimension;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CacheUnitView extends Observable implements View {

	public JButton buttonLoad;
	public JButton buttonStatistics;
	public JTextField textWindow;
	
	public CacheUnitView() {
		JFrame frame = new JFrame("Cache Unit UI");
		buttonLoad = new JButton("Load a Request");
		buttonStatistics = new JButton("Show Statistics");
		JPanel panel = new JPanel();
		panel.add(buttonLoad);
		panel.add(buttonStatistics);
		frame.add("North", panel);
		
		textWindow = new JTextField();
		textWindow.setPreferredSize(new Dimension(500, 500));
		frame.add("South", textWindow);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void start() {
		setChanged();
		notifyObservers("connect");
	}
	
	public <T> void updateUIData(T t) {
		
	}
}
