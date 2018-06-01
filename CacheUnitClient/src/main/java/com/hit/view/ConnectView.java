package com.hit.view;


import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConnectView extends Observable implements View {


	public JButton reset;
	public JButton connect;
	public JTextField ip;
	public JTextField port;
	public JFrame frame;
	public JLabel ipL;
	public JLabel portL;
	
	public ConnectView() {
		frame = new JFrame("Connection Panel");

		frame.setPreferredSize(new Dimension(300,135));
		
		
		reset = new JButton("Reset to Default");
		connect = new JButton("Connect");
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(connect);
		buttonPanel.add(reset);
		frame.add("South", buttonPanel);
		
		ipL = new JLabel("IP Address:");
		ip = new JTextField("127.0.0.1");
		ip.setPreferredSize(new Dimension(100,20));
		JPanel ipPanel = new JPanel();
		ipPanel.add(ipL);
		ipPanel.add(ip);
		frame.add("North", ipPanel);
		
		portL = new JLabel("Port:");
		port = new JTextField("12345");
		port.setPreferredSize(new Dimension(50,20));
		JPanel portPanel = new JPanel();
		portPanel.add(portL);
		portPanel.add(port);
		frame.add("Center", portPanel);
		
		frame.pack();
		
	}
	
	public void show() {
		frame.setVisible(true);
	}
	
	public void addController (ActionListener controller) {
		reset.addActionListener(controller);
		connect.addActionListener(controller);
	}
	
	public void start() {
		frame.setVisible(true);
	}
	
	public <T> void updateUIData(T t) {
		if(t == "connect") {
			show();
		}
	}
}
