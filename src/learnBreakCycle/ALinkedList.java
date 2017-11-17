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
        for (Node pred = null, q = nodes, s; q != null; q = s) {//q�ǻᱻunlink�Ľڵ㣬s��q����һ���ڵ㣬pred��q��ǰһ���ڵ�
          s = q.next;//ÿѭ���Ƴ���q��s���������ƶ�һ���ڵ�
          if (q.id != null)//��⵱ǰqָ��Ľڵ��ǲ����Ǹ���Ҫ���Ƴ��Ľڵ�
            pred = q;//q�����Ǹ���Ҫ���Ƴ��Ľڵ㣬����pred��֮��q�����ƶ���pred��֤�ܹ�ָ�򽫱��Ƴ��Ľڵ��ǰһ���ڵ�
          else if (pred != null) {
            pred.next = s;//����Ҫ�Ƴ��Ľڵ����м��ʱ�򣬻��ߵ����ʹ��ǰһ���ڵ��nextָ���һ���ڵ㣬���Ƴ��ɹ�
            if (pred.id == null) // check for race//���������ڵĽڵ�ͬʱ��Ҫ���Ƴ������־���������£����ȳɹ������������￿ǰ�Ľڵ㣬������Ҫ���ǰһ���ڵ��ǲ���Ҳͬʱ�ڽ����Ƴ�����
              continue retry;
          } else if (!compareAndSwapObject(q, s)) //����ͷ�Ľڵ�����Ҫ���Ƴ��Ľڵ�ʱ���ߵ����if�����
              continue retry;

        }
        break;
      }
    }
  }

  /**
   * ģ��ԭ���Բ�����������������
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
