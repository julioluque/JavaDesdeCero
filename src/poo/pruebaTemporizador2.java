package poo;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.util.*;

public class pruebaTemporizador2 {

	public static void main(String[] args) {

		Reloj miReloj = new Reloj();
		
		miReloj.enMarcha(3000, true);

		JOptionPane.showMessageDialog(null, "Aceptar para terminar");

		System.exit(0);

	}

}

class Reloj {

	public void enMarcha(int intervalo, final boolean sonido) {

		class DameLaHora2 implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				Date ahora = new Date();
				System.out.println("Contador cada 3 segundos" + ahora);
				if (sonido) {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}

		ActionListener oyente = new DameLaHora2();

		Timer miTemporizador = new Timer(intervalo, oyente);
		miTemporizador.start();

	}

}