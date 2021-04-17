package com.bluff.domain.repository;

import com.bluff.domain.dao.UserDao;
import com.bluff.domain.dto.user.User;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryJdbc implements UserDao {

    private final DataSource dataSource;

    public UserRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User save(User user) {
        String sql = "insert into user(name) values(?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getName());
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) { user.setId(rs.getLong(1));
            } else {
                throw new SQLException("id 조회 실패");
            }
            return user;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        String sql = "select * from user where id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql); pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                User user = new User(); user.setId(rs.getLong("id")); user.setName(rs.getString("name")); return Optional.of(user);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }



    @Override
    public Optional<User> findByName(String name) {
        String sql = "select * from user where name = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql); pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                User user = new User(); user.setId(rs.getLong("id")); user.setName(rs.getString("name")); return Optional.of(user);
            }
            return Optional.empty(); } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<User> users = new ArrayList<>(); while(rs.next()) {
                User user = new User(); user.setId(rs.getLong("id")); user.setName(rs.getString("name")); users.add(user);
            }
            return users;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }



    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }

    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
    {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); }
        try {
            if (pstmt != null) {
                pstmt.close(); }
        } catch (SQLException e) { e.printStackTrace();
        } try {
        if (conn != null) {
            close(conn);
        }
    } catch (SQLException e) {
        e.printStackTrace(); }
    }

    private void close(Connection conn) throws SQLException {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }
}