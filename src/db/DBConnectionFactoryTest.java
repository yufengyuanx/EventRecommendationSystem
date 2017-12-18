package db;

import static org.junit.Assert.*;

import org.junit.Test;

import db.mysql.MySQLConnection;
import db.mongodb.MongoDBConnection;;

public class DBConnectionFactoryTest {

	@Test
	public void testGetDBConnectionDefalut() {
		DBConnection conn = DBConnectionFactory.getDBConnection();
		assertEquals(conn, MySQLConnection.getInstance());
	}
	
	@Test
	public void testGetDBConnectionMySQL() {
		DBConnection conn = DBConnectionFactory.getDBConnection("mysql");
		assertEquals(conn, MySQLConnection.getInstance());
	}
	
	@Test
	public void testGetDBConnectionMongoDB() {
		DBConnection conn = DBConnectionFactory.getDBConnection("mongodb");
		assertEquals(conn, MongoDBConnection.getInstance());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetDBConnectionInvalid() {
		@SuppressWarnings("unused")
		DBConnection conn = DBConnectionFactory.getDBConnection("invalid string");
	}

}
