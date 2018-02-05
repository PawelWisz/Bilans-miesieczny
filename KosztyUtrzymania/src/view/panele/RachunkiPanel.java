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

import bilans.Bilans;
import view.listenery.RachunkiListener;
import view.listenery.powrotListener.WrocRachDoDochPanel;



public class RachunkiPanel extends JPanel {
	
	Bilans bilans = new Bilans();


	private JTextField CzynszField; 
    private JTextField PradField;
    private JTextField TVField; 
    private JButton dodaj;
    private RachunkiListener rachListener;
    private JButton wstecz;
    private WrocRachDoDochPanel wsteczListener;
    
    
    public String getCzynsz() {
    	return CzynszField.getText();
    }
    public String getPrad() {
    	return PradField.getText();
    }
    public String getTV() {
    	return TVField.getText();
    }

	
	public RachunkiPanel(RachunkiListener rachListener, WrocRachDoDochPanel wsteczListener){
		super();
    	GridBagLayout gridBag = new GridBagLayout();
    	GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.PAGE_START;
        gridBag.setConstraints(this, constraints);
        setLayout(gridBag);
        this.rachListener=rachListener;
        this.rachListener.setPanel(this);
        this.wsteczListener =wsteczListener;
        DochodOldComonents();
        createComponents();
	}


	public void createComponents() {
		JLabel naglowek = new JLabel("Twoje rachunki");
		JLabel czynsz = new JLabel("Czynsz: ");
		JLabel prad = new JLabel("Prad: ");
		JLabel TV = new JLabel("TV i Internet: ");
		CzynszField = new JTextField();
		PradField = new JTextField();
		TVField = new JTextField();
		JPanel FirstPanel = new JPanel();
		FirstPanel.add(naglowek);
		//FirstPanel.setLayout(new FlowLayout());
		JPanel InputPanel = new JPanel();
		InputPanel.add(czynsz);
		InputPanel.add(CzynszField);
		InputPanel.add(prad);
		InputPanel.add(PradField);
		InputPanel.add(TV);
		InputPanel.add(TVField);
		
		JPanel button = new JPanel();
		dodaj = new JButton("Dodaj");
		dodaj.addActionListener(rachListener);
		wstecz = new JButton("Wstecz");
		wstecz.addActionListener(wsteczListener);
		button.setLayout(new BorderLayout());
		button.add(dodaj, BorderLayout.CENTER);
		button.add(wstecz, BorderLayout.SOUTH);
		
		
		InputPanel.setLayout(new GridLayout(3,2,10,0));
		JPanel parentPanel = new JPanel();
		parentPanel.setLayout(new BorderLayout(0,10));
		parentPanel.add(FirstPanel, BorderLayout.PAGE_START);
		parentPanel.add(InputPanel, BorderLayout.CENTER);
		parentPanel.add(button, BorderLayout.PAGE_END);
		
		this.add(parentPanel);
		
	
	}	
	void DochodOldComonents() {

	JLabel naglowek = new JLabel("Dochody");
	JLabel p1 = new JLabel("Pierwszy przchod: ");
	JLabel p2 = new JLabel("Drugi przchod: ");
	JLabel p1Licz = new JLabel(String.valueOf(bilans.getDochod1())+" z³");
	JLabel p2Licz = new JLabel(String.valueOf(bilans.getDochod2())+" z³");
	JLabel sumaD = new JLabel("Suma: ");
	JLabel suma = new JLabel(String.valueOf(bilans.getSuma())+" z³");
	JPanel FirstPanel = new JPanel();
	FirstPanel.add(naglowek);
	//FirstPanel.setLayout(new FlowLayout());
	JPanel InputPanel = new JPanel();
	InputPanel.add(p1);
	InputPanel.add(p1Licz);
	InputPanel.add(p2);
	InputPanel.add(p2Licz);
	InputPanel.add(sumaD);
	InputPanel.add(suma);
	
	InputPanel.setLayout(new GridLayout(3,2,10,0));
	JPanel parentPanel = new JPanel();
	parentPanel.setLayout(new BorderLayout());
	parentPanel.add(InputPanel, BorderLayout.EAST);
	parentPanel.add(FirstPanel, BorderLayout.PAGE_START);
	
	this.add(parentPanel);
	
}
}
