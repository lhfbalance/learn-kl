/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnBreakCycle;

import java.util.Random;

/**
 * @author LouHF
 *
 */
public class ALinkedList {

  static int id = 0;

  static Node nodes = new Node();


  static final class Node {
    String id;
    Node next;

    public Node() {
      this.id = String.valueOf(ALinkedList.id++);
    }
  }

  static void addNode(Node node) {
    node.next = nodes;
    nodes = node;
  }


  static void remove(Node node) {
    int retry = 0;
    if (node != null) {
      node.id = null;
      retry: for (;;) { // restart on removeWaiter race
        System.out.println(retry++);
        for (Node pred = null, q = nodes, s; q != null; q = s) {//q是会被unlink的节点，s是q的下一个节点，pred是q的前一个节点
          s = q.next;//每循环移除，q和s都会向下移动一个节点
          if (q.id != null)//检测当前q指向的节点是不是那个需要被移除的节点
            pred = q;//q不是那个需要被移除的节点，更新pred，之后q会下移动，pred保证能够指向将被移除的节点的前一个节点
          else if (pred != null) {
            pred.next = s;//当需要移除的节点在中间的时候，会走到这里，使用前一个节点的next指向后一个节点，即移除成功
            if (pred.id == null) // check for race//有两个相邻的节点同时需要被移除，这种竞争的情况下，优先成功的是链表里里靠前的节点，所以需要检测前一个节点是不是也同时在进行移除操作
              continue retry;
          } else if (!compareAndSwapObject(q, s)) //当表头的节点是需要被移除的节点时会走到这个if语句中
              continue retry;

        }
        break;
      }
    }
  }

  /**
   * 模拟原子性操作，交换两个对象
   */
  static boolean compareAndSwapObject(Node n1, Node n2) {
    Random random = new Random();
    boolean result = random.nextBoolean();
    System.out.println(result);
    if (result) {
      n1.next = n2.next;
      n1.id = n2.id;
    }
    return result;
  }

  public static void main(String[] args) {
    Node node1 = new Node();
    ALinkedList.addNode(node1);
    Node node2 = new Node();
    ALinkedList.addNode(node2);
    Node node3 = new Node();
    ALinkedList.addNode(node3);

    ALinkedList.remove(node3);
    
    System.out.println("over");

  }

}
