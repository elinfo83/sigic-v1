package gui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import mem.exception.InvalidDateException;
import mem.model.integrantesIg.IntegranteIgreja;
import util.Date;
import facade.Facade;

public class Aniversariantes extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jp_dateLimite = null;
	private JLabel jl_dataInicial = null;
	private JLabel jl_dataFinal = null;
	private JTextField jtf_diaInicial = null;
	private JTextField jtf_diaFim = null;
	private JComboBox jcb_mesInicial = null;
	private JComboBox jcb_mesFinal = null;
	private JButton jb_visualizarAniversariantes = null;
	private JScrollPane jsp_aniversariantes = null;
	private JTable jt_aniversariantes = null;
	private JPanel jp_buttons = null;
	private JButton jb_imprimirLista = null;
	private JButton jb_Fechar = null;
	private Facade facade;
	private JTabbedPane jtpane;
	private String[] titulosColunas = {"Nº de Registro", "Tipo", "Nome", "Data Nascimento", "Estado Civil"};
	private String[][] initialDados = {{"","","","",""}};
	
	/**
	 * This is the default constructor
	 */
	public Aniversariantes(Facade facada, JTabbedPane parent) {
		super();
		this.facade = facada;
		this.jtpane = parent;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        this.setLayout(null);
        this.setBounds(new java.awt.Rectangle(0,0,1023,703));
        this.setBackground(new java.awt.Color(225,230,235));
        this.add(getJp_dateLimite(), null);
        this.add(getJsp_aniversariantes(), null);
        this.add(getJp_buttons(), null);
	}

	/**
	 * This method initializes jp_dateLimite	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJp_dateLimite() {
		if (jp_dateLimite == null) {
			jl_dataFinal = new JLabel();
			jl_dataFinal.setBounds(new java.awt.Rectangle(364,28,55,16));
			jl_dataFinal.setText("Data Final");
			jl_dataInicial = new JLabel();
			jl_dataInicial.setBounds(new java.awt.Rectangle(17,28,62,16));
			jl_dataInicial.setText("Data inicial");
			jp_dateLimite = new JPanel();
			jp_dateLimite.setLayout(null);
			jp_dateLimite.setBounds(new java.awt.Rectangle(22,16,971,114));
			jp_dateLimite.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datas Limitantes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), new java.awt.Color(51,51,51)));
			jp_dateLimite.setBackground(new java.awt.Color(225,230,232));
			jp_dateLimite.add(jl_dataInicial, null);
			jp_dateLimite.add(jl_dataFinal, null);
			jp_dateLimite.add(getJtf_diaInicial(), null);
			jp_dateLimite.add(getJtf_diaFim(), null);
			jp_dateLimite.add(getJcb_mesInicial(), null);
			jp_dateLimite.add(getJcb_mesFinal(), null);
			jp_dateLimite.add(getJb_visualizarAniversariantes(), null);
		}
		return jp_dateLimite;
	}

	/**
	 * This method initializes jtf_diaInicial	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_diaInicial() {
		if (jtf_diaInicial == null) {
			jtf_diaInicial = new JTextField();
			jtf_diaInicial.setBounds(new java.awt.Rectangle(84,28,30,18));
		}
		return jtf_diaInicial;
	}

	/**
	 * This method initializes jtf_diaFim	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_diaFim() {
		if (jtf_diaFim == null) {
			jtf_diaFim = new JTextField();
			jtf_diaFim.setBounds(new java.awt.Rectangle(423,28,30,18));
		}
		return jtf_diaFim;
	}

	/**
	 * This method initializes jcb_mesInicial	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJcb_mesInicial() {
		if (jcb_mesInicial == null) {
			jcb_mesInicial = new JComboBox(LoadComboBoxs.preencheComboMeses());
			jcb_mesInicial.setBounds(new java.awt.Rectangle(130,28,135,20));
		}
		return jcb_mesInicial;
	}

	/**
	 * This method initializes jcb_mesFinal	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJcb_mesFinal() {
		if (jcb_mesFinal == null) {
			jcb_mesFinal = new JComboBox(LoadComboBoxs.preencheComboMeses());
			jcb_mesFinal.setBounds(new java.awt.Rectangle(464,28,135,21));
		}
		return jcb_mesFinal;
	}

	/**
	 * This method initializes jb_visualizarAniversariantes	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_visualizarAniversariantes() {
		if (jb_visualizarAniversariantes == null) {
			jb_visualizarAniversariantes = new JButton();
			jb_visualizarAniversariantes.setBounds(new java.awt.Rectangle(707,28,185,23));
			jb_visualizarAniversariantes.setText("Pesquisar Aniversariantes");
			jb_visualizarAniversariantes
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							jTableSetModel();
						}
					});
		}
		return jb_visualizarAniversariantes;
	}
	
	

	/**
	 * This method initializes jsp_aniversariantes	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJsp_aniversariantes() {
		if (jsp_aniversariantes == null) {
			jsp_aniversariantes = new JScrollPane();
			jsp_aniversariantes.setBounds(new java.awt.Rectangle(22,146,972,364));
			jsp_aniversariantes.setViewportView(getJt_aniversariantes());
		}
		return jsp_aniversariantes;
	}

	/**
	 * This method initializes jt_aniversariantes	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJt_aniversariantes() {
		if (jt_aniversariantes == null) {
			jt_aniversariantes = new JTable(this.initialDados,titulosColunas);
			TableColumn column = null;
			for (int i = 0; i < 5; i++) {
				column = jt_aniversariantes.getColumnModel().getColumn(i);
				if (i==2) {
					column.setPreferredWidth(300);
				} else {
					column.setPreferredWidth(0);
				}
			}
		}
		return jt_aniversariantes;
	}
	
	private void jTableSetModel(){
		
		
		int tamList = 0;
		DefaultTableModel tableModel = new DefaultTableModel();
		int mesInicial =  jcb_mesInicial.getSelectedIndex();
		int mesFinal =  jcb_mesFinal.getSelectedIndex();
		
		Date dateInicial = null;
		Date dateFinal = null;
		String dataInicial = "";
		String dataFinal = "";
		
		try {
			
			if(mesInicial>=1 || mesInicial<=9){
				dataInicial =  jtf_diaInicial.getText()+"/"+"0"+mesInicial+"/"+"2000";
			}else{
				dataInicial =  jtf_diaInicial.getText()+"/"+mesInicial+"/"+"2000";
			}
			if(mesFinal>=1 || mesFinal<=9){
				dataFinal = jtf_diaFim.getText()+"/"+"0"+mesFinal+"/"+"2000";
			}else{
				dataFinal =  jtf_diaFim.getText()+"/"+mesFinal+"/"+"2000";
			}
			System.out.println(dataInicial);
			System.out.println(dataFinal);
			dateInicial = new Date(dataInicial);
			dateFinal = new Date(dataFinal);
			
			IntegranteIgreja[] integrantesIg = this.facade.getIntegranteIgreja();
			
			LinkedList<IntegranteIgreja> aniverIntig = new LinkedList<IntegranteIgreja>();
			
			for (int i = 0; i < integrantesIg.length; i++) {
				if((integrantesIg[i].getDataNascimento().getMonth()>= dateInicial.getMonth() && 
						integrantesIg[i].getDataNascimento().getMonth()<= dateFinal.getMonth()) &&
						(integrantesIg[i].getDataNascimento().getDay())>= dateInicial.getDay() && 
						integrantesIg[i].getDataNascimento().getDay()<= dateFinal.getDay()){
					aniverIntig.add(integrantesIg[i]);
				}
			}
			
			
			tamList = aniverIntig.size();
			tableModel.addColumn("Nº de Registro");
			tableModel.addColumn("Nome");
			tableModel.addColumn("Tipo");
			tableModel.addColumn("Data Nascimento");
			tableModel.addColumn("Estado Civil");
			String []row = new String[5];
			
			/*"Rg", "Tipo", "Nome", "Data Nascimento", "Estado Civil"*/
			for (int i = 0; i < tamList; i++) {
				row[0] = aniverIntig.get(i).getRg();
				row[1] = aniverIntig.get(i).getNome();
				row[2] = aniverIntig.get(i).getType().name();
				row[3] = aniverIntig.get(i).getDataNascimento().toString();
				row[4] = aniverIntig.get(i).getEstadoCivil();
				tableModel.addRow(row);
			}
			
			if(tamList==0){
				row[0] = "";
				row[1] = "";
				row[2] = "";
				row[3] = "";
				row[4] = "";
				tableModel.addRow(row);
			}
			TableColumn column = null;
			if(this.jt_aniversariantes!=null) this.jt_aniversariantes.setModel(tableModel);
			for (int i = 0; i < 5; i++) {
				column = jt_aniversariantes.getColumnModel().getColumn(i);
				if (i==1) {
					column.setPreferredWidth(300);
				} else {
					column.setPreferredWidth(0);
				}
			}
			
			
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidDateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method initializes jp_buttons	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJp_buttons() {
		if (jp_buttons == null) {
			jp_buttons = new JPanel();
			jp_buttons.setLayout(null);
			jp_buttons.setBounds(new java.awt.Rectangle(476,583,515,81));
			jp_buttons.setBackground(new java.awt.Color(225,230,232));
			jp_buttons.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jp_buttons.add(getJb_imprimirLista(), null);
			jp_buttons.add(getJb_Fechar(), null);
		}
		return jp_buttons;
	}

	/**
	 * This method initializes jb_imprimirLista	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_imprimirLista() {
		if (jb_imprimirLista == null) {
			jb_imprimirLista = new JButton();
			jb_imprimirLista.setBounds(new java.awt.Rectangle(72,27,149,23));
			jb_imprimirLista.setText("Imprimir Lista");
		}
		return jb_imprimirLista;
	}

	/**
	 * This method initializes jb_Fechar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_Fechar() {
		if (jb_Fechar == null) {
			jb_Fechar = new JButton();
			jb_Fechar.setBounds(new java.awt.Rectangle(293,27,149,23));
			jb_Fechar.setText("Fechar");
			jb_Fechar.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							closeAba();
						}
					});
		}
		return jb_Fechar;
	}
	private void closeAba(){
		jtpane.remove(this);
	}

}
