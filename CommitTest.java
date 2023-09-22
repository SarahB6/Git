import static org.junit.Assert.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CommitTest {
    private static String testFile = "testfile.txt";

    @BeforeAll
    static void runBeforeAll () throws Exception {
        //make a test file
        File f = new File(testFile);
        f.createNewFile();

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(testFile)));

        pw.print("hello"); 
        pw.close();

        //make objects file
        File objects = new File ("./objects");
        objects.mkdirs();

    }


    @Test
    @DisplayName ("Test save w/o prev commit info")
    void testSavenoPrev() throws Exception {
       Commit c = new Commit("Bob", "This is it");
        c.finishCommit();
        File f = new File("./objects/" + c.shaOfFileContent());
        assertTrue(f.exists()); 
    }

    @Test
    @DisplayName ("Test save w prev commit info")
    void testSaveyesPrev() throws Exception {
        Commit c = new Commit("f924e482dd33576fd0de90b6376f1671b08b5f52","Bob", "This is it");
        c.finishCommit();
        File f = new File("./objects/" + c.shaOfFileContent());
        assertTrue(f.exists());
    }

    @Test
    @DisplayName ("Test SHA1")
    void testSHA1() throws Exception {
        Commit c = new Commit("f924e482dd33576fd0de90b6376f1671b08b5f52", "Bob", "test");
        String sha = c.shaOfFileContent();
    }

    @Test
    @DisplayName ("Test adding CommitVal")
    void testAddCommitVal() throws Exception 
    {
        
        
    }
}