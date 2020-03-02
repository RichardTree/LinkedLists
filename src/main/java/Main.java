import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {


  public static void main(String[] args) throws NoSuchAlgorithmException {

//    MessageDigest md = MessageDigest.getInstance("MD5");
//
//    byte[] hashResult = md.digest("Hello".getBytes());
//
//    boolean[] bitmap = new boolean[256];
//
//    for (boolean b : bitmap) {
//      System.out.println(b?1:0);
//    }

    MySet mySet = new MySet();
    try {
      mySet.fillWordArray();
    } catch (IOException e) {
      e.printStackTrace();
    }
    mySet.add("test");
    mySet.add("attested");
    System.out.println(mySet.contains("test"));
    System.out.println(mySet.contains("xjsdsdsdsdsdsdsdks"));
    System.out.println(mySet.contains("attested"));

  }

//  public static void main(String[] args) {
//    LinkedList linkedList = new LinkedList();
//
//    linkedList.addNode("One");
//    linkedList.addNode("Two");
//    linkedList.addNode("Three");
//    linkedList.addNode("Four");
//
//    if (linkedList.contains("Three"))
//    {
//      System.out.println("YES - It contains 3");
//    }
//
//    System.out.println("Node at index 2 before delete:"+ linkedList.getNodeFromIndex(2).getValue());
//    linkedList.deleteNodeFromIndex(2);
//    System.out.println("Node at index 2 after delete:"+ linkedList.getNodeFromIndex(2).getValue());
//
//    System.out.println(linkedList.returnAsArray().get(0).getValue());
//    System.out.println(linkedList.returnAsArray().get(1).getValue());
//    System.out.println(linkedList.returnAsArray().get(2).getValue());
//    System.out.println(linkedList.returnAsArray().get(3).getValue());
//    System.out.println(linkedList.returnAsArray().get(4).getValue());
//
//  }
}
