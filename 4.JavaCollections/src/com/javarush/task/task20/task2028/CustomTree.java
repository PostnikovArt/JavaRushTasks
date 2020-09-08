package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable{

    private List<Entry> treeList;
    Entry<String> root;

    public CustomTree() {
        this.root = new Entry<>("0");
        this.treeList = new ArrayList<>();
        treeList.add(root);
    }

    @Override
    public int size() {
        return treeList.size() -1;
    }

    @Override
    public String get(int index) {throw new UnsupportedOperationException();}
    public String set(int index, String element) {throw new UnsupportedOperationException();}
    public void add(int index, String element) {throw new UnsupportedOperationException();}
    public String remove(int index) {throw new UnsupportedOperationException();}
    public List<String> subList(int fromIndex, int toIndex) {throw new UnsupportedOperationException();}
    protected void removeRange(int fromIndex, int toIndex) {throw new UnsupportedOperationException();}
    public boolean addAll(int index, Collection<? extends String> c) {throw new UnsupportedOperationException();}

    public boolean add(String s) {

        for (Entry entry : treeList) {
            if (entry.elementName.equals(s)) return false;
        }

        for (int i = 0; i < treeList.size(); i++) {
            if (treeList.get(i).isAvailableToAddChildren()) {
                Entry<String> newEntry = new Entry<>(s);
                if (treeList.get(i).availableToAddLeftChildren) {
                    treeList.get(i).leftChild = newEntry;
                    newEntry.parent = treeList.get(i);
                    treeList.add(newEntry);
                    return ! ( treeList.get(i).availableToAddLeftChildren = false);
                } else {
                    treeList.get(i).rightChild = newEntry;
                    newEntry.parent = treeList.get(i);
                    treeList.add(newEntry);
                    return ! (treeList.get(i).availableToAddRightChildren = false);
                }
            }
        }
        return false;
    }

    public String getParent(String s) {
        for (int i = 0; i < treeList.size(); i++) {
            if (treeList.get(i).elementName.equals(s)) return treeList.get(i).parent.elementName;
        }
        return null;
    }

    public boolean remove(Object o) {
        if ( ! (o instanceof String)) {
            throw new UnsupportedOperationException();
        }

        Entry<String> buffer = null;

        for (int i = 0; i < treeList.size(); i++) {
            if (treeList.get(i).elementName.equals((String)o)) {
                buffer = treeList.get(i);
                break;
            }
        }

        if (buffer == null) return false;

        if (buffer.parent.leftChild == buffer) {
            buffer.parent.leftChild = null;
            buffer.parent.availableToAddLeftChildren = true;
        } else {
            buffer.parent.rightChild = null;
            buffer.parent.availableToAddRightChildren = true;
        }

        if (buffer.leftChild != null) {
            remove(buffer.leftChild.elementName);

        }
        if (! buffer.availableToAddRightChildren) {

            remove(buffer.rightChild.elementName);
        }

        return treeList.remove(buffer);
    }


    static class Entry<T> implements Serializable{
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren||availableToAddRightChildren;
        }
    }
}
