package view.listenery.powrotListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import view.listenery.OplatyListener;
import view.panele.OplatyPanel;

public class WrocPodsDoOplPanel implements ActionListener {

	private  JFrame frame;


	public WrocPodsDoOplPanel(JFrame frame) {
		this.frame=frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				OplatyListener listener = new OplatyListener(frame);
				WrocOplDoRachPanel wsteczListener = new WrocOplDoRachPanel(frame);
				JPanel oplaty = new OplatyPanel(listener, wsteczListener);	
				frame.getContentPane().removeAll();
				frame.add(oplaty);
                frame.validate();

			}			
		});
		
	}

}
