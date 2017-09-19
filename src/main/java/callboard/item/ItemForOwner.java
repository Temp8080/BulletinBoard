
package callboard.item;


public class ItemForOwner {
    private int id;
    private String name;
    private int price;
    private String smallimg;
    private String about;
    private String category;
    private String owner;

    public ItemForOwner() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public ItemForOwner withId(int id) {
        this.id = id;
        return this;
    }

    public ItemForOwner withName(String name) {
        this.name = name;
        return this;
    }

    public ItemForOwner withPrice(Integer price) {
        this.price = price;
        return this;
    }

    public ItemForOwner withSmallImg(String smallimg) {
        this.smallimg = smallimg;
        return this;
    }

    public ItemForOwner withAbout(String about) {
        this.about = about;
        return this;
    }

    public ItemForOwner withCategory(String category) {
        this.category = category;
        return this;
    }

    public ItemForOwner withOwner(String owner) {
        this.owner = owner;
        return this;
    }
}
