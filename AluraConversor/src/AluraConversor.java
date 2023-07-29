import javax.swing.JOptionPane;

public class AluraConversor {
	public static void main(String[] args) {
		String[] tipoConversor = { "Conversor de Monedas", "Conversor de Medidas" };

		while (true) {
			String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione conversor",
					"Alura Conversor", JOptionPane.PLAIN_MESSAGE, null, tipoConversor, tipoConversor[0]);

			if (opcionSeleccionada == null || opcionSeleccionada.equals("Cancelar")) {
				JOptionPane.showMessageDialog(null, "Cerrando AluraConversor", "AluraConversor",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			}

			if (opcionSeleccionada.equals("Conversor de Monedas")) {
				mostrarOpcionesConversorMonedas();
			} else if (opcionSeleccionada.equals("Conversor de Medidas")) {
				mostrarOpcionesMedidas();
			}
		}
	}

	static void mostrarOpcionesConversorMonedas() {
		String[] opciones = { "Pesos Chilenos a Dólares", "Pesos chilenos a Euros",
				"Pesos chilenos a Libras Esterlinas", "Pesos chilenos a Yen Japonés",
				"Pesos chilenos a Won sur-coreano", "Dólares a Pesos Chilenos", "Euros a Pesos chilenos",
				"Libras Esterlinas a Pesos chilenos", "Yen Japonés a Pesos chilenos",
				"Won sur-coreano a Pesos chilenos" };

		String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:",
				"AluraConversor - Monedas", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

		if (opcionSeleccionada == null || opcionSeleccionada.equals("Cancelar")) {
			JOptionPane.showMessageDialog(null, "Cancelando conversión de monedas", "AluraConversor",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		switch (opcionSeleccionada) {
		case "Pesos Chilenos a Dólares":
			convertir(824.74, "Dólares");
			break;
		case "Pesos chilenos a Euros":
			convertir(916.42, "Euros");
			break;
		case "Pesos chilenos a Libras Esterlinas":
			convertir(1067.67, "Libras Esterlinas");
			break;
		case "Pesos chilenos a Yen Japonés":
			convertir(5.90, "Yen Japonés");
			break;
		case "Pesos chilenos a Won sur-coreano":
			convertir(0.65, "Won sur-coreano");
			break;
		case "Dólares a Pesos Chilenos":
			convertirEnReverso(824.74, "Pesos Chilenos");
			break;
		case "Euros a Pesos chilenos":
			convertirEnReverso(916.42, "Pesos Chilenos");
			break;
		case "Libras Esterlinas a Pesos chilenos":
			convertirEnReverso(1067.67, "Pesos Chilenos");
			break;
		case "Yen Japonés a Pesos chilenos":
			convertirEnReverso(5.90, "Pesos Chilenos");
			break;
		case "Won sur-coreano a Pesos chilenos":
			convertirEnReverso(0.65, "Pesos Chilenos");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Seleccione una opción válida", "AluraConversor",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	static void mostrarOpcionesMedidas() {
		String[] opciones = { "Longitud", };

		String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:",
				"AluraConversor - Medidas", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

		if (opcionSeleccionada == null || opcionSeleccionada.equals("Cancelar")) {
			JOptionPane.showMessageDialog(null, "Cancelando conversión", "AluraConversor",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		switch (opcionSeleccionada) {
		case "Longitud":
			mostrarOpcionesLongitud();
			break;

		default:
			JOptionPane.showMessageDialog(null, "Seleccione una opción válida", "AluraConversor",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	static void convertir(double valorMoneda, String pais) {
		String cantidadMonedaStr = JOptionPane.showInputDialog(null, "Ingrese la cantidad a convertir en " + pais + ":",
				"AluraConversor", JOptionPane.QUESTION_MESSAGE);

		try {
			double cantidadMoneda = Double.parseDouble(cantidadMonedaStr);
			double monedaExtranjera = cantidadMoneda / valorMoneda;
			
			JOptionPane.showMessageDialog(null, "* Tienes $" + monedaExtranjera, "AluraConversor",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad válida", "AluraConversor",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	static void convertirEnReverso(double valorMoneda, String pais) {
		String cantidadMonedasStr = JOptionPane.showInputDialog(null,
				"Ingrese la cantidad de " + pais + " a convertir a Pesos Chilenos:", "AluraConversor",
				JOptionPane.QUESTION_MESSAGE);

		try {
			double cantidadMonedas = Double.parseDouble(cantidadMonedasStr);
			double pesosChilenos = cantidadMonedas * valorMoneda;

			JOptionPane.showMessageDialog(null, "* Tienes $" + pesosChilenos + " Pesos Chilenos", "AluraConversor",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad válida", "AluraConversor",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	static void mostrarOpcionesLongitud() {
		String[] opcionesLongitud = { "Metros a Pies", "Pies a Metros" };

		String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:",
				"AluraConversor - Longitud", JOptionPane.PLAIN_MESSAGE, null, opcionesLongitud, opcionesLongitud[0]);

		if (opcionSeleccionada == null || opcionSeleccionada.equals("Cancelar")) {
			JOptionPane.showMessageDialog(null, "Cancelando conversión de longitud", "AluraConversor",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		convertirLongitud(opcionSeleccionada);
	}

	static void convertirLongitud(String medida) {
		String cantidadStr = JOptionPane.showInputDialog(null, "Ingrese la cantidad a convertir en " + medida + ":",
				"AluraConversor", JOptionPane.QUESTION_MESSAGE);

		try {
			double cantidad = Double.parseDouble(cantidadStr);
			double cantidadFinal = 0.0;

			if (medida.equals("Metros a Pies")) {
				cantidadFinal = cantidad * 3.28084;
			} else if (medida.equals("Pies a Metros")) {
				cantidadFinal = cantidad / 3.28084;
			}

			JOptionPane.showMessageDialog(null, "* Tienes " + cantidadFinal, "AluraConversor",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad válida", "AluraConversor",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
