public class Node {

  public Node(String value) {
    this.value = value;
  }

  private String value;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Node getNextNode() {
    return nextNode;
  }

  public void setNextNode(Node nextNode) {
    this.nextNode = nextNode;
  }

  private Node nextNode;

  public boolean equals(Object o) {
    if (!(o instanceof Node)) {
      return false;
    }

    return ((Node) o).getValue().equals(value);
  }

  public int hashCode() {
    return value.hashCode();
  }

}
