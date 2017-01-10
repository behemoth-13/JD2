package by.pvt.dao.pool;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by Alex on 05.01.2017.
 */
public class ConnectionPoolTest {

    private ConnectionPool connectionPoolTest;

    @Test
    public void getInstance() throws Exception {
        connectionPoolTest = ConnectionPool.getInstance();
        assertEquals(ConnectionPool.class, connectionPoolTest.getClass());
    }

    @Test  (expected = NullPointerException.class)
    public void takeTestNull() throws Exception {
        Connection connectionTest = connectionPoolTest.take();
    }

    @Test
    public void takeTest() throws Exception {
        connectionPoolTest = ConnectionPool.getInstance();
        connectionPoolTest.init();
        Connection connectionTest = connectionPoolTest.take();
    }
}