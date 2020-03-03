package poo;

import javax.swing.*;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
public class PruebaTemporizador {

	public static void main(String[] args) {
		
		DameLaHora oyente = new DameLaHora();
		
		Timer miTemporizador = new Timer(5000, oyente);
		
		miTemporizador.start();

		JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener!");
		
		System.exit(0);
	}

}

class DameLaHora implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
		Date ahora = new Date();
		
		System.out.println("Poner la hora cada 5 seg." + ahora );
		
		Toolkit.getDefaultToolkit().beep();
	}
}