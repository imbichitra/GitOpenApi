package repository;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import model.UserDetail;
import network.RetrofitClientInstance;
import network.UserApi;
import network.UserInterFace;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class UserRepository {

    private Context context;

    public UserRepository(Application application) {
        context = application;
    }

    public void getUserData(final String user, final String repo, final UserInterFace userInterFace){
        Log.d(TAG, "getUserData: "+user);
        Call<UserDetail> call = RetrofitClientInstance.cteateService(UserApi.class).getGitRepo(user,repo);

        call.enqueue(new Callback<UserDetail>() {
            @Override
            public void onResponse(Call<UserDetail> call, Response<UserDetail> response) {
                if (response.isSuccessful()){
                    userInterFace.onResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserDetail> call, Throwable t) {
                userInterFace.onFail(t.getMessage());
            }
        });
    }
}
