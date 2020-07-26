package jrJava.GraceHopperHacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TeacherData {

    private static final Map<String, String> data = new HashMap<>();

    static void read() throws IOException {
        try (InputStream is = TeacherData.class.getResourceAsStream("/Teacher_ID");
                BufferedReader f = new BufferedReader(new InputStreamReader(is))) {
            String line = null;
            while ((line = f.readLine()) != null) {
                String[] emailAndPassword = line.split(" ");
                data.put(emailAndPassword[0], emailAndPassword[1]);
            }
        }
    }

    static Map<String, String> getData() {
        return data;
    }

    public static void main(String[] args) throws IOException {
        TeacherData.read();
        System.out.println(TeacherData.getData());
    }
}
