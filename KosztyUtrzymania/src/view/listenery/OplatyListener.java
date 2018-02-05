package view.listenery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import bilans.Bilans;
import view.listenery.powrotListener.WrocPodsDoOplPanel;
import view.panele.OplatyPanel;
import view.panele.PodsumowaniePanel;

public class OplatyListener implements ActionListener {
	Bilans bilans = new Bilans();
	
	OplatyPanel OplPanel;
	JFrame frame;
	
	public void setPanel(OplatyPanel OplPanel) {
		this.OplPanel=OplPanel;
	}

	public OplatyListener(JFrame frame) {
		this.frame=frame;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
	bilans.Zycie(OplPanel.getJedzenie(), OplPanel.getRrestauracje() , OplPanel.getPysznepl());
	bilans.Koszta(OplPanel.getPapierosy(), OplPanel.getLucek(), OplPanel.getHonda(), OplPanel.getKredyt(), OplPanel.getDziadek(), OplPanel.getInne());
	
	if(OplPanel.getJedzenie().isEmpty() || OplPanel.getRrestauracje().isEmpty() || OplPanel.getPysznepl().isEmpty() ||
		OplPanel.getPapierosy().isEmpty() || OplPanel.getLucek().isEmpty() || OplPanel.getHonda().isEmpty() ||
		OplPanel.getKredyt().isEmpty() || OplPanel.getDziadek().isEmpty() || OplPanel.getInne().isEmpty())
		System.out.println("Bloczki Puste!!");
	
	else if(Pattern.matches("[0-9]+\\.?[0-9]*",OplPanel.getJedzenie())==false ||
			Pattern.matches("[0-9]+\\.?[0-9]*",OplPanel.getRrestauracje())==false ||
			Pattern.matches("[0-9]+\\.?[0-9]*",OplPanel.getPysznepl())==false ||
			Pattern.matches("[0-9]+\\.?[0-9]*",OplPanel.getPapierosy())==false ||
			Pattern.matches("[0-9]+\\.?[0-9]*",OplPanel.getLucek())==false ||
			Pattern.matches("[0-9]+\\.?[0-9]*",OplPanel.getHonda())==false ||
			Pattern.matches("[0-9]+\\.?[0-9]*",OplPanel.getKredyt())==false ||
			Pattern.matches("[0-9]+\\.?[0-9]*",OplPanel.getDziadek())==false ||
			Pattern.matches("[0-9]+\\.?[0-9]*",OplPanel.getInne())==false)
		System.out.println("Zle dane");
	
	else
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				WrocPodsDoOplPanel wrocListener = new WrocPodsDoOplPanel(frame);
				WyjsceListener exitListener = new WyjsceListener(frame);
				JPanel podsumowanie = new PodsumowaniePanel(wrocListener,exitListener);
				frame.getContentPane().removeAll();
				frame.add(podsumowanie);
                frame.validate();
					
			}			
		});
	
	}

}
