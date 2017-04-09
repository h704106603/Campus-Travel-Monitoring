package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//basedao的配置化被封装。未开启自动提交事务
public class ExecuteQuery {

		public static boolean executeQuery(String sql){
			Connection conn = null;
			
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "hang", "hang");
				conn.setAutoCommit(true);
				Statement stmt = conn.createStatement();
				stmt.executeQuery(sql);
				stmt.close();
				conn.close();
			}catch(SQLException e){
				try{
					conn.rollback();
					return false;
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			} catch (ClassNotFoundException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
				return false;
			}
			return true;
		}
}
