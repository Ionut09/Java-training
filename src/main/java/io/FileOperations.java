package io;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileOperations {

    public static final String IN_STR_PATH = "./src/main/resources/io/input.txt";

    public static final Path scripts = Paths.get("./src/main/resources/io/scripts.sh");

    public static final Path input_path = Paths.get(IN_STR_PATH);

    public static void main(String... args) throws IOException {
        //check if a file exists
        var exists = Files.exists(input_path);//true
        var notExists = Files.notExists(input_path);//false

        //check file rights
        var hasFullPermissions = Files.isExecutable(scripts) && Files.isWritable(scripts) && Files.isReadable(scripts);
        System.out.println("hasFullPermissions = " + hasFullPermissions);

        var regularFile = Files.isRegularFile(scripts, LinkOption.NOFOLLOW_LINKS);
        System.out.println(regularFile);

        //check whether 2 paths refer to the same file
        var sameFile = Files.isSameFile(input_path, input_path.toAbsolutePath());
        System.out.println("sameFile = " + sameFile);

        //delete
//        Files.delete(input_path);

        //create
//        Files.createFile(input_path);

        //move
//        Files.move(p.getParent().resolve("output.txt"), p, StandardCopyOption.REPLACE_EXISTING);

        //copy
        Files.copy(input_path, input_path.getParent().resolve("output.txt"), StandardCopyOption.REPLACE_EXISTING);

        try (var bufferedReader = Files.newBufferedReader(input_path)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println();
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }

        //walking the directory tree
        Files.walk(Paths.get("."), 10, FileVisitOption.FOLLOW_LINKS)
             .map(Path::normalize)
             .map(Path::toString)
             .filter(name -> name.endsWith(".java"))
             .forEach(System.out::println);

        System.out.println("list ====================");
        //listing directory content
        Files.list(Paths.get("."))
             .map(Path::normalize)
             .map(Path::toString)
             .filter(name -> name.contains("gradle"))
             .forEach(System.out::println);


        //listing file content as a Stream<String> with the lines
        try (var bufferedWriter =
                     Files.newBufferedWriter(input_path.getParent().resolve("Classes_from_project.txt"))) {
            Files.lines(input_path)
                 .peek(System.out::println)
                 .map(str -> str.substring(str.lastIndexOf("/") + 1))
                 .sorted()
                 .forEach(line -> write(bufferedWriter, line));
            bufferedWriter.close(); //performed by try-with-resources
        } catch (IOException ex) {
            log.error("Bad ");
        }
//        bufferedWriter.flush();

    }

    private static void write(java.io.BufferedWriter bufferedWriter, String line) {
        try {
            bufferedWriter.write(line + "\n");
        } catch (IOException e) {
            log.error("Bad ");
        }
    }
}
