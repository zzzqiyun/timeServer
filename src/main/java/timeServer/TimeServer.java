package timeServer;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 2018/3/10.
 *
 * @author qiyun
 */
public class TimeServer{
  public static void main(String args[])throws Exception{

    Date now = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String nowTime = dateFormat.format(now);
    ServerSocket ss = new ServerSocket(7777);//����7777�˿�
    while(true){
      Socket s = ss.accept();//�ȴ����ӣ�������ʱ��һֱ����
      PrintStream ps = new PrintStream(s.getOutputStream());
      ps.println(nowTime);
      ps.flush();
    }
  }
}
