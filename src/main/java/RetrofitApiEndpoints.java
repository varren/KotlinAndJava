import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiEndpoints {
    @GET("/")
    Call<NavigationMenu[]> getMenus();
}
