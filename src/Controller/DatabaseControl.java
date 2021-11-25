/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Admin;
import Model.Customers;
import Model.DetailPesanan;
import Model.Driver;
import Model.Food;
import Model.Pesanan;
import Model.PesananFood;
import Model.PesananOjek;
import Model.Restaurant;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sebastian Berto
 */
public class DatabaseControl {
    static DatabaseHandler conn = new DatabaseHandler();
    
    public static ArrayList<Pesanan> getAllPesanan(){
        ArrayList<Pesanan> listPesanan = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM pesanan";
        DatabaseControl ctrl = new DatabaseControl();
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Pesanan pesanan = new Pesanan();
                pesanan.setId_pesanan(rs.getInt("id"));
                pesanan.setCustomer(ctrl.getCustomerByIdCustomer(rs.getInt("idCustomer")));
                pesanan.setDriver(ctrl.getDriverByIdDriver(rs.getInt("idDriver")));
                pesanan.setTanggalpemesanan(rs.getString("tanggalpemesanan"));
                pesanan.setMetodepembayaran(rs.getString("metodepembayaran"));
                pesanan.setTitikawal(rs.getString("titikawal"));
                pesanan.setTitikakhir(rs.getString("titikakhir"));
                pesanan.setTotalharga(rs.getInt("totalharga"));
                pesanan.setJarak(rs.getInt("jarak"));
                listPesanan.add(pesanan);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listPesanan;
    }
    public static ArrayList<PesananOjek> getAllPesananOjek(){
        ArrayList<PesananOjek> listPesananOjek = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM pesananojek";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                PesananOjek pesananOjek = new PesananOjek();
                Pesanan pesanan = new Pesanan();
                DatabaseControl ctrl = new DatabaseControl();
                ArrayList<Pesanan> listPesanan = new ArrayList<>();
                listPesanan = ctrl.getAllPesanan();
                
                for(int i = 0; i < listPesanan.size(); i++){
                    if(listPesanan.get(i).getId_pesanan() == rs.getInt("id_pesanan")){
                        pesanan = listPesanan.get(i);
                    }
                }
                pesananOjek.setId_pesananojek(rs.getInt("id_PesananOjek"));
                pesananOjek.setId_pesanan(rs.getInt("id_pesanan"));
                pesananOjek.setJeniskendaraan(rs.getString("JenisKendaraan"));
                pesananOjek.setStatuspesanan(rs.getInt("StatusPesanan"));
                
                pesananOjek.setId_pesanan(pesanan.getId_pesanan());
                pesananOjek.setCustomer(pesanan.getCustomer());
                pesananOjek.setDriver(pesanan.getDriver());
                pesananOjek.setTanggalpemesanan(pesanan.getTanggalpemesanan());
                pesananOjek.setMetodepembayaran(pesanan.getMetodepembayaran());
                pesananOjek.setTitikawal(pesanan.getTitikawal());
                pesananOjek.setTitikakhir(pesanan.getTitikakhir());
                pesananOjek.setTotalharga(pesanan.getTotalharga());
                pesananOjek.setJarak(pesanan.getJarak());
                
                listPesananOjek.add(pesananOjek);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listPesananOjek;
    }
    public static ArrayList<PesananFood> getAllPesananFood(){
        ArrayList<PesananFood> listPesananFood = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM pesananfood";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                PesananFood pesananFood = new PesananFood();
                Pesanan pesanan = new Pesanan();
                DatabaseControl ctrl = new DatabaseControl();
                ArrayList<Pesanan> listPesanan = new ArrayList<>();
                listPesanan = ctrl.getAllPesanan();
                
                for(int i = 0; i < listPesanan.size(); i++){
                    if(listPesanan.get(i).getId_pesanan() == rs.getInt("id_pesanan")){
                        pesanan = listPesanan.get(i);
                    }
                }
                pesananFood.setID_PesananFood(rs.getInt("id_PesananFood"));
                pesananFood.setId_pesanan(rs.getInt("id_pesanan"));
                pesananFood.setTotalHargaFood(rs.getInt("totalhargamakanan"));
                pesananFood.setStatusfood(rs.getInt("StatusPesanan"));
                
                pesananFood.setId_pesanan(pesanan.getId_pesanan());
                pesananFood.setCustomer(pesanan.getCustomer());
                pesananFood.setDriver(pesanan.getDriver());
                pesananFood.setTanggalpemesanan(pesanan.getTanggalpemesanan());
                pesananFood.setMetodepembayaran(pesanan.getMetodepembayaran());
                pesananFood.setTitikawal(pesanan.getTitikawal());
                pesananFood.setTitikakhir(pesanan.getTitikakhir());
                pesananFood.setTotalharga(pesanan.getTotalharga());
                pesananFood.setJarak(pesanan.getJarak());
                
                listPesananFood.add(pesananFood);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listPesananFood;
    }
    public static ArrayList<DetailPesanan> getAllDetailPesanan(int idPesanan){
        conn.connect();
        ArrayList<DetailPesanan> listPesanan = new ArrayList<>();
        String query = "SELECT * FROM detailfood WHERE id_pesanan = " + idPesanan;
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                DatabaseControl ctrl = new DatabaseControl();
                Food makanan = new Food();
                makanan = ctrl.getFood(rs.getInt("id_makanan"));
                
                DetailPesanan pesanan = new DetailPesanan();
                pesanan.setNamaMenu(makanan.getNamamakanan());
                pesanan.setHargaSatuan(makanan.getHargamakanan());
                pesanan.setQuantity(rs.getInt("quantity"));
                listPesanan.add(pesanan);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listPesanan;
    }
    public static Food getFood(int idFood){
        conn.connect();
        Food makanan = new Food();
        String query = "SELECT * FROM makanan WHERE id_Makanan = " + idFood;
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                DatabaseControl ctrl = new DatabaseControl();
                ArrayList<Restaurant> listRestaurant = new ArrayList<>();
                listRestaurant = ctrl.getAllRestaurant();
                Restaurant restaurant = new Restaurant();
                
                for(int i = 0; i < listRestaurant.size(); i++){
                    if(listRestaurant.get(i).getId_restaurant() == rs.getInt("id_Restoran")){
                        restaurant = listRestaurant.get(i);
                    }
                }
                
                makanan.setIdmakanan(rs.getInt("id_Makanan"));
                makanan.setRestaurant(restaurant);
                makanan.setNamamakanan(rs.getString("NamaMakanan"));
                makanan.setHargamakanan(rs.getInt("harga"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return makanan;
    }
    public static ArrayList<Food> getAllFood(){
        conn.connect();
        ArrayList<Food> listFood = new ArrayList<>();
        String query = "SELECT * FROM makanan";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                DatabaseControl ctrl = new DatabaseControl();
                ArrayList<Restaurant> listRestaurant = new ArrayList<>();
                listRestaurant = ctrl.getAllRestaurant();
                Restaurant restaurant = new Restaurant();
                for(int i = 0; i < listRestaurant.size(); i++){
                    if(listRestaurant.get(i).getId_restaurant() == rs.getInt("id_Restoran")){
                        restaurant = listRestaurant.get(i);
                    }
                }
                
                Food food = new Food();
                food.setIdmakanan(rs.getInt("id_Makanan"));
                food.setRestaurant(restaurant);
                food.setNamamakanan(rs.getString("NamaMakanan"));
                food.setHargamakanan(rs.getInt("harga"));
                
                listFood.add(food);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listFood;
    }
    public static ArrayList<Restaurant> getAllRestaurant(){
        conn.connect();
        ArrayList<Restaurant> listRestaurant = new ArrayList<>();
        String query = "SELECT * FROM restoran";
        
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Restaurant restaurant = new Restaurant();
                restaurant.setId_restaurant(rs.getInt("id_Restoran"));
                restaurant.setNamarestaurant(rs.getString("NamaRestoran"));
                restaurant.setAlamatrestaurant(rs.getString("Alamat"));
                listRestaurant.add(restaurant);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listRestaurant;
    }
    public static ArrayList<User> getAllUser(){
        conn.connect();
        ArrayList<User> listUser = new ArrayList<>();
        String query = "SELECT * FROM user";
        
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                User user = new User();
                user.setId_User(rs.getInt("id"));
                user.setNama(rs.getString("nama"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setTanggallahir(rs.getString("tanggallahir"));
                user.setNoHp(rs.getString("noHP"));
                user.setTipe(rs.getInt("tipe"));
                listUser.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listUser;
    }
    public static ArrayList<Admin> getAllAdmin(){
        conn.connect();
        String query = "SELECT * FROM admin";
        ArrayList<Admin> listAdmin = new ArrayList<>();
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Admin admin = new Admin();
                User user = new User();
                DatabaseControl ctrl = new DatabaseControl();
                ArrayList<User> listUser = new ArrayList<>();
                listUser = ctrl.getAllUser();
                
                for(int i = 0; i < listUser.size(); i++){
                    if(listUser.get(i).getId_User() == rs.getInt("id_user")){
                        user = listUser.get(i);
                    }
                }
                
                admin.setId_admin(rs.getInt("id_Admin"));
                admin.setAlamat("alamat");
                
                admin.setId_User(user.getId_User());
                admin.setNama(user.getNama());
                admin.setUsername(user.getUsername());
                admin.setPassword(user.getPassword());
                admin.setEmail(user.getEmail());
                admin.setTanggallahir(user.getTanggallahir());
                admin.setNoHp(user.getNoHp());
                admin.setTipe(user.getTipe());
                
                listAdmin.add(admin);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listAdmin;
    }
    public static ArrayList<Driver> getAllDriver(){
        conn.connect();
        String query = "SELECT * FROM driver";
        ArrayList<Driver> listDriver = new ArrayList<>();
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Driver driver = new Driver();
                User user = new User();
                DatabaseControl ctrl = new DatabaseControl();
                ArrayList<User> listUser = new ArrayList<>();
                listUser = ctrl.getAllUser();
                
                for(int i = 0; i < listUser.size(); i++){
                    if(listUser.get(i).getId_User() == (rs.getInt("id_user"))){
                        user = listUser.get(i);
                    }
                }
                
                driver.setId_driver(rs.getInt("id_Driver"));
                driver.setJeniskendaraan(rs.getString("jenisKendaraan"));
                driver.setPlatnomor(rs.getString("platNomor"));
                driver.setPendapatan(rs.getInt("pendapatan"));
                driver.setSaldoOvo(rs.getInt("saldoOvo"));
                driver.setStatus(rs.getString("status"));
                
                driver.setId_User(user.getId_User());
                driver.setNama(user.getNama());
                driver.setUsername(user.getUsername());
                driver.setPassword(user.getPassword());
                driver.setEmail(user.getEmail());
                driver.setTanggallahir(user.getTanggallahir());
                driver.setNoHp(user.getNoHp());
                driver.setTipe(user.getTipe());
                
                listDriver.add(driver);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listDriver;
    }
    public static ArrayList<Customers> getAllCustomer(){
        conn.connect();
        String query = "SELECT * FROM customers";
        ArrayList<Customers> listCustomer = new ArrayList<>();
        
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Customers customers = new Customers();
                User user = new User();
                DatabaseControl ctrl = new DatabaseControl();
                ArrayList<User> listUser = new ArrayList<>();
                listUser = ctrl.getAllUser();
                
                for(int i = 0; i < listUser.size(); i++){
                    if(listUser.get(i).getId_User() == (rs.getInt("id_user"))){
                        user = listUser.get(i);
                    }
                }
                
                customers.setId_customer(rs.getInt("id_Customers"));
                customers.setAlamat(rs.getString("alamat"));
                customers.setSaldoovo(rs.getInt("saldo"));
                
                customers.setId_User(user.getId_User());
                customers.setNama(user.getNama());
                customers.setUsername(user.getUsername());
                customers.setPassword(user.getPassword());
                customers.setEmail(user.getEmail());
                customers.setTanggallahir(user.getTanggallahir());
                customers.setNoHp(user.getNoHp());
                customers.setTipe(user.getTipe());
                
                listCustomer.add(customers);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listCustomer;
    }
    public static Driver getDriverByIdDriver(int idDriver){
        conn.connect();
        String query = "SELECT * FROM driver WHERE id_Driver = '" + idDriver + "'";
        Driver driver = new Driver();
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                User user = new User();
                DatabaseControl ctrl = new DatabaseControl();
                ArrayList<User> listUser = new ArrayList<>();
                listUser = ctrl.getAllUser();
                
                for(int i = 0; i < listUser.size(); i++){
                    if(listUser.get(i).getId_User() == (rs.getInt("id_user"))){
                        user = listUser.get(i);
                    }
                }
                
                driver.setId_driver(rs.getInt("id_Driver"));
                driver.setJeniskendaraan(rs.getString("jenisKendaraan"));
                driver.setPlatnomor(rs.getString("platNomor"));
                driver.setPendapatan(rs.getInt("pendapatan"));
                driver.setSaldoOvo(rs.getInt("saldoOvo"));
                driver.setStatus(rs.getString("status"));
                
                driver.setId_User(user.getId_User());
                driver.setNama(user.getNama());
                driver.setUsername(user.getUsername());
                driver.setPassword(user.getPassword());
                driver.setEmail(user.getEmail());
                driver.setTanggallahir(user.getTanggallahir());
                driver.setNoHp(user.getNoHp());
                driver.setTipe(user.getTipe());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return driver;
    }
    public static Customers getCustomerByIdCustomer(int idCustomer){
        conn.connect();
        String query = "SELECT * FROM customers WHERE id_Customers = '" + idCustomer + "'";
        Customers customers = new Customers();
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                User user = new User();
                DatabaseControl ctrl = new DatabaseControl();
                ArrayList<User> listUser = new ArrayList<>();
                listUser = ctrl.getAllUser();
                
                for(int i = 0; i < listUser.size(); i++){
                    if(listUser.get(i).getId_User() == (rs.getInt("id_user"))){
                        user = listUser.get(i);
                    }
                }
                
                customers.setId_customer(rs.getInt("id_Customers"));
                customers.setAlamat(rs.getString("alamat"));
                customers.setSaldoovo(rs.getInt("saldo"));
                
                customers.setId_User(user.getId_User());
                customers.setNama(user.getNama());
                customers.setUsername(user.getUsername());
                customers.setPassword(user.getPassword());
                customers.setEmail(user.getEmail());
                customers.setTanggallahir(user.getTanggallahir());
                customers.setNoHp(user.getNoHp());
                customers.setTipe(user.getTipe());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return customers;
    }
    public static ArrayList<User> getAllDriverUser(){
        ArrayList<User> listUser = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM user WHERE tipe='3'";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                User user = new User();
                user.setId_User(rs.getInt("id"));
                user.setNama(rs.getString("nama"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setTanggallahir(rs.getString("tanggallahir"));
                user.setNoHp(rs.getString("noHP"));
                user.setTipe(rs.getInt("tipe"));
                listUser.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listUser;
    }
    public static Pesanan getPesananTerbaru(){
        conn.connect();
        Pesanan pesanan = new Pesanan();
        String query = "SELECT * FROM pesanan ORDER BY id DESC LIMIT 1";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            DatabaseControl ctrl = new DatabaseControl();
            
            while(rs.next()){
                pesanan.setId_pesanan(rs.getInt("id"));
                pesanan.setCustomer(ctrl.getCustomerByIdCustomer(rs.getInt("idCustomer")));
                pesanan.setDriver(ctrl.getDriverByIdDriver(rs.getInt("idDriver")));
                pesanan.setTanggalpemesanan(rs.getString("tanggalpemesanan"));
                pesanan.setMetodepembayaran(rs.getString("metodepembayaran"));
                pesanan.setTitikawal(rs.getString("titikawal"));
                pesanan.setTitikakhir(rs.getString("titikakhir"));
                pesanan.setTotalharga(rs.getInt("totalharga"));
                pesanan.setJarak(rs.getInt("jarak"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return pesanan;
    }
    public static boolean insertNewPesanan(Pesanan pesanan){
        conn.connect();
        String query = "INSERT INTO pesanan (id,idCustomer,idDriver,titikawal,titikakhir,tanggalpemesanan,metodepembayaran,totalharga,jarak) values (?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, pesanan.getCustomer().getId_customer());
            stmt.setInt(3, pesanan.getDriver().getId_driver());
            stmt.setString(4, pesanan.getTitikawal());
            stmt.setString(5, pesanan.getTitikakhir());
            stmt.setString(6, pesanan.getTanggalpemesanan());
            stmt.setString(7, pesanan.getMetodepembayaran());
            stmt.setInt(8, pesanan.getTotalharga());
            stmt.setInt(9, pesanan.getJarak());
            
            stmt.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public static boolean insertNewPesananOjek(PesananOjek pesanan){
        conn.connect();
        String query = "INSERT INTO pesananojek (id_PesananOjek,id_pesanan,JenisKendaraan,StatusPesanan) values (?,?,?,?)";
        try{
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, pesanan.getId_pesanan());
            stmt.setString(3, pesanan.getJeniskendaraan());
            stmt.setInt(4, 2);
            
            stmt.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean insertNewPesananFood(PesananFood pesanan){
        conn.connect();
        String query = "INSERT INTO pesananfood (id_PesananFood,id_pesanan,totalhargamakanan,StatusPesanan) values (?,?,?,?)";
        try{
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, pesanan.getId_pesanan());
            stmt.setInt(3, pesanan.getTotalHargaFood());
            stmt.setInt(4, 2);
            
            stmt.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public static boolean insertNewDetailFood(ArrayList<DetailPesanan> listDetailFood, PesananFood pesanan){
        conn.connect();
        String query;
        for(int i = 0; i < listDetailFood.size(); i++){
            query = "INSERT INTO detailfood (id_pesanan, id_makanan, quantity) values (?,?,?)";
            try{
                PreparedStatement stmt = conn.con.prepareStatement(query);
                stmt.setInt(1, pesanan.getID_PesananFood());
                stmt.setInt(2, listDetailFood.get(i).getId_makanan());
                stmt.setInt(3, listDetailFood.get(i).getQuantity());
            }catch(SQLException e){
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
    public static boolean updateCustomer(Customers customer) {
        conn.connect();
        String query = "UPDATE customers SET saldo=" + customer.getSaldoovo() + " WHERE id_Customers=" + customer.getId_customer();
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static boolean updateDriver(Driver driver) {
        conn.connect();
        String query = "UPDATE driver SET saldoOvo=" + driver.getSaldoOvo() + " WHERE id_Driver=" + driver.getId_driver();
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static boolean updateStatusDriver(String status, int idDriver){
        conn.connect();
        String query = "UPDATE driver SET status = '" + status + "' WHERE id_Driver = " + idDriver;
        try{
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public static boolean updateStatusPesananFood(int status, int idPesananFood){
        conn.connect();
        String query = "UPDATE pesananfood SET StatusPesanan = '" + status + "' WHERE id_PesananFood = " + idPesananFood;
        try{
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public static boolean updateStatusPesananOjek(int status, int idPesananOjek){
        conn.connect();
        String query = "UPDATE pesananojek SET StatusPesanan = '" + status + "' WHERE id_PesananOjek = " + idPesananOjek;
        try{
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
