
import java.util.Scanner;


public class Uso_Tallas {

//	enum Talla {MINI, MEDIANO, GRANDE, MUYGRANDE};

	enum Talla {
		MINI("S"), MEDIANO("M"), GRANDE("L"), MUYGRANDE("X");
		private String abreviatura;

		private Talla(String abreviatura) {
			this.abreviatura = abreviatura;
		}

		public String dameAbreviatura() {
			return abreviatura;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String talla;
//		talla = "pequeña";
//		talla = "mediana";
//		talla = "grande";
//		talla = "azul";

//		Talla S = Talla.MINI;
//		Talla M = Talla.MEDIANO;
//		Talla L = Talla.GRANDE;
//		Talla X = Talla.MUYGRANDE;

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Escribe una talla: Mini, Mediano, Grande y Muy Grande" );
		String entrada_datos = entrada.next().toUpperCase();
		
		Talla la_talla = Enum.valueOf(Talla.class, entrada_datos);
		System.out.println("Talla = " + la_talla);
		System.out.println("Abreviatura = " + la_talla.dameAbreviatura());
	}

}
