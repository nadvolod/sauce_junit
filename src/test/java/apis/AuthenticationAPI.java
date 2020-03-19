package apis;

import io.restassured.response.Response;
import lombok.Getter;
import data.UserData;

public class AuthenticationAPI extends BaseAPI {
    @Getter
    private String endpoint = "users";

    public UserData createRandomUser() {
        return createUser(new UserData());
    }

    public UserData createUser(UserData userData) {
        Response response = create(userData);
        String rememberToken = response.getCookies().get("remember_token");

        // Post doesn't follow redirects, so can't auto convert to a user
        userData.setId(rememberToken);
        return userData;
    }
}
