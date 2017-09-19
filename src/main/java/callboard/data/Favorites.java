
package callboard.data;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Favorites {
    private List<Integer> fav = new LinkedList<>();

    public List<Integer> getFav() {
        return fav;
    }

    public void setFav(List<Integer> fav) {
        this.fav = fav;
    }

    public void removeFav(Integer id) {
        fav.remove(id);
    }
}
