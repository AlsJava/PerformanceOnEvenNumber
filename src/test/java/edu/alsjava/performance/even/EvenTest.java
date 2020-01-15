package edu.alsjava.performance.even;

import edu.alsjava.performance.even.utils.TimeExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by aluis on 1/14/20.
 */
@ExtendWith(TimeExtension.class)
public class EvenTest {

    private static final EvenNumber EVEN_NUMBER = new EvenNumber();

    private static final List<Integer> EVEN_LIST;
    private static final List<Integer> NO_EVEN_LIST;

    static {
        EVEN_LIST = evenNumbers();
        NO_EVEN_LIST = noEvenNumbers();
    }

    @Test
    void simpleTest() {
        // Fast
        List.of(0, 2, 4, 6, 8).forEach(number -> assertTrue(EVEN_NUMBER.fastEven(number)));
        List.of(1, 3, 5, 7, 9).forEach(number -> assertFalse(EVEN_NUMBER.fastEven(number)));
        // Normal
        List.of(0, 2, 4, 6, 8).forEach(number -> assertTrue(EVEN_NUMBER.normalEven(number)));
        List.of(1, 3, 5, 7, 9).forEach(number -> assertFalse(EVEN_NUMBER.normalEven(number)));
    }

    @Test
    void fastEvenOverList() {
        EVEN_LIST.forEach(number -> assertTrue(EVEN_NUMBER.fastEven(number))); // Verify divisible by 2
        NO_EVEN_LIST.forEach(number -> assertFalse(EVEN_NUMBER.fastEven(number))); // Verify not divisible by 2
    }

    @Test
    void normalEvenOverList() {
        EVEN_LIST.forEach(number -> assertTrue(EVEN_NUMBER.normalEven(number))); // Verify divisible by 2
        NO_EVEN_LIST.forEach(number -> assertFalse(EVEN_NUMBER.normalEven(number))); // Verify not divisible by 2
    }

    private static List<Integer> noEvenNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 100001; i += 2) {
            numbers.add(i);
        }
        return numbers;
    }

    private static List<Integer> evenNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            numbers.add(i * 2);
        }
        return numbers;
    }
}
