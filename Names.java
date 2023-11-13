import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Names {

   private static List<String> names;

    static {
        // Replace "path/to/your/names.txt" with the actual path to your names file
        String filePath = "/workspaces/assignment-2-a-living-world-SirHoldembeck/Try/name.txt";
        names = readNamesFromFile(filePath);
    }

    private static List<String> readNamesFromFile(String filePath) {
        List<String> names = new ArrayList<>();

        try {
            Path path = Paths.get(filePath);
            String content = Files.readString(path);
            // Split the content into an array of names using ","
            String[] nameArray = content.split(",");
            for (String name : nameArray) {
                // Remove quotes and add to the list
                names.add(name.replace("\"", ""));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return names;
    }

    public static String generateRandomName() {
        int randomIndex = (int) (Math.random() * names.size());
        return names.get(randomIndex);
    }
}