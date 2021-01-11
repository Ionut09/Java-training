package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CharacterStreams {

    public static void main(String... args) {
//        try (Reader in = new FileReader("./src/main/resources/io/input.txt");
//             Writer out = new FileWriter("./src/main/resources/io/output.txt")) {
//
//            int byteRead;
//            while ((byteRead = in.read()) != -1) {
//                out.write(byteRead);
//            }
//
//        } catch (IOException ex) {
//            log.error(ex.getMessage(), ex);
//        }

        try (BufferedReader in = new BufferedReader(new FileReader("./src/main/resources/io/input.txt"), 1024 * 1024);
             BufferedWriter out = new BufferedWriter(new FileWriter("./src/main/resources/io/output.txt", true))) {

            String line;
            while ((line = in.readLine()) != null) {
//                if(in.markSupported()){
//                    in.mark(0);
//                }
//                in.reset();
                out.write(line);
                out.newLine();
            }
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }


    }
}
