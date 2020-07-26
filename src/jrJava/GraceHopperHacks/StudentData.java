package jrJava.GraceHopperHacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentData {

    private static final List<String> data = new ArrayList<>();

    static void read() throws IOException {
        try (InputStream is = StudentData.class.getResourceAsStream("/Student_ID");
                BufferedReader f = new BufferedReader(new InputStreamReader(is))) {
            String line = null;
            while ((line = f.readLine()) != null) {
                data.add(line);
            }
        }
    }

    static List<String> getData() {
        return data;
    }

    public static void main(String[] args) throws IOException {
        StudentData.read();
        System.out.println(StudentData.getData());
    }
}
