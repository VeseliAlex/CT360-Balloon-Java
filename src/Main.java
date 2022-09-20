import exceptions.Assignment2FileNotFoundException;
import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String INPUT_FILE = "src/bananan.txt";
    private static final String OUTPUT_FILE = "src/upisivanje.txt";

    public static void main(String[] args) {
        Solution s = new Solution();
        // int a = s.maximalniBrojBalona("aleksa");
        try {
            ucitavanjePodataka(INPUT_FILE, OUTPUT_FILE, s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void ucitavanjePodataka(final String inputFilePath, final String outputFilePath, final Solution validator) throws IOException {

        try (BufferedWriter upis = new BufferedWriter(new FileWriter(outputFilePath))) {
            File file = new File(inputFilePath);
            if (file == null) {
                throw new Assignment2FileNotFoundException("File: " + INPUT_FILE + " Not found in classpath");
            }
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                final String line = sc.nextLine();
                int result = validator.maximalniBrojBalona(line);
                //thrown exceptions

                upis.write(line.toUpperCase() + " : " + result);
                upis.write("\n");
            }


        } catch (FileNotFoundException | Assignment2FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
