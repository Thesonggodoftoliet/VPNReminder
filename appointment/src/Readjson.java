

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;

public class Readjson {
    public String read() throws IOException, JSONException {
//        ArrayList<Integer> name = new ArrayList<>();
//        ArrayList<String> value = new ArrayList<>();
        // 读取原始json文件并进行操作和输出
        BufferedReader br = new BufferedReader(new FileReader(
                "src/config.json"));// 读取原始json文件
//        BufferedWriter bw = new BufferedWriter(new FileWriter(
//                "src/json/HK_new.json"));// 输出新的json文件
        String s;
        JSONObject dataJson= null;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
            dataJson = new JSONObject(s);// 创建一个包含原始json串的json对象
//            JSONObject port = dataJson.getJSONObject("port_password");// 找到features的json数组
//            Iterator keys = port.keys();
//            while(keys.hasNext()) {
//                String key = String.valueOf(keys.next());
//                name.add(Integer.parseInt(key));
//                value.add(port.getString(key));
//                System.out.println(port.getString(key));
//            }
//            port.remove(name.get(0).toString());
//            System.out.println(port);
//            JSONObject ports;
//            JSONArray emals;
//            ArrayList<instance> portlist= new ArrayList<>();
//            try {
//                ports = dataJson.getJSONObject("port_password");
//                emals = dataJson.getJSONArray("emails");
//                int i = 0;
//                Iterator keys = ports.keys();
//                while (keys.hasNext()){
//                    String key = String.valueOf(keys.next());
//                    instance temp = new instance();
//                    temp.setPort(Integer.parseInt(key));
//                    temp.setPassword(ports.getString(key));
//                    portlist.add(temp);
//                }
//                dataJson.remove("port_password");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            JSONObject temp = new JSONObject();
//            for (int i =0;i<portlist.size();i++) {
//                System.out.println(portlist.get(i).getPort() + " " + portlist.get(i).getPassword() + " " + portlist.get(i).getEmail());
//                temp.put(new Integer(portlist.get(i).getPort()).toString(),portlist.get(i).getPassword());
//            }
//            dataJson.put("port_password",temp);
        }
        br.close();
        return dataJson.toString();
    }
}
