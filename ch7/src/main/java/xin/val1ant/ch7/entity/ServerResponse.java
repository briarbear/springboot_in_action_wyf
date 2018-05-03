package xin.val1ant.ch7.entity;

public class ServerResponse {
    private String responseMessage;
    public ServerResponse(String responseMessage){
        this.responseMessage = responseMessage;
    }
    public String getResponseMessage(){
        return responseMessage;
    }
}
