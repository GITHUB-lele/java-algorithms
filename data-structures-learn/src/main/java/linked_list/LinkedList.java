package linked_list;



public class LinkedList<E> implements List<E> {
    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;

    public LinkedList() {
    }

    void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l,e,null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }
    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean addFirst(E e) {
        linkFirst(e);
        return true;
    }

    @Override
    public boolean addLast(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first;x != null;x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        }else {
            for(Node<E> x = first;x != null;x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }
    E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> prev = x.prev;
        final Node<E> next = x.next;
        if (prev == null)
            first = next;
        else
            prev.next = next;
        if (next == null)
            last = prev;
        else
            next.prev = prev;
        x.item = null;
        size--;
        return element;
    }
    @Override
    public E get(int index) {
        return node(index);
    }

    private E node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x.item;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x.item;
        }
    }

    @Override
    public void printLinkList() {
        if (this.size == 0){
            System.out.println("链表为空");

        }
        else {
            int i = 1;
            for(Node<E> x = first;x != null;x = x.next) {
                System.out.println("节点:" + i++ + "  值:" + x.item);
            }
        }

    }

    /**
     * ？表示不确定的 java 类型
     * T (type) 表示具体的一个java类型
     * K V (key value) 分别代表java键值中的Key Value
     * E (element) 代表Element
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
        public Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

    }
}
