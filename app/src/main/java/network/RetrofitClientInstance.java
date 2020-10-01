package network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    static String baseUrl = "https://api.github.com";//imbichitra/LoginMvvm
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null){

            //to see the log
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

            final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    /*.connectTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20,TimeUnit.SECONDS)
                    .readTimeout(20,TimeUnit.SECONDS)*/
                    .callTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor)
                    .build();

            Gson gson = new GsonBuilder().serializeNulls().create();

            retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();

        }
        return retrofit;
    }

    public static <S> S cteateService(Class<S> serviceClass) {
        return getRetrofitInstance().create(serviceClass);
    }
}
