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
public class Guru extends Civitas{
    private int idGuru;
    
    public Guru(/*int idGuru, String nama, String tglLahir, String tempatLahir, String jenisKel, String alamat, String noHP, String email*/){
//        super(nama,tglLahir,tempatLahir,jenisKel,alamat,noHP,email);
//        this.idGuru = idGuru;
    }
    
    public void setIdGuru(int idGuru){
       this.idGuru = idGuru;
   }
   
   public int getIdGuru(){
       return idGuru;
   }
}
