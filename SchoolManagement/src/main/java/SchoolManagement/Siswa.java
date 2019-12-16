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
public class Siswa extends Civitas{
    private int idSiswa;
    
    public Siswa(/*int idSiswa, String nama, String tglLahir, String tempatLahir, String jenisKel, String alamat, String noHP, String email*/){
//        super(nama,tglLahir,tempatLahir,jenisKel,alamat,noHP,email);
//        this.idSiswa = idSiswa;
    }
    
    public void setIdSiswa(int idSiswa){
       this.idSiswa = idSiswa;
   }
   
   public int getIdSiswa(){
       return idSiswa;
   }
}
