import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Utils {
    public ArrayList<instance> CheckPort(ArrayList<instance> list,String server) throws Exception {
        int min = getMin(list);
        for (int i = 0;i<list.size();i++){
//            String command = "sh "+"/root/1.sh "+list.get(i).getPort();
//            Process process = Runtime.getRuntime().exec(command);
//            int status = process.waitFor();
//            if (status != 0)
//                System.out.println("Fail!");
//            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            StringBuffer sb = new StringBuffer("");
//            while ((line = br.readLine()) != null)
//                sb.append(line);
//            br.close();
//            if (sb.length()<=30){//端口被封禁
            if (!ping(server,list.get(i).getPort())){
                list.get(i).setPort(min);
                min=min-1;
                Mail email = new Mail();
                email.SendEmail(min,list.get(i).getEmail());
            }else {
                System.out.println(list.get(i).getPort()+"端口通畅");
            }
        }
        return list;
    }

    public int getMin(List<instance> list){
        int tag = 10000;
        for (int i = 0;i<list.size();i++) {
            if (tag >= list.get(i).getPort())
                tag = list.get(i).getPort();
        }
        return tag-1;
    }

    public boolean ping(String host,int port){
        System.out.println("连接"+host+":"+port);
        Socket socket = new Socket();
        try{
            socket.connect(new InetSocketAddress(host,port));
        }catch (IOException e){
           // e.printStackTrace();
            try{
                socket.close();
            }catch (IOException oe){
                oe.printStackTrace();
            }
            System.out.println(port+"不通");
            return false;
        }
        try{
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return true;
    }

}
