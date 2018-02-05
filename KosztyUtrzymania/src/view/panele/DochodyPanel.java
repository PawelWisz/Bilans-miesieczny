package view.panele;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.listenery.PrzychListener;
import view.listenery.powrotListener.WrocDochDoZalPanel;

public class DochodyPanel extends JPanel {
	
	private JTextField p1Field; 
    private JTextField p2Field;
    private JButton dodaj;
    private PrzychListener DodajPrzyListener;
    private JButton wstecz;
    private WrocDochDoZalPanel wsteczListener;
    
    
    public String getp1() {
    	return p1Field.getText();
    }
    
    public String getp2() {
    	return p2Field.getText();
    }
	
	public DochodyPanel(PrzychListener DodajPrzyListener, WrocDochDoZalPanel wsteczListener) {
		super();
    	GridBagLayout gridBag = new GridBagLayout();
    	GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.PAGE_START;
        gridBag.setConstraints(this, constraints);
        setLayout(gridBag);
        this.DodajPrzyListener=DodajPrzyListener;
        this.DodajPrzyListener.setPanel(this);
        this.wsteczListener=wsteczListener;
		createComponents();

		
	}

	

	private void createComponents() {
		JLabel nazwa = new JLabel("Podaj przychody domownikow ");
		JLabel p1 = new JLabel("Pierwszy przchod: ");
		JLabel p2 = new JLabel("Drugi przchod: ");
		p1Field = new JTextField();
		p2Field = new JTextField();
		JPanel FirstPanel = new JPanel();
		FirstPanel.add(nazwa);
		FirstPanel.setLayout(new FlowLayout());
		JPanel InputPanel = new JPanel();
		InputPanel.add(p1);
		InputPanel.add(p1Field);
		InputPanel.add(p2);
		InputPanel.add(p2Field);
		InputPanel.setLayout(new GridLayout(2,2));
		
		JPanel button = new JPanel();
		dodaj = new JButton("dalej");
		dodaj.addActionListener(DodajPrzyListener);
		wstecz = new JButton("Wstecz");
		wstecz.addActionListener(wsteczListener);
		button.setLayout(new BorderLayout());
		button.add(dodaj, BorderLayout.CENTER);
		button.add(wstecz, BorderLayout.SOUTH);
		
		JPanel parentPanel = new JPanel();
		parentPanel.setLayout(new BorderLayout());
		parentPanel.add(InputPanel, BorderLayout.CENTER);
		parentPanel.add(FirstPanel, BorderLayout.NORTH);
		parentPanel.add(button, BorderLayout.PAGE_END);
		
		
		this.add(parentPanel);
		
	}

}
