package view.listenery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import dataBase.UserData;
import dataBase.Uzytkownik;
import view.listenery.powrotListener.WrocDochDoZalPanel;
import view.panele.DochodyPanel;
import view.panele.ZalogujPanel;

public class ZalListener implements ActionListener {
	
	Uzytkownik user = new Uzytkownik();
	UserData userDB = new UserData();
	
	JFrame frame;
	ZalogujPanel ZalPanel;
	
	
		
	
	
	public void setPanel(ZalogujPanel ZalPanel) {
		this.ZalPanel=ZalPanel;
	}

	public ZalListener(JFrame frame) {
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(ZalPanel.getName().isEmpty())
			System.out.println("Puste Bloczki");
		else
		userDB.ShowUser("Nazwa", ZalPanel.getName());
		
		if (ZalPanel.getName().isEmpty() || ZalPanel.getPassword().isEmpty()) {
				System.out.println("Jeszcze raz wpisz");
			}
		else if(userDB.getImie2().equals(ZalPanel.getName()) && userDB.getHaslo2().equals(ZalPanel.getPassword())) {
			System.out.println("Dobre dane");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				PrzychListener PListener = new PrzychListener(frame);
				WrocDochDoZalPanel wrocListener = new WrocDochDoZalPanel(frame);
				JPanel dochody = new DochodyPanel(PListener, wrocListener);
				frame.getContentPane().removeAll();
				frame.add(dochody);
                frame.validate();
					
			}			
		});
		}
		
		else
		System.out.println("Zle dane");
	}
	

}
