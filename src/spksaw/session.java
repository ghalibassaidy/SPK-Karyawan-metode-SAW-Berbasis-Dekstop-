    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spksaw;

/**
 *
 * @author Acer
 */
public class session {
     private static int idp;
    private static String id;
    private static String uname;
    private static String pass;
    private static String akses;
    
    
    
    /**********ForID***********************************************88****/
     public static void setidp(int idp){
        session.idp = idp;
    }
    public static int getidp(){
        return idp;
    }
    public static void setid(String id){
        session.id = id;
    }
    public static String getid(){
        return id;
    }
    
    public static void setuname(String uname){
        session.uname = uname;
    }
    public static String getuname(){
        return uname;
    }
    
    public static void setpass(String pass){
        session.pass = pass;
    }
    public static String getpass(){
        return pass;
    }
    
    public static void setakses(String akses){
        session.akses = akses;
    }
    public static String getakses(){
        return akses;
    }
    
    
   
}
