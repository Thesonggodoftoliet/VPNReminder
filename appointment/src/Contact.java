

//import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
//import java.net.ProtocolException;
import java.net.URL;

public class Contact {
    URL url;
    Contact() throws IOException {
        //url = new URL("http://warmcoding.com:8080/VPN/VPN");
        url = new URL("http://localhost:8080/VPN_war_exploded/VPN");
    }

    public void writejson(String json) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/config.json"));
        bw.write(json);
        bw.flush();
        bw.close();
    }


    public void dosomething(String msg) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");

        out.write(msg);
        out.flush();
        out.close();

        //获取服务器反馈
        String strLine;
        String strResponse = "";
        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        while ((strLine = reader.readLine()) != null){
            strResponse += strLine+"\n";
        }
        System.out.print(strResponse);

        writejson(strResponse);
    }


}
