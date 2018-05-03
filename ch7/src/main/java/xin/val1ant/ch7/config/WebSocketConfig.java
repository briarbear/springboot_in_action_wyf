package xin.val1ant.ch7.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer { //springboot 2.0 新特性

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {//1 注册一个节点，并映射指定的URL
        registry.addEndpoint("/endpointWisely").withSockJS();// 泣册一个STOMP 的endpoint ，并指定使用SockJS 协议

        registry.addEndpoint("/endpointChat").withSockJS(); // 注册一个名为／endpointChat 的endpoint
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) { // 配置消息代理
        registry.enableSimpleBroker("/queue","/topic"); //2 广播 topic消息代理 点对点式应增加一个／queue 消息代理。
    }

}