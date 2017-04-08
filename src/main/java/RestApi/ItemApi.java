package RestApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ItemDao;
import entities.Customer;
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


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findItemById")
    public Item findItemById(String itemId){
        Item item = itemDao.findById(Integer.parseInt(itemId));



        assert item != null;
        return item;
    }


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
