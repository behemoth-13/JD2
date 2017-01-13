package by.pvt.dao.impl;

import by.pvt.bean.BrandOfCar;
import by.pvt.dao.SqlDAO;
import by.pvt.dao.pool.ConnectionPool;
import by.pvt.exception.InitException;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by Alex on 05.01.2017.
 */
public class SqlBrandsOfCarDAOTest extends SqlDAO{

    private ConnectionPool connectionPoolTest;
    private SqlBrandsOfCarDAO sqlBrandsOfCarDAOTest;

    @Before
    public void makePoolInstance() throws InitException {
        connectionPoolTest = ConnectionPool.getInstance();
        connectionPoolTest.init();
        sqlBrandsOfCarDAOTest = SqlBrandsOfCarDAO.getInstance();
    }

    @Test
    public void getInstance() throws Exception {
        sqlBrandsOfCarDAOTest = SqlBrandsOfCarDAO.getInstance();
        assertEquals(SqlBrandsOfCarDAO.class, sqlBrandsOfCarDAOTest.getClass());
    }

    @Test
    public void addBrandOfCar() throws Exception {
        addBrandofCar("Mercedes");
        addBrandofCar("Toyota");

    }

    @Test
    public void getBrandsOfCars() throws Exception {
        addBrandofCar("Mercedes");
        addBrandofCar("Toyota");
        List<BrandOfCar> list;
        list = sqlBrandsOfCarDAOTest.getBrandsOfCars();
        assertEquals(2, list.size());
    }

    @Test
    public void getBrandsOfCarsById() throws Exception {

    }

    @Test
    public void deleteBrandOfCarById() throws Exception {

    }

    @Test
    public void isBrandsOfCarsExist() throws Exception {

    }

    private void addBrandofCar(String name) throws SQLException, InterruptedException {
        BrandOfCar brandOfCarTest = new BrandOfCar();
        brandOfCarTest.setName("name");
        brandOfCarTest.setLoadingCapacity(1);
        brandOfCarTest.setCapacity(1);
        brandOfCarTest.setCostPerKM(1);
        sqlBrandsOfCarDAOTest.addBrandOfCar(brandOfCarTest);
    }

}