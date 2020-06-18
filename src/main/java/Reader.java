import java.util.*;

import java.io.File;
import java.io.IOException;

public class Reader implements Constants{

    public String readFromFile() {
        File file = new File(PATH_TO_FILE);
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
                sb.append("\n");
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(sb);
    }
}
