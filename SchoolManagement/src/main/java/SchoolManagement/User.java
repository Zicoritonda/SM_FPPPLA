/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchoolManagement;

/**
 *
 * @author zicor
 */
public class User {
    private int idUser;
    private String username;
    private String password;
    private String nama;
    private String noHP;
    private String email;

    public User(/*int idUser, String username, String password, String nama, String noHP, String email*/){
//        this.idUser = idUser;
//        this.username = username;
//        this.password = password;
//        this.nama = nama;
//        this.noHP = noHP;
//        this.email = email;
    }

    public void setIdUser(int idUser){
        this.idUser = idUser;
    }

    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public void setNoHP(String noHP){
        this.noHP = noHP;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public int getIdUser(){
       return idUser;
   }
    
    public String getUsername(){
       return username;
   }
    
    public String getPassword(){
       return password;
   }
    
    public String getNama(){
       return nama;
   }
    
    public String getNoHP(){
       return noHP;
   }
    
    public String getEmail(){
       return email;
   }
}
