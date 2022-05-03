public class Main {
    public static void main(String[] args) {
        MyHeap_MyArrayList arrstack = new MyHeap_MyArrayList<Integer>();
        MyHeap_MyLinkedList linkedstack = new MyHeap_MyLinkedList<Integer>();

        arrstack.add(1);
        arrstack.add(2);
        arrstack.add(3);

        linkedstack.add(1);
        linkedstack.add(2);
        linkedstack.add(3);

        System.out.println(arrstack.remove(2));
        System.out.println(linkedstack.remove(2));

    }
}
