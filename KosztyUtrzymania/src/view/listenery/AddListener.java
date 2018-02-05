package view.listenery;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import dataBase.UserData;
import dataBase.Uzytkownik;
import view.panele.LoginPanel;
import view.panele.ZarejestrujPanel;

public class AddListener implements ActionListener {
	
	private  JFrame frame;
	private ZarejestrujPanel ZarPanel;
	Uzytkownik user = new Uzytkownik();
	UserData userDB = new UserData();
	
	public void setPanel(ZarejestrujPanel ZarPanel) {
		this.ZarPanel=ZarPanel;
	}
	
	public AddListener(JFrame frame) {
		this.frame=frame;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		user.setNazwa(ZarPanel.getName());
		user.setPassword(ZarPanel.getPassword());
		if(user.getNazwa().isEmpty() || user.getPassword().isEmpty()) {
			/*SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					JLabel puste = new JLabel("Puste Bloczki!");
					JPanel pusty = new JPanel();
					pusty.add(puste);
					ZarPanel.validate();
						
				}			
			});*/
			System.out.println("Puste Bloczki");
		}
		else {
		userDB.addNazwa(user);	
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

}
