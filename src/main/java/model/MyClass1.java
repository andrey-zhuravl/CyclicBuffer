package model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class MyClass1 {
    static {
        System.out.println("static 1234321234");
        print();
    }
    public static void print(){
        System.out.println("1234321234");
//        List<String> lines = null;
//        try {
//            lines = Files.readAllLines(Path.of("D:/TEMP/text31.txt"));
//            lines.forEach(s->System.out.println(s));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Path.of("D:/TEMP/new 31.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        char c = (char) bytes[0];
        int i = (int) bytes[0];
        Stream.of(bytes).forEach( cv ->
                System.out.println(String.format("Symb %h", cv))
        );
        System.out.println("EEEEEEEEEEEEE");
    }
}
