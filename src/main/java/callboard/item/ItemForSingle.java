
package callboard.item;


public class ItemForSingle {
    private int id;
    private String name;
    private int price;
    private String img;
    private String about;
    private String category;
    private String owner;

    public ItemForSingle() {
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

    public ItemForSingle withId(int id) {
        this.id = id;
        return this;
    }

    public ItemForSingle withName(String name) {
        this.name = name;
        return this;
    }

    public ItemForSingle withPrice(Integer price) {
        this.price = price;
        return this;
    }

    public ItemForSingle withImg(String img) {
        this.img = img;
        return this;
    }

    public ItemForSingle withAbout(String about) {
        this.about = about;
        return this;
    }

    public ItemForSingle withCategory(String category) {
        this.category = category;
        return this;
    }

    public ItemForSingle withOwner(String owner) {
        this.owner = owner;
        return this;
    }
}
