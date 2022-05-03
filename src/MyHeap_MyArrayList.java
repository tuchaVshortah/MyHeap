public class MyHeap_MyArrayList<T> {
    private MyArrayList arraylist;

    public MyHeap_MyArrayList(){
        arraylist = new MyArrayList();
    }

    public void add(T item){
        arraylist.add(item);
        heapify();
    }

    public T removeRoot(){
        return (T) arraylist.remove(0);
    }

    public boolean remove(T item){
        return arraylist.remove(item);
    }

    private void heapify(){
        arraylist.sort();
    }
}
