package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import mem.exception.DepartmentNoRegisteredException;
import mem.exception.InvalidDateException;
import mem.exception.MemberAlreadyRegisteredException;
import mem.model.cargo.Cargo;
import mem.model.documentos.Historico;
import mem.model.integrantesIg.IntegranteIgreja;
import mem.model.integrantesIg.IntegrantesIgrejaTypes;
import util.Address;
import util.Date;
import util.Sexo;
import util.SystemConfiguration;
import util.TelephonesTypes;
import facade.Facade;

public class PanelIntegrantesIgreja extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextField jtf_nomeMembro = null;
	private JLabel jl_nomeMembro = null;
	private JPanel jp_button = null;
	private JButton jb_confirmar = null;
	private JButton jb_cancelar = null;
	private JPanel jp_dadosPessoais = null;
	private JLabel jl_rgMembro1 = null;
	private JLabel jl_nomePaiMembro11 = null;
	private JLabel jl_nomeMaeMembro111 = null;
	private JTextField jtf_nomePai = null;
	private JTextField jtf_nomeMae = null;
	private JTextField jtf_codIntIg = null;
	private JLabel jl_dataAniversario = null;
	private JComboBox jcb_mesAniverssario = null;
	private JPanel jp_photo = null;
	private JLabel jl_photo = null;
	private JLabel jl_dataBatismo = null;
	private JComboBox jcb_mesBatismo = null;
	private JLabel jl_email = null;
	private JTextField jtf_email = null;
	private JLabel jl_estadoCivil = null;
	private JComboBox jcb_estadoCivil = null;
	private JLabel jl_dataConversao = null;
	private JComboBox jcb_mesConversao = null;
	private JLabel jl_Tipo = null;
	private JComboBox jcb_tipo = null;
	private JPanel jp_endereco = null;
	private JLabel jl_rua = null;
	private JTextField jtf_rua = null;
	private JLabel jl_num = null;
	private JLabel jl_bairro = null;
	private JLabel jl_cidade = null;
	private JLabel jl_estado = null;
	private JLabel jl_telRes = null;
	private JPanel jp_telefones = null;
	private JLabel jl_telCel = null;
	private JLabel jl_telComercial = null;
	private JLabel jl_cep = null;
	private JTextField jtf_num = null;
	private JTextField jtf_cep = null;
	private JTextField jtf_bairro = null;
	private JTextField jtf_cidade = null;
	private JComboBox jcb_estados = null;
	private JTextField jtf_telRes = null;
	private JTextField jtf_telCel = null;
	private JTextField jtf_telCom = null;
	private JButton jb_procurarFoto = null;
	private JRadioButton jrb_masc = null;
	private JRadioButton jrb_fem = null;
	private JTextField jtf_cep1 = null;
	private JLabel jl_complemento = null;
	private JTextField jtf_complemento = null;
	private JLabel jl_Departamento = null;
	private JComboBox jcb_departamento = null;
	private JPanel jp_sexo = null;
	private JScrollPane jsp_Historico = null;
	private JTextArea jta_historico = null;
	private JLabel jl_tracocep = null;
	private ButtonGroup buttonGroup;  //  @jve:decl-index=0:
	private Facade facade;
	private JTextField jtf_diaAniversario = null;
	private JTextField jtf_diaBatismo = null;
	private JTextField jtf_diaConversao = null;
	private JTextField jtf_anoAniversario = null;
	private JTextField jtf_anoBatismo = null;
	private JTextField jtf_anoConversao = null;
	private JPanel jp_datas = null;
	private JTabbedPane parent;
	private String pathPhoto = "";
	private List<Cargo> cargos = null;
	private JLabel jl_naturalidade = null;
	private JComboBox jcb_estadoNatural = null;
	private JTextField jtf_telRes1 = null;
	private JTextField jtf_telCel1 = null;
	private JTextField jtf_telCom1 = null;
	private JButton jb_limpar = null;
	private JLabel jl_titulo = null;
	private JComboBox jcb_titulo = null;
	
	/**
	 * This is the default constructor
	 */
	public PanelIntegrantesIgreja(Facade facade, JTabbedPane parent) {
		super();
		this.facade = facade;
		this.parent = parent;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		
		cargos = new LinkedList<Cargo>();
		buttonGroup = new ButtonGroup();
		jl_photo = new JLabel();
		jl_photo.setBackground(Color.white);
		jl_photo.setBounds(new java.awt.Rectangle(8,15,143,181));
		jl_photo.setText("                     3x4");
		jl_nomeMembro = new JLabel();
		jl_nomeMembro.setText("Nome Completo");
		jl_nomeMembro.setBounds(new java.awt.Rectangle(150,45,90,16));
		this.setLayout(null);
		this.setBackground(new Color(225, 230, 232));
		this.setBounds(new java.awt.Rectangle(0,0,1023,703));
		this.add(getJp_button(), null);
		this.add(getJp_dadosPessoais(), null);
		this.add(getJp_endereco(), null);
		this.add(getJp_telefones(), null);
		this.add(getJb_procurarFoto(), null);
		this.add(getJsp_Historico(), null);
		this.add(getJp_photo(), null);
		
	}
	
	public List<Cargo> getCargos() {
		return cargos;
	}

	/**
	 * This method initializes jtf_nomeMembro	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_nomeMembro() {
		if (jtf_nomeMembro == null) {
			jtf_nomeMembro = new JTextField();
			jtf_nomeMembro.setBounds(new java.awt.Rectangle(244,45,379,18));
			jtf_nomeMembro.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					consomeNumeros(e);
				}
			});
			
		}
		return jtf_nomeMembro;
	}
	
	private void consomeNumeros(KeyEvent e){
		if(e.getKeyChar()>='0' && e.getKeyChar()<='9'){
			e.consume();
		}
	}

	/**
	 * This method initializes jp_button	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJp_button() {
		if (jp_button == null) {
			jp_button = new JPanel();
			jp_button.setLayout(null);
			jp_button.setBounds(new java.awt.Rectangle(488,582,511,61));
			jp_button.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jp_button.setBackground(new Color(225, 230, 232));
			jp_button.add(getJb_fechar(), null);
			jp_button.add(getJb_confirmar(), null);
			jp_button.add(getJb_limpar(), null);
		}
		return jp_button;
	}

	/**
	 * This method initializes jb_fechar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_fechar() {
		if (jb_confirmar == null) {
			jb_confirmar = new JButton();
			jb_confirmar.setBounds(new Rectangle(346, 19, 143, 25));
			jb_confirmar.setIcon(new ImageIcon("D:/workspace/sigic-v1.1/imagens/confirm1.png"));
			jb_confirmar.setText("Cadastrar");
			jb_confirmar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cadastrar();
				}
			});
		}
		return jb_confirmar;
	}

	
	private void cadastrar(){
		
		String titulo = (String)jcb_titulo.getSelectedItem();
		String tipo = (String)jcb_tipo.getSelectedItem();
		String nome = jtf_nomeMembro.getText();
		String nomePai = jtf_nomePai.getText();
		String nomeMae = jtf_nomeMae.getText();
		String rg = jtf_codIntIg.getText();
		String email = jtf_email.getText();
		int mesNasc =  jcb_mesAniverssario.getSelectedIndex();
		int mesBatismo =  jcb_mesBatismo.getSelectedIndex();
		int mesConversao =  jcb_mesConversao.getSelectedIndex();
		Sexo sexo = null;
		String codDep = jcb_departamento.getSelectedItem().toString();
		String estadoCivil = (String)jcb_estadoCivil.getSelectedItem();
		String Rua = jtf_rua.getText();
		String numCasa = jtf_num.getText();
		String complemento = jtf_complemento.getText();
		String bairro = jtf_bairro.getText();
		String cidade = jtf_cidade.getText();
		String estado = (String)jcb_estados.getSelectedItem();
		String naturalidade = (String)jcb_estadoNatural.getSelectedItem();
		String cep = jtf_cep.getText()+ "-"+ jtf_cep1.getText();
		String telRes = jtf_telRes1.getText() + "-" +jtf_telRes.getText();
		String telCel = jtf_telCel1.getText()+ "-" +jtf_telCel.getText();
		String telCom = jtf_telCom1.getText()+ "-" +jtf_telCom.getText();
		String historico = jta_historico.getText();
		String dataNascimento = "";
		String dataBatismo = "";
		String dataConversao = "";
		
		Address address = null; 
		IntegranteIgreja integranteIgreja = null;
		Date dateNasc = null;
		Date dateBat = null;
		Date dateConv = null;
		IntegrantesIgrejaTypes type = null;
		Historico hist;
		
		if(tipo.equals(IntegrantesIgrejaTypes.CONGREGADO.name())){
			type = IntegrantesIgrejaTypes.CONGREGADO;
		}else if(tipo.equals(IntegrantesIgrejaTypes.MEMBRO.name())){
			type = IntegrantesIgrejaTypes.MEMBRO;
		}
		if(jrb_masc.isSelected()){
			sexo = Sexo.MASCULINO;
		}else if(jrb_fem.isSelected()){
			sexo = Sexo.FEMININO;
		}
		if(mesNasc>=1 || mesNasc<=9){
			dataNascimento =  jtf_diaAniversario.getText()+"/"+"0"+mesNasc+"/"+jtf_anoAniversario.getText();
		}else{
			dataNascimento =  jtf_diaAniversario.getText()+"/"+mesNasc+"/"+jtf_anoAniversario.getText();
		}
		if(mesBatismo>=1 || mesBatismo<=9){
			dataBatismo = jtf_diaBatismo.getText()+"/"+"0"+mesBatismo+"/"+jtf_anoBatismo.getText();
		}else{
			dataBatismo =  jtf_diaBatismo.getText()+"/"+mesBatismo+"/"+jtf_anoBatismo.getText();
		}
		if(mesConversao>=1 || mesConversao<=9){
			dataConversao = jtf_diaConversao.getText()+"/"+"0"+mesConversao+"/"+jtf_anoConversao.getText();
		}else{
			dataConversao =  jtf_diaConversao.getText()+"/"+mesConversao+"/"+jtf_anoConversao.getText();
		}
		
		if(Rua.equals("") || numCasa.equals("") || bairro.equals("") || cidade.equals("") || estado.equals("") || cep.equals("") ){
			JOptionPane.showMessageDialog(this, "Preencha os campos obrigatórios do Endereço!", "Atenção", JOptionPane.PLAIN_MESSAGE);
			return;
		}else{
			address = new Address(Rua,numCasa,cep,bairro,cidade,estado,complemento);
		}
		
		if(nome.equals("") || nomePai.equals("") || nomeMae.equals("") || sexo.equals("") || rg.equals("") 
				|| dataBatismo.equals("") || dataConversao.equals("") || dataNascimento.equals("") || jtf_cep.getText().equals("") ||
				jtf_cep1.getText().equals("")){
			JOptionPane.showMessageDialog(this, "Preencha os campos obrigatórios do Endereço!", "Atenção", JOptionPane.PLAIN_MESSAGE);
			return;			
		}else{
			try {
				
				if(jtf_diaBatismo.getText().equals("") || jtf_anoBatismo.getText().equals("")){
					dateBat = new Date();
				}else{
					dateBat = new Date(dataBatismo);
				}
				
				if(jtf_diaConversao.getText().equals("") || jtf_anoConversao.getText().equals("")){
					dateConv = new Date();
				}else{
					dateConv = new Date(dataBatismo);
				}
				
				hist = new Historico(historico,rg);
				dateNasc = new Date(dataNascimento);
							
				integranteIgreja = new IntegranteIgreja(nome,rg,dateNasc,nomePai,nomeMae,estadoCivil,email,address,this.pathPhoto,
						dateBat,dateConv,codDep,type,sexo,this.cargos,naturalidade,hist,titulo);
				integranteIgreja.addTelefone(TelephonesTypes.RESIDENCIAL, telRes);
				integranteIgreja.addTelefone(TelephonesTypes.CELULAR, telCel);
				integranteIgreja.addTelefone(TelephonesTypes.COMERCIAL, telCom);
				integranteIgreja.setTitulo(titulo);
				
				this.facade.cadastrar(integranteIgreja);
				
				
				JOptionPane.showMessageDialog(this, "Membro Cadastrado Com Sucesso!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
				SystemConfiguration.setProxNum();
				setJtfCodForProxNum();
				
			} catch (InvalidDateException e) {
				JOptionPane.showMessageDialog(this,e.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(this,e.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
			} catch (MemberAlreadyRegisteredException e) {
				JOptionPane.showMessageDialog(this,e.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
			} catch (DepartmentNoRegisteredException e) {
				JOptionPane.showMessageDialog(this,e.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(this,e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(this,e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this,e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}			
		}
	}
	
	
	private JButton getJb_confirmar() {
		if (jb_cancelar == null) {
			jb_cancelar = new JButton();
			jb_cancelar.setBounds(new Rectangle(20, 19, 143, 25));
			jb_cancelar.setIcon(new ImageIcon("D:/workspace/sigic-v1.1/imagens/sair.png"));
			jb_cancelar.setText("Fechar");
			jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					closeAba();
				}
			});
		}
		return jb_cancelar;
	}

	private void closeAba(){
		parent.remove(this);
	}
	
	/**
	 * This method initializes jp_dadosPessoais	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJp_dadosPessoais() {
		if (jp_dadosPessoais == null) {
			jl_titulo = new JLabel();
			jl_titulo.setBounds(new java.awt.Rectangle(11,45,35,18));
			jl_titulo.setText("Título");
			jl_naturalidade = new JLabel();
			jl_naturalidade.setBounds(new java.awt.Rectangle(378,153,72,16));
			jl_naturalidade.setText("Naturalidade");
			jl_Departamento = new JLabel();
			jl_Departamento.setBounds(new java.awt.Rectangle(298,21,81,16));
			jl_Departamento.setText("Departamento");
			jl_Tipo = new JLabel();
			jl_Tipo.setBounds(new Rectangle(11, 21, 24, 16));
			jl_Tipo.setText("Tipo");
			jl_dataConversao = new JLabel();
			jl_dataConversao.setText("Data Conversão");
			jl_dataConversao.setBounds(new Rectangle(8, 57, 90, 16));
			jl_estadoCivil = new JLabel();
			jl_estadoCivil.setBounds(new java.awt.Rectangle(379,180,65,16));
			jl_estadoCivil.setText("Estado Civil");
			jl_email = new JLabel();
			jl_email.setBounds(new Rectangle(378, 207, 31, 16));
			jl_email.setText("Email");
			jl_dataBatismo = new JLabel();
			jl_dataBatismo.setText("Data Batismo");
			jl_dataBatismo.setBounds(new Rectangle(7, 33, 76, 16));
			jl_dataAniversario = new JLabel();
			jl_dataAniversario.setText("Data Nascimento");
			jl_dataAniversario.setBounds(new Rectangle(7, 10, 97, 16));
			jl_nomeMaeMembro111 = new JLabel();
			jl_nomeMaeMembro111.setBounds(new Rectangle(11, 103, 77, 16));
			jl_nomeMaeMembro111.setText("Nome da Mãe");
			jl_nomePaiMembro11 = new JLabel();
			jl_nomePaiMembro11.setBounds(new Rectangle(11, 74, 71, 16));
			jl_nomePaiMembro11.setText("Nome do Pai");
			jl_rgMembro1 = new JLabel();
			jl_rgMembro1.setBounds(new java.awt.Rectangle(177,21,39,16));
			jl_rgMembro1.setText("Código");
			jp_dadosPessoais = new JPanel();
			jp_dadosPessoais.setLayout(null);
			jp_dadosPessoais.setBounds(new Rectangle(6, 7, 804, 250));
			jp_dadosPessoais.setBorder(BorderFactory.createTitledBorder(null, "Dados Pessoais", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jp_dadosPessoais.setBackground(new Color(225, 230, 232));
			jp_dadosPessoais.add(jl_nomeMembro, null);
			jp_dadosPessoais.add(getJtf_nomeMembro(), null);
			jp_dadosPessoais.add(jl_rgMembro1, null);
			jp_dadosPessoais.add(jl_nomePaiMembro11, null);
			jp_dadosPessoais.add(jl_nomeMaeMembro111, null);
			jp_dadosPessoais.add(getJtf_nomePai(), null);
			jp_dadosPessoais.add(getJtf_nomeMae(), null);
			jp_dadosPessoais.add(getJtf_nomeRg(), null);
			jp_dadosPessoais.add(jl_email, null);
			jp_dadosPessoais.add(getJtf_email(), null);
			jp_dadosPessoais.add(jl_estadoCivil, null);
			jp_dadosPessoais.add(getJcb_estadoCivil(), null);
			jp_dadosPessoais.add(jl_Tipo, null);
			jp_dadosPessoais.add(getJcb_tipo(), null);
			jp_dadosPessoais.add(jl_Departamento, null);
			jp_dadosPessoais.add(getJcb_departamento(), null);
			jp_dadosPessoais.add(getJp_sexo(), null);
			jp_dadosPessoais.add(getJp_datas(), null);
			jp_dadosPessoais.add(jl_naturalidade, null);
			jp_dadosPessoais.add(getJcb_estadoNatural(), null);
			jp_dadosPessoais.add(jl_titulo, null);
			jp_dadosPessoais.add(getJcb_titulo(), null);
		}
		return jp_dadosPessoais;
	}

	/**
	 * This method initializes jtf_nomePai	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_nomePai() {
		if (jtf_nomePai == null) {
			jtf_nomePai = new JTextField();
			jtf_nomePai.setBounds(new Rectangle(90, 74, 401, 18));
			jtf_nomePai.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					consomeNumeros(e);
				}
			});
		}
		return jtf_nomePai;
	}

	/**
	 * This method initializes jtf_nomeMae	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_nomeMae() {
		if (jtf_nomeMae == null) {
			jtf_nomeMae = new JTextField();
			jtf_nomeMae.setBounds(new Rectangle(90, 103, 401, 18));
			jtf_nomeMae.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					consomeNumeros(e);
				}
			});
		}
		return jtf_nomeMae;
	}

	/**
	 * This method initializes jtf_nomeRg	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_nomeRg() {
		if (jtf_codIntIg == null) {
			
			jtf_codIntIg = new JTextField();
			jtf_codIntIg.setBounds(new java.awt.Rectangle(223,21,49,18));
			setJtfCodForProxNum();
			jtf_codIntIg.setEditable(false);
			jtf_codIntIg.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					consomeLetras(e);
				}
			});
			
		}
		return jtf_codIntIg;
	}
	
	private void setJtfCodForProxNum(){
		try {
			SystemConfiguration.createFileConfig();
			String tex = formatNum(SystemConfiguration.getProxNum());
			jtf_codIntIg.setText(tex);
			
		} catch (FileNotFoundException e) {
			
			JOptionPane.showMessageDialog(this,e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			
			JOptionPane.showMessageDialog(this,e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
			
	}
	
	private String formatNum(String num){
		String newNum = num;
		for (int i = 0; i < (6 - num.length()); i++) {
			newNum = "0" + newNum;
		}
		
		return newNum;
	}
	
	

	/**
	 * This method initializes jcb_mesAniverssario	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJcb_mesAniverssario() {
		if (jcb_mesAniverssario == null) {
			jcb_mesAniverssario = new JComboBox(LoadComboBoxs.preencheComboMeses());
			jcb_mesAniverssario.setBounds(new Rectangle(149, 10, 98, 17));
		}
		return jcb_mesAniverssario;
	}

	/**
	 * This method initializes jp_photo	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJp_photo() {
		if (jp_photo == null) {
			jp_photo = new JPanel();
			jp_photo.setLayout(null);
			jp_photo.setBorder(BorderFactory.createTitledBorder(null, "Foto", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jp_photo.setBackground(Color.white);
			jp_photo.setBounds(new java.awt.Rectangle(831,16,159,203));
			jp_photo.add(jl_photo, null);
		}
		return jp_photo;
	}

	/**
	 * This method initializes jcb_mesBatismo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJcb_mesBatismo() {
		if (jcb_mesBatismo == null) {
			jcb_mesBatismo = new JComboBox(LoadComboBoxs.preencheComboMeses());
			jcb_mesBatismo.setBounds(new Rectangle(149, 34, 98, 17));
		}
		return jcb_mesBatismo;
	}

	/**
	 * This method initializes jtf_email	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_email() {
		if (jtf_email == null) {
			jtf_email = new JTextField();
			jtf_email.setBounds(new Rectangle(414, 207, 307, 18));
		}
		return jtf_email;
	}

	/**
	 * This method initializes jcb_estadoCivil	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJcb_estadoCivil() {
		
		if (jcb_estadoCivil == null) {
			jcb_estadoCivil = new JComboBox(LoadComboBoxs.loadEstCivil());
			jcb_estadoCivil.setBounds(new java.awt.Rectangle(459,180,98,17));
		}
		return jcb_estadoCivil;
	}
	
	

	/**
	 * This method initializes jcb_mesConversao	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJcb_mesConversao() {
		if (jcb_mesConversao == null) {
			jcb_mesConversao = new JComboBox(LoadComboBoxs.preencheComboMeses());
			jcb_mesConversao.setBounds(new Rectangle(149, 57, 98, 17));
			
		}
		return jcb_mesConversao;
	}
	
	

	/**
	 * This method initializes jcb_tipo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJcb_tipo() {
		if (jcb_tipo == null) {
			String tipos[] = {"",IntegrantesIgrejaTypes.MEMBRO.name(),IntegrantesIgrejaTypes.CONGREGADO.name()}; 
			jcb_tipo = new JComboBox(tipos);
			jcb_tipo.setBounds(new java.awt.Rectangle(49,21,96,17));
		}
		return jcb_tipo;
	}

	/**
	 * This method initializes jp_endereco	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJp_endereco() {
		if (jp_endereco == null) {
			jl_tracocep = new JLabel();
			jl_tracocep.setBounds(new Rectangle(382, 122, 7, 16));
			jl_tracocep.setFont(new Font("Dialog", Font.BOLD, 12));
			jl_tracocep.setText("-");
			jl_complemento = new JLabel();
			jl_complemento.setBounds(new Rectangle(12, 58, 79, 16));
			jl_complemento.setText("Complemento");
			jl_cep = new JLabel();
			jl_cep.setBounds(new Rectangle(275, 122, 22, 16));
			jl_cep.setText("Cep");
			jl_telRes = new JLabel();
			jl_telRes.setText("Residencial");
			jl_telRes.setBounds(new Rectangle(13, 28, 66, 16));
			jl_estado = new JLabel();
			jl_estado.setBounds(new Rectangle(12, 122, 39, 16));
			jl_estado.setText("Estado");
			jl_cidade = new JLabel();
			jl_cidade.setBounds(new Rectangle(197, 90, 39, 16));
			jl_cidade.setText("Cidade");
			jl_bairro = new JLabel();
			jl_bairro.setBounds(new Rectangle(12, 90, 35, 16));
			jl_bairro.setText("Bairro");
			jl_num = new JLabel();
			jl_num.setBounds(new Rectangle(383, 26, 12, 16));
			jl_num.setText("Nº");
			jl_rua = new JLabel();
			jl_rua.setBounds(new Rectangle(12, 26, 22, 16));
			jl_rua.setText("Rua");
			jp_endereco = new JPanel();
			jp_endereco.setLayout(null);
			jp_endereco.setBounds(new Rectangle(7, 260, 474, 148));
			jp_endereco.setBorder(BorderFactory.createTitledBorder(null, "Endereço", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jp_endereco.setBackground(new Color(225, 230, 232));
			jp_endereco.add(jl_rua, null);
			jp_endereco.add(getJtf_rua(), null);
			jp_endereco.add(jl_num, null);
			jp_endereco.add(jl_bairro, null);
			jp_endereco.add(jl_cidade, null);
			jp_endereco.add(jl_estado, null);
			jp_endereco.add(jl_cep, null);
			jp_endereco.add(getJtf_num(), null);
			jp_endereco.add(getJtf_cep(), null);
			jp_endereco.add(getJtf_bairro(), null);
			jp_endereco.add(getJtf_cidade(), null);
			jp_endereco.add(getJcb_estados(), null);
			jp_endereco.add(getJtf_cep1(), null);
			jp_endereco.add(jl_complemento, null);
			jp_endereco.add(getJtf_complemento(), null);
			jp_endereco.add(jl_tracocep, null);
		}
		return jp_endereco;
	}

	/**
	 * This method initializes jtf_rua	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_rua() {
		if (jtf_rua == null) {
			jtf_rua = new JTextField();
			jtf_rua.setBounds(new Rectangle(39, 26, 336, 18));
		}
		return jtf_rua;
	}

	/**
	 * This method initializes jp_telefones	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJp_telefones() {
		if (jp_telefones == null) {
			jl_telComercial = new JLabel();
			jl_telComercial.setBounds(new Rectangle(13, 110, 58, 16));
			jl_telComercial.setText("Comercial");
			jl_telCel = new JLabel();
			jl_telCel.setBounds(new Rectangle(13, 69, 40, 16));
			jl_telCel.setText("Celular");
			jp_telefones = new JPanel();
			jp_telefones.setLayout(null);
			jp_telefones.setBorder(BorderFactory.createTitledBorder(null, "Telefones", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jp_telefones.setBackground(new Color(225, 230, 232));
			jp_telefones.setBounds(new Rectangle(6, 417, 257, 157));
			jp_telefones.add(jl_telRes, null);
			jp_telefones.add(jl_telCel, null);
			jp_telefones.add(jl_telComercial, null);
			jp_telefones.add(getJtf_telCel(), null);
			jp_telefones.add(getJtf_telCom(), null);
			jp_telefones.add(getJtf_telRes(), null);
			jp_telefones.add(getJtf_telRes1(), null);
			jp_telefones.add(getJtf_telCel1(), null);
			jp_telefones.add(getJtf_telCom1(), null);
		}
		return jp_telefones;
	}

	/**
	 * This method initializes jtf_num	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_num() {
		if (jtf_num == null) {
			jtf_num = new JTextField();
			jtf_num.setBounds(new Rectangle(399, 26, 47, 18));
			jtf_num.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					consomeLetras(e);
				}
			});
		}
		return jtf_num;
	}

	/**
	 * This method initializes jtf_cep	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_cep() {
		if (jtf_cep == null) {
			jtf_cep = new JTextField();
			jtf_cep.setBounds(new Rectangle(307, 122, 72, 18));
			jtf_cep.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					consomeLetras(e);
					processCep();
				}
			});
		}
		return jtf_cep;
	}
	@SuppressWarnings("deprecation")
	private void processCep(){
		if(jtf_cep.getText().length()==4){
			jtf_cep.nextFocus();
		}
	}
	private void consomeLetras(KeyEvent e){
		if((e.getKeyChar()>='a' && e.getKeyChar()<= 'z') || (e.getKeyChar()>='A' && e.getKeyChar()<= 'Z')){
			e.consume();
		}
	}
	/**
	 * This method initializes jtf_bairro	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_bairro() {
		if (jtf_bairro == null) {
			jtf_bairro = new JTextField();
			jtf_bairro.setBounds(new Rectangle(55, 90, 123, 18));
		}
		return jtf_bairro;
	}

	/**
	 * This method initializes jtf_cidade	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_cidade() {
		if (jtf_cidade == null) {
			jtf_cidade = new JTextField();
			jtf_cidade.setBounds(new Rectangle(241, 90, 143, 18));
			jtf_cidade.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					consomeNumeros(e);
				}
			});
		}
		return jtf_cidade;
	}

	/**
	 * This method initializes jcb_estados	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJcb_estados() {
		if (jcb_estados == null) {
			jcb_estados = new JComboBox(LoadComboBoxs.preencheComboEstados());
			jcb_estados.setBounds(new Rectangle(61, 122, 155, 17));
		}
		return jcb_estados;
	}
	
	

	/**
	 * This method initializes jtf_telRes	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_telRes() {
		if (jtf_telRes == null) {
			jtf_telRes = new JTextField();
			jtf_telRes.setBounds(new java.awt.Rectangle(118,26,93,18));
			jtf_telRes.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					consomeLetras(e);
					processaTel(jtf_telRes);
				}
			});
		}
		return jtf_telRes;
	}

	/**
	 * This method initializes jtf_telCel	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_telCel() {
		if (jtf_telCel == null) {
			jtf_telCel = new JTextField();
			jtf_telCel.setBounds(new java.awt.Rectangle(118,67,93,18));
			jtf_telCel.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					consomeLetras(e);
					processaTel(jtf_telCel);
				}
			});
		}
		return jtf_telCel;
	}

	/**
	 * This method initializes jtf_telCom	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_telCom() {
		if (jtf_telCom == null) {
			jtf_telCom = new JTextField();
			jtf_telCom.setBounds(new java.awt.Rectangle(118,108,93,18));
			jtf_telCom.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					consomeLetras(e);
					processaTel(jtf_telCom);
				}
			});
		}
		return jtf_telCom;
	}

	/**
	 * This method initializes jb_procurarFoto	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_procurarFoto() {
		if (jb_procurarFoto == null) {
			jb_procurarFoto = new JButton();
			jb_procurarFoto.setText("Procurar Foto");
			jb_procurarFoto.setIcon(new ImageIcon("D:/workspace/sigic-v1.1/imagens/buscar.png"));
			jb_procurarFoto.setBounds(new Rectangle(838, 227, 143, 25));
			jb_procurarFoto.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getFile();
				}
			});
		}
		return jb_procurarFoto;
	}

	private void getFile(){
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setDialogTitle("Abrir");
		fileChooser.showOpenDialog(this);
		File file = fileChooser.getSelectedFile();
		
		if (file==null) {
			return;
		}
		if(file.getName().equals("") || !analizeExtension(file.getPath())){
			JOptionPane.showMessageDialog(null, "Extensão de Arquivo não Suportada!", "Aviso", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		
		if(file.exists()){
			this.pathPhoto = file.getPath();
			jl_photo.setIcon(new ImageIcon(this.pathPhoto));
		}
		
	}
	
	private boolean analizeExtension(String name) {
		
		if(name.endsWith(".jpeg") || name.endsWith(".jpg") || name.endsWith(".gif") || 
				name.endsWith(".JPEG") || name.endsWith(".JPG") || name.endsWith(".GIF")){
			return true;
		}
		return false;

	}
	/**
	 * This method initializes jrb_masc	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJrb_masc() {
		if (jrb_masc == null) {
			jrb_masc = new JRadioButton();
			buttonGroup.add(jrb_masc);
			jrb_masc.setBackground(new Color(225, 230, 232));
			jrb_masc.setBounds(new Rectangle(39, 17, 84, 15));
			jrb_masc.setText("masculino");
			
		}
		return jrb_masc;
	}

	/**
	 * This method initializes jrb_fem	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJrb_fem() {
		if (jrb_fem == null) {
			jrb_fem = new JRadioButton();
			buttonGroup.add(jrb_fem);
			jrb_fem.setBackground(new Color(225, 230, 232));
			jrb_fem.setBounds(new Rectangle(39, 38, 74, 15));
			jrb_fem.setText("feminino");
		}
		return jrb_fem;
	}

	/**
	 * This method initializes jtf_cep1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_cep1() {
		if (jtf_cep1 == null) {
			jtf_cep1 = new JTextField();
			jtf_cep1.setBounds(new Rectangle(390, 122, 33, 18));
			jtf_cep1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					consomeLetras(e);
				}
			});
		}
		return jtf_cep1;
	}

	/**
	 * This method initializes jtf_complemento	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_complemento() {
		if (jtf_complemento == null) {
			jtf_complemento = new JTextField();
			jtf_complemento.setBounds(new Rectangle(93, 58, 220, 18));
		}
		return jtf_complemento;
	}

	/**
	 * This method initializes jcb_departamento	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJcb_departamento() {
		if (jcb_departamento == null) {
			LoadComboBoxs comboBoxs = new LoadComboBoxs(this.facade);
			try {
				jcb_departamento = new JComboBox(comboBoxs.preencheComboDep());
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Exceção", JOptionPane.INFORMATION_MESSAGE);
			} catch (InvalidDateException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Exceção", JOptionPane.INFORMATION_MESSAGE);
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Exceção", JOptionPane.INFORMATION_MESSAGE);
			}
			jcb_departamento.setBounds(new java.awt.Rectangle(387,21,126,17));
		}
		return jcb_departamento;
	}
	
	/**
	 * This method initializes jp_sexo	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJp_sexo() {
		if (jp_sexo == null) {
			jp_sexo = new JPanel();
			jp_sexo.setLayout(null);
			jp_sexo.setBounds(new java.awt.Rectangle(522,68,160,66));
			jp_sexo.setBackground(new Color(225, 230, 232));
			jp_sexo.setBorder(BorderFactory.createTitledBorder(null, "Sexo", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jp_sexo.add(getJrb_masc(), null);
			jp_sexo.add(getJrb_fem(), null);
		}
		return jp_sexo;
	}

	/**
	 * This method initializes jsp_Historico	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJsp_Historico() {
		if (jsp_Historico == null) {
			jsp_Historico = new JScrollPane();
			jsp_Historico.setBounds(new java.awt.Rectangle(485,260,516,313));
			jsp_Historico.setBackground(new Color(225, 230, 232));
			jsp_Historico.setViewportView(getJta_historico());
			jsp_Historico.setBorder(BorderFactory.createTitledBorder(null, "Histórico", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
		}
		return jsp_Historico;
	}

	/**
	 * This method initializes jta_historico	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJta_historico() {
		if (jta_historico == null) {
			jta_historico = new JTextArea();
			jta_historico.setColumns(30);
		}
		return jta_historico;
	}

	
	private JTextField getJtf_diaAniversario() {
		if (jtf_diaAniversario == null) {
			jtf_diaAniversario = new JTextField();
			jtf_diaAniversario.setBounds(new Rectangle(111, 10, 29, 20));
			jtf_diaAniversario.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					consomeLetras(e);
				}
			});
		}
		return jtf_diaAniversario;
	}

	
	private JTextField getJtf_diaBatismo() {
		if (jtf_diaBatismo == null) {
			jtf_diaBatismo = new JTextField();
			jtf_diaBatismo.setBounds(new Rectangle(111, 33, 29, 20));
			jtf_diaBatismo.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					consomeLetras(e);
				}
			});
		}
		return jtf_diaBatismo;
	}

	/**
	 * This method initializes jtf_diaConversao	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_diaConversao() {
		if (jtf_diaConversao == null) {
			jtf_diaConversao = new JTextField();
			jtf_diaConversao.setBounds(new Rectangle(111, 57, 29, 20));
			jtf_diaConversao.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					consomeLetras(e);
				}
			});
		}
		return jtf_diaConversao;
	}

	/**
	 * This method initializes jtf_anoAniversario	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_anoAniversario() {
		if (jtf_anoAniversario == null) {
			jtf_anoAniversario = new JTextField();
			jtf_anoAniversario.setBounds(new Rectangle(255, 10, 46, 20));
			jtf_anoAniversario.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					consomeLetras(e);
				}
			});
		}
		return jtf_anoAniversario;
	}

	/**
	 * This method initializes jtf_anoBatismo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_anoBatismo() {
		if (jtf_anoBatismo == null) {
			jtf_anoBatismo = new JTextField();
			jtf_anoBatismo.setBounds(new Rectangle(255, 33, 46, 20));
			jtf_anoBatismo.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					consomeLetras(e);
				}
			});
		}
		return jtf_anoBatismo;
	}

	/**
	 * This method initializes jtf_anoConversao	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_anoConversao() {
		if (jtf_anoConversao == null) {
			jtf_anoConversao = new JTextField();
			jtf_anoConversao.setBounds(new Rectangle(255, 57, 46, 20));
			jtf_anoConversao.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					consomeLetras(e);
				}
			});
		}
		return jtf_anoConversao;
	}

	/**
	 * This method initializes jp_datas	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJp_datas() {
		if (jp_datas == null) {
			jp_datas = new JPanel();
			jp_datas.setLayout(null);
			jp_datas.setBounds(new Rectangle(11, 135, 346, 87));
			jp_datas.setBackground(new Color(225, 230, 232));
			jp_datas.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jp_datas.add(getJtf_anoConversao(), null);
			jp_datas.add(getJcb_mesConversao(), null);
			jp_datas.add(getJtf_diaConversao(), null);
			jp_datas.add(jl_dataConversao, null);
			jp_datas.add(getJtf_anoBatismo(), null);
			jp_datas.add(getJcb_mesBatismo(), null);
			jp_datas.add(getJtf_diaBatismo(), null);
			jp_datas.add(jl_dataBatismo, null);
			jp_datas.add(getJtf_anoAniversario(), null);
			jp_datas.add(getJcb_mesAniverssario(), null);
			jp_datas.add(getJtf_diaAniversario(), null);
			jp_datas.add(jl_dataAniversario, null);
		}
		return jp_datas;
	}

	/**
	 * This method initializes jcb_estadoNatural	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJcb_estadoNatural() {
		if (jcb_estadoNatural == null) {
			jcb_estadoNatural = new JComboBox(LoadComboBoxs.preencheComboEstados());
			jcb_estadoNatural.setBounds(new java.awt.Rectangle(459,153,155,17));
		}
		return jcb_estadoNatural;
	}

	/**
	 * This method initializes jtf_telRes1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_telRes1() {
		if (jtf_telRes1 == null) {
			jtf_telRes1 = new JTextField();
			jtf_telRes1.setBounds(new java.awt.Rectangle(88,26,22,18));
			jtf_telRes1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					processaDDD(jtf_telRes1);
				}
			});
		}
		return jtf_telRes1;
	}

	/**
	 * This method initializes jtf_telCel1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_telCel1() {
		if (jtf_telCel1 == null) {
			jtf_telCel1 = new JTextField();
			jtf_telCel1.setBounds(new java.awt.Rectangle(88,67,22,18));
			jtf_telCel1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					processaDDD(jtf_telCel1);
				}
			});
		}
		return jtf_telCel1;
	}

	/**
	 * This method initializes jtf_telCom1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_telCom1() {
		if (jtf_telCom1 == null) {
			jtf_telCom1 = new JTextField();
			jtf_telCom1.setBounds(new java.awt.Rectangle(88,108,22,18));
			jtf_telCom1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					processaDDD(jtf_telCom1);
				}
			});
		}
		return jtf_telCom1;
	}
	
	
	@SuppressWarnings("deprecation")
	private void processaDDD(JTextField jtfDDD){
		if(jtfDDD.getText().length()==1){
			jtfDDD.nextFocus();
		}
	}
	
	@SuppressWarnings("deprecation")
	private void processaTel(JTextField jtfTel){
		if(jtfTel.getText().length()==7){
			jtfTel.nextFocus();
		}
	}

	/**
	 * This method initializes jb_limpar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_limpar() {
		if (jb_limpar == null) {
			jb_limpar = new JButton();
			jb_limpar.setBounds(new Rectangle(183, 19, 143, 25));
			jb_limpar.setIcon(new ImageIcon("D:/workspace/sigic-v1.1/imagens/lixeira2.png"));
			jb_limpar.setText("Limpar");
			jb_limpar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					limpar();
				}
			});
		}
		return jb_limpar;
	}
	
	private void limpar(){
		
		jtf_nomeMembro.setText("");
		jtf_nomePai.setText("");
		jtf_nomeMae.setText("");
		
		buttonGroup.clearSelection();
		
		jtf_diaAniversario.setText("");
		jtf_diaBatismo.setText("");
		jtf_diaConversao.setText("");
		
		jcb_mesAniverssario.setSelectedIndex(0);
		jcb_mesBatismo.setSelectedIndex(0);
		jcb_mesConversao.setSelectedIndex(0);
		
		jtf_anoAniversario.setText("");
		jtf_anoBatismo.setText("");
		jtf_anoConversao.setText("");
		
		
		jtf_email.setText("");
		
		jtf_rua.setText("");
		jtf_num.setText("");
		jtf_complemento.setText("");
		jtf_bairro.setText("");
		jtf_cidade.setText("");
		jtf_cep1.setText("");
		jtf_cep.setText("");
		jtf_telCel1.setText("");
		jtf_telCel.setText("");
		jtf_telRes.setText("");
		jtf_telRes1.setText("");
		jtf_telCom.setText("");
		jtf_telCom1.setText("");
		jta_historico.setText("");
	}

	/**
	 * This method initializes jcb_titulo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJcb_titulo() {
		if (jcb_titulo == null) {
			jcb_titulo = new JComboBox(LoadComboBoxs.preencheComboTitulo());
			jcb_titulo.setBounds(new java.awt.Rectangle(49,45,96,17));
		}
		return jcb_titulo;
	}

}  //  @jve:decl-index=0:visual-constraint="-6,10"
