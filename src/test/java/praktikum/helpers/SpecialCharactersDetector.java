package praktikum.helpers;

public class SpecialCharactersDetector {
    public static Boolean detectSpecialCharacters(String inputString) {
        String specialCharactersString = "!@#$%&*()'+,./:;<=>?[]^_`{|}";
        for (int i=0; i < inputString.length() ; i++)
        {
            char ch = inputString.charAt(i);
            if(specialCharactersString.contains(Character.toString(ch))) {
                return true;
            }
        }
        return false;
    }
}
