import java.security.SecureRandom;

public class Contrasenas {

        public static void main(String[] args) {
        int longitud = 12; // Longitud predeterminada de la contraseña
        boolean incluirMayusculas = true;//Idican si deben incluir estos tipos de carcteres en la contraseña
        boolean incluirMinusculas = true;
        boolean incluirNumeros = true;
        boolean incluirEspeciales = true;


//string cadena alfanumerica le asigno un nombre, en este caso contersena y creo un metodo en este caso generarContraena
        String contrasena = generarContrasena(longitud, incluirMayusculas, incluirMinusculas, incluirNumeros, incluirEspeciales);
        System.out.println("La contraseña generada es: " + contrasena); /*  Se llama al metodo generar contrasena() con los
        parametros especificados que son longitud y todos los incluir y se guarda la contraseña en la variable contrasena */
    }


    public static String generarContrasena(int longitud, boolean incluirMayusculas, boolean incluirMinusculas,
            boolean incluirNumeros, boolean incluirEspeciales) { /*Este metodo toma los parametros de entrada y genera la
    contraseña. Toma la longitud de la contraseña y los booleanos que indican qué tipos de caracteres se deben incluir. */


        String caracteresMayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String caracteresMinusculas = "abcdefghijklmnopqrstuvwxyz";
        String caracteresNumeros = "0123456789";
        String caracteresEspeciales = "!@#$%^&*()-_+=";
        /*Definen cuatro strings que contienen los caracteres permitidos para cada tipo de caracter:
         mayúsculas, minúsculas, números y caracteres especiales. */



/*Se crea un StringBuilder llamado caracteresPermitidos para contener todos los caracteres permitidos
 según los criterios especificados.*/

 /*Si los booleanos correspondientes son true,
  se agregan los caracteres del tipo respectivo al StringBuilder caracteresPermitidos. */
        StringBuilder caracteresPermitidos = new StringBuilder(); 
        if (incluirMayusculas) {
            caracteresPermitidos.append(caracteresMayusculas);
        }
        if (incluirMinusculas) {
            caracteresPermitidos.append(caracteresMinusculas);
        }
        if (incluirNumeros) {
            caracteresPermitidos.append(caracteresNumeros);
        }
        if (incluirEspeciales) {
            caracteresPermitidos.append(caracteresEspeciales);
        }


/*Se crea un objeto SecureRandom para generar números aleatorios seguros.
Se crea un StringBuilder llamado contrasena para construir la contraseña generada.
Se genera cada carácter de la contraseña en un bucle for que se ejecuta longitud veces:
Se elige un índice aleatorio dentro de la longitud de caracteresPermitidos y se agrega el carácter correspondiente 
al StringBuilder contrasena.*/
        SecureRandom random = new SecureRandom();
        StringBuilder contrasena = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteresPermitidos.length());
            contrasena.append(caracteresPermitidos.charAt(indice));
        }
/*Finalmente, se devuelve la contraseña generada como un String*/
        return contrasena.toString();
    }
}