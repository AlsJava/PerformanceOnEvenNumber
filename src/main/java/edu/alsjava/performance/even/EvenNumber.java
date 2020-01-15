package edu.alsjava.performance.even;

/**
 * Clase que tiene dos metodos para verificar si un número es par o impar.
 * <p>
 * Cabe destacar que el operador más pesado de lo elementos matemáticos es la división.
 * <p>
 * EN los operadores el Módulo (%) es el más pesado porque realiza multiples divisiones para conocer el residuo.
 * <p>
 * Created by aluis on 1/14/20.
 */
public class EvenNumber {

    /**
     * Este caso es más rápido porque compara el último bit del numero en question.
     * <p>
     * Ejemplo:
     * - 000 => 0
     * - 001 => 1
     * - 010 => 2
     * - 011 => 3
     * - 100 => 4
     * - 101 => 5
     * - 110 => 6
     * - 111 => 7
     * <p>
     * Todos los números pares terminan en 0 en el ultimo bit en su representación en binario.
     * <p>
     * Si comparas el último bit de ese numero en binario podrás saber si es par si hacer divisiones.
     *
     * @param number Número a comparar
     * @return si es Par
     */
    public boolean fastEven(int number) {
        return (number & 1) == 0;
    }

    /**
     * Esta es la forma conversional usando el módulo para conocer el residuo y en operaciones matemáticas es un proceso pesado.
     *
     * @param number Número a comparar
     * @return si es Par
     */
    public boolean normalEven(int number) {
        return number % 2 == 0;
    }
}
