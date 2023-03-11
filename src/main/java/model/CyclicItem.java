package model;

public class CyclicItem<T, R> {
    public CyclicItem next = null;
    public CyclicItem priviouse = null;
    public T o;
    public R base;
    public CyclicItem(){
        this.next = this;
    }
}
