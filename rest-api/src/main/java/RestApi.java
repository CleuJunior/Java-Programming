import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

import static java.lang.String.format;
import static java.util.Arrays.asList;

class RestApi {

    private final List<User> usersList = new LinkedList<>();

    public RestApi(User... users) {
        usersList.addAll(asList(users));
    }

    public String get(String url) {
        return format("{\"users\":%s}", usersList);
    }

    public String get(String url, JSONObject payload) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    public String post(String url, JSONObject payload) {
        var user = User.builder()
                .setName(payload.get("user").toString())
                .build();

        return user.toString();
    }

}