import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {
    public static int day1(){
        int total = 0;
        try{
            File myObj = new File("/Users/sakchhamsangroula/Projects/aoc/aoc2023/src/puzzle1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                String nums = data.replaceAll("\\D+","");
                int num = 0;
                if(nums.length() == 1){
                    num = Integer.parseInt(nums) * 10 + Integer.parseInt(nums);

                }
                else{
                    num = Integer.parseInt(String.valueOf(nums.charAt(0))) * 10 + Integer.parseInt(String.valueOf(nums.charAt(nums.length()-1)));
                    System.out.println(data);
                    System.out.println(nums);
                    System.out.println(num);
                }
                total += num;
            }
            myReader.close();
        }catch(FileNotFoundException e){
            System.out.println("No file found");
            e.printStackTrace();
        }
        return total;
    }


}
