package db.mysql;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


public class MySQLTableCreation {

	public static void main(String[] args) {
		try {
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			// This is java.sql.Connection. Not com.mysql.jdbc.Connection
			Connection conn = null;
			
			try {
				System.out.println("Connection to \n" + MySQLDBUtil.URL);
				conn = DriverManager.getConnection(MySQLDBUtil.URL);	
			} catch(SQLException e) {
				System.out.println("SQL Exception " + e.getMessage());
				System.out.println("SQL State " + e.getSQLState());
				System.out.println("VendorError " + e.getErrorCode());
			}
			
			if (conn == null) {
				return;
			}
			/**
			 * Syntax for DROP:
			 * 
				DROP TABLE IF EXISTS TABLE table_name;
			 */
			// Step 2 Drop tables in case they exist. 
			Statement stmt = conn.createStatement();
			
			String sql = "DROP TABLE IF EXISTS history"; 
			stmt.executeUpdate(sql);
			
			sql = "DROP TABLE IF EXISTS categories"; 
			stmt.executeUpdate(sql);
			
			sql = "DROP TABLE IF EXISTS items"; 
			stmt.executeUpdate(sql);
			
			sql = "DROP TABLE IF EXISTS users"; 
			stmt.executeUpdate(sql);

			
			// Step 3. Create new tables.
			sql = "CREATE TABLE items " 
					+ "(item_id VARCHAR(255) NOT NULL, " 
					+ "name VARCHAR(255), "
					+ "city VARCHAR(255), " 
					+ "state VARCHAR(255), " 
					+ "country VARCHAR(255), "
					+ "zipcode VARCHAR(255), " 
					+ "rating FLOAT,"
					+ "address VARCHAR(255), " 
					+ "latitude FLOAT, "
					+ "longitude FLOAT, " 
					+ "description VARCHAR(255), " 
					+ "snippet VARCHAR(255), "
					+ "snippet_url VARCHAR(255), " 
					+ "image_url VARCHAR(255)," 
					+ "url VARCHAR(255),"
					+ "PRIMARY KEY ( item_id ))";
			stmt.executeUpdate(sql);
/**
		TABLE : categories
					    
		PRIMARY  item_id			VARCHAR(255)			NOT NULL	
			
				 category		VARCHAR(255)	

*/	
			
			sql = "CREATE TABLE categories " 
					+ "(item_id VARCHAR(255) NOT NULL, " 
					+ "category VARCHAR(255), "
					+ "PRIMARY KEY ( item_id, category), " 
					+ "FOREIGN KEY (item_id) REFERENCES items(item_id))";
			stmt.executeUpdate(sql);

/**
		TABLE : user
				    
		PRIMARY  user_id			VARCHAR(255)			NOT NULL	
		
				 password		VARCHAR(255)			NOT NULL	
				 first_name		VARCHAR(255)
				 last_name		VARCHAR(255)
*/
			
			
			sql = "CREATE TABLE users " 
					+ "(user_id VARCHAR(255) NOT NULL, " 
					+ "password VARCHAR(255) NOT NULL, "
					+ "first_name VARCHAR(255), " 
					+ "last_name VARCHAR(255), " 
					+ "PRIMARY KEY ( user_id ))";
			stmt.executeUpdate(sql);
			
			
/**
		TABLE : history
			    
		PRIMARY  history_id			bigint (20)		unsigned		NOT NULL		AUTO_INCREMENT
		
		FOREIGN  user_id				VARCHAR(255)					NOT NULL		
	 	FOREIGN  item_id				VARCHAR(255)					NOT NULL		
	 	
			     last_favor_time		timestamp					NOT NULL		DEFAULT CURRENT_TIMESTAMP
*/

			sql = "CREATE TABLE history " 
					+ "(history_id bigint(20) unsigned NOT NULL AUTO_INCREMENT, "
					+ "user_id VARCHAR(255) NOT NULL , " 
					+ "item_id VARCHAR(255) NOT NULL, "
					+ "last_favor_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, " 
					+ "PRIMARY KEY (history_id),"
					+ "FOREIGN KEY (item_id) REFERENCES items(item_id),"
					+ "FOREIGN KEY (user_id) REFERENCES users(user_id))";
			stmt.executeUpdate(sql);
			
			
			
			
			// Step 4: insert data
			/**
			 * Syntax for INSERT:
			 * 
				INSERT INTO table_name (column1, column2, column3, ...)
				VALUES (value1, value2, value3, ...);
			 */
			// Create a fake user
			sql = "INSERT INTO users " + "VALUES (\"1111\", \"3229c1097c00d497a0fd282d586be050\", \"John\", \"Smith\")";

			System.out.println("Executing query:\n" + sql);
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO users " + "VALUES (\"2222\", \"331813e554ebac9113407c9232ecc999\", \"John\", \"Smith\")";

			System.out.println("Executing query:\n" + sql);
			stmt.executeUpdate(sql);

			System.out.println("Import is done successfully.");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}