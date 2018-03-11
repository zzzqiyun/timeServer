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

    ServerSocket ss = new ServerSocket(7777);//����7777�˿�
    while(true){
      Socket s = ss.accept();//�ȴ����ӣ�������ʱ��һֱ����
      socketList.add(s);
        Thread t = new Thread(new ServerThread(s));
        t.start();
    }
  }
}
