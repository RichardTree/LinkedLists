import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Search {

  public static final List<String> getWordsArray() {
    return words;
  }

  public static final List<String> words = new ArrayList<>();

  public static void main(String[] args) {

    ///fills up array
    try {
      fillWordArray();
    }
    catch (IOException e) {
      System.out.println(e);
    }


    long averageTimeTakenForLinearSearch = 0;
    long averageTimeTakenForBinarySearch = 0;

    ///generates random element in the words array
    for (int i = 0; i<1000; i++){

      Random random = new Random();
      int randomWordIndex = random.nextInt(getWordsArray().size());

      long startTime = System.currentTimeMillis();
      linearSearch(getWordsArray(), getWordsArray().get(randomWordIndex));
      averageTimeTakenForLinearSearch += (System.currentTimeMillis() - startTime);

      startTime = System.currentTimeMillis();
      binarySearch(getWordsArray(), getWordsArray().get(randomWordIndex));
      averageTimeTakenForBinarySearch += (System.currentTimeMillis() - startTime);
    }

    System.out.println("Time taken for Linear Search (milliseconds)"+averageTimeTakenForLinearSearch);
    System.out.println("Time taken for Binary Search (milliseconds)"+averageTimeTakenForBinarySearch);

  }

  static boolean binarySearch(List<String> wordsArray, String wordToBeSearched)
  {
    int left = 0, right = wordsArray.size() - 1;
    while (left <= right) {
      int midPoint = left + (right - left) / 2;

      int result = wordToBeSearched.compareTo(wordsArray.get(midPoint));

      if (result == 0)
        return true;

      if (result > 0)
        left = midPoint + 1;

      else
        right = midPoint - 1;
    }
    return false;
  }

  public static boolean linearSearch (List<String> wordsArray, String wordToBeSearched) {
    for (String word: wordsArray) {
      if(wordToBeSearched.equals(word)){
        return true;
      }
    }
    return false;
  }

  public static void fillWordArray() throws IOException
  {
    URL url = new URL("https://raw.githubusercontent.com/CorndelWithSoftwire/SearchAlgorithms-Java/master/words");
    try (BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(url.openStream()))) {

      StringBuilder stringBuilder = new StringBuilder();

      String inputLine;
      while ((inputLine = bufferedReader.readLine()) != null) {
        words.add(inputLine);
        stringBuilder.append(inputLine);
      }
    }
  }
}
