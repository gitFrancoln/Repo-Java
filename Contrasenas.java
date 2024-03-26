import java.security.SecureRandom;

public class Contrasenas {

        public static void main(String[] args) {
        int longitud = 12; 
        boolean incluirMayusculas = true;
        boolean incluirMinusculas = true;
        boolean incluirNumeros = true;
        boolean incluirEspeciales = true;
        String contrasena = generarContrasena(longitud, incluirMayusculas, incluirMinusculas, incluirNumeros, incluirEspeciales);
        System.out.println("La contraseña generada es: " + contrasena); 
    }
    public static String generarContrasena(int longitud, boolean incluirMayusculas, boolean incluirMinusculas,
            boolean incluirNumeros, boolean incluirEspeciales) { 
        String caracteresMayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String caracteresMinusculas = "abcdefghijklmnopqrstuvwxyz";
        String caracteresNumeros = "0123456789";
        String caracteresEspeciales = "!@#$%^&*()-_+=";
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
        SecureRandom random = new SecureRandom();
        StringBuilder contrasena = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteresPermitidos.length());
            contrasena.append(caracteresPermitidos.charAt(indice));
        }
        return contrasena.toString();
    }
}
