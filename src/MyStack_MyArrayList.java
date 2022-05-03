public class MyStack_MyArrayList<T> {

    private MyArrayList<T> arraylist;

    public MyStack_MyArrayList(){
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
        return arraylist.get(arraylist.size() - 1);
    }

    public void push(T item){
        arraylist.add(item);
    }

    public T pop(){
        return arraylist.remove(arraylist.size() - 1);
    }
}
