import java.util.ArrayList;
import java.util.List;

public class LinkedList {

  private Node firstNode = new Node("Zero");

  public boolean contains(String o) {

    if (firstNode.getValue().equals(o)) {
      return true;
    }

    Node nextNode = firstNode.getNextNode();
    while (nextNode != null) {
      if (nextNode.getValue().equals(o)) {
        return true;
      }
      nextNode = nextNode.getNextNode();
    }
    return false;

  }

  public Node getNodeFromIndex(int index) {
    if (index == 0) {
      return firstNode;
    }
    int i = 1;
    Node nextNode = firstNode.getNextNode();
    while (nextNode != null) {
      if (i == index) {
        return nextNode;
      }
      nextNode = nextNode.getNextNode();
      i++;
    }
    return null;
  }

  public void deleteNodeFromIndex(int index) {

    //node index 0
    if (index == 0) {
        try {
          firstNode = firstNode.getNextNode();
        }catch (NullPointerException e) {
          System.out.println("There is no node in position:" + index);
        }
    }

    int i = 1;
    Node nextNode = firstNode.getNextNode();
    Node previousNode = firstNode;
    while (nextNode != null){
//node index 1
      if (index == 1){
        try {
          firstNode.setNextNode(nextNode.getNextNode());
          break;
        }catch (NullPointerException e){
          System.out.println("There is no node in position:" + index);
        }
      }
// every other node index
      if (i == index) {
        try {
          previousNode.setNextNode(nextNode.getNextNode());
        }catch (NullPointerException e) {
          System.out.println("There is no node in position:" + index);
        }
      }
      i++;
      previousNode = nextNode;
      nextNode = nextNode.getNextNode();
    }
  }

  public List<Node> returnAsArray () {
    List<Node> array = new ArrayList<>();

    array.add(firstNode);
    Node nextNode = firstNode.getNextNode();
    while (nextNode != null){
      array.add(nextNode);
      nextNode = nextNode.getNextNode();
    }
    return array;
  }

  public void addNode(String value) {
    if (firstNode.getNextNode() == null) {
      firstNode.setNextNode(new Node(value));
    } else {

      Node nextNode = firstNode.getNextNode();

      while (nextNode != null) {
        if (nextNode.getNextNode() == null) {
          nextNode.setNextNode(new Node(value));
          break;
        }
        nextNode = nextNode.getNextNode();
      }
    }
  }
}
