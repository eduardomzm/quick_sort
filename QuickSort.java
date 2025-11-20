import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) throws IOException {
        Files files = new Files();
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Nombre del archivo a leer: ");
        String inputFile = bufer.readLine();

        int[] data = files.fileToIntArray(inputFile);

        if (data != null) {
            sort(data, 0, data.length - 1);
            System.out.println("Archivo ordenado correctamente.");

            System.out.print("Nombre del archivo para guardar: ");
            String outputFile = bufer.readLine();
            files.writeIntArrayToFile(outputFile, data);
        }
    }
}