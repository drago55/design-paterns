package main.structural_design_patterns.facade;

import java.sql.Connection;

public class HelperFacade {

	public static void generateReport(DBType dbType, ReportTypes reportType, String tableName) {
		Connection con = null;

		switch (dbType) {
		case MYSQL:
			con = MySqlHelper.getMySqlDBConnection();
			MySqlHelper mySqlHelper = new MySqlHelper();
			switch (reportType) {
			case HTML:
				mySqlHelper.generateMySqlHTMLReport(tableName, con);
				break;
			case PDF:
				mySqlHelper.generateMySqlPDFReports(tableName, con);
				break;
			}
			break;

		case ORACLE:
			con = OracleHelper.getOracleDBConnection();
			OracleHelper oracleHelper = new OracleHelper();
			switch (reportType) {
			case HTML:
				oracleHelper.generateOracleHTMLReport(tableName, con);
				break;
			case PDF:
				oracleHelper.generateOraclePDFReport(tableName, con);
				break;
			}
			break;
		}

	}

	public static enum DBType {
		MYSQL, ORACLE;
	}

	public static enum ReportTypes {
		HTML, PDF
	}
}
