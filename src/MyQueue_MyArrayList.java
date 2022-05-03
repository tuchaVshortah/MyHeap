public class MyQueue_MyArrayList<T> {

    private MyArrayList<T> arraylist;

    public MyQueue_MyArrayList(){
        arraylist = new MyArrayList();
    }

    public boolean empty(){
        if(arraylist.size() == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return arraylist.size();
    }

    public T peek(){
        return arraylist.get(0);
    }

    public void enqueue(T item){
        arraylist.add(item);
    }

    public T dequeue(){
        return arraylist.remove(0);
    }
}
