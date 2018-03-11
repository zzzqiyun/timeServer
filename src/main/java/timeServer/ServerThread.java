package timeServer;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created on 2018/3/11.
 *
 * @author qiyun
 */
public class ServerThread implements Runnable {
private Socket s;
public static List<String> dateList = Collections.synchronizedList(new ArrayList<>());
public ServerThread(Socket s) {
  this.s = s;
}
  public void run(){
    try{
      Date now = new Date();
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      String nowTime = dateFormat.format(now);
      PrintStream ps = new PrintStream(s.getOutputStream());
      dateList.add(nowTime);
      for (String s:dateList) {
        ps.println(s);
      }
    }catch(Exception e){
     TimeServer.socketList.remove(s);
    }
  }
}
