package timeServer;
import java.net.Socket;

/**
 * Created on 2018/3/10.
 *
 * @author qiyun
 */
public class Client {
  public static void main(String args[])throws Exception{
    Socket socket = new Socket("127.0.0.1",7777);
    new Thread(new ClientThread(socket)).start();
  }

}
