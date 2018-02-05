package view.listenery.powrotListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import view.listenery.PrzychListener;
import view.panele.DochodyPanel;

public class WrocRachDoDochPanel implements ActionListener {

	private  JFrame frame;


	public WrocRachDoDochPanel(JFrame frame) {
		this.frame=frame;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				PrzychListener listener = new PrzychListener(frame);
				WrocDochDoZalPanel wsteczListener = new WrocDochDoZalPanel(frame);
				JPanel dochody = new DochodyPanel(listener, wsteczListener);	
				frame.getContentPane().removeAll();
				frame.add(dochody);
                frame.validate();

			}			
		});
		
	}

	
}
