import java.util.Arrays;
import java.util.logging.*;
import java.util.logging.Logger;

// Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл.
public class DZS22 {
    private static Logger logger = Logger.getLogger(DZS22.class.getName());

    public static void main(String[] args) {
        int[] array = { 5, 7, 3, 1, 4, 2, 0 };
        System.out.println(Arrays.toString(array));
        bubbleSort (array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort (int[] array) {
        for (int i = array.length; i >= 0; i--) {
            for (int j = 0; j < i && j + 1 < i; j++){
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    logger.log (Level.INFO, String.format ("%d <-> %d, %s",array[j], array[j + 1], Arrays.toString(array)));
                }    
            }
        }
    }
}
