package timeServer;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created on 2018/3/10.
 *
 * @author qiyun
 */
public class TimeServer{
  public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());
  public static void main(String args[])throws Exception{

    ServerSocket ss = new ServerSocket(7777);//监听7777端口
    while(true){
      Socket s = ss.accept();//等待连接，无连接时会一直阻塞
      socketList.add(s);
        Thread t = new Thread(new ServerThread(s));
        t.start();
    }
  }
}
