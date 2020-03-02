import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MySet {

  List<String> contents = new ArrayList<>();
  MyBloomFilter bloomFilter = new MyBloomFilter();

  public void fillWordArray() throws IOException {
//    List<String> words = new ArrayList<>();

      BufferedReader br = new BufferedReader(new FileReader("/Users/rtree/workspace/Algorithms/src/main/resources/wordlist.txt"));


    StringBuilder stringBuilder = new StringBuilder();

    String inputLine;
    while ((inputLine = br.readLine()) != null) {
      this.add(inputLine);
      stringBuilder.append(inputLine);
    }

  }

  public void add(String value) {
    contents.add(value);
    bloomFilter.add(value);
  }

  public boolean contains(String value) {
    return bloomFilter.contains(value);
  }
}
