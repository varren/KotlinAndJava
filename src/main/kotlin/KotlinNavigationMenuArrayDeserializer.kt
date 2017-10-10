import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class KotlinNavigationMenuArrayDeserializer : JsonDeserializer<Array<NavigationMenu>> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Array<NavigationMenu> {
        return Array(1, { NavigationMenu("From kotlin")})
    }
}