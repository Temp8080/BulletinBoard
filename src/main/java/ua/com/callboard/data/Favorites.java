
package ua.com.callboard.data;

import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Favorites {

    private List<Integer> fav = new LinkedList<>();

    public void removeFav(Integer id) {
        fav.remove(id);
    }
}
