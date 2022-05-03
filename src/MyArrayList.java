public class MyArrayList<T>  implements MyList<T>{
    private Object[] arr;
    private int length = 0;
    private int capacity = 3;

    public MyArrayList() {
        arr = new Object[capacity];
    }

    @Override
    public void add(T item) {
        if (length == capacity)
            increaseCapacity();

        arr[length] = item;
        length++;
    }

    @Override
    public void add(T item, int index) {
        if(index < capacity){
            arr[index] = item;
        }else{
            System.out.println("Index out of range");
        }
    }

    @Override
    public boolean remove(T item) {
        if(contains(item)){
            Object[] old = arr;
            int oldlength = length;
            int target = indexOf(item);
            arr = new Object[capacity];
            length = 0;
            for(int i = 0; i < oldlength; i++){
                if(i != target) {
                    add((T) old[i]);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if(index < length && index >= 0){
            Object[] old = arr;
            int oldlength = length;
            arr = new Object[capacity];
            length = 0;
            for(int i = 0; i < oldlength; i++){
                if(i != index) {
                    add((T) old[i]);
                }
            }
            return (T) old[index];
        }
        System.out.println("Index out of range");
        return null;
    }

    @Override
    public void clear() {
        length = 0;
        capacity = 3;
        arr = new Object[capacity];
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];

        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }

    @Override
    public T get(int index) {
        if(index < length && index >= 0) {
            return (T) arr[index];
        }
        System.out.println("Index out of range");
        return null;
    }

    @Override
    public int indexOf(Object o) {
        if(contains(o)) {
            for (int i = 0; i < length; i++) {
                if (o.equals(arr[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if(contains(o)) {
            for (int i = length - 1; i >= 0; i--) {
                if (o.equals(arr[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void sort() {
        //QuickSort Algorithm
        if (length == 0)
            return;

        int middle = (length - 1) / 2;
        T base = (T) arr[middle];

        int i = 0, j = length - 1;
        while (i <= j) {
            while (((Comparable) arr[i]).compareTo(base) < 0) {
                i++;
            }

            while (((Comparable) arr[j]).compareTo(base) > 0) {
                j--;
            }

            if (i <= j) {
                T temp = (T) arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < length; i++){
            if(o.equals(arr[i])){
                return true;
            }
        }
        return false;
    }
}