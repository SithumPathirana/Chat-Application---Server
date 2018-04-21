/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.webservices;

/**
 *
 * @author DELL
 */

public class ChatThread {
    
     
     private String title;
      
     private  String  author;
    
     private String lastEdited;

    public ChatThread(String title, String author, String lastEdited) {
        this.title = title;
        this.author = author;
        this.lastEdited = lastEdited;
    }
    
    public ChatThread(){
    
    }
      
      

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getLastEdited() {
        return lastEdited;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLastEdited(String lastEdited) {
        this.lastEdited = lastEdited;
    }
      
    
      
      
}
