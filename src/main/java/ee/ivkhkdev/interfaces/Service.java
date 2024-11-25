package ee.ivkhkdev.interfaces;

import java.util.List;

public interface Service<T> {
    boolean add();
    boolean edit();
    boolean print();
    List<T> list();
    void printList();
    int size();
    T get(T j);
}
