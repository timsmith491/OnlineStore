package RestApi;

import dao.ItemDao;
import entities.Customer;
import entities.Item;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/item")
public class ItemApi {

    ItemDao itemDao = new ItemDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<Item> findAllItems(){

        return itemDao.findAllItems();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public String addItem(){
        Item item = new Item();
        item.setTitle("Madone 2.1");
        item.setManufacturer("Trek");
        item.setPrice(1600.00);
        item.setCategory("Road");
        item.setImage("No Image");
        item.setStockLevel(10);
        item.setRating(5);

        itemDao.createItem(item);
        return "success";
    }
}
