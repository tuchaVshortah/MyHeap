public class MyHeap_MyLinkedList<T> {
    private MyLinkedList linkedlist;

    public MyHeap_MyLinkedList(){
        linkedlist = new MyLinkedList<T>();
    }

    public void add(T item){
        linkedlist.add(item);
        heapify();
    }

    public T removeRoot(){
        return (T) linkedlist.remove(0);
    }

    public boolean remove(T item){
        return linkedlist.remove(item);
    }

    private void heapify(){
        linkedlist.sort();
    }
}