import com.demo.junitTempDemo.ZipMultipleFiles;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static org.assertj.core.api.Assertions.assertThat;

public class ZipMultiFileTest {
    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();



    @Test
    public void testZipMultipleFile() throws IOException {
        //Setup
        File file = tempFolder.newFolder("inbound");
        File originalFile1 = new File("src/test/resources/zipTest/test1.txt");
        String finalFile1Path=file.getAbsolutePath()+"/"+ originalFile1.getName();
        copyFileToTempDirectory(originalFile1, finalFile1Path);
        System.out.println("finalFile1Path :" +finalFile1Path);

        File originalFile2 = new File("src/test/resources/zipTest/test2.txt");
        String finalFile2Path=file.getAbsolutePath()+"/"+ originalFile2.getName();
        copyFileToTempDirectory(originalFile2, file.getAbsolutePath()+"/"+ originalFile2.getName());
        System.out.println("finalFile2Path :" +finalFile2Path);

        // Perform the task . Zip files
        String outputFile= file.getAbsolutePath()+"multiCompressed.zip";

        ZipMultipleFiles.zipfile(finalFile1Path,finalFile2Path,outputFile);

        System.out.println("outputFile :" +outputFile);
        // Check output
        Path outputFileCopied = Paths.get(outputFile);
        assertThat(outputFileCopied).exists();


    }

    private void copyFileToTempDirectory(File originalFile, String finalFile1Path) throws IOException {
        Files.copy(originalFile.toPath(), Paths.get(finalFile1Path), StandardCopyOption.REPLACE_EXISTING);
    }
}
