package poo;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Empleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Jefatura jefe_RRHH = new Jefatura("juan", 32000, 2020, 1, 2);
		jefe_RRHH.estableceIncentivo(2300);

		Empleado[] misEmpleados = new Empleado[6];
		misEmpleados[0] = new Empleado("Ana", 2300, 2020, 2, 4);
		misEmpleados[1] = new Empleado("Carlos", 33000, 2020, 2, 4);
		misEmpleados[2] = new Empleado("Antonio", 43000, 2020, 2, 4);
		misEmpleados[3] = new Empleado("Luis", 76000, 2020, 2, 4);
		misEmpleados[4] = jefe_RRHH; // Polimorfismo en accion. Principio de sustitucion
		misEmpleados[5] = new Jefatura("Maria", 98000, 2020, 2, 4);

		Jefatura jefa_Finanzas = (Jefatura) misEmpleados[5];
		jefa_Finanzas.estableceIncentivo(55000);

		Empleado director_comercial = new Jefatura("Sandra", 85000, 2012, 01, 03);

		Comparable ejemplo = new Empleado("Elizabeth", 95000, 2012, 05, 05);

		// podemos usar instance of tanto con clases como interfaces
		if (director_comercial instanceof Empleado) {
			System.out.println("Es de tipo Jefatura."); // jefatura hereda de empleado
		}

		if (ejemplo instanceof Comparable) {
			System.out.println("Implementa la interfaz comparable");
		}

		for (Empleado e : misEmpleados) {
			e.subeSueldo(5);
		}

		Arrays.sort(misEmpleados);

		System.out.println(jefa_Finanzas.tomar_decisiones("Dar mas dias de vacaciones"));

		jefa_Finanzas.establece_bonus(500);
		System.out.println("El jefe " + jefa_Finanzas.dameNombre() + " tiene un bonus de " + jefa_Finanzas.establece_bonus(500));
		System.out.println(misEmpleados[3].dameNombre() + " tiene un bonus de : " + misEmpleados[3].establece_bonus(200));
		
		for (Empleado e : misEmpleados) {
			System.out.println("Nombre: " + e.dameNombre() + " Sueldo: " + e.dameSueldo() + " Fecha de alta: "
					+ e.dameFechaContrato());
		}
	}
}

class Empleado implements Comparable, Trabajadores{

	private String nombre;
	private double sueldo;
	private Date altaContrato;
	private static int IdSiguiente;
	private int Id;

	public Empleado(String nom, double sue, int agno, int mes, int dia) {
		nombre = nom;
		sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia);
		altaContrato = calendario.getTime();

		++IdSiguiente;

		Id = IdSiguiente;
	}

	@Override
	public int compareTo(Object miObjeto) {
		Empleado otroEmpleado = (Empleado) miObjeto;

		if (this.sueldo < otroEmpleado.sueldo) {
			return -1;
		}
		if (this.sueldo > otroEmpleado.sueldo) {
			return 1;
		}
		return 0;
	}

	@Override 
	public double establece_bonus (double gratiicacion) {
	
		return Trabajadores.bonus_base + gratiicacion;
	}
	
	public Empleado(String nom) {
		this(nom, 30000, 2000, 1, 1);
	}

	public String dameNombre() {
		return nombre + " Id: " + Id;
	}

	public double dameSueldo() {
		return sueldo;
	}

	public Date dameFechaContrato() {
		return altaContrato;
	}

	public void subeSueldo(double porcentaje) {
		double aumento = sueldo * porcentaje / 100;
		sueldo += aumento;
	}

}

class Jefatura extends Empleado implements Jefes {

	private double incentivo;

	public Jefatura(String nom, double sue, int agno, int mes, int dia) {
		super(nom, sue, agno, mes, dia);
	}
	
	@Override
	public String tomar_decisiones(String decision) {
		return "La clase Jefatura toma la decision de " + decision
				+ ". Esta clase hereda Empleado e implementa la interfaz Jefes";
	}

	@Override
	public double establece_bonus(double gratificacion) {
		double prima = 2000;
		return Trabajadores.bonus_base + gratificacion + prima;
	}

	public void estableceIncentivo(double b) {
		incentivo = b;
	}


	public double dameSueldo() {
		double sueldoJefe = super.dameSueldo();
		return sueldoJefe + incentivo;
	}
}
