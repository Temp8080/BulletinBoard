
package ua.com.callboard.item;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemForOwner {

    private int id;

    private String name;

    private int price;

    private String smallimg;

    private String about;

    private String category;

    private String owner;


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
