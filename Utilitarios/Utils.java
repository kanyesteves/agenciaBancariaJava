package Utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
	//Classe para armazenar funções
	
	static NumberFormat formatandoValores = new DecimalFormat("R$ #.##0.00");
	
	private static String doubleToString(Double valor) {
		return formatandoValores.format(valor);
	}
}
