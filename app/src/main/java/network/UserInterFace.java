package network;

import model.UserDetail;

public interface UserInterFace {
    void onResult(UserDetail userDetail);
    void onFail(String error);
}
