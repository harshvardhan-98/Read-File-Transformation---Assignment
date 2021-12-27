import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class FileTransformation {

        public static void main(String[] args) throws FileNotFoundException, IOException {

                Map m1 = new HashMap();

                try (BufferedReader br = new BufferedReader(new FileReader("words"))) {
                        StringBuilder sb = new StringBuilder();
                        String line = br.readLine();

                        while (line != null) {
                                String[] words = line.split(" ");//those are your words
                                for (int i = 0; i < words.length; i++) {
                                        if (m1.get(words[i]) == null) {
                                                m1.put(words[i], 1);
                                        } else {
                                                int newValue = Integer.valueOf(String.valueOf(m1.get(words[i])));
                                                newValue++;
                                                m1.put(words[i], newValue);
                                        }
                                }
                                sb.append(System.lineSeparator());
                                line = br.readLine();
                        }
                }
                Map<String, String> sorted = new TreeMap<String, String>(m1);
                for (Object key : sorted.keySet()) {
                        System.out.println(  key + "\t:" + m1.get(key));
                }
        }
}