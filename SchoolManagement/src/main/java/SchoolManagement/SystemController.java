/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchoolManagement;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zicor
 */
public class SystemController {
    
    private Siswa siswa;
    private javax.swing.JFrame activeFrame;
    private HalamanUtama halUtama;
    private FormDataBaru formDataBaru;
    private FormUserBaru formUserBaru;
    private FormData formData;
    private FormUser formUser;
    private DataTable dataTable;
    private UserTable userTable;
    
    public SystemController(HalamanUtama hu, FormDataBaru fdb, FormUserBaru fub, FormData fd, FormUser fu, DataTable dt, UserTable ut){
//        siswa = s;
        halUtama = hu;
        formDataBaru = fdb;
        formUserBaru = fub;
        formData = fd;
        formUser = fu;
        dataTable = dt;
        userTable = ut;
    
    }
    
    public void initController(){
        //halaman utama
        halUtama.setVisible(true);
        activeFrame = halUtama;
        halUtama.getJButton1().addActionListener(e -> gotoDataTable());
        halUtama.getJButton3().addActionListener(e -> gotoFormDataBaru());
        halUtama.getJButton4().addActionListener(e -> gotoFormUserBaru());
        
        //form data baru
        formDataBaru.getJButton1().addActionListener(e -> saveDataBaru());
        formDataBaru.getJButton2().addActionListener(e -> gotoHalamanUtama());
        formDataBaru.getJButton3().addActionListener(e -> gotoDataTable());
        
        //form user baru
        formUserBaru.getJButton1().addActionListener(e -> saveUserBaru());
        formUserBaru.getJButton2().addActionListener(e -> gotoHalamanUtama());
        formUserBaru.getJButton3().addActionListener(e -> gotoUserTable());
        
        //data table
        dataTable.getJButton4().addActionListener(e -> gotoHalamanUtama());
        dataTable.getJTable1().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gotoFormData(evt);
            }
        });
        
        //user table
        userTable.getJButton6().addActionListener(e -> gotoHalamanUtama());
        userTable.getJTable1().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gotoFormUser(evt);
            }
        });
        
        // form data
        formData.getJButton2().addActionListener(e -> gotoDataTable());
        formData.getJButton4().addActionListener(e -> gotoFormDataBaru());
        formData.getJButton3().addActionListener(e -> updateData());
        formData.getJButton1().addActionListener(e -> deleteData());
        
        //form user
        formUser.getJButton2().addActionListener(e -> gotoUserTable());
        formUser.getJButton4().addActionListener(e -> gotoFormUserBaru());
        formUser.getJButton3().addActionListener(e -> updateUser());
        formUser.getJButton1().addActionListener(e -> deleteUser());
    }
    
    private void gotoHalamanUtama(){
        activeFrame.setVisible(false);
        halUtama.setVisible(true);
        activeFrame.dispose();
        activeFrame = halUtama;
        
    }
    
    private void gotoFormDataBaru(){
        activeFrame.setVisible(false);
        formDataBaru.setVisible(true);
        activeFrame.dispose();
        activeFrame = formDataBaru;
    }
    
    private void gotoFormUserBaru(){
        activeFrame.setVisible(false);
        formUserBaru.setVisible(true);
        activeFrame.dispose();
        activeFrame = formUserBaru;
    }
    
    private void gotoDataTable(){
        activeFrame.setVisible(false);
        dataTable.setVisible(true);
        activeFrame.dispose();
        activeFrame = dataTable;
        listDataTable();
    }
    
    private void gotoUserTable(){
        activeFrame.setVisible(false);
        userTable.setVisible(true);
        activeFrame.dispose();
        activeFrame = userTable;
        listUserTable();
    }
    
    public void gotoFormData(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
//        int dataSelected = dataTable.getJTable1().getSelectedRow() + 1;
//        System.out.println(dataSelected);
        
//        formData.setSelectedRow(dataSelected);
        //create siswa
//        Siswa s = new Siswa();
        
        activeFrame.setVisible(false);
        formData.setVisible(true);
        activeFrame.dispose();
        activeFrame = formData;
        System.out.println(dataTable.getJTable1().getValueAt(dataTable.getJTable1().getSelectedRow(), 0));
        setData((int) dataTable.getJTable1().getValueAt(dataTable.getJTable1().getSelectedRow(), 0));
//       return dataSelected;
    }
    
    public void gotoFormUser(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
//        int dataSelected = dataTable.getJTable1().getSelectedRow() + 1;
//        System.out.println(dataSelected);
//        
//        formUser.setSelectedRow(dataSelected);
        activeFrame.setVisible(false);
        formUser.setVisible(true);
        activeFrame.dispose();
        activeFrame = formUser;
        System.out.println(userTable.getJTable1().getValueAt(userTable.getJTable1().getSelectedRow(), 0));
        setUser((int) userTable.getJTable1().getValueAt(userTable.getJTable1().getSelectedRow(), 0));
//       return dataSelected;
    }
    
    private void saveDataBaru(){
        //code here
//        System.out.println(formDataBaru.getJTextField1().getText());
        String nama;
        String tglLahir;
        String tempatLahir;
        String jenisKel;
        String alamat;
        String noHP;
        String email;
        while(true){
            if(formDataBaru.getJTextField1().getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Nama Kosong!");
                break;
            }
            else{
                nama = formDataBaru.getJTextField1().getText();
            }
            if(formDataBaru.getJTextField2().getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Tanggal Lahir Kosong!");
                break;
            }
            else{
                tglLahir = formDataBaru.getJTextField2().getText();
            }
            if(formDataBaru.getJTextField3().getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Tempat Lahir Kosong!");
                break;
            }
            else{
                tempatLahir = formDataBaru.getJTextField2().getText();
//                check = true;
            }
            if(formDataBaru.getPerempuan().isSelected()){
                jenisKel = "P";
//                check = true;
            } else if(formDataBaru.getLaki().isSelected()){
                jenisKel = "L";
//                check = true;
            } else {
                JOptionPane.showMessageDialog(null,"Jenis Kelamin Kosong!");
                break;
            }
            if(formDataBaru.getJTextField5().getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Alamat Kosong!");
                break;
            }
            else{
                alamat = formDataBaru.getJTextField5().getText();
//                check = true;
            }
            if(formDataBaru.getJTextField6().getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Nomor HP Kosong!");
                break;
            }
            else{
                noHP = formDataBaru.getJTextField6().getText();
//                check = true;
            }
            if(formDataBaru.getJTextField7().getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Email Kosong!");
                break;
            }
            else{
                email = formDataBaru.getJTextField7().getText();
//                check = true;
            }
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement","root","");
                
                String sql = "insert into data values (default,?,?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, nama);
                ps.setString(2, tglLahir);
                ps.setString(3, tempatLahir);
                ps.setString(4, jenisKel);
                ps.setString(5, alamat);
                ps.setString(6, noHP);
                ps.setString(7, email);
                
                ps.executeUpdate();
                
                //Jika data telah sesuai
                JOptionPane.showMessageDialog(null,"Successfully Registered!");
            
                conn.close();
            } catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, e);
            }
            break;
        }
    }
    
    private void saveUserBaru(){
        String username;
        String password;
        String nama;
        String noHP;
        String email;
        while(true){
            if(formUserBaru.getJTextField1().getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Username Kosong!");
                break;
            }
            else{
                username = formUserBaru.getJTextField1().getText();
//                check = true;
            }
            if(formUserBaru.getJTextField2().getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Password Kosong!");
                break;
            }
            else{
                password = formUserBaru.getJTextField2().getText();
//                check = true;
            }
            if(formUserBaru.getJTextField3().getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Nama Kosong!");
                break;
            }
            else{
                nama = formUserBaru.getJTextField3().getText();
//                check = true;
            }
            if(formUserBaru.getJTextField4().getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Nomor HP Kosong!");
                break;
            }
            else{
                noHP = formUserBaru.getJTextField4().getText();
//                check = true;
            }
            if(formUserBaru.getJTextField7().getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Email Kosong!");
                break;
            }
            else{
                email = formUserBaru.getJTextField7().getText();
//                check = true;
            }
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement","root","");
                
                //check username
                PreparedStatement pstmt = conn.prepareStatement("select * from user where username=?");
                pstmt.setString(1, username);
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next() == false) {
                    String sql = "insert into user values (default,?,?,?,?,?)";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, username);
                    pstmt.setString(2, password);
                    pstmt.setString(3, nama);
                    pstmt.setString(4, noHP);
                    pstmt.setString(5, email);

                    pstmt.executeUpdate();

                    //Jika data telah sesuai
                    JOptionPane.showMessageDialog(null,"Successfully Registered!");
            
                }
                else{
                    JOptionPane.showMessageDialog(null,"Username Exist");
                }
                
                
                conn.close();
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            
            break;
        }
    }
        
    private void listDataTable(){
        //TODO
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement","root","");

            PreparedStatement ps = conn.prepareStatement("select * from data");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel tm = new DefaultTableModel();
            
            tm.addColumn("ID");
            tm.addColumn("Nama");
            tm.addColumn("Tanggal Lahir");
            tm.addColumn("Tempat lahir");
            tm.addColumn("Jenis Kelamin");
            tm.addColumn("Alamat");
            tm.addColumn("No HP");
            tm.addColumn("Email");

            while(rs.next()){
                tm.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("tgl_lahir"),
                    rs.getString("tempat_lahir"),
                    rs.getString("jk"),
                    rs.getString("alamat"),
                    rs.getString("noHP"),
                    rs.getString("email")
                });
            }
            
//            System.out.println("hai");
            
            dataTable.getJTable1().setModel(tm);

        } catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
        }

    }
    
    private void listUserTable(){
        //TODO
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement","root","");

            PreparedStatement ps = conn.prepareStatement("select * from user");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel tm = new DefaultTableModel();
            
            tm.addColumn("ID");
            tm.addColumn("Username");
            tm.addColumn("Nama");
            tm.addColumn("No HP");
            tm.addColumn("Email");

            while(rs.next()){
                tm.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("nama"),
                    rs.getString("noHP"),
                    rs.getString("email")
                });
            }
            
            userTable.getJTable1().setModel(tm);

        } catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void setData(int selected){
        try{
            Siswa s = new Siswa();
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement","root","");

            PreparedStatement ps = conn.prepareStatement("select * from data where data.id=?");
            ps.setInt(1,selected);
            ResultSet rs = ps.executeQuery();
            
            rs.next();
//            
            s.setIdSiswa(rs.getInt("id"));
            s.setNama(rs.getString("nama"));
            s.setTglLahir(rs.getString("tgl_lahir"));
            s.setTempatLahir(rs.getString("tempat_lahir"));
            s.setJenisKel(rs.getString("jk"));
            s.setAlamat(rs.getString("alamat"));
            s.setNoHP(rs.getString("noHP"));
            s.setEmail(rs.getString("email"));
//            JOptionPane.showMessageDialog(rootPane, s.jenisKel);
            formData.getJLabel10().setText(String.valueOf(s.getIdSiswa()));
            formData.getJTextField4().setText(s.getNama());
            formData.getJTextField2().setText(s.getTglLahir());
            formData.getJTextField3().setText(s.getTempatLahir());
            if(s.getJenisKel().equals("L")){
                formData.getLaki().setSelected(true);
            } else{
                formData.getPerempuan().setSelected(true);
            }
            formData.getJTextField5().setText(s.getAlamat());
            formData.getJTextField6().setText(s.getNoHP());
            formData.getJTextField7().setText(s.getEmail());

        } catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void setUser(int selected){
//        JOptionPane.showMessageDialog(rootPane, userSelected);
        try{
            User u = new User();
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement","root","");

            PreparedStatement ps = conn.prepareStatement("select * from user where user.id=?");
            ps.setInt(1,selected);
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            u.setIdUser(rs.getInt("id"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setNama(rs.getString("nama"));
            u.setNoHP(rs.getString("noHP"));
            u.setEmail(rs.getString("Email"));
            
            formUser.getJLabel7().setText(String.valueOf(u.getIdUser()));
            formUser.getJTextField2().setText(u.getUsername());
            formUser.getJTextField5().setText(u.getPassword());
            formUser.getJTextField3().setText(u.getNama());
            formUser.getJTextField4().setText(u.getNoHP());
            formUser.getJTextField7().setText(u.getEmail());

        } catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
        }   
    }
    
    private void updateData(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement","root","");

            PreparedStatement ps = conn.prepareStatement("UPDATE data SET nama=?, tgl_lahir=?, tempat_lahir=?, jk=?, alamat=?, noHP=?, email=? where id=?");
            
            ps.setString(1, formData.getJTextField4().getText());
            ps.setString(2, formData.getJTextField2().getText());
            ps.setString(3, formData.getJTextField3().getText());
            if(formData.getPerempuan().isSelected()){
                ps.setString(4, "p");
            } else if(formData.getLaki().isSelected()){
                ps.setString(4, "L");
            }
            ps.setString(5, formData.getJTextField5().getText());
            ps.setString(6, formData.getJTextField6().getText());
            ps.setString(7, formData.getJTextField7().getText());
            ps.setString(8, formData.getJLabel10().getText());
            
            ps.executeUpdate();
            
            //Jika data telah sesuai
            JOptionPane.showMessageDialog(null,"Successfully Update Data!");
        } catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void updateUser(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement","root","");

            PreparedStatement ps = conn.prepareStatement("UPDATE user SET username=?, password=?, nama=?, noHP=?, email=? where id=?");
            
            ps.setString(1, formUser.getJTextField2().getText());
            ps.setString(2, formUser.getJTextField5().getText());
            ps.setString(3, formUser.getJTextField3().getText());
            ps.setString(4, formUser.getJTextField4().getText());
            ps.setString(5, formUser.getJTextField7().getText());
            ps.setString(6, formUser.getJLabel7().getText());
            
            ps.executeUpdate();
            
            //Jika data telah sesuai
            JOptionPane.showMessageDialog(null,"Successfully Update User!");
        } catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void deleteData(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement","root","");

            PreparedStatement ps = conn.prepareStatement("delete from data where id=?");
            ps.setInt(1, Integer.parseInt(formData.getJLabel10().getText()));
            
            ps.execute();
            
            //Jika data telah sesuai
            JOptionPane.showMessageDialog(null,"Successfully Delete Data!");
            
            //Balik ke DataTable
            activeFrame.setVisible(false);
            dataTable.setVisible(true);
            activeFrame.dispose();
            activeFrame = dataTable;
            listDataTable();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void deleteUser(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement","root","");

            PreparedStatement ps = conn.prepareStatement("delete from user where id=?");
            ps.setInt(1, Integer.parseInt(formUser.getJLabel7().getText()));
            
            ps.execute();
            
            //Jika data telah sesuai
            JOptionPane.showMessageDialog(null,"Successfully Delete Data!");
            
            //Balik ke DataTable
            activeFrame.setVisible(false);
            userTable.setVisible(true);
            activeFrame.dispose();
            activeFrame = userTable;
            listUserTable();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
