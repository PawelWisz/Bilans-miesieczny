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

import view.listenery.AddListener;
import view.listenery.powrotListener.WrocZarDoLoginPanel;

public class ZarejestrujPanel extends JPanel {
	
	private JTextField nameField; 
    private JPasswordField passField;
    private JButton addButton;
    private AddListener DodajListener;
    private JButton powrot;
    private WrocZarDoLoginPanel powrotListener;
    
    
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
    
	
	public ZarejestrujPanel(AddListener DodajListener, WrocZarDoLoginPanel powrotListener) {
		super();
    	GridBagLayout gridBag = new GridBagLayout();
    	GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        gridBag.setConstraints(this, constraints);
        setLayout(gridBag);
        this.DodajListener=DodajListener;
        this.DodajListener.setPanel(this);
        this.powrotListener= powrotListener;
        
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
		
		addButton = new JButton("Zarejestruj");
		addButton.addActionListener(DodajListener);
		powrot = new JButton("Wstecz");
		powrot.addActionListener(powrotListener);
		
		JPanel parentPanel = new JPanel();
		parentPanel.setLayout(new BorderLayout());
		parentPanel.add(inputPanel, BorderLayout.NORTH);
		parentPanel.add(addButton, BorderLayout.CENTER);
		parentPanel.add(powrot, BorderLayout.SOUTH);
		
		this.add(parentPanel);
		
	}

}
