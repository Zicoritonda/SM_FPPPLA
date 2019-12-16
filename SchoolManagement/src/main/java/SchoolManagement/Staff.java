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
public class Staff extends Civitas{
    private int idStaff;
    
    public Staff(/*int idStaff, String nama, String tglLahir, String tempatLahir, String jenisKel, String alamat, String noHP, String email*/){
//        super(nama,tglLahir,tempatLahir,jenisKel,alamat,noHP,email);
//        this.idStaff = idStaff;
    }
    
    public void setIdStaff(int idStaff){
       this.idStaff = idStaff;
   }
   
   public int getIdStaff(){
       return idStaff;
   }
}
