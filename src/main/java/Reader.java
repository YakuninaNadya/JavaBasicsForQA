import java.io.InputStream;
import java.util.*;

public class Reader {

    /**
     * The method reads the information from file, which puts in 'resources' folder.
     * @return String with all information from file.
     */
    public String readFromFile() {
        InputStream inputStream = getClass()
                .getClassLoader().getResourceAsStream(Constants.FILE_NAME);
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
                sb.append("\n");
            }
        }
        return String.valueOf(sb);
    }
}
