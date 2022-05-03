public class MyQueue_MyLinkedList<T> {
    private MyLinkedList<T> linkedlist;

    public MyQueue_MyLinkedList(){
        linkedlist = new MyLinkedList<T>();
    }

    public boolean empty(){
        if(linkedlist.size() == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return linkedlist.size();
    }

    public T peek(){
        return linkedlist.get(0);
    }

    public void enqueue(T item){
        linkedlist.add(item);
    }

    public T dequeue(){
        return linkedlist.remove(0);
    }
}