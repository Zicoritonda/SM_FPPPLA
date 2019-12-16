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
public class Civitas {
   private String nama;
   private String tglLahir;
   private String tempatLahir;
   private String jenisKel;
   private String alamat;
   private String noHP;
   private String email;
   
   public Civitas(/*String nama, String tglLahir, String tempatLahir, String jenisKel, String alamat, String noHP, String email*/){
//       this.nama = nama;
//       this.tglLahir = tglLahir;
//       this.tempatLahir = tempatLahir;
//       this.jenisKel = jenisKel;
//       this.alamat = alamat;
//       this.noHP = noHP;
//       this.email = email;
   }
   
   public void setNama(String nama){
       this.nama = nama;
   }
   
   public void setTglLahir(String tglLahir){
       this.tglLahir = tglLahir;
   }
   
   public void setTempatLahir(String tempatLahir){
       this.tempatLahir = tempatLahir;
   }
   
   public void setJenisKel(String jenisKel){
       this.jenisKel = jenisKel;
   }
   
   public void setAlamat(String alamat){
       this.alamat = alamat;
   }
   
   public void setNoHP(String noHP){
       this.noHP = noHP;
   }
   
   public void setEmail(String email){
       this.email = email;
   }
   
   public String getNama(){
       return nama;
   }
   
   public String getTglLahir(){
       return tglLahir;
   }
   
   public String getTempatLahir(){
       return tempatLahir;
   }
   
   public String getJenisKel(){
       return jenisKel;
   }
   
   public String getAlamat(){
       return alamat;
   }
   
   public String getNoHP(){
       return noHP;
   }
   
   public String getEmail(){
       return email;
   }
}
