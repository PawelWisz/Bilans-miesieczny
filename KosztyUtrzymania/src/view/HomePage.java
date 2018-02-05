package view;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.listenery.WyjsceListener;
import view.listenery.ZalogujListener;
import view.listenery.ZarejestrujListener;
import view.panele.LoginPanel;

public class HomePage extends JFrame {
	
	
	public HomePage() {
        super("Bilans vol.1.0");
        ZalogujListener ZalListener = new ZalogujListener(this);
        ZarejestrujListener listener = new ZarejestrujListener(this);
        WyjsceListener exitListener = new WyjsceListener(this);
        JPanel login  = new LoginPanel(listener, ZalListener, exitListener);
        add(login);
        setPreferredSize(new Dimension(800, 400));
        setLocation(250, 100);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
	
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            new HomePage();
        }
	});
}

}
