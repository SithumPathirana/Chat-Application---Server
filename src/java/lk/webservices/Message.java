
package lk.webservices;


public class Message {
 
   private String messageContent;
   private String sender;
   private  String lastEdited;

    public Message() {
        
    }

    public Message(String messageContent, String sender, String lastEdited) {
        this.messageContent = messageContent;
        this.sender = sender;
        this.lastEdited = lastEdited;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public String getSender() {
        return sender;
    }

    public String getLastEdited() {
        return lastEdited;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setLastEdited(String lastEdited) {
        this.lastEdited = lastEdited;
    }
    
    
    
    
    
}
