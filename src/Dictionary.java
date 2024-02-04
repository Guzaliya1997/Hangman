
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Dictionary {
    protected static String getWord() throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("./src/russian_nouns.txt"));
        return  lines.get(new Random().nextInt(lines.size()));
    }
}
