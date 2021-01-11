package io;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathOperations {

    public static final String IN_STR_PATH = "./src/main/resources/io/input.txt";

    public static final Path p = Paths.get(IN_STR_PATH);

    /**
     * Path is immutable
     */
    public static void main(String... args) throws Exception {

//        creating a path
        Path px = Paths.get(IN_STR_PATH);
        Path p1 = Paths.get("./src/main", "resources", "io", "input.txt");
        Path pathToUrl = Paths.get(new URI("file:////home/ionut/workspace/Java-intro-PHP/src/main/resources/io/input.txt"));
        File file = new File(IN_STR_PATH);
        Path fromFile = file.toPath();
        file = fromFile.toFile();

//        retrieving information about a path
        System.out.format("toString: %s%n", p.toString());
        System.out.format("getFileName: %s%n", p.getFileName());
        System.out.format("getRoot: %s%n", p.getRoot());
        System.out.format("getNameCount: %s%n", p.getNameCount());
        System.out.format("getName: %s%n", p.getName(1));
        System.out.format("getParent: %s%n", p.getParent());
        System.out.format("toRealPath: %s%n", p.toRealPath());

//        removing redundancies from a path
        System.out.format("normalize: %s%n", p.normalize());

//        converting a path
        System.out.format("toAbsolutePath: %s%n", p.toAbsolutePath().normalize());

//        joining two path
        System.out.format("resolve: %s%n", p.getParent().resolve("output.txt"));

//        creating a path between two path
        Path foo = Paths.get("foo");    // ../bar
        Path bar = Paths.get("bar");            // ../foo
        System.out.format("relativize: %s%n", foo.relativize(bar));
        System.out.format("relativize: %s%n", bar.relativize(foo));
//      System.out.format("relativize: %s%n", bar.relativize(foo.toAbsolutePath()));   //boom -> paths need to be the same type
        foo = Paths.get("/home/foo/files");
        bar = Paths.get("/home/bar");
        Path relativizedPath = foo.relativize(bar);
        System.out.format("relativize: %s%n", relativizedPath);   //../../bar

//      comparing two paths
        System.out.format("startsWith: %s%n", p.startsWith("./src/main/resources"));

    }
}
