public class Main {


  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();

    linkedList.addNode("One");
    linkedList.addNode("Two");
    linkedList.addNode("Three");
    linkedList.addNode("Four");

    if (linkedList.contains("Three"))
    {
      System.out.println("YES - It contains 3");
    }

    System.out.println("Node at index 2 before delete:"+ linkedList.getNodeFromIndex(2).getValue());
    linkedList.deleteNodeFromIndex(2);
    System.out.println("Node at index 2 after delete:"+ linkedList.getNodeFromIndex(2).getValue());

    System.out.println(linkedList.returnAsArray().get(0).getValue());
    System.out.println(linkedList.returnAsArray().get(1).getValue());
    System.out.println(linkedList.returnAsArray().get(2).getValue());
    System.out.println(linkedList.returnAsArray().get(3).getValue());
    System.out.println(linkedList.returnAsArray().get(4).getValue());

  }
}
