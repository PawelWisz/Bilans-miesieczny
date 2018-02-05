package view.listenery.powrotListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import view.listenery.ZalListener;
import view.panele.ZalogujPanel;

public class WrocDochDoZalPanel implements ActionListener{

	private  JFrame frame;


	public WrocDochDoZalPanel(JFrame frame) {
		this.frame=frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ZalListener listener = new ZalListener(frame);
				WrocZalDoLoginPanel wsteczListener = new WrocZalDoLoginPanel(frame);
				JPanel login = new ZalogujPanel(listener,wsteczListener);	
				frame.getContentPane().removeAll();
				frame.add(login);
                frame.validate();

			}			
		});
	}

}
