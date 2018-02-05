package view.listenery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import bilans.Bilans;
import view.listenery.powrotListener.WrocRachDoDochPanel;
import view.panele.DochodyPanel;
import view.panele.RachunkiPanel;

public class PrzychListener implements ActionListener {
	
	public Bilans bilans = new Bilans();
	
	JFrame frame;
	DochodyPanel DochPanel;
	
	public void setPanel(DochodyPanel DochPanel) {
		this.DochPanel=DochPanel;
	}

	public PrzychListener(JFrame frame) {
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		bilans.SumaPrzychodow(DochPanel.getp1(), DochPanel.getp2());
		if(DochPanel.getp1().isEmpty() || DochPanel.getp2().isEmpty()) {
			System.out.println("Bloczki puste");}
		else if (Pattern.matches("[0-9]+\\.?[0-9]*",DochPanel.getp1())==false || Pattern.matches("[0-9]+\\.?[0-9]*",DochPanel.getp2())==false){
			System.out.println("Z³e dane");
		}
		else {	
			
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					RachunkiListener RachListener = new RachunkiListener(frame);
					WrocRachDoDochPanel wsteczListener = new WrocRachDoDochPanel(frame);
					JPanel rachunki = new RachunkiPanel(RachListener, wsteczListener);
					frame.getContentPane().removeAll();
					frame.add(rachunki);
	                frame.validate();
						
				}			
			});
		}
		
	}

}
