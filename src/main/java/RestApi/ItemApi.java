package RestApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ItemDao;
import entities.Item;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
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


//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/add")
//    public String addItem(){
//        Item item = new Item();
//        item.setTitle("Madone 2.1");
//        item.setManufacturer("Trek");
//        item.setPrice(1600.00);
//        item.setCategory("Road");
//        item.setImage("No Image");
//        item.setStockLevel(10);
//        item.setRating(5);
//
//        itemDao.createItem(item);
//        return "success";
//
//    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addItem")
    public Item addItem(String itemJson ){
        Item item = null;
        try {
            item = mapItem(itemJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Should form values be taken as strings for all??
        itemDao.createItem(item);
        return item;

    }

    private Item mapItem(String itemJson) throws IOException {
        Item item = null;
        item = new ObjectMapper().readValue(itemJson, Item.class);

        return item;

    }
}
