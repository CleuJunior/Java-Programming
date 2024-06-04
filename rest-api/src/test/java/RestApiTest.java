import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RestApiTest {

    @Test
    void noUsers() {
        var expected =
            new JSONObject().put("users", new JSONArray()).toString();
        var url = "/users";

        assertThat(new RestApi().get(url)).isEqualTo(expected);
    }
    
    @Test
    void addUser() {
        var expected = new JSONObject()
            .put("name", "Adam")
            .put("owes", new JSONObject())
            .put("owedBy", new JSONObject())
            .put("balance", 0.0)
            .toString();
        var url = "/add";
        var payload = new JSONObject().put("user", "Adam");

        assertThat(new RestApi().post(url, payload)).isEqualTo(expected);
    }


    @Test
    void getSingleUser() {
        var expected = new JSONObject()
            .put(
                "users",
                new JSONArray()
                    .put(
                        new JSONObject()
                        .put("name", "Bob")
                        .put("owes", new JSONObject())
                        .put("owedBy", new JSONObject())
                        .put("balance", 0.0)))
            .toString();
        var url = "/users";
        var payload =
            new JSONObject().put("users", new JSONArray().put("Bob"));

        assertThat(new RestApi(
                User.builder().setName("Adam").build(),
                User.builder().setName("Bob").build())
                .get(url, payload)).isEqualTo(expected);
    }

    @Test
    void bothUsersHave0Balance() {
        var expected =
            new JSONObject()
                .put(
                    "users",
                    new JSONArray()
                        .put(
                            new JSONObject()
                                .put("name", "Adam")
                                .put("owes", new JSONObject())
                                .put(
                                    "owedBy",
                                    new JSONObject().put("Bob", 3.0))
                                .put("balance", 3.0))
                        .put(
                            new JSONObject()
                                .put("name", "Bob")
                                .put(
                                    "owes",
                                    new JSONObject().put("Adam", 3.0))
                                .put("owedBy", new JSONObject())
                                .put("balance", -3.0)))
                .toString();
        var url = "/iou";
        var payload =
            new JSONObject()
                .put("lender", "Adam")
                .put("borrower", "Bob")
                .put("amount", 3.0);

        assertThat(new RestApi(
                User.builder().setName("Adam").build(),
                User.builder().setName("Bob").build())
                .post(url, payload)).isEqualTo(expected);
    }


    @Test
    void borrowerHasNegativeBalance() {
        var expected =
            new JSONObject()
                .put(
                    "users",
                    new JSONArray()
                        .put(
                            new JSONObject()
                                .put("name", "Adam")
                                .put("owes", new JSONObject())
                                .put(
                                    "owedBy",
                                    new JSONObject().put("Bob", 3.0))
                                .put("balance", 3.0))
                        .put(
                            new JSONObject()
                                .put("name", "Bob")
                                .put(
                                    "owes",
                                    new JSONObject()
                                        .put("Adam", 3.0)
                                        .put("Chuck", 3.0))
                                .put("owedBy", new JSONObject())
                                .put("balance", -6.0)))
                .toString();
        var url = "/iou";
        var payload =
            new JSONObject()
                .put("lender", "Adam")
                .put("borrower", "Bob")
                .put("amount", 3.0);

        assertThat(new RestApi(
                User.builder().setName("Adam").build(),
                User.builder().setName("Bob").owes("Chuck", 3.0).build(),
                User.builder().setName("Chuck").owedBy("Bob", 3.0).build())
                .post(url, payload)).isEqualTo(expected);
    }


    @Test
    void lenderHasNegativeBalance() {
        var expected =
            new JSONObject()
                .put(
                    "users",
                    new JSONArray()
                        .put(
                            new JSONObject()
                                .put("name", "Adam")
                                .put(
                                    "owes",
                                    new JSONObject().put("Bob", 3.0))
                                .put(
                                    "owedBy", new JSONObject())
                                .put("balance", -3.0))
                        .put(
                            new JSONObject()
                                .put("name", "Bob")
                                .put(
                                    "owes",
                                    new JSONObject()
                                        .put("Chuck", 3.0))
                                .put(
                                    "owedBy",
                                    new JSONObject().put("Adam", 3.0))
                                .put("balance", 0.0)))
                .toString();
        var url = "/iou";
        var payload =
            new JSONObject()
                .put("lender", "Bob")
                .put("borrower", "Adam")
                .put("amount", 3.0);

        assertThat(new RestApi(
                User.builder().setName("Adam").build(),
                User.builder().setName("Bob").owes("Chuck", 3.0).build(),
                User.builder().setName("Chuck").owedBy("Bob", 3.0).build())
                .post(url, payload)).isEqualTo(expected);
    }


    @Test
    void lenderOwesBorrower() {
        var expected =
            new JSONObject()
                .put(
                    "users",
                    new JSONArray()
                        .put(
                            new JSONObject()
                                .put("name", "Adam")
                                .put(
                                    "owes",
                                    new JSONObject().put("Bob", 1.0))
                                .put("owedBy", new JSONObject())
                                .put("balance", -1.0))
                        .put(
                            new JSONObject()
                                .put("name", "Bob")
                                .put("owes", new JSONObject())
                                .put(
                                    "owedBy",
                                    new JSONObject().put("Adam", 1.0))
                                .put("balance", 1.0)))
                .toString();
        var url = "/iou";
        var payload =
            new JSONObject()
                .put("lender", "Adam")
                .put("borrower", "Bob")
                .put("amount", 2.0);

        assertThat(new RestApi(
                User.builder().setName("Adam").owes("Bob", 3.0).build(),
                User.builder().setName("Bob").owedBy("Adam", 3.0).build())
                .post(url, payload)).isEqualTo(expected);
    }

    @Test
    void lenderOwesBorrowerLessThanNewLoan() {
        var expected =
            new JSONObject()
                .put(
                    "users",
                    new JSONArray()
                        .put(
                            new JSONObject()
                                .put("name", "Adam")
                                .put("owes", new JSONObject())
                                .put(
                                    "owedBy",
                                    new JSONObject().put("Bob", 1.0))
                                .put("balance", 1.0))
                        .put(
                            new JSONObject()
                                .put("name", "Bob")
                                .put(
                                    "owes",
                                    new JSONObject().put("Adam", 1.0))
                                .put("owedBy", new JSONObject())
                                .put("balance", -1.0)))
                .toString();
        var url = "/iou";
        var payload =
            new JSONObject()
                .put("lender", "Adam")
                .put("borrower", "Bob")
                .put("amount", 4.0);

        assertThat(new RestApi(
                User.builder().setName("Adam").owes("Bob", 3.0).build(),
                User.builder().setName("Bob").owedBy("Adam", 3.0).build())
                .post(url, payload)).isEqualTo(expected);
    }


    @Test
    void lenderOwesBorrowerSameAsNewLoan() {
        var expected =
            new JSONObject()
                .put(
                    "users",
                    new JSONArray()
                        .put(
                            new JSONObject()
                                .put("name", "Adam")
                                .put("owes", new JSONObject())
                                .put("owedBy", new JSONObject())
                                .put("balance", 0.0))
                        .put(
                            new JSONObject()
                                .put("name", "Bob")
                                .put("owes", new JSONObject())
                                .put("owedBy", new JSONObject())
                                .put("balance", 0.0)))
                .toString();
        var url = "/iou";
        var payload =
            new JSONObject()
                .put("lender", "Adam")
                .put("borrower", "Bob")
                .put("amount", 3.0);

        assertThat(new RestApi(
                User.builder().setName("Adam").owes("Bob", 3.0).build(),
                User.builder().setName("Bob").owedBy("Adam", 3.0).build())
                .post(url, payload)).isEqualTo(expected);
    }
}
