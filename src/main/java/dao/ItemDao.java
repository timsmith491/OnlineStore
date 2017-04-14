package dao;



import entities.Customer;
import entities.Item;
import interfaces.ItemDaoInterface;
import persistence.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ItemDao implements ItemDaoInterface{

    public void createItem(Item item){
        PersistenceUtil.persist(item);
    }

    public List<Item> findAllItems() {
        EntityManager em = persistence.PersistenceUtil.createEM();
        List<Item> items = (List<Item>)
                em.createNamedQuery("Item.findAll").getResultList();
        em.close();

        return items;
    }

    public Item findById(int id) {
        EntityManager em = PersistenceUtil.createEM();
        List<Item> items = (List<Item>)
                em.createNamedQuery("Item.findById").setParameter("id", id).getResultList();

        em.close();
        if(items.size() > 0 ){
            return items.get(0);
        }
        else{
            return null;
        }

    }
}
