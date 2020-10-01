package viewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import model.UserDetail;
import network.UserInterFace;
import repository.UserRepository;

import static android.content.ContentValues.TAG;

public class UserViewModel extends AndroidViewModel {
    private Context context;
    private UserRepository userRepository;
    public String userId;
    public String repo;

    public UserDetail userDetails;

    public void setUserId(String userId) {

        this.userId = userId;
        Log.d(TAG, "setUserId: "+this.userId);
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public UserViewModel(@NonNull Application application) {
        super(application);
        context = application;

        userRepository = new UserRepository(application);
    }

    public void getUserData(final UserInterFace userInterFace){
        Log.d(TAG, "getUserData:1 "+this.userId);
        userRepository.getUserData(this.userId, this.repo, new UserInterFace() {
            @Override
            public void onResult(UserDetail userDetail) {
                userDetails = userDetail;
                Log.d(TAG, "onResult: ");
                userInterFace.onResult(userDetail);
            }

            @Override
            public void onFail(String error) {

            }
        });
    }

}
