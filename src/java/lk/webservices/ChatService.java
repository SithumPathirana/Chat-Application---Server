/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 *
 * @author DELL
 */
@WebService(serviceName = "ChatService")
public class ChatService {

     private DBConnection db;
    
    
      
    @WebMethod(operationName = "createThraed")
    @Oneway
    public void createThraed(@WebParam(name = "title") String title, @WebParam(name = "author") String author, @WebParam(name = "lastEdited") String lastEdited) {
        db=new DBConnection();
        db.createChatThread(title, author, lastEdited);
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addMessage")
    @Oneway
    public void addMessage(@WebParam(name = "messageContent") String messageContent, @WebParam(name = "title") String title, @WebParam(name = "sender") String sender, @WebParam(name = "lastEdited") String lastEdited) {
       
         db=new DBConnection();
        db.addChat(messageContent, title, sender, lastEdited);
      
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkTitle")
    public boolean checkTitle(@WebParam(name = "title") String title) {
        if(title.equals("")){
          return true;
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateTable")
    @Oneway
    public void updateTable(@WebParam(name = "title") String title, @WebParam(name = "lastEdited") String lastEdited) {
        DBConnection db=new DBConnection();
        db.upadateChatTable(title, lastEdited);
        
                
    }



    /**
     * Web service operation
     */
    @WebMethod(operationName = "getThreadData")
    public ChatThread[] getChatThreadData() {
        String query="select * from chat_threads";
        List<Object> chatThreads=new ArrayList<Object>();
        db=new DBConnection();
       try{
           db.rs=db.st.executeQuery(query);
           while(db.rs.next()){
              ChatThread newThread=new ChatThread();
               newThread.setTitle(db.rs.getString("title"));
               newThread.setAuthor(db.rs.getString("author"));
               newThread.setLastEdited(db.rs.getTimestamp("last_edited").toString());
               
               chatThreads.add(newThread);
           
           }
       }
       catch(Exception e){
           System.out.println(e);
       
       }
       
        return chatThreads.toArray(new ChatThread[chatThreads.size()]);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "showChats")
    public Message[] showChats(@WebParam(name = "chatTitle") String chatTitle) {
        
        String query="select message,sender,last_edited from messages where chat_title='"+chatTitle+"'";
         List<Object> chatMessages=new ArrayList<Object>();
          db=new DBConnection();
         try{
           db.rs=db.st.executeQuery(query);
           while(db.rs.next()){
                Message message=new Message();
               message.setMessageContent(db.rs.getString("message"));
               message.setSender(db.rs.getString("sender"));
               message.setLastEdited(db.rs.getTimestamp("last_edited").toString());
               
               chatMessages.add(message);
           
           }
         }catch(Exception e){
            System.out.println(e);
         }
        return chatMessages.toArray(new Message[chatMessages.size()]);
    }
    
   
  

}
