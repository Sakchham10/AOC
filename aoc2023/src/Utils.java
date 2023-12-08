import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static List<String> readFile(String fileName) {
        List<String> fileValue = new ArrayList<String>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                fileValue.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }
        return fileValue;
    }

}