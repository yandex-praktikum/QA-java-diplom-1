import java.util.Random;

public class Utils {
    public static String randomAlphabeticString(int StringLength) {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = StringLength;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
