package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Tim on 15/03/2017.
 */
@NamedQueries({
        @NamedQuery(name = "item.findAll", query = "select o from Item o")
})

@XmlRootElement
@Entity
public class    Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String manufacturer;
    private Double price;
    private String category;
    private String image;
    private int stockLevel;
    private int rating;

    public Item(){

    }

    public Item(String title, String manufacturer, Double price, String category, String image, int stockLevel, int rating) {
        this.title = title;
        this.manufacturer = manufacturer;
        this.price = price;
        this.category = category;
        this.image = image;
        this.stockLevel = stockLevel;
        this.rating = rating;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @XmlElement
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @XmlElement
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @XmlElement
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlElement
    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    @XmlElement
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + id +
                ", title='" + title + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", stockLevel=" + stockLevel +
                ", rating=" + rating +
                '}';
    }
}
