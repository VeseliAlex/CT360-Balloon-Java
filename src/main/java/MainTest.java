package main.java;

import main.java.exceptions.Assignment2FileNotFoundException;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import static main.java.Main.ucitavanjePodataka;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static final Logger logger = Logger.getLogger(MainTest.class.getName());
    public static final String INPUT_WORD = "BALLOON";

    @BeforeAll
    @DisplayName("Test class started.")
    static void logStart() {
        logger.info("Test class started.");
    }

    @AfterAll
    static void logEnd() {
        logger.info("Test class ended.");
    }

    @BeforeEach
    void logStart2() {
        logger.info("Test have started");
    }

    @AfterEach
    void logEnd2() {
        logger.info("Test have finished");
    }

    @Test
    @DisplayName("Maksimalni broj reci u odgovoru")
    void maximalniBrojBalonaTest() {
        var s = new Solution();
        assertEquals(1, s.maximalniBrojBalona(INPUT_WORD));
    }

    @Test
//wrong result
    void pogresanBrojBalonaTest() {
        var s = new Solution();
        assertNotEquals(2, s.maximalniBrojBalona(INPUT_WORD));
    }

    @Test
    void solutionTestThrowsExceptionForInvalidResult() {
        ISolution iSolution = Mockito.mock(ISolution.class);
        Mockito.when(iSolution.maximalniBrojBalona(Mockito.anyString())).thenReturn(-1);
        assertThrows(Assignment2FileNotFoundException.class, () -> ucitavanjePodataka("src/main/java/bananan.txt", "src/main/java/upisivanje.txt", iSolution));
    }

    @Test
    void solutionTestDoesntThrowExceptionForInvalidResult() throws Exception {
        ISolution iSolution = Mockito.mock(ISolution.class);
        Mockito.when(iSolution.maximalniBrojBalona(Mockito.anyString())).thenReturn(1);
        ucitavanjePodataka("src/main/java/bananan.txt", "src/main/java/upisivanje.txt", iSolution);
    }

    @Test
        // checks if the output file is empty
    void checkingOutputFile() throws IOException {
        Path p = Paths.get("src/main/java/upisivanje.txt");
        if (Files.size(p) == 0) {
            Assertions.fail("upisivanje.txt is empty");
        }
    }

    @Test
        //checks if the input file is empty
    void checkingInputFile() throws IOException {
        Path p1 = Paths.get("src/main/java/bananan.txt");
        if (Files.size(p1) == 0) {
            Assertions.fail("bananan.txt is empty");
        }
    }

    @Test
    void ucitavanjePodatakaTest2() {
        Solution s = new Solution();
        assertNotNull(s);

        assertDoesNotThrow(()-> ucitavanjePodataka("src/main/java/bananan.txt", "src/main/java/upisivanje.txt", s));
    }

    @Test
    void ucitavanjePodatakaTestInvalidInputPath() throws Exception {
        Solution s = new Solution();
        assertNotNull(s);
        assertThrows(Assignment2FileNotFoundException.class,()-> ucitavanjePodataka(null, "src/main/java/upisivanje.txt", s));
    }

    @Test
        //checking if exception is being thrown
    void testForException() {
        Solution s = new Solution();
        assertThrows(Assignment2FileNotFoundException.class, () -> ucitavanjePodataka("src/min/jav/upisivanje.txt", "2", s));
    }


}