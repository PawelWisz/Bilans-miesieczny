package view.listenery.powrotListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import view.listenery.RachunkiListener;
import view.panele.RachunkiPanel;

public class WrocOplDoRachPanel implements ActionListener {

	
	private  JFrame frame;


	public WrocOplDoRachPanel(JFrame frame) {
		this.frame=frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				RachunkiListener listener = new RachunkiListener(frame);
				WrocRachDoDochPanel wsteczListener = new WrocRachDoDochPanel(frame);
				JPanel rachunki = new RachunkiPanel(listener, wsteczListener);	
				frame.getContentPane().removeAll();
				frame.add(rachunki);
                frame.validate();

			}			
		});
		
	}
	
	
}
