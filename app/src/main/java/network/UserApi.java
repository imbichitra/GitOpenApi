package network;

import model.UserDetail;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface UserApi {
   /* @Headers({
            "X-GitHub-Media-Type: github.v3; param=full; format=json"
    })
*/
    @GET("/repos/{username}/{repo}")
    @Headers("Content-Type: application/json")
    Call<UserDetail> getGitRepo(@Path(value = "username") String username,
                                @Path(value = "repo") String repo);
}
