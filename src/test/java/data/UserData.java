package data;

import com.saucelabs.salsaverde.data.DataObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserData extends DataObject {
    private String email = faker.internet().emailAddress();
    private String password = faker.internet().password();

    public UserData getValidUser() {
        return this;
    }
}
