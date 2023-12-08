import java.util.List;
import java.util.Objects;

public class Day2 {
    public static int problem1() {
        List<String> fileData = Utils.readFile("/Users/sakchhamsangroula/Projects/aoc/aoc2023/src/puzzle2.txt");
        int total = 0;

        for (String data : fileData) {
            String[] firstSpilt = data.split(":");
            String[] secondSplit = firstSpilt[1].split(";");
            boolean correct = true;
            for (String game : secondSplit) {
                if (correct) {
                    String[] squares = game.split(",");
                    for (String square : squares) {
                        square = square.trim();
                        square = square.strip();
                        String[] squareNum = square.split(" ");
                        String color = squareNum[1];
                        int value = Integer.parseInt(squareNum[0]);
                        if (Objects.equals(color, "blue") && value > 14 || Objects.equals(color, "red") && value > 12 || Objects.equals(color, "green") && value > 13) {
                            correct = false;
                        }
                    }
                }
            }
            if (correct) {
                String[] gameSplit = firstSpilt[0].split(" ");
                int gameNum = Integer.parseInt(gameSplit[1]);
                total += gameNum;
            }
        }
        return total;
    }

    public static int problem2() {
        List<String> fileData = Utils.readFile("/Users/sakchhamsangroula/Projects/aoc/aoc2023/src/puzzle2.txt");
        int total = 0;
        for (String data : fileData) {
            String[] firstSpilt = data.split(":");
            String[] secondSplit = firstSpilt[1].split(";");
            int minRed = Integer.MIN_VALUE;
            int minBlue = Integer.MIN_VALUE;
            int minGreen = Integer.MIN_VALUE;
            for (String game : secondSplit) {
                String[] squares = game.split(",");
                for (String square : squares) {
                    square = square.trim();
                    square = square.strip();
                    String[] squareNum = square.split(" ");
                    String color = squareNum[1];
                    int value = Integer.parseInt(squareNum[0]);
                    if (Objects.equals(color, "blue") && value > minBlue) {
                        minBlue = value;
                    }
                    if (Objects.equals(color, "red") && value > minRed) {
                        minRed = value;
                    }
                    if (Objects.equals(color, "green") && value > minGreen) {
                        minGreen = value;
                    }
                }
            }
            if(minBlue == Integer.MIN_VALUE || minRed == Integer.MAX_VALUE || minGreen == Integer.MAX_VALUE){
                total += 0;
                continue;
            }

            int power = minBlue * minGreen * minRed;
            total += power;
        }
        return total;
    }
}