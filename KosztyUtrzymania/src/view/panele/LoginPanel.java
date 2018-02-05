package view.panele;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.listenery.WyjsceListener;
import view.listenery.ZalogujListener;
import view.listenery.ZarejestrujListener;

public class LoginPanel extends JPanel {
	
	private JButton zaloguj;
	private JButton zarejestruj;
	private JButton exit;
	private ZalogujListener ZalListener;
	private ZarejestrujListener ZarListener;
	private WyjsceListener exitListener;
	

	public LoginPanel(ZarejestrujListener ZarListener, ZalogujListener ZalListener, WyjsceListener exitListener) {
		GridBagLayout gridBag = new GridBagLayout();
    	GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        gridBag.setConstraints(this, constraints);
        setLayout(gridBag); 
        this.ZarListener=ZarListener;
        this.ZarListener.setPanel(this);
        this.ZalListener=ZalListener;
        this.ZalListener.setPanel(this);
        this.exitListener=exitListener;
        this.exitListener.setPanel(this);
        
		createButtons();
		
		
	}


	private void createButtons() {
		zaloguj = new JButton("Zaloguj");
		zarejestruj = new JButton("Zarejestruj");
		exit = new JButton("Zakoñcz program");
		zaloguj.addActionListener(ZalListener);
		zarejestruj.addActionListener(ZarListener);
		exit.addActionListener(exitListener);
		
		
		JPanel parentPanel = new JPanel();
		parentPanel.setLayout(new BorderLayout());
		parentPanel.add(zaloguj, BorderLayout.NORTH);
		parentPanel.add(zarejestruj, BorderLayout.CENTER);
		parentPanel.add(exit, BorderLayout.SOUTH);
		
		this.add(parentPanel);
	}
}
