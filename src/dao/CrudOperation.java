package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 7/12/2022
 **/
public class CrudOperation {
    private static PreparedStatement getPreparedStatement(String sql, Object... param) throws SQLException, Exception {
        Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);

        for (int i = 0; i < param.length; i++) {
            pstm.setObject(i + 1, param[i]);
        }
        return pstm;
    }

    public static boolean executeUpdate(String sql, Object... param) throws Exception {
        return getPreparedStatement(sql, param).executeUpdate() > 0;

    }
    public static ResultSet executeQuery(String sql, Object... param) throws Exception {
        return getPreparedStatement(sql, param).executeQuery();

    }
}
