
package callboard.instance;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "myitems")
public class Item {
    @Id
    private int id;
    private String name;
    private int price;
    private String smallimg;
    private String img;
    private String about;
    private String category;
    private String owner;

    public Item() {
    }

    public Item(int id, String name, int price, String smallimg, String img, String about, String category, String owner) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.smallimg = smallimg;
        this.img = img;
        this.about = about;
        this.category = category;
        this.owner = owner;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSmallimg() {
        return smallimg;
    }

    public void setSmallimg(String smallimg) {
        this.smallimg = smallimg;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


}
