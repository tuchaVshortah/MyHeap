public class MyStack_MyLinkedList<T> {

    private MyLinkedList<T> linkedlist;

    public MyStack_MyLinkedList(){
        linkedlist = new MyLinkedList();
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
        return linkedlist.get(linkedlist.size() - 1);
    }

    public void push(T item){
        linkedlist.add(item);
    }

    public T pop(){
        return linkedlist.remove(linkedlist.size() - 1);
    }
}