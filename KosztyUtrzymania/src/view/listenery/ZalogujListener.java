package view.listenery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import view.listenery.powrotListener.WrocZalDoLoginPanel;
import view.panele.LoginPanel;
import view.panele.ZalogujPanel;

public class ZalogujListener implements ActionListener {
	
	private  JFrame frame;
	private LoginPanel loginPanel;
	
	public void setPanel(LoginPanel loginPanel) {
		this.loginPanel=loginPanel;
	}
	
	public ZalogujListener(JFrame frame) {
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ZalListener listener = new ZalListener(frame);
				WrocZalDoLoginPanel wsteczListener = new WrocZalDoLoginPanel(frame);
				JPanel zalPanel = new ZalogujPanel(listener, wsteczListener);
				frame.getContentPane().removeAll();
				frame.add(zalPanel);
                frame.validate();
					
			}			
		});
		
	}

}
