package dao;


import entities.Customer;
import entities.Item;
import persistence.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ItemDao {

    public void createItem(Item item){
        PersistenceUtil.persist(item);
    }

    public static List<Item> findAllItems() {
        EntityManager em = persistence.PersistenceUtil.createEM();
        List<Item> items = (List<Item>)
                em.createNamedQuery("item.findAll").getResultList();
        em.close();

        return items;
    }
}
