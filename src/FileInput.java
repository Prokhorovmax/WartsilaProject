import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInput {

    public static int[][] getMatrixFromFile(String fileName) {

        List<String> strings = readStringsFromFile(fileName);

        int rowNumber = strings.size();
        int columnNumber = strings.get(0).split(" ").length;

        int[][] matrix = new int[rowNumber][columnNumber];

        for (int i = 0; i < strings.size(); i++) {
            String[] arrayStringNumbers = strings.get(i).split(" ");
            for (int j = 0; j < columnNumber; j++) {
                if (isNumber(arrayStringNumbers[j])) {
                    matrix[i][j] = Integer.parseInt(arrayStringNumbers[j]);
                }
            }
        }
        return matrix;
    }

    private static List<String> readStringsFromFile(String fileName) {
        List<String> strings = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                strings.add(line);
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("CANNOT READ FILE!");
        }
        return strings;
    }

    private static boolean isNumber(String string) {
        return string.matches("\\d*\\.?\\d+");
    }
}