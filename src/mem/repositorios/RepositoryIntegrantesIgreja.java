package mem.repositorios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;

import mem.exception.InvalidDateException;
import mem.exception.MemberNoRegisterException;
import mem.interfaces.IRepositoryIntegrantesIgreja;
import mem.model.documentos.Historico;
import mem.model.integrantesIg.IntegranteIgreja;
import mem.model.integrantesIg.IntegrantesIgrejaTypes;
import util.Address;
import util.ConstantsSystem;
import util.Date;
import util.Sexo;
import util.TelephonesTypes;

public class RepositoryIntegrantesIgreja implements IRepositoryIntegrantesIgreja  {
	
	private Connection connection = null;
	private Statement statement = null;
	
	public RepositoryIntegrantesIgreja() {
		
	}
	
	/* Testado status:Funcionando corretamente*/
	
	public void insert(IntegranteIgreja integranteIg) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException{
		
		String insertIntIg = "";
		String insertDadosPessoais = "";
		String insertFiliacao = "";
		String insertTelefones = "";
		String insertIntDep = "";
		String insertEndereco = "";
		
		
		
		insertIntIg = "INSERT INTO integrantesIgreja VALUES ('" +
		integranteIg.getRg() + "','" + integranteIg.getType().name() + "','" + 
		integranteIg.getDataConversao() + "','" + integranteIg.getDataBatismo()  + "','" +integranteIg.getHistorico().getPath()+ 
		"','" +integranteIg.getTitulo()+"');";
		
		insertDadosPessoais = "INSERT INTO dadosPessoais VALUES('"+
		integranteIg.getRg() + "','" + integranteIg.getNome() + "','" +  integranteIg.getDataNascimento() + "','" +
		integranteIg.getEstadoCivil() + "','" + integranteIg.getPathPhoto() + "','" + integranteIg.getEmail()+
		"','" +integranteIg.getSexo().name()+ "','" +integranteIg.getNaturalidade()+"');" ;
		
		
		insertFiliacao = "INSERT INTO filiacao VALUES('"+
		integranteIg.getRg() + "','" + integranteIg.getNomePai() + "','" + 
		integranteIg.getNomeMae()+ "');" ;
		
		
		insertTelefones = "INSERT INTO telefones VALUES('"+
		integranteIg.getRg() + "','" + integranteIg.getTelefones().get(TelephonesTypes.RESIDENCIAL) + "','"  +
		integranteIg.getTelefones().get(TelephonesTypes.CELULAR)+ "','"  + integranteIg.getTelefones().get(TelephonesTypes.COMERCIAL) + "');" ;
		
		insertIntDep = "INSERT INTO integrantesDep VALUES('"+
		integranteIg.getCodDep() + "','" + integranteIg.getRg() + "');" ;
		
		insertEndereco = "INSERT INTO enderecos VALUES ('" +
		integranteIg.getRg()+ "','" + integranteIg.getEndereco().getRua() + "','" +
		integranteIg.getEndereco().getNumCasa()+ "','" +
		integranteIg.getEndereco().getCep()+ "','" +
		integranteIg.getEndereco().getBairro()+ "','" +
		integranteIg.getEndereco().getCidade()+ "','" +
		integranteIg.getEndereco().getEstado()+ "','" +
		integranteIg.getEndereco().getComplemento()+ "');" ;
		
		
		this.connectBank();
		
		this.statement.executeUpdate(insertIntIg);
		this.statement.executeUpdate(insertDadosPessoais);
		this.statement.executeUpdate(insertFiliacao);
		this.statement.executeUpdate(insertTelefones);
		this.statement.executeUpdate(insertIntDep);
		this.statement.executeUpdate(insertEndereco);
		integranteIg.getHistorico().register();
		this.closeConnection();
		
		
	}
	
	public void remove(String rg) throws SQLException, MemberNoRegisterException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		
		String deleteDadosPessoais = "";
		String deleteIntIg = "";
		String deleteFiliacao = "";
		String deleteTelefones = "";
		String deleteIntDep = "";
		String deleteEnderecos = "";
		
		if(this.exist(rg)){
			
			deleteDadosPessoais = "DELETE FROM dadosPessoais WHERE rg = '" + rg + "';";
			deleteIntIg = "DELETE FROM integrantesIgreja WHERE rg = '" + rg + "';";
			deleteFiliacao = "DELETE FROM filiacao WHERE rg = '" + rg + "';";
			deleteTelefones = "DELETE FROM telefones WHERE rg = '" + rg + "';";
			deleteIntDep = "DELETE FROM integrantesDep WHERE rg = '" + rg + "';";
			deleteEnderecos = "DELETE FROM enderecos WHERE rg = '" + rg + "';";
			
						
			this.connectBank();
			
			this.statement.executeUpdate(deleteDadosPessoais);
			this.statement.executeUpdate(deleteIntIg);
			this.statement.executeUpdate(deleteFiliacao);
			this.statement.executeUpdate(deleteTelefones);
			this.statement.executeUpdate(deleteIntDep);
			this.statement.executeUpdate(deleteEnderecos);
			
			
			this.closeConnection();
		}else{
			throw new MemberNoRegisterException();
		}
	}
	
	public boolean exist(String rg) throws SQLException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		
		
		String query = "SELECT rg FROM dadosPessoais " +
				"WHERE rg = '" +rg +"'";
		boolean resp = false;
		
		this.connectBank();
		ResultSet resultSet = this.statement.executeQuery(query);
		resp = resultSet.next();
		this.closeConnection();
		return resp;
		
	}
	
	public void update(IntegranteIgreja integranteIg) throws SQLException, MemberNoRegisterException, ClassNotFoundException, InvalidDateException, FileNotFoundException, IOException{
		
		String updateIntIg = "";
		String updateDadosPessoais = "";
		String updateFiliacao = "";
		String updateTelefones = "";
		String updateIntDep = "";
		String updateEnderecos = "";
		
		String rg = integranteIg.getRg();
		
		if(exist(integranteIg.getRg())){
			
			updateIntIg = "UPDATE integrantesIgreja SET tipo = '" + integranteIg.getType() + "', dataConversao = '" + 
			integranteIg.getDataConversao() + "' , dataBatismo = '" + integranteIg.getDataBatismo()+
			"' , titulo = '" + integranteIg.getTitulo()+
			"' WHERE rg = '" + rg + "';";
			
			updateDadosPessoais = "UPDATE dadosPessoais SET nome = '" + integranteIg.getNome() + 
			"' , dataNascimento = '" + integranteIg.getDataNascimento() + "', estadoCivil = '" +
			integranteIg.getEstadoCivil() + "', pathPhoto = '" + integranteIg.getPathPhoto() + "', email = '" + 
			integranteIg.getEmail()+ "', sexo = '"+ integranteIg.getSexo().name() +
			"' WHERE rg = '" + rg + "';";
			
			updateFiliacao = "UPDATE filiacao SET nomePai = '" +
			integranteIg.getNomePai() + "', nomeMae = '" + 
			integranteIg.getNomeMae() + "' WHERE rg = '" + rg +"';" ;
			
			updateTelefones = "UPDATE telefones  SET residencial = '" + 
			integranteIg.getTelefones().get(TelephonesTypes.RESIDENCIAL) + "', celular = '"  +
			integranteIg.getTelefones().get(TelephonesTypes.CELULAR)+ "', comercial = '"  + 
			integranteIg.getTelefones().get(TelephonesTypes.COMERCIAL) + 
			"' WHERE rg = '" + rg +"';";
			
			updateIntDep = "UPDATE integrantesDep SET codDep = '" +
			integranteIg.getCodDep() + "' WHERE rg = '" + rg +"';";
			
			updateEnderecos = "UPDATE enderecos SET rua = '"+
			integranteIg.getEndereco().getRua() + "',numCasa = '" +
			integranteIg.getEndereco().getNumCasa()+ "', cep = '" +
			integranteIg.getEndereco().getCep()+ "', bairro = '" +
			integranteIg.getEndereco().getBairro()+ "', cidade = '" +
			integranteIg.getEndereco().getCidade()+ "', estado = '" +
			integranteIg.getEndereco().getEstado()+ "' WHERE rg = '" + rg +"';";
			
			System.out.println(updateDadosPessoais);
			System.out.println(updateFiliacao);
			System.out.println(updateTelefones);
			System.out.println(updateIntDep);
			System.out.println(updateEnderecos);
			
			this.connectBank();
			
			this.statement.executeUpdate(updateIntIg);
			this.statement.executeUpdate(updateDadosPessoais);
			this.statement.executeUpdate(updateFiliacao);
			this.statement.executeUpdate(updateTelefones);
			this.statement.executeUpdate(updateIntDep);
			integranteIg.getHistorico().register();
			this.closeConnection();
		}else{
			throw new MemberNoRegisterException();
		}
		
	}
	
	
	public IntegranteIgreja find(String rg) throws SQLException, InvalidDateException, MemberNoRegisterException, ClassNotFoundException, FileNotFoundException, IOException{
		
		ResultSet resultSet = null;
		String query = "";
		IntegranteIgreja temp = null;
		
		if(exist(rg)){
			// CONSULTAS NO BANCO
			query = "SELECT DP.rg, DP.nome, DP.dataNascimento, DP.estadoCivil, DP.pathphoto, DP.email, DP.sexo, DP.naturalidade, " +
			"II.tipo, II.dataConversao, II.dataBatismo, II.pathHistorico, ID.codDep, T.residencial, T.celular, T.comercial, " +
			"F.nomePai, F.nomeMae, E.rua, E.numCasa, E.cep, E.bairro, E.cidade, E.estado, E.complemento, II.titulo " +
			"FROM dadosPessoais  DP, integrantesIgreja  II, integrantesDep  ID, telefones  T, filiacao  F, enderecos  E " +
			"WHERE (DP.rg = '"+ rg +"') AND (II.rg = '"+ rg +"') AND (ID.rg = '"+ rg +"') AND (E.rg = '"+ rg +"') " +
					"AND (F.rg = '"+ rg +"') AND (T.rg = '"+ rg +"');";
			
			this.connectBank();
			resultSet = this.statement.executeQuery(query);
			
			if (resultSet.next()) {
				
				temp = createIntegranteIgrejaComplete(resultSet);
				this.closeConnection();
				return temp;
				
			} else{
				this.closeConnection();
				return null;
			}
			
			
		}else{
			throw new MemberNoRegisterException();
		}
		
	}
	
	private IntegranteIgreja createIntegranteIgrejaComplete(ResultSet resultSet) throws SQLException, InvalidDateException, FileNotFoundException, IOException, ClassNotFoundException
	{
		
		IntegranteIgreja integranteIg = new IntegranteIgreja();
		
		Sexo sexo = null;
		IntegrantesIgrejaTypes type = null;
		
		
		if (((String)resultSet.getObject(7)).equals("MASCULINO")) {
			sexo = Sexo.MASCULINO;
		} else {
			sexo = Sexo.FEMININO;
		}
		
		if (((String) resultSet.getObject(9)).equals("MEMBRO")) {
			type = IntegrantesIgrejaTypes.MEMBRO;
		} else {
			type = IntegrantesIgrejaTypes.CONGREGADO;
		}
		
		integranteIg.setRg((String)resultSet.getObject(1));
		integranteIg.setNome((String)resultSet.getObject(2));
		integranteIg.setDataNascimento(new Date((String)resultSet.getObject(3)));
		integranteIg.setEstadoCivil((String)resultSet.getObject(4));
		integranteIg.setPathPhoto((String)resultSet.getObject(5));
		integranteIg.setEmail((String)resultSet.getObject(6));
		integranteIg.setSexo(sexo);
		integranteIg.setNaturalidade((String)resultSet.getObject(8));
		
		integranteIg.setType(type);
		integranteIg.setDataConversao(new Date((String)resultSet.getObject(10)));
		integranteIg.setDataBatismo(new Date((String)resultSet.getObject(11)));
		integranteIg.setHistorico(Historico.getHistorico((String)resultSet.getObject(12)));
		integranteIg.setTitulo((String)resultSet.getObject(26));
		
		integranteIg.setCodDep((String)resultSet.getObject(13));
		
		integranteIg.addTelefone(TelephonesTypes.RESIDENCIAL,(String)resultSet.getObject(14));
		integranteIg.addTelefone(TelephonesTypes.CELULAR,(String)resultSet.getObject(15));
		integranteIg.addTelefone(TelephonesTypes.COMERCIAL,(String)resultSet.getObject(16));
		
		integranteIg.setNomePai((String)resultSet.getObject(17));
		integranteIg.setNomeMae((String)resultSet.getObject(18));
			
		integranteIg.setEndereco(new Address((String)resultSet.getObject(19),(String)resultSet.getObject(20),
				(String)resultSet.getObject(21),(String)resultSet.getObject(22),(String)resultSet.getObject(23),
				(String)resultSet.getObject(24), (String)resultSet.getObject(25)));
				
		return integranteIg;
	}
	
	
	public  Iterator<IntegranteIgreja> getIntegranteIgreja() throws SQLException, InvalidDateException, ClassNotFoundException, FileNotFoundException, IOException{
				
		String queryIntIg = "";		
		LinkedList<IntegranteIgreja> list = new LinkedList<IntegranteIgreja>();
		
		queryIntIg = "SELECT DP.rg, DP.nome, DP.dataNascimento, DP.estadoCivil, DP.pathphoto, DP.email, DP.sexo, " +
					"DP.naturalidade, II.tipo, II.dataConversao, II.dataBatismo, II.pathHistorico, ID.codDep, T.residencial, " +
					"T.celular, T.comercial, F.nomePai, F.nomeMae, E.rua, E.numCasa, E.cep, E.bairro, E.cidade, E.estado, E.complemento, " +
					"II.titulo FROM  ((((  dadosPessoais DP INNER JOIN integrantesIgreja II ON (DP.rg = II.rg))" +
					" INNER JOIN integrantesDep ID ON (ID.rg = DP.rg)) INNER JOIN telefones T ON (T.rg = DP.rg))" +
					"INNER JOIN filiacao F ON (F.rg = DP.rg)) INNER JOIN enderecos E ON (E.rg = DP.rg) ORDER BY DP.rg;";
		
		
		
		Class.forName(ConstantsSystem.JDBC_DRIVER);
		Connection connection = DriverManager.getConnection(ConstantsSystem.DATABASE_URL, ConstantsSystem.USER, ConstantsSystem.PASSWORD);;
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		ResultSet resultSetIntIg = statement.executeQuery(queryIntIg);		
		
		
		
		while(resultSetIntIg.next()){
			list.add(createIntegranteIgrejaComplete(resultSetIntIg));
		}
		statement.close();
		connection.close();
		
		return list.iterator();
	}
	
	
	private void connectBank() throws ClassNotFoundException, SQLException{
		Class.forName(ConstantsSystem.JDBC_DRIVER);
		connection = DriverManager.getConnection(ConstantsSystem.DATABASE_URL, ConstantsSystem.USER, ConstantsSystem.PASSWORD);
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	}
	
	private void closeConnection() throws SQLException{
		this.statement.close();
		this.connection.close();
	}
}
