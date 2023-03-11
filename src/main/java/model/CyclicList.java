package model;

import java.awt.*;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class CyclicList<T extends Feature, R extends Recta> {
    CyclicItem<T, R> begin = null;
    CyclicItem<T, R> end = null;
    public int size = 0;

    public CyclicList(int size){
        if(size == 0) return;
        this.size = size;
        CyclicItem cur = new CyclicItem<>();
        begin = cur;
        for(int i=0; i<this.size-1;  i++) {
            cur.next = new CyclicItem<>();
            cur = cur.next;
        };
        cur.next = begin;
        end = begin;
    }
    public void fillNodes(List<R> nodeList){
        if(size == 0 || (begin == end.next && begin.o != null)) return; //full buffer or nullable buffer
        CyclicItem<T, R> curr = begin.next;
        CyclicItem<T, R> en = begin;
        Iterator<R> iter = nodeList.iterator();
        while (curr != en && iter.hasNext()){
            curr.base = iter.next();
            System.out.println("base = " + curr.base.toString());
            curr = curr.next;
        }
    }

    public void push(T o){
        if(size == 0 || (begin == end.next && begin.base != null)) return; //full buffer or nullable buffer
        end = end.next;
        if(end.base != null)
        end.base.setColor(o.color);
        end.o = o;
    }

    public void print(){
        CyclicItem cur = begin;
        do{
            cur = cur.next;
            System.out.println(cur.o.toString());
        }while(end != cur);
    }

    void forEach(Consumer<T> action) {
        Objects.requireNonNull(action);
        CyclicItem<T, R> curr = begin.next;
        CyclicItem<T, R> en = end.next;
        while (curr != en){
            action.accept(curr.o);
            curr = curr.next;
        }
    }

    void forEachNode(Consumer<R> action) {
        Objects.requireNonNull(action);
        CyclicItem<T, R> curr = begin.next;
        CyclicItem<T, R> en = begin;
        while (curr != en){
            action.accept(curr.base);
            curr = curr.next;
        }
    }

    public T pop(){
        if(size == 0 || (end == begin)) return null;
        T ob = begin.o;
        if(begin.base != null)
        begin.base.setColor(Color.RED);
        begin.o = null;
        begin = begin.next;
        return ob;
    }

    public int getNumber(){
        int count = 0;
        CyclicItem<T, R> curr = begin;
        CyclicItem<T, R> en = end;
        while (curr != en){
            count++;
            curr = curr.next;
        }
        return count;
    }

    public T getBegin (){
        return begin.o;
    }
}
