import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyBloomFilter {

  boolean[] bitVector = new boolean[1073527];

  public void add(String value) {
    MessageDigest messageDigest = null;
    try {
      messageDigest = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    byte [] hashResult = messageDigest.digest(value.getBytes());

    bitVector[hashResult[0]+128] = true;
  }

  public boolean contains(String value) {
    MessageDigest messageDigest = null;
    try {
      messageDigest = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    byte [] hashResult = messageDigest.digest(value.getBytes());

    return bitVector[hashResult[0]+128];
  }
}
