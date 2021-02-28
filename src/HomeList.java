import java.util.Optional;

public class HomeList<T> implements SimpleList<T>, AuthorHolder {
    private T[] array;
    int size = 0;

//    @SuppressWarnings("unchecked")
//    public HomeList(Class<T> clazz) {
//        this.array = (T[]) Array.newInstance(clazz,size);
//    }

    public HomeList() {
        this.array = (T[])new Object[size];
    }

    @Override
    public String author() {
        return "Елена Титова";
    }

    @Override
    public void add(T item) {
        resize(size+1);
        array[size] = item;
        //System.out.println(array[size]);
        size++;
    }

    @Override
    public void insert(int index, T item) throws Exception {
        array[index] = item;
        //System.out.println(array[index]);
    }

    @Override
    public void remove(int index) throws Exception {
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size-1] = null;
        size--;
        resize(size);
        //System.out.println(array[index]);
    }

    @Override
    public Optional<T> get(int index) {
        return Optional.ofNullable(array[index]);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addAll(SimpleList<T> list) {
        int t = list.size();
        for (int i = 0; i < t; i++) {
            add(list.get(i).get());
        }
    }

    @Override
    public int first(T item) {
        for(int i = 0; i < size; i++) {
            if (array[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int last(T item) {
        for(int i = size - 1; i >= 0; i--) {
            if (array[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (array[i] == item) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                return false;
            }
        }
        return true;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = (T[])newArray;
    }
}
