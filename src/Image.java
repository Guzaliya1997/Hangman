import java.util.Arrays;
import java.util.Map;

public class Image  {
    protected static String getImage(int faults){
        StringBuilder result = new StringBuilder();
        switch (faults) {
            case 0:
                result.append("---------");
                result.append(System.getProperty("line.separator"));
                result.append("|    |");
                result.append(System.getProperty("line.separator"));
                result.append("|");
                result.append(System.getProperty("line.separator"));
                result.append("|");
                result.append(System.getProperty("line.separator"));
                result.append("|");
                result.append(System.getProperty("line.separator"));
                result.append("--------------");
                break;
            case 1:
                result.append("---------");
                result.append(System.getProperty("line.separator"));
                result.append("|    |");
                result.append(System.getProperty("line.separator"));
                result.append("|   (_)");
                result.append(System.getProperty("line.separator"));
                result.append("|");
                result.append(System.getProperty("line.separator"));
                result.append("|");
                result.append(System.getProperty("line.separator"));
                result.append("--------------");
                break;
            case 2:
                result.append("---------");
                result.append(System.getProperty("line.separator"));
                result.append("|    |");
                result.append(System.getProperty("line.separator"));
                result.append("|   (_)");
                result.append(System.getProperty("line.separator"));
                result.append("|    |");
                result.append(System.getProperty("line.separator"));
                result.append("|");
                result.append(System.getProperty("line.separator"));
                result.append("--------------");
                break;
            case 3:
                result.append("---------");
                result.append(System.getProperty("line.separator"));
                result.append("|    |");
                result.append(System.getProperty("line.separator"));
                result.append("|   (_)");
                result.append(System.getProperty("line.separator"));
                result.append("|   /|");
                result.append(System.getProperty("line.separator"));
                result.append("|");
                result.append(System.getProperty("line.separator"));
                result.append("--------------");
                break;
            case 4:
                result.append("---------");
                result.append(System.getProperty("line.separator"));
                result.append("|    |");
                result.append(System.getProperty("line.separator"));
                result.append("|   (_)");
                result.append(System.getProperty("line.separator"));
                result.append("|   /|\\");
                result.append(System.getProperty("line.separator"));
                result.append("|");
                result.append(System.getProperty("line.separator"));
                result.append("--------------");
                break;
            case 5:
                result.append("---------");
                result.append(System.getProperty("line.separator"));
                result.append("|    |");
                result.append(System.getProperty("line.separator"));
                result.append("|   (_)");
                result.append(System.getProperty("line.separator"));
                result.append("|   /|\\");
                result.append(System.getProperty("line.separator"));
                result.append("|   /");
                result.append(System.getProperty("line.separator"));
                result.append("--------------");
                break;
            case 6:
                result.append("---------");
                result.append(System.getProperty("line.separator"));
                result.append("|    |");
                result.append(System.getProperty("line.separator"));
                result.append("|   (_)");
                result.append(System.getProperty("line.separator"));
                result.append("|   /|\\");
                result.append(System.getProperty("line.separator"));
                result.append("|   / \\");
                result.append(System.getProperty("line.separator"));
                result.append("--------------");
                break;
        }
        return  result.toString();
    }
    protected static String getMaskWithGuessedChar(Map<Integer, Character> map, String[] str, int index, char ch) {
        for (Map.Entry<Integer, Character> entry : map.entrySet()) {
            if (entry.getValue().equals(ch)) {
                index = entry.getKey();
                str[index] = String.valueOf(ch);
            }
        }
        return Arrays.toString(str);
    }
    protected static String[] getVisibleForPlayerMask(String str){
        String[] visibleForPlayer = new String[str.length()];
        for (int i = 0; i < visibleForPlayer.length; i++) {
            visibleForPlayer[i] = "*";
        }
        return visibleForPlayer;
    }
}
