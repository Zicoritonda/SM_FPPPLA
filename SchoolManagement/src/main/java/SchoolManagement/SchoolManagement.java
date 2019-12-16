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
public class SchoolManagement {
    public static void main(String args[]) {
        //Asemble MVC
//        Siswa siswa = new Siswa();
        HalamanUtama halUtama = new HalamanUtama();
        FormDataBaru formDataBaru = new FormDataBaru();
        FormUserBaru formUserBaru = new FormUserBaru();
        FormData formData = new FormData();
        FormUser formUser = new FormUser();
        DataTable dataTable = new DataTable();
        UserTable userTable = new UserTable();
        
        SystemController c = new SystemController(halUtama, formDataBaru, formUserBaru, formData, formUser,dataTable,userTable);
        c.initController();
    }
}
