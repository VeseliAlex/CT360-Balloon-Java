package main.java;

import main.java.exceptions.Assignment2FileNotFoundException;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.internal.util.StringUtil;

import java.io.*;
import java.util.Scanner;


public class Main {
    private static final String INPUT_FILE = "src/main/java/bananan.txt";
    private static final String OUTPUT_FILE = "src/main/java/upisivanje.txt";

    public static void main(String[] args) {
        Solution s = new Solution();
        try {
            ucitavanjePodataka(INPUT_FILE, OUTPUT_FILE, s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void ucitavanjePodataka(final String inputFilePath, final String outputFilePath, final ISolution validator) throws Exception {

        if(inputFilePath==null){
            throw new Assignment2FileNotFoundException("Input path cannot be blank!");
        }

        if (StringUtils.isBlank(inputFilePath)) {

            throw new Assignment2FileNotFoundException("Input path cannot be blank!");
        }

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
                if(result==-1){
                    throw new Assignment2FileNotFoundException("hghg");
                }

                upis.write(line.toUpperCase() + " : " + result);
                upis.write("\n");
            }


        } catch (FileNotFoundException | Assignment2FileNotFoundException ex) {
            ex.printStackTrace();
            throw new Assignment2FileNotFoundException("Error");
        }
    }

}
