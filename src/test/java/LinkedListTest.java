import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.*;

import static org.hamcrest.core.Is.is;

import java.util.List;
import org.junit.Test;

public class LinkedListTest extends Object {


  @Test
  public void contains() {

    LinkedList linkedList = new LinkedList();

    linkedList.addNode("One");
    linkedList.addNode("Two");
    linkedList.addNode("Three");
    linkedList.addNode("Four");

    assertThat(linkedList.contains("One"), is(true));
  }

  @Test
  public void getNodeFromIndex() {

    LinkedList linkedList = new LinkedList();

    linkedList.addNode("One");
    linkedList.addNode("Two");
    linkedList.addNode("Three");
    linkedList.addNode("Four");

    assertThat(linkedList.getNodeFromIndex(1).getNextNode().getValue(), is("Two"));

    assertThat(linkedList.getNodeFromIndex(1), is(new Node("One")));
  }

  @Test
  public void deleteNodeFromIndex() {

    LinkedList linkedList = new LinkedList();

    linkedList.addNode("One");
    linkedList.addNode("Two");
    linkedList.addNode("Three");
    linkedList.addNode("Four");

    linkedList.deleteNodeFromIndex(3);

    assertThat(linkedList.getNodeFromIndex(2).getNextNode().getValue(), is("Four"));
  }

  @Test
  public void returnAsArray() {

    LinkedList linkedList = new LinkedList();

    linkedList.addNode("One");
    linkedList.addNode("Two");
    linkedList.addNode("Three");
    linkedList.addNode("Four");

    List<Node> nodes = linkedList.returnAsArray();

    assertThat(nodes.size(), is(5));
    assertThat(nodes, hasItem(new Node("Zero")));
    assertThat(nodes, hasItem(new Node("One")));
    assertThat(nodes, hasItem(new Node("Two")));
    assertThat(nodes, hasItem(new Node("Three")));
    assertThat(nodes, hasItem(new Node("Four")));
  }
}