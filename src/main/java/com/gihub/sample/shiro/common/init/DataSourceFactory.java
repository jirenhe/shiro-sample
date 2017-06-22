package com.gihub.sample.shiro.common.init;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceFactory {

	private static DataSourceFactory instance;

	private ComboPooledDataSource C3DataSource;

	private BasicDataSource dpDataSource;

	private DataSourceFactory() {
		initC3p0DataSource();
		initComonDbcpDataSource();
	}

	private void initComonDbcpDataSource() {
		dpDataSource = new BasicDataSource();
		String contextPath = DataSourceFactory.class.getClassLoader().getResource("").getPath();
		System.out.println(contextPath + "jdbc.properties");
		Properties jdbcProperties = new Properties();
		try {
			jdbcProperties.load(new FileInputStream(new File(contextPath + "jdbc.properties")));
			dpDataSource.setDriverClassName(jdbcProperties.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		dpDataSource.setUrl(jdbcProperties.getProperty("url"));
		dpDataSource.setUsername(jdbcProperties.getProperty("username"));
		dpDataSource.setPassword(jdbcProperties.getProperty("password"));
	}

	private void initC3p0DataSource() {
		C3DataSource = new ComboPooledDataSource();
		String contextPath = DataSourceFactory.class.getClassLoader().getResource("").getPath();
		System.out.println(contextPath + "jdbc.properties");
		Properties jdbcProperties = new Properties();
		try {
			jdbcProperties.load(new FileInputStream(new File(contextPath + "jdbc.properties")));
			C3DataSource.setDriverClass(jdbcProperties.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		C3DataSource.setJdbcUrl(jdbcProperties.getProperty("url"));
		C3DataSource.setUser(jdbcProperties.getProperty("username"));
		C3DataSource.setPassword(jdbcProperties.getProperty("password"));
	}

	public static DataSourceFactory getInstance() {
		if (null == instance)
			instance = new DataSourceFactory();
		return instance;
	}

	public ComboPooledDataSource getC3DataSource() {
		return C3DataSource;
	}

	public BasicDataSource getDpDataSource() {
		return dpDataSource;
	}

	public static void main(String[] args) {
		// DataSourceFactory.getInstance().getDataSource();
	}

}
