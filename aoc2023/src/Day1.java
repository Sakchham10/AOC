import com.sun.nio.sctp.AbstractNotificationHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Character.isDigit;

public class Day1 {
    public static int firstPuzzle() {
        int total = 0;
        List<String> fileData = Utils.readFile("/Users/sakchhamsangroula/Projects/aoc/aoc2023/src/puzzle1.txt");
        for (String data : fileData) {
            String nums = data.replaceAll("\\D+", "");
            int num = 0;
            if (nums.length() == 1) {
                num = Integer.parseInt(nums) * 10 + Integer.parseInt(nums);

            } else {
                num = Integer.parseInt(String.valueOf(nums.charAt(0))) * 10 + Integer.parseInt(String.valueOf(nums.charAt(nums.length() - 1)));
            }
            total += num;
        }
        return total;
    }

    public static int secondPuzzle() {


        int total = 0;
        List<String> fileData = Utils.readFile("/Users/sakchhamsangroula/Projects/aoc/aoc2023/src/puzzle1.txt");
        List<String> alphaDigits = new ArrayList<String>() {{
            add("one");
            add("two");
            add("three");
            add("four");
            add("five");
            add("six");
            add("seven");
            add("eight");
            add("nine");
        }};
        for (String data : fileData) {
            List<String> digits = new ArrayList<String>();
            int index = 0;
            for (char character : data.toCharArray()) {
                if (isDigit(character)) {
                    digits.add(String.valueOf(character));
                }
                for (String digit : alphaDigits) {
                    String remainList = data.substring(index);
                    if (remainList.startsWith(digit)) {
                        digits.add(String.valueOf(alphaDigits.indexOf(digit) + 1));
                    }
                }
                index++;
            }
            int num = 0;
            if (digits.size() > 1) {
                num = Integer.parseInt(digits.get(0)) * 10 + Integer.parseInt(digits.get(digits.size() - 1));
            } else {
                num = Integer.parseInt(digits.get(0)) * 10 + Integer.parseInt(digits.get(0));
            }
            total += num;
        }
        return total;
    }
}