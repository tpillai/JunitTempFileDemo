package com.demo.junitTempDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipMultipleFiles {
    public static void main(final String[] args) throws IOException {
        String test1File ="src/test/resources/zipTest/test1.txt";
        String test2File = "src/test/resources/zipTest/test2.txt";
        String outputFile= "src/test/resources/multiCompressed.zip";
        ZipMultipleFiles.zipfile(test1File, test2File, outputFile);
    }



    public static void zipfile(String test1File, String test2File,String outputFile) throws IOException {
        final List<String> srcFiles = Arrays.asList(test1File,test2File);
        final FileOutputStream fos = new FileOutputStream(outputFile);
        final ZipOutputStream zipOut = new ZipOutputStream(fos);
        for (final String srcFile : srcFiles) {
            final File fileToZip = new File(srcFile);
            final FileInputStream fis = new FileInputStream(fileToZip);
            final ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            final byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        fos.close();
    }
}
