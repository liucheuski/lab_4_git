package by.iba.lab_4_git.dao;

import by.iba.lab_4_git.entity.Office;

import java.sql.*;

import static java.lang.System.currentTimeMillis;

public class OfficeDao {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int st;

    public int insert(Office office) {
        long start = currentTimeMillis();
        con = ConnectionFactory.getConnection();
        try {
            String query = "insert into office (number,name,address,postCode,phoneNumber) "
                    + "values(?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, office.getNumber());
            ps.setString(2, office.getName());
            ps.setString(3, office.getAddress());
            ps.setString(4, office.getPostCode());
            ps.setString(5, office.getPhoneNumber());
            st = ps.executeUpdate();
            System.out.println("inserted student " + st);
        } catch (SQLIntegrityConstraintViolationException e) {
            st = -1;
            e.printStackTrace();
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        long finish = currentTimeMillis();
        System.out.println(finish - start);
        return st;

    }

    public int update(Office office) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "update office set number=?,name=?,address=?,postCode=?,phoneNumber=? where id=? ";
            ps = con.prepareStatement(query);
            ps.setInt(1, office.getNumber());
            ps.setString(2, office.getName());
            ps.setString(3, office.getAddress());
            ps.setString(4, office.getPostCode());
            ps.setString(5, office.getPhoneNumber());
            ps.setLong(6, office.getId());
            st = ps.executeUpdate();
            System.out.println("updated office " + st);
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }

    public int delete(int id) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "delete from office where id=? ";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            st = ps.executeUpdate();
            System.out.println("deleted office " + st);
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }

    public Office findById(int id) {
        Office office = new Office();
        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from office where id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                office.setId(rs.getInt("id"));
                office.setNumber(rs.getInt("number"));
                office.setName(rs.getString("name"));
                office.setAddress(rs.getString("address"));
                office.setPostCode(rs.getString("postCode"));
                office.setPhoneNumber(rs.getString("phoneNumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return office;
    }
}
