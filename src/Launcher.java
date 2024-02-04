import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Launcher {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char ch;
        String str;
        boolean isPlaying = false;
        System.out.println("Введите \"и\" чтобы начать игру заново или \"в\", чтобы выйти из игры");
        str = br.readLine();
        if(str.equals("в")){
            System.out.println("Вы вышли из игры");
        }
        else if( str.equals("и")){
            isPlaying = true;
        }
        else {
            System.out.println("Введите \"и\" чтобы начать игру заново или \"в\", чтобы выйти из игры");
        }
        while (isPlaying) {
            Map<Character, Integer> map = new HashMap<>();
            Map<Integer, Character> guessedWord = new HashMap<>();
            Set<Character> wrongChars = new HashSet<>();
            String word = Dictionary.getWord();
            String[] visibleForPlayer = Image.getVisibleForPlayerMask(word);
            System.out.println("Отгадайте слово: ");
            System.out.println(Arrays.toString(visibleForPlayer));
            for (int i = 0; i < word.length(); i++) {
                char value = word.charAt(i);
                guessedWord.put(i, value);
            }
            for (int i = 0; i < word.length(); i++) {
                char key = word.charAt(i);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int wordsKey = 0;
            int count = 0;
            while (!map.isEmpty() && count < 6) {
                ch = (char) br.read();
                if (Character.isWhitespace(ch)) {
                    continue;
                } else if (map.containsKey(ch) && Checks.isCharValid(ch) && !Checks.ifCharAlreadyGuessed(ch, visibleForPlayer)) {
                    if (map.get(ch) == 1) {
                        map.remove(ch);
                        System.out.println("Правильно! " + " Отгаданная буква " + ch + " Слово " + Image.getMaskWithGuessedChar(guessedWord, visibleForPlayer, wordsKey, ch));
                        System.out.println(Image.getImage(count));
                    } else {
                        while (map.get(ch) != 0) {
                            map.put(ch, map.get(ch) - 1);
                            Image.getMaskWithGuessedChar(guessedWord, visibleForPlayer, wordsKey, ch);
                        }
                        map.remove(ch);
                        System.out.println("Правильно! " + " Отгаданная буква " + ch + " Слово " + Image.getMaskWithGuessedChar(guessedWord, visibleForPlayer, wordsKey, ch));
                        System.out.println(Image.getImage(count));

                    }

                } else if (Checks.isCharValid(ch) && Checks.ifCharAlreadyGuessed(ch, visibleForPlayer)) {
                    System.out.println("Эту букву в слове вы уже угадали");
                } else if (Checks.isCharValid(ch) && !Checks.ifCharAlreadyGuessed(ch, visibleForPlayer) && wrongChars.add(ch)) {
                    count++;
                    System.out.println("Количество ошибок: " + count + " Неправильная буква  " + ch);
                    System.out.println(Image.getImage(count));

                } else if (Checks.isCharValid(ch) && !wrongChars.add(ch)) {
                    System.out.println("Эту букву вы уже писали, она не подходит");
                } else {
                    System.out.println("Вводите только буквы русского алфавита");
                }
            }
            if (visibleForPlayer.equals(word)) {
                System.out.println("Вы победили! Введите \"и\" чтобы начать игру или \"в\", чтобы выйти из игры ");
                str = br.readLine();
                while (!Checks.checkInput(str) && !str.equals("в")) {
                    System.out.println("Введите \"и\" чтобы начать игру или \"в\", чтобы выйти из игры ");
                    str = br.readLine();
                }
                if (Checks.checkInput(str)) {
                    continue;
                } else {
                    isPlaying = false;
                    break;
                }
            } else {
                System.out.println("Вы проиграли! Введите \"и\" чтобы начать игру заново или \"в\", чтобы выйти из игры ");
                System.out.println("Загаданное слово: " + word);
                System.out.println("количество ошибок: " + count);
                str = br.readLine();
                while (!Checks.checkInput(str) && !str.equals("в")) {
                    System.out.println("Введите \"и\" чтобы начать игру или \"в\", чтобы выйти из игры ");
                    str = br.readLine();
                }
                if (Checks.checkInput(str)) {
                    continue;
                } else {
                    isPlaying = false;
                    break;
                }
            }
        }
    }


}
