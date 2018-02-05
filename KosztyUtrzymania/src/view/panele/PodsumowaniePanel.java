package view.panele;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bilans.Bilans;
import net.miginfocom.swing.MigLayout;
import view.listenery.WyjsceListener;
import view.listenery.powrotListener.WrocPodsDoOplPanel;

public class PodsumowaniePanel extends JPanel {
	Bilans bilans = new Bilans();
	private JButton wstecz;
    private WrocPodsDoOplPanel wsteczListener;
	private JButton exit;
	private WyjsceListener exitListener;

	
	public PodsumowaniePanel(WrocPodsDoOplPanel wsteczListener, WyjsceListener exitListener) {
		super();
		this.wsteczListener=wsteczListener;
        this.exitListener=exitListener;
	
		MigLayout absLM = new MigLayout("",
				"30[250,fill]50[250,fill]50[fill]",
                "[]20[]50[10:pref,fill]10[]");
		
		setLayout(absLM);
		this.add(NaglowekComponents(), "span, wrap");
        this.add(DochodyComponents());
        this.add(RachunkiComponets());
        this.add(OplatyComponents(), "wrap");
        this.add(CreateComponents(), "span 3, wrap");
        this.add(CreateButtons(), "span 3");
        
        
        
	}
	private JPanel CreateButtons() {
		JPanel button = new JPanel();
		wstecz = new JButton("Wstecz");
		wstecz.addActionListener(wsteczListener);
		exit = new JButton("Zako�cz program");
		exit.addActionListener(exitListener);
		button.setLayout(new BorderLayout());
		button.add(wstecz, BorderLayout.WEST);
		button.add(exit, BorderLayout.EAST);
		
		return button;
	}
	

	private JPanel CreateComponents() {
		JLabel dzialanie = new JLabel("Bilans wynosi: "+ bilans.getBilansMiesiaca()+ " z�.");
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		panel.add(dzialanie);
	

		JPanel layout = new JPanel();
		layout.add(panel, BorderLayout.CENTER);
		return layout;
	}

	private JPanel NaglowekComponents() {
		JLabel naglowek = new JLabel("Podsumowanie bilansu miesiaca!");

		JPanel panel = new JPanel();
		panel.add(naglowek);
		
		return panel;
	}

	private JPanel OplatyComponents() {
		JLabel naglowek = new JLabel("Twoje oplaty");
		JLabel jedzenie = new JLabel("Jedzienie: ");
		JLabel jedzenieLicz = new JLabel(String.valueOf(bilans.getJedzenie())+" z�");
		JLabel restauracje = new JLabel("Restauracje: ");
		JLabel restauracjeLicz = new JLabel(String.valueOf(bilans.getRestauracjce())+" z�");
		JLabel pyszne = new JLabel("Pyszne.pl: ");
		JLabel pyszneLicz = new JLabel(String.valueOf(bilans.getPyszne())+" z�");
		JLabel honda = new JLabel("Auto: ");
		JLabel hondaLicz = new JLabel(String.valueOf(bilans.getHonda())+" z�");
		JLabel papierosy = new JLabel("Papierosy: ");
		JLabel papierosyLicz = new JLabel(String.valueOf(bilans.getPapierosy())+" z�");
		JLabel lucek = new JLabel("Zwierze domowe: ");
		JLabel lucekLicz = new JLabel(String.valueOf(bilans.getLucek())+" z�");
		JLabel kredyt = new JLabel("Kredyt: ");
		JLabel kredytLicz = new JLabel(String.valueOf(bilans.getKredyt())+" z�");
		JLabel dziadek = new JLabel("Op�aty rodzinne: ");
		JLabel dziadekLicz = new JLabel(String.valueOf(bilans.getDziadek())+" z�");
		JLabel inne = new JLabel("Inne: ");
		JLabel inneLicz = new JLabel(String.valueOf(bilans.getInne())+" z�");
		JLabel suma = new JLabel("suma: ");
		JLabel sumaLicz = new JLabel(String.valueOf(bilans.getSumaOP()+bilans.getSumaJed())+" z�");

		
		JPanel FirstPanel = new JPanel();
		FirstPanel.add(naglowek);
		JPanel InputPanel = new JPanel();
		InputPanel.add(jedzenie);
		InputPanel.add(jedzenieLicz);
		InputPanel.add(restauracje);
		InputPanel.add(restauracjeLicz);
		InputPanel.add(pyszne);
		InputPanel.add(pyszneLicz);
		InputPanel.add(honda);
		InputPanel.add(hondaLicz);
		InputPanel.add(papierosy);
		InputPanel.add(papierosyLicz);
		InputPanel.add(lucek);
		InputPanel.add(lucekLicz);
		InputPanel.add(kredyt);
		InputPanel.add(kredytLicz);
		InputPanel.add(dziadek);
		InputPanel.add(dziadekLicz);
		InputPanel.add(inne);
		InputPanel.add(inneLicz);
		InputPanel.add(suma);
		InputPanel.add(sumaLicz);
		
		
		
		InputPanel.setLayout(new GridLayout(10,2));
		JPanel parentPanel = new JPanel();
		parentPanel.setLayout(new BorderLayout());
		parentPanel.add(FirstPanel, BorderLayout.NORTH);
		parentPanel.add(InputPanel, BorderLayout.CENTER);
		

		return parentPanel;
	}

	private JPanel RachunkiComponets() {
		JLabel naglowek = new JLabel("Rachunki");
		JLabel czynsz = new JLabel("Czynsz: ");
		JLabel prad = new JLabel("Prad: ");
		JLabel TV = new JLabel("TV i internet: ");
		JLabel czynszLicz = new JLabel(String.valueOf(bilans.getCzynsz())+" z�");
		JLabel pradLicz = new JLabel(String.valueOf(bilans.getPrad())+" z�");
		JLabel TVLicz = new JLabel(String.valueOf(bilans.getTV())+" z�");
		JLabel sumaD = new JLabel("Suma: ");
		JLabel suma = new JLabel(String.valueOf(bilans.getSumaRach())+" z�");
		JPanel FirstPanel = new JPanel();
		FirstPanel.add(naglowek);
		JPanel InputPanel = new JPanel();
		InputPanel.add(czynsz);
		InputPanel.add(czynszLicz);
		InputPanel.add(prad);
		InputPanel.add(pradLicz);
		InputPanel.add(TV);
		InputPanel.add(TVLicz);
		InputPanel.add(sumaD);
		InputPanel.add(suma);
		
		InputPanel.setLayout(new GridLayout(4,2,0,0));
		JPanel parentPanel = new JPanel();
		parentPanel.setLayout(new BorderLayout());
		parentPanel.add(InputPanel, BorderLayout.CENTER);
		parentPanel.add(FirstPanel, BorderLayout.NORTH);
		
		//this.add(parentPanel);
		
		return parentPanel;
		
	}

	private JPanel DochodyComponents() {
		JLabel naglowek = new JLabel("Dochody");
		JLabel p1 = new JLabel("Pierwszy przchod: ");
		JLabel p2 = new JLabel("Drugi przchod: ");
		JLabel p1Licz = new JLabel(String.valueOf(bilans.getDochod1())+" z�");
		JLabel p2Licz = new JLabel(String.valueOf(bilans.getDochod2())+" z�");
		JLabel sumaD = new JLabel("Suma: ");
		JLabel suma = new JLabel(String.valueOf(bilans.getSuma())+" z�");
		JPanel FirstPanel = new JPanel();
		FirstPanel.add(naglowek);
		JPanel InputPanel = new JPanel();
		InputPanel.add(p1);
		InputPanel.add(p1Licz);
		InputPanel.add(p2);
		InputPanel.add(p2Licz);
		InputPanel.add(sumaD);
		InputPanel.add(suma);
		
		InputPanel.setLayout(new GridLayout(3,2,0,0));
		JPanel parentPanel = new JPanel();
		parentPanel.setLayout(new BorderLayout());
		parentPanel.add(InputPanel, BorderLayout.CENTER);
		parentPanel.add(FirstPanel, BorderLayout.NORTH);
		
		return parentPanel;
		
	}
}
