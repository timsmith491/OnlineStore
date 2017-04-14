package interfaces;

import entities.Item;

import java.util.List;

/**
 * Created by Tim on 14/04/2017.
 */
public interface ItemDaoInterface {

    void createItem (Item item);

    List<Item> findAllItems();

    Item findById(int id);
}
