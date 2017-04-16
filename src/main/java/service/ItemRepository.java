package service;


import dao.ItemDao;
import entities.Item;

import java.util.List;

public class ItemRepository implements Container {

    private ItemDao itemDao;

    private final List<Item> items = itemDao.findAllItems();

    @Override
    public Iterator getIterator() {
        return new ItemIterator();
    }

    private class ItemIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {

            if(index < items.size()){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if(this.hasNext()){
                return items.get(index++);
            }
            return null;
        }
    }
}