import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Arrays;

/**
 * Created by varren on 10.10.17.
 */
public class Main {
    private static OkHttpClient okHttpClient = new OkHttpClient();

    public static void main(String[] args) {
        // run(new JavaNavigationMenuArrayDeserializer());
        // run(new KotlinNavigationMenuArrayDeserializer());

        runRetrofit(new JavaNavigationMenuArrayDeserializer());
        runRetrofit(new KotlinNavigationMenuArrayDeserializer());
    }

    private static void runRetrofit(JsonDeserializer deserializer){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://api.github.com/")
                .client(okHttpClient)
                .addConverterFactory(getGsonConverter(deserializer))
                .build();
        RetrofitApiEndpoints api = retrofit.create(RetrofitApiEndpoints.class);
        Call<NavigationMenu[]> call = api.getMenus();
        call.enqueue(new Callback<NavigationMenu[]>() {
            @Override
            public void onResponse(Call<NavigationMenu[]> call, Response<NavigationMenu[]> response) {
                System.out.println(Arrays.toString(response.body()));
            }

            @Override
            public void onFailure(Call<NavigationMenu[]> call, Throwable t) {
                System.out.println("ERROR");
            }
        });

    }

    private static GsonConverterFactory getGsonConverter(JsonDeserializer deserializer) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        gsonBuilder.registerTypeAdapter(NavigationMenu[].class, deserializer);
        Gson gson = gsonBuilder.create();
        return GsonConverterFactory.create(gson);
    }


    private static void run(JsonDeserializer deserializer){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        gsonBuilder.registerTypeAdapter(NavigationMenu[].class, deserializer);
        Gson gson = gsonBuilder.create();
        NavigationMenu[] menu = gson.fromJson("Somejson", NavigationMenu[].class);
        System.out.println(Arrays.toString(menu));
    }

}
