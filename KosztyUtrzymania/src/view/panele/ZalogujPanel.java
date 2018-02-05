package view.panele;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import view.listenery.ZalListener;
import view.listenery.powrotListener.WrocZalDoLoginPanel;

public class ZalogujPanel extends JPanel {
	private JTextField nameField; 
    private JPasswordField passField;
    private JButton ZalButton;
    private ZalListener ZalogujListener;
    private JButton wstecz;
    private WrocZalDoLoginPanel wsteczListener;
    
    
    public String getName() {
    	return nameField.getText();
    }
    
    public String getPassword() {
    	String password = "";
        char[] pass = passField.getPassword();
        for(int i=0; i<pass.length; i++) {
            password += pass[i];
        }
        return password;
    }
    
    
    
    public ZalogujPanel(ZalListener ZalogujListener, WrocZalDoLoginPanel wsteczListener) {
    	super();
    	GridBagLayout gridBag = new GridBagLayout();
    	GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        gridBag.setConstraints(this, constraints);
        setLayout(gridBag);
        this.ZalogujListener=ZalogujListener;
        this.ZalogujListener.setPanel(this);
        this.wsteczListener=wsteczListener;
    	crateComponents();
    	
    	
    }

	private void crateComponents() {
		JLabel nazwa = new JLabel("Nazwa uzytownika: ");
		JLabel password = new JLabel("Haslo: ");
		nameField = new JTextField();
		passField = new JPasswordField();
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(2, 2));
		inputPanel.add(nazwa);
		inputPanel.add(nameField);
		inputPanel.add(password);
		inputPanel.add(passField);
		
		ZalButton = new JButton("Zaloguj");
		ZalButton.addActionListener(ZalogujListener);
		wstecz = new JButton("Wstecz");
		wstecz.addActionListener(wsteczListener);
		
		JPanel parentPanel = new JPanel();
		parentPanel.setLayout(new BorderLayout());
		parentPanel.add(inputPanel, BorderLayout.NORTH);
		parentPanel.add(ZalButton, BorderLayout.CENTER);
		parentPanel.add(wstecz, BorderLayout.SOUTH);
		
		this.add(parentPanel);
		
	}

}
