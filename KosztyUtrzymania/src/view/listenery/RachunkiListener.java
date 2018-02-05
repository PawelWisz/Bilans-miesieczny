package view.listenery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import bilans.Bilans;
import view.listenery.powrotListener.WrocOplDoRachPanel;
import view.panele.OplatyPanel;
import view.panele.RachunkiPanel;

public class RachunkiListener implements ActionListener {
	Bilans bilans = new Bilans();
	
	JFrame frame;
	RachunkiPanel RachPanel;
	
	public void setPanel(RachunkiPanel RachPanel) {
		this.RachPanel=RachPanel;
	}

	public RachunkiListener(JFrame frame) {
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			bilans.Rachunki(RachPanel.getCzynsz(), RachPanel.getPrad(), RachPanel.getTV());
			if(RachPanel.getCzynsz().isEmpty() || RachPanel.getPrad().isEmpty() || RachPanel.getTV().isEmpty())
				System.out.println("Bloczki puste");
			else if(Pattern.matches("[0-9]+\\.?[0-9]*",RachPanel.getCzynsz())==false || 
					 Pattern.matches("[0-9]+\\.?[0-9]*",RachPanel.getPrad())==false || 
					 Pattern.matches("[0-9]+\\.?[0-9]*",RachPanel.getTV())==false){
				
					System.out.println("Z³e dane");
			}
			else {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					OplatyListener OplListener = new OplatyListener(frame);
					WrocOplDoRachPanel wsteczListener = new WrocOplDoRachPanel(frame);
					JPanel oplaty = new OplatyPanel(OplListener, wsteczListener);
					frame.getContentPane().removeAll();
					frame.add(oplaty);
	                frame.validate();
						
				}			
			});
			}
	}

}
