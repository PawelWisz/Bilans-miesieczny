package view.listenery.powrotListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import view.listenery.WyjsceListener;
import view.listenery.ZalogujListener;
import view.listenery.ZarejestrujListener;
import view.panele.*;

public class WrocZarDoLoginPanel implements ActionListener {

	private  JFrame frame;


	public WrocZarDoLoginPanel(JFrame frame) {
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ZalogujListener ZalListener = new ZalogujListener(frame);
				ZarejestrujListener ZarListener = new ZarejestrujListener(frame);
				WyjsceListener exitListener = new WyjsceListener(frame);
				JPanel login = new LoginPanel(ZarListener, ZalListener,exitListener);	
				frame.getContentPane().removeAll();
				frame.add(login);
                frame.validate();

			}			
		});
		
	}

}
