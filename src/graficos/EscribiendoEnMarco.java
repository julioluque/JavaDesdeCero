package graficos;

import javax.swing.*;
import java.awt.*;

public class EscribiendoEnMarco {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoConTexto miMarco = new MarcoConTexto();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}

class MarcoConTexto extends JFrame {
	
	public MarcoConTexto() {
		setVisible(true);
		setTitle("Marco con texto");
		setSize(600, 450);
		setLocation(400, 200);
		
		Lamina miLamina = new Lamina();
		add(miLamina);
		
	}
}

class Lamina extends JPanel {
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawString("Usando librerias swing", 100, 100);
	}
	
}