package compiler;

public class Verificador {

	public boolean ehInteiro(String s) {
		// cria um array de char
		char[] c = s.toCharArray();
		boolean d = true;
		for (int i = 0; i < c.length; i++)
			// verifica se o char n�o � um d�gito
			if (!Character.isDigit(c[i])) {
				d = false;
				break;
			}

		return d;
	}
}
