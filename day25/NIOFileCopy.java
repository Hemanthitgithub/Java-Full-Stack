package day25;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOFileCopy {
    public static void main(String[] args) {
        Path inputFile = Paths.get("input.txt");
        Path outputFile = Paths.get("output.txt");

        System.out.println("Input File Path: " + inputFile.toAbsolutePath());
        System.out.println("Output File Path: " + outputFile.toAbsolutePath());

        try {
            if (!Files.exists(outputFile)) {
                Files.createFile(outputFile);
            }
        } catch (IOException e) {
            System.err.println("Error creating output file: " + e.getMessage());
            return;
        }

        try (FileChannel inChannel = FileChannel.open(inputFile, StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(outputFile, StandardOpenOption.WRITE)) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (inChannel.read(buffer) > 0) {
                buffer.flip(); 
                outChannel.write(buffer);
                buffer.clear(); 
            }

            System.out.println("File content has been copied to output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

