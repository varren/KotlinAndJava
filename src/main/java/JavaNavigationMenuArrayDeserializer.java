import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by varren on 10.10.17.
 */

public class JavaNavigationMenuArrayDeserializer implements JsonDeserializer<NavigationMenu[]> {
    @Override
    public NavigationMenu[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return new NavigationMenu[]{new NavigationMenu("From Java")};
    }
}
