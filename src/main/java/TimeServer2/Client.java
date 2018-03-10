package TimeServer2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created on 2018/3/10.
 *
 * @author qiyun
 */
public class Client {
  public static void main(String args[])throws Exception{
    Socket socket = new Socket("127.0.0.1",6666);
    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    String content = null;

    while((content = br.readLine())!=null){
      System.out.print(content);
    }
  }
}
