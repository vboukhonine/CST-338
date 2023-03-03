import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Markov {
    private final static String PUNCTUATION = "__$"; // it's a key
    private final static String PUNCTUATION_MARKS = "!?.";
    private HashMap<String, ArrayList<String>> words;
    private String prevWord;

    Markov() {
        ArrayList<String> list = new ArrayList<>();
        words = new HashMap<String, ArrayList<String>>();
        words.put(PUNCTUATION, list);
        prevWord = PUNCTUATION;
    }

    HashMap<String, ArrayList<String>> getWords() {
        return words;
    }

    public void addFromFile(String filename) {
        addLine(filename);
    }

    void addLine(String filename) {
        try {
            List<String> lines = Files.readAllLines(Path.of(filename));
            String temp;
            String[] myWords;
            for (String line : lines) {
                if (line.trim().isEmpty()) {
                    continue;
                }
            }
            lines.removeAll(Collections.singleton(""));
            for (int i = 0; i < lines.size(); i++) {
                temp = lines.get(i);
                temp = temp.trim();
                if (!temp.isEmpty()) {
                    myWords = temp.split("\\s");
                    for (int j = 0; j < myWords.length; j++) {
                        addWord(myWords[j]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //ϞϞ(๑⚈ ․̫ ⚈๑)
    void addWord(String word) {
        ArrayList<String> list = new ArrayList<>();
        String temp = "";
        temp = prevWord;
        prevWord = word;
        boolean tryIt;
        tryIt = endsWithPunctuation(word);
        try {
            if (word != "") {
                if (tryIt) {
                    words.remove("");
                    if (words.containsKey(PUNCTUATION)) {
                        words.get(PUNCTUATION).add(word);
                    } else {
                        System.out.println("error");
                    }

                } else {
                    if (!words.containsKey(word)) {
                        prevWord = word;
                        words.put(word, list);
                        if (words.get(temp) != null) {
                            words.get(temp).add(prevWord);
                        }

                    } else {
                        if (words.containsKey(temp)) {
                            words.get(temp).add(prevWord);
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    public String getSentence() {
        List<String> keyList = new ArrayList<>(words.keySet());
        int size = keyList.size() - 1;
        String currentWord;
        String myString = "";
        currentWord = getRandomWord(PUNCTUATION);
        boolean tryIt = endsWithPunctuation(currentWord);

        for (int i = 0; i < 10; i++) {
            int randIdx = new Random().nextInt(size);
            String randomKey = keyList.get(randIdx);
            currentWord = getRandomWord(randomKey);
            if (tryIt) {
//                currentWord = currentWord.replaceAll("\\.", "");
                myString += currentWord+" ";
            }
            currentWord = getRandomWord(randomKey);
            if (!tryIt) {
                myString += currentWord + " ";
//                currentWord = getRandomWord(randomKey);
            }

        }
        String output = myString.substring(0, 1).toUpperCase() + myString.substring(1).toLowerCase();
        output = output.trim() + ".";
        return output;
    }

    String getRandomWord(String word) {
        String randomKey = word;
        ArrayList<String> randomValue = words.get(randomKey);
        int index = (int) (Math.random() * randomValue.size());
        if (index < randomValue.size())
            word = randomValue.get(index);
        return word;
    }

    public boolean endsWithPunctuation(String word) {
        char[] chars = PUNCTUATION_MARKS.toCharArray();

        for (int j = 0; j < word.length(); j++) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == word.charAt(j)) {
                    return true; // Char exists in array
                }
            }
        }
        return false;  // Char does not exist in  array
    }

    @Override
    public String toString() {
        String temp = "";
        for (String key : words.keySet()) {
            temp = key + " = " + words.get(key);
            System.out.println(key + " = " + words.get(key));
        }
        return temp;
    }

}
