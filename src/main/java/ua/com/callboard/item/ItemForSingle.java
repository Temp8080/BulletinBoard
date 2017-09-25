
package ua.com.callboard.item;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemForSingle {

    private int id;

    private String name;

    private int price;

    private String img;

    private String about;

    private String category;

    private String owner;


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
