package PraticasJava6;

public class Ex3 {

    /**
     * Função que determina se um número é ou não par
     *
     * @param num Número a analisar
     * @return true se par || false se impar
     */
    public static boolean par(int num) {
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Função que determina se um número é ou não positivo
     *
     * @param num Número a analisar
     * @return true se positivo || false se negativo
     */
    public static boolean positivo(int num) {
        if (num >= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Função que determina se um número é ou não primo
     *
     * @param num Número a analisar
     * @return true se primo || false se não primo
     */
    public static boolean primo(int num) {

        for (int divisor = 2; divisor < num; divisor++) {
            if (num % divisor == 0) {
                return false;
            }
        }

        return true;

    }

    /**
     * Função que determina se um número é ou não perfeito
     *
     * @param num Número a analisar
     * @return true se perfeito || false se não perfeito
     */
    public static boolean perfeito(int num) {

        int somaDivisores = 0;

        for (int divisor = 1; divisor < num; divisor++) {
            if (num % divisor == 0) {
                somaDivisores += divisor;
            }
        }

        if (somaDivisores == num) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Função que determina se um número é ou não trianguler
     *
     * @param num Número a analisar
     * @return true se triangular || false se não triangular
     */
    public static boolean triangular(int num) {

        int triangulares = 0;

        for (int i = 0; triangulares < num; i++) {
            triangulares += i;

            if (triangulares == num) {
                return true;
            }
        }

        return false;
    }
}