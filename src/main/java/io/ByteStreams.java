package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ByteStreams {

    public static void main(String... args) throws IOException {
        Stream<String> aStreamIterator; //iterates over a sequence of objects

//        InputStream in = null;
//        OutputStream out = null;
        long start = System.currentTimeMillis(); //ms
        try (InputStream in = new BufferedInputStream(new FileInputStream(new File("./src/main/resources/io/input.txt")));
             //        if output.txt doesn't exist will be created automatically
             OutputStream out = new BufferedOutputStream(new FileOutputStream("./src/main/resources/io/output.txt"))) {//

//         try (InputStream in = new FileInputStream(new File("./src/main/resources/io/input.txt"));
//             //        if output.txt doesn't exist will be created automatically
//             OutputStream out = new FileOutputStream("./src/main/resources/io/output.txt")) {//

            int byteRead;
            while ((byteRead = in.read()) != -1) {//0101010101010101010 EOF
                //throw
                out.write(byteRead);
            }
            System.out.println(String.format("Time needed to copy is %.3f seconds", ((System.currentTimeMillis() - start) / 1000.0)));
        }//at the end of the try the resources will be closed automatically
        catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }


//        finally {
//            if (in != null) {
//                in.close();
//            }
//            if (out != null) {
//                out.close();
//            }
//        }
    }
}
