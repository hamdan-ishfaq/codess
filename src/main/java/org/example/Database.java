// Database.java

package org.example;

import javax.xml.crypto.Data;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class Database {

    public static Connection connect(){
        Connection con=null;
        try{
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection("jdbc:sqlite:forJava.db");
            System.out.println("Connected");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e+"");
        }
        return con;
    }

    public static boolean userLogin(String booksid){
        Connection con =Database.connect();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            String sql="SELECT * From Users where booksid=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,booksid);
            rs = ps.executeQuery();
            String name="";
            while(rs.next()){
                 name=rs.getString("Name");
            }
            if(name==""){
                return false;
            }
            else
                return true;
        }catch (SQLException e){
            System.out.println(e+"");
            return false;
        }finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

    }

    public static boolean borrowingBook(String booksid, String ubooksid){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            con= Database.connect();
            String sql="SELECT * FROM Books where booksid=? and status is null";
            ps=con.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(booksid));
            rs=ps.executeQuery();

            if(!rs.next()){
                return false;
            }
            ps.close();
            rs.close();

            con=Database.connect();

            sql = "update Books set status=? where booksid=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, ubooksid);
            ps.setInt(2, Integer.parseInt(booksid));
            ps.executeUpdate();

            ps.close();
            con.close();
            con=Database.connect();
            sql="update Users set Borrowed_Books=? where booksid=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,booksid);
            ps.setInt(2,Integer.parseInt(ubooksid));
            ps.executeUpdate();

            return true;
        }catch (SQLException e){
            System.out.println(e+"");
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e);
                return false;
            }
        }
    }

    public static boolean returningBook(String booksid,String ubooksid){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            con=Database.connect();
            String sql="SELECT * from Books where booksid=? and status=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(booksid));
            ps.setString(2,ubooksid);
            rs=ps.executeQuery();

            if(!rs.next())
                return false;

            sql="update Books set status=null where booksid=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(booksid));
            ps.executeUpdate();

            return true;
        }catch (SQLException e){
            System.out.println(e+"");
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e);
                return false;
            }
        }
    }

    public static ArrayList<Book> getingBooksCollection(){
        ArrayList<Book> books=new ArrayList<>();
        Connection con= Database.connect();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            String sql="SELECT * FROM Books";
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            String title="";
            String writer="";
            String category="";
            String status="";
            int booksid=0;
            while(rs.next()){
                title=rs.getString("title");
                writer=rs.getString("writer");
                category=rs.getString("category");
                status=rs.getString("status");
                booksid=rs.getInt("booksid");
                books.add(new Book(title,writer,category,status,booksid));
            }
        }catch (SQLException e){
            System.out.println(e+"");
        }finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return books;
    }

    public static ArrayList<Book> searchingForBooksByTitle(String title){
        ArrayList<Book> books=new ArrayList<>();
        Connection con =Database.connect();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            String sql="select * from Books where title =?";
            ps=con.prepareStatement(sql);
            ps.setString(1,title);
            rs=ps.executeQuery();
            String _title="";
            String writer="";
            String category="";
            String status="";
            int booksid=0;
            while(rs.next()){
                _title=rs.getString("title");
                writer=rs.getString("writer");
                category=rs.getString("category");
                status=rs.getString("status");
                booksid=rs.getInt("booksid");
                books.add(new Book(_title,writer,category,status,booksid));
            }

        }catch (SQLException e){
            System.out.println(e+"");
        }finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return books;
    }

    public static ArrayList<Book> searchingForBooksBywriter(String _writer){
        ArrayList<Book> books=new ArrayList<>();
        Connection con =Database.connect();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            String sql="select * from Books where writer =?";
            ps=con.prepareStatement(sql);
            ps.setString(1,_writer);
            rs=ps.executeQuery();
            String _title="";
            String writer="";
            String category="";
            String status="";
            int booksid=0;
            while(rs.next()){
                _title=rs.getString("title");
                writer=rs.getString("writer");
                category=rs.getString("category");
                status=rs.getString("status");
                booksid=rs.getInt("booksid");
                books.add(new Book(_title,writer,category,status,booksid));
            }

        }catch (SQLException e){
            System.out.println(e+"");
        }finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return books;
    }

    public static ArrayList<Book> searchForBooksBybooksid(String _booksid){
        ArrayList<Book> books=new ArrayList<>();
        Connection con =Database.connect();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            String sql="select * from Books where booksid =?";
            ps=con.prepareStatement(sql);
            ps.setString(1,_booksid);
            rs=ps.executeQuery();
            String _title="";
            String writer="";
            String category="";
            String status="";
            int booksid=0;
            while(rs.next()){
                _title=rs.getString("title");
                writer=rs.getString("writer");
                category=rs.getString("category");
                status=rs.getString("status");
                booksid=rs.getInt("booksid");
                books.add(new Book(_title,writer,category,status,booksid));
            }

        }catch (SQLException e){
            System.out.println(e+"");
        }finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return books;
    }

    public static boolean bookAddition(String title,String writer,String category){
        Connection con=Database.connect();
        PreparedStatement ps=null;
        try{
            String sql="insert into Books(title,writer,category) values(?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,title);
            ps.setString(2, writer);
            ps.setString(3,category);
            ps.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e+"");
            return false;
        }finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }


    public static boolean userAddition(String name,String contactInfo){
        Connection con =Database.connect();
        PreparedStatement ps=null;
        try{
            String sql="insert into Users(Name,Contact_Info) values(?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,contactInfo);
            ps.execute();
            return true;

        }catch (SQLException e){
            System.out.println(e+"");
            return false;
        }finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }




}
