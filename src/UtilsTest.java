import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import static org.junit.Assert.*;

public class UtilsTest {

    @org.junit.Test
    public void ping() {
        Socket socket = new Socket();
        try{
            socket.connect(new InetSocketAddress("207.148.91.55",9517));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("连接失败");
            try{
                socket.close();
            }catch (IOException oe){
                oe.printStackTrace();
            }
            return;
        }
        try{
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("连接成功");
        return;
    }
}