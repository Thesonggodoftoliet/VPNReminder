import org.json.JSONException;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, JSONException {
        Readjson readjson = new Readjson();
        Contact contact = new Contact();
        contact.dosomething(readjson.read());
    }
}
