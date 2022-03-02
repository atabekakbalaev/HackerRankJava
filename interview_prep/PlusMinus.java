import java.io.*;
import java.text.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        DecimalFormat df = new DecimalFormat("#.######");
        int positives = arr.stream().filter(t -> t > 0).collect(Collectors.toList()).size();
        int negatives = arr.stream().filter(t -> t < 0).collect(Collectors.toList()).size();
        int neutrals = arr.stream().filter(t -> t == 0).collect(Collectors.toList()).size();
        double positiveCount = (double) positives / arr.size();
        double negativeCount = (double) negatives / arr.size();
        double neutralCount = (double) neutrals / arr.size();
        System.out.println(df.format(positiveCount));
        System.out.println(df.format(negativeCount));
        System.out.println(df.format(neutralCount));
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
