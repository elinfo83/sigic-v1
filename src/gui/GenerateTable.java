package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;

import util.ConstantsSystem;

public class GenerateTable extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet;
	private String query;




	public GenerateTable(String query){
		this.query = query;
		if (!query.equals("")) {
			this.setQuery(query);
		}

	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
		fireTableStructureChanged();
	}



	@SuppressWarnings("unchecked")
	public Class<Object> getColumnClass(int column) {

		if(!getQuery().equals("")){
			try {

				this.connectBank();
				this.resultSet = this.statement.executeQuery(getQuery());
				String name = this.resultSet.getMetaData().getColumnClassName(column+1);
				this.closeConnection();
				return (Class<Object>) Class.forName(name);
			} catch (SQLException e) {
				try {
					this.closeConnection();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				try {
					this.closeConnection();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
		return Object.class;
	}

	
	public String getColumnName(int column) {
		String name = "";

		switch (column) {
		case 0: name =  "Rg";

		break;
		case 1: name =  "Nome";

		break;
		case 2: name =  "Data Nascimento";

		break;
		case 3: name =  "Email";

		break;
		default:
			break;
		}

		return name;
	}


	public void executeQuery(String query){
		fireTableStructureChanged();
	}

	private void connectBank() throws ClassNotFoundException, SQLException{
		Class.forName(ConstantsSystem.JDBC_DRIVER);
		connection = DriverManager.getConnection(ConstantsSystem.DATABASE_URL, ConstantsSystem.USER, ConstantsSystem.PASSWORD);
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	}

	private void closeConnection() throws SQLException{
		if(this.statement != null && this.connection!= null){
			this.statement.close();
			this.connection.close();
		}
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		int numLinhas = 0;
		if(!getQuery().equals("")){
			try {
				this.connectBank();
				this.resultSet = this.statement.executeQuery(getQuery());
				numLinhas = this.resultSet.getRow();
				this.closeConnection();
			} catch (ClassNotFoundException e) {
				try {
					this.closeConnection();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			} catch (SQLException e) {
				try {
					this.closeConnection();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
		return numLinhas;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	public Object getValueAt(int row, int column) {
		if(!getQuery().equals("")){
			try {
				this.connectBank();
				this.resultSet = this.statement.executeQuery(this.getQuery());
				resultSet.absolute(row +1);
				this.closeConnection();
				return resultSet.getObject(column +1);
			} catch (SQLException e) {
				try {
					this.closeConnection();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			} catch (ClassNotFoundException e) {		
				try {
					this.closeConnection();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}

		return "";
	}

}
