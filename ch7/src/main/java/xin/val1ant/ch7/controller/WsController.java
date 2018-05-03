package xin.val1ant.ch7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import xin.val1ant.ch7.entity.ClientMessage;
import xin.val1ant.ch7.entity.ServerResponse;

import java.security.Principal;

@Controller
public class WsController {

    @MessageMapping("/welcome") //
    @SendTo("/topic/getResponse")
    public ServerResponse say(ClientMessage clientMessage) throws InterruptedException {
        Thread.sleep(3000);
        return new ServerResponse("welcome " + clientMessage.getName() + "!");
    }

    @Autowired
    private SimpMessagingTemplate messagingTemplate;//1 通过 SimpMessagingTemplate 向流量器发送信息

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) { //2 pricipal中包含用户信息
        if (principal.getName().equals("xzp")) {//3  如果用户是xzp,zch
            messagingTemplate.convertAndSendToUser("zch",
                    "/queue/notifications", principal.getName() + "-send:"
                            + msg);
        } else {
            messagingTemplate.convertAndSendToUser("xzp",
                    "/queue/notifications", principal.getName() + "-send:"
                            + msg);
        }
    }
}
