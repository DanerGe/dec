package dec.demo.websocket;


import dec.demo.pojo.WebSocketBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@EnableScheduling
@Controller
public class WebSocketServer {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // “send”方法用于接收客户端发送过来的websocket请求。
    @MessageMapping("/send")
    @SendTo("/topic/app")
    public WebSocketBean send(WebSocketBean bean){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String now = sdf.format(new Date());
        bean.setDate(now);
        return bean;
    }

    @Scheduled(fixedRate = 1000)
    @SendTo("/topic/callback")
    public Object callback() throws Exception {
        // 发现消息
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        messagingTemplate.convertAndSend("/topic/callback", df.format(new Date()));
        return "callback";
    }
}
