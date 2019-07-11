import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/VPN")
public class VPN extends HttpServlet {

    public VPN() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = ReciveUtils.getObject(request);
        PrintWriter out =response.getWriter();
        JSONObject ports;
        JSONArray emails;
        ArrayList<instance> portlist= new ArrayList<>();
        ArrayList<instance> changedlist;
        String server=null;
        try {
            ports = jsonObject.getJSONObject("port_password");
            emails = jsonObject.getJSONArray("emails");
            server = jsonObject.getString("server");
            int i = 0;
            Iterator keys = ports.keys();
            while (keys.hasNext()){
                String key = String.valueOf(keys.next());
                instance temp = new instance();
                temp.setPort(Integer.parseInt(key));
                temp.setPassword(ports.getString(key));
                temp.setEmail(emails.getJSONObject(i).getString("address"));
                i++;
                portlist.add(temp);
            }
            jsonObject.remove("port_password");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Utils utils = new Utils();
        try {
            JSONObject ports1 = new JSONObject();
            changedlist = utils.CheckPort(portlist,server);
            Collections.sort(changedlist);
            for (int i = 0;i<changedlist.size();i++){
                ports1.put(Integer.toString(changedlist.get(i).getPort()),changedlist.get(i).getPassword());
            }
            jsonObject.put("port_password",ports1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("返回信息"+jsonObject);
        out.print(jsonObject);
        out.flush();
        out.close();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}