package linked_list;


import org.junit.Test;

import java.util.ArrayList;

public class LinkedListTest {

    @Test
    public void test_linked_list() {
        LinkedList<String> list = new LinkedList<>();
        list.linkFirst("a");
        list.linkLast("b");
        list.linkLast("c");
        list.linkFirst("d");
        list.printLinkList();
        System.out.println("------------------------");
        String s = list.get(1);
        System.out.println(s);
        System.out.println("------------------------");
        list.printLinkList();
        list.remove("b");
        System.out.println("------------------------");
        list.printLinkList();
    }
    @Test
    public void test_linked_list2() {
        LinkedList<Integer> list = new LinkedList<>();
        list.linkFirst(1);
        list.linkLast(2);
        list.linkLast(3);
        list.linkFirst(4);
        list.printLinkList();
        System.out.println("------------------------");
        Integer s = list.get(1);
        System.out.println(s);
        System.out.println("------------------------");
        list.printLinkList();
        list.remove(4);
        System.out.println("------------------------");
        list.printLinkList();
    }
    @Test
    public void test_linked_list3() {
        new ArrayList<>();
        new LinkedList<>();
    }
}
