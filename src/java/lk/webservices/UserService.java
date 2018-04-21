
package lk.webservices;

import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "UserService")
public class UserService {

   private DBConnection db;
   
    
     @WebMethod(operationName = "register")
    public boolean register(@WebParam(name = "password") String password, @WebParam(name = "re_password") String re_password) {
        if(password.equals(re_password)){
            return true;
        }else{
           return false;
        }
        
    }
    
     @WebMethod(operationName = "checkLoginId")
    public boolean checkLoginId(@WebParam(name = "loginId") String loginId) {
        DBConnection.id=loginId;
         db=new DBConnection();
        boolean result=db.getData();
        return result;
    }
    
     @WebMethod(operationName = "insertUser")
    @Oneway
    public void insertUser(@WebParam(name = "nickname") String nickname, @WebParam(name = "loginId") String loginId, @WebParam(name = "password") String password) {
         db=new DBConnection();
        db.insertUser(nickname, loginId, password);
    }
    
      
    @WebMethod(operationName = "checkUser")
    public boolean checkUser(@WebParam(name = "loginId") String loginId, @WebParam(name = "password") String password) {
       
       
         db=new DBConnection();
       boolean result= db.userAvailbility(loginId, password);
        return result;
    }
    

}
