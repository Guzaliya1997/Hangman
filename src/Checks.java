import java.util.Arrays;

public class Checks {
    protected static boolean isCharValid(char ch) {
        String s = Character.toString(ch);
        if (s.matches("^[а-я]+")) {
            return true;
        } else {
            return false;
        }
    }

    protected static boolean ifCharAlreadyGuessed(char ch, String[] arr) {
        boolean test = Arrays.stream(arr)
                .anyMatch(x -> x.equals(String.valueOf(ch)));
        if (test) {
            return true;
        } else {
            return false;
        }
    }
    protected static boolean checkInput(String input) {
        return input.equals("и");
    }
}
