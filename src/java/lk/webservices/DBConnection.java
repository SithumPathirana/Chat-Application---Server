/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.webservices;

import java.sql.*;



public class DBConnection {
    
      private Connection con;
    public Statement st;
    public ResultSet rs;
    private PreparedStatement prep;
    public static String id;
    

    public DBConnection() {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chatapp","root","");
            st=con.createStatement();
            
            
        
        }catch(Exception e){
            System.out.println("Error : "+e);
        }
        
    }
    
   public boolean getData(){
   
      try{
          String query="select loginId from users";
          rs=st.executeQuery(query);
          
          while(rs.next()){
            
             if(id.equals(rs.getString("loginId"))){
                 
                 return true;
             }
          }
      
      }catch(Exception e){
        System.out.println(e);
      }
      return false;
   }
    
  public void insertUser(String nickname,String loginID,String password){
      try{
       
      String query="insert into users(nickName,loginId,userpassword)values('"+nickname+"','"+loginID+"','"+password+"')";
      prep=con.prepareStatement(query);
      prep.executeUpdate();
      }catch(Exception e){
          System.out.println(e);
      }
    
  }
  
  public boolean userAvailbility(String loginId,String password){
     try{
         String query="select loginId,userpassword from users";
         rs=st.executeQuery(query);
         
         while(rs.next()){
             
             if(loginId.equals(rs.getString("loginId"))){
                  if(password.equals(rs.getString("userpassword"))){
                         return true;
                  }
             }
         
         }
         
     
     }catch(Exception e){
         System.out.println(e);
     }
     return false;
      
    
  }
  
  public void createChatThread(String title,String author,String lastEdited){
        try{
            String query="insert into chat_threads values('"+title+"','"+author+"','"+lastEdited+"')";
            prep=con.prepareStatement(query);
            prep.executeUpdate();
            
        
        }catch(Exception e){
          System.out.println(e);
        }
  }
  
 
  public void addChat(String messageContent,String chatTitle,String sender,String lastEdited){
       try{
           
             String query="insert into messages(message,chat_title,sender,last_edited) "
                     + "values('"+messageContent+"','"+chatTitle+"','"+sender+"','"+lastEdited+"')";
            prep=con.prepareStatement(query);
            prep.executeUpdate();
       
       }catch(Exception e){
           System.out.println(e);
       
       }
  }
    
  public void upadateChatTable(String title,String lastEdited){
      DBConnection db=new DBConnection();
      String query="update chat_threads set last_edited='"+lastEdited+"' where title='"+title+"'";
      try{
          prep=con.prepareStatement(query);
          prep.executeUpdate();
      
      }catch(Exception e){
        System.out.println(e);
      }
   }
    
 
    
}
