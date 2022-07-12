package util;

import db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 7/12/2022
 **/
public class IDGenController {
    public static String getLastID(String tableName,String columnName) throws Exception{
        String sql="SELECT "+columnName+" FROM "+tableName+" ORDER BY 1 DESC LIMIT 1";
        Connection con= DBConnection.getInstance().getConnection();
        ResultSet stm=con.createStatement().executeQuery(sql);
        if (stm.next()) {
            return stm.getString(1);
        }
        return null;
    }
}
