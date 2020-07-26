package jrJava.GraceHopperHacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ProblemData {

    private static final List<String> data = new ArrayList<>();

    static void read() throws IOException {
        try (InputStream is = Student.class.getResourceAsStream("/ProblemData");
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

    static void append(String s) {
        data.add(s);
    }

    static void replace(String oldStr, String newStr) {
        ListIterator<String> iterator = data.listIterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals(oldStr)) {
                iterator.set(newStr);
            }
        }
    }

    static List<String> unread() {
        List<String> unread = new ArrayList<>();
        for (String s : getData()) {
            if (!s.equals("read")) {
                unread.add(s);
            }
        }
        return unread;
    }
 
    public static void main(String[] args) throws IOException {
        ProblemData.read();
        System.out.println(ProblemData.getData());
        ProblemData.append("xyz");
        ProblemData.replace("Problem1", "read");
        System.out.println(ProblemData.getData());
    }
}
