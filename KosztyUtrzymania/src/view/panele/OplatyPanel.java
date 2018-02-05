package view.panele;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bilans.Bilans;
import view.listenery.OplatyListener;
import view.listenery.powrotListener.WrocOplDoRachPanel;

public class OplatyPanel extends JPanel {
	
	Bilans bilans = new Bilans();
	
	private JTextField jedzenieField; 
    private JTextField RrestauracjeField;
    private JTextField pyszneplField;
    private JTextField hondaField;
    private JTextField papierosyField;
    private JTextField LucekField;
    private JTextField kredytField;
    private JTextField dziadekField;
    private JTextField inneField;
    private JButton wstecz;
    private WrocOplDoRachPanel wsteczListener;
    
    
    private JButton dodaj;
    private OplatyListener OplListener;
   
    
    
	
	

	public String getJedzenie() {
		return jedzenieField.getText();
	}

	public String getRrestauracje() {
		return RrestauracjeField.getText();
	}

	public String getPysznepl() {
		return pyszneplField.getText();
	}

	public String getHonda() {
		return hondaField.getText();
	}

	public String getPapierosy() {
		return papierosyField.getText();
	}

	public String getLucek() {
		return LucekField.getText();
	}

	public String getKredyt() {
		return kredytField.getText();
	}

	public String getDziadek() {
		return dziadekField.getText();
	}

	public String getInne() {
		return inneField.getText();
	}

	
	public OplatyPanel(OplatyListener OplListener, WrocOplDoRachPanel wsteczListener) {
		super();
		GridBagLayout gridBag = new GridBagLayout();
    	GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.PAGE_START;
        gridBag.setConstraints(this, constraints);
        setLayout(gridBag);
        this.OplListener=OplListener;
        OplListener.setPanel(this);
        this.wsteczListener=wsteczListener;
        DochodOldComonents();
        RachunkiOldComonents();
        crateComponents();
        
	}
	
	private void crateComponents() {
		JLabel naglowek = new JLabel("Twoje oplaty");
		JLabel jedzenie = new JLabel("Jedzienie: ");
		JLabel restauracje = new JLabel("Restauracje: ");
		JLabel pyszne = new JLabel("Pyszne.pl: ");
		JLabel honda = new JLabel("Auto: ");
		JLabel papierosy = new JLabel("Papierosy: ");
		JLabel lucek = new JLabel("Zwierze domowe: ");
		JLabel kredyt = new JLabel("Kredyt: ");
		JLabel dziadek = new JLabel("Op³aty rodzinne: ");
		JLabel inne = new JLabel("Inne: ");
		
		jedzenieField = new JTextField();
		RrestauracjeField = new JTextField();
		pyszneplField = new JTextField();
		hondaField = new JTextField();
		papierosyField = new JTextField();
		LucekField = new JTextField();
		kredytField = new JTextField();
		dziadekField = new JTextField();
		inneField = new JTextField();
		
		JPanel FirstPanel = new JPanel();
		FirstPanel.add(naglowek);
		//FirstPanel.setLayout(new FlowLayout());
		JPanel InputPanel = new JPanel();
		InputPanel.add(jedzenie);
		InputPanel.add(jedzenieField);
		InputPanel.add(restauracje);
		InputPanel.add(RrestauracjeField);
		InputPanel.add(pyszne);
		InputPanel.add(pyszneplField);
		InputPanel.add(honda);
		InputPanel.add(hondaField);
		InputPanel.add(papierosy);
		InputPanel.add(papierosyField);
		InputPanel.add(lucek);
		InputPanel.add(LucekField);
		InputPanel.add(kredyt);
		InputPanel.add(kredytField);
		InputPanel.add(dziadek);
		InputPanel.add(dziadekField);
		InputPanel.add(inne);
		InputPanel.add(inneField);
		
		
		JPanel button = new JPanel();
		dodaj = new JButton("Dodaj");
		dodaj.addActionListener(OplListener);
		wstecz = new JButton("Wstecz");
		wstecz.addActionListener(wsteczListener);
		button.setLayout(new BorderLayout());
		button.add(dodaj, BorderLayout.CENTER);
		button.add(wstecz, BorderLayout.SOUTH);
		
		
		InputPanel.setLayout(new GridLayout(9,2,10,0));
		JPanel parentPanel = new JPanel();
		parentPanel.setLayout(new BorderLayout(0,10));
		parentPanel.add(FirstPanel, BorderLayout.PAGE_START);
		parentPanel.add(InputPanel, BorderLayout.CENTER);
		parentPanel.add(button, BorderLayout.PAGE_END);
		
		this.add(parentPanel);
		
	}
	
	public void RachunkiOldComonents() {
		JLabel naglowek = new JLabel("Rachunki");
		JLabel czynsz = new JLabel("Czynsz: ");
		JLabel prad = new JLabel("Prad: ");
		JLabel TV = new JLabel("TV i internet: ");
		JLabel czynszLicz = new JLabel(String.valueOf(bilans.getCzynsz())+" z³");
		JLabel pradLicz = new JLabel(String.valueOf(bilans.getPrad())+" z³");
		JLabel TVLicz = new JLabel(String.valueOf(bilans.getTV())+" z³");
		JLabel sumaD = new JLabel("Suma: ");
		JLabel suma = new JLabel(String.valueOf(bilans.getSumaRach())+" z³");
		JPanel FirstPanel = new JPanel();
		FirstPanel.add(naglowek);
		//FirstPanel.setLayout(new FlowLayout());
		JPanel InputPanel = new JPanel();
		InputPanel.add(czynsz);
		InputPanel.add(czynszLicz);
		InputPanel.add(prad);
		InputPanel.add(pradLicz);
		InputPanel.add(TV);
		InputPanel.add(TVLicz);
		InputPanel.add(sumaD);
		InputPanel.add(suma);
		
		InputPanel.setLayout(new GridLayout(4,2,10,0));
		JPanel parentPanel = new JPanel();
		parentPanel.setLayout(new BorderLayout());
		parentPanel.add(InputPanel, BorderLayout.EAST);
		parentPanel.add(FirstPanel, BorderLayout.PAGE_START);
		
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

