public class MyLinkedList<T> implements MyList<T>{

    private int length = 0;
    private MyNode<T> head, tail;

    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    public void add(T item) {
        MyNode<T> newNode = new MyNode<T>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void add(T item, int index) {

        //Works like a setter
        //Sets a new value to an element under a particular index

        if(index < length && index >= 0){
            MyNode<T> node = head;
            for(int i = 0; i < index; i++){
                node = node.next;
            }
            node.data = item;
        }else{
            System.out.println("Index out of range");
        }
    }

    @Override
    public boolean remove(T item) {
        if(contains(item)){
            MyNode<T> node = head;
            for(int i = 0; i < length; i++){
                if(node.data.equals(item)){
                    if(i > 0 && i < length - 1) {
                        node.prev.next = node.next;
                        node.next.prev = node.prev;
                        return true;
                    } else if(i == 0) {
                        node.next.prev = null;
                        head = node.next;
                        return true;
                    } else if(i == length - 1) {
                        node.prev.next = null;
                        tail = node.prev;
                        return true;
                    }
                    length--;
                }
                if(i != length - 1) {
                    node = node.next;
                }
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if(index < length && index >= 0){
            MyNode<T> node = head;
            for(int i = 0; i <= index; i++){
                if(i == index) {
                    if(i > 0 && i < length - 1) {
                        node.prev.next = node.next;
                        node.next.prev = node.prev;
                    } else if(i == 0) {
                        node.next.prev = null;
                        head = node.next;
                    } else if(i == length - 1) {
                        node.prev.next = null;
                        tail = node.prev;
                    }
                    length--;
                }
                if(i != index) {
                    node = node.next;
                }
            }
            return node.data;
        }
        System.out.println("Index out of range");
        return null;
    }

    @Override
    public void clear() {
        head = null;
    }

    public T get(int index) {
        if(index < length && index >= 0){
            MyNode<T> node = head;

            for(int i = 0; i <= index; i++){
                if(i == index) {
                    return node.data;
                }
                if(i != index) {
                    node = node.next;
                }
            }
        }
        System.out.println("Index out of range");
        return null;
    }

    @Override
    public int indexOf(Object o) {
        if(contains(o)){
            MyNode<T> node = head;
            for(int i = 0; i < length; i++){
                if(node.data.equals(o)){
                    return i;
                }
                if(i != length - 1) {
                    node = node.next;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if(contains(o)){
            MyNode<T> node = tail;
            for(int i = length - 1; i >= 0; i--){
                if(node.data.equals(o)){
                    return i;
                }
                if(i > 0) {
                    node = node.prev;
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
        T base = (T) get(middle);

        int i = 0, j = length - 1;
        while (i <= j) {
            while (((Comparable) get(i)).compareTo(base) < 0) {
                i++;
            }

            while (((Comparable) get(j)).compareTo(base) > 0) {
                j--;
            }

            if (i <= j) {
                T temp = (T) get(i);
                //arr[i] = arr[j];
                add(get(j), i);
                //arr[j] = temp;
                add(temp, j);
                i++;
                j--;
            }
        }
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        MyNode<T> node = head;
        for(int i = 0; i < length; i++){
            if(node.data.equals(o)){
                return true;
            }
            if(i != length - 1) {
                node = node.next;
            }
        }
        return false;
    }

}