/**
 * Created by varren on 10.10.17.
 */
public class NavigationMenu {
    private String id;

    public NavigationMenu(String id) {
        this.id = id;
    }

    public NavigationMenu() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "NavigationMenu{" +
                "id='" + id + '\'' +
                '}';
    }
}
