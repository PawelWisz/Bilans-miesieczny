package view.listenery;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


import view.panele.LoginPanel;


public class WyjsceListener implements ActionListener {
	
	private  JFrame frame;
	private LoginPanel loginPanel;
	
	public void setPanel(LoginPanel loginPanel) {
		this.loginPanel=loginPanel;
	}

	public WyjsceListener(JFrame frame) {
		this.frame=frame;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}

}
