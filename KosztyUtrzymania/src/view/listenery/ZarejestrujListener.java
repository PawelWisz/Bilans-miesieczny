package view.listenery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import dataBase.UserData;
import view.listenery.powrotListener.WrocZarDoLoginPanel;
import view.panele.LoginPanel;
import view.panele.ZarejestrujPanel;

public class ZarejestrujListener implements ActionListener {
	UserData userDB = new UserData();
	private  JFrame frame;
	private LoginPanel loginPanel;
	
	public void setPanel(LoginPanel loginPanel) {
		this.loginPanel=loginPanel;
	}
	
	public ZarejestrujListener(JFrame frame) {
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				AddListener listener = new AddListener(frame);
				WrocZarDoLoginPanel powrotListener = new WrocZarDoLoginPanel(frame);
				JPanel zarPanel = new ZarejestrujPanel(listener, powrotListener);
				userDB.crateTable(userDB.polacz());
				frame.getContentPane().removeAll();
				frame.add(zarPanel);
                frame.validate();
					
			}			
		});
		
	}

}
