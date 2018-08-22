package ApiPersona.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validaciones {

	public static boolean validarCorreo(String correo) {
		// Patrón para validar el email
		boolean valido = false;
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
       
 
        Matcher mathcer = pattern.matcher(correo);
        return mathcer.matches();
 
       
	}  

	public static boolean validarNumerico(String value) {
		return (value.matches("[+-]?\\d*(\\.\\d+)?") && value.equals("") == false);
	}

	public static boolean validarLetras(String value) {
		return (value.matches("[a-zA-Z áéíóúÁÉÍÓÚñÑ]?") && value.equals("") == false);
	}

	public static boolean validarContrasena(String value) {
		return (value.matches("^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$")
				&& value.equals("") == false);
	}

}
