package gui;

import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;

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
	private JLabel jl_numAniversariantes = null;
	private JLabel jl_quantAniversariantes = null;
	private JPanel jp_numNiver = null;
	private JLabel jl_baloes = null;

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
			jl_baloes = new JLabel();
			jl_baloes.setIcon(new ImageIcon("D:/workspace/sigic-v1.1/imagens/baloes3.gif"));
			jl_baloes.setBounds(new Rectangle(817, 8, 86, 103));
			jl_baloes.setText("JLabel");
			jl_quantAniversariantes = new JLabel();
			jl_quantAniversariantes.setBackground(Color.white);
			jl_quantAniversariantes.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jl_quantAniversariantes.setFont(new Font("Dialog", Font.BOLD, 24));
			jl_quantAniversariantes.setBounds(new Rectangle(206, 9, 43, 26));
			jl_quantAniversariantes.setText("0");
			jl_numAniversariantes = new JLabel();
			jl_numAniversariantes.setText("Nº Aniversariantes no Período:");
			jl_numAniversariantes.setBounds(new Rectangle(17, 9, 172, 16));
			jl_dataFinal = new JLabel();
			jl_dataFinal.setBounds(new Rectangle(16, 70, 55, 16));
			jl_dataFinal.setText("Data Final");
			jl_dataInicial = new JLabel();
			jl_dataInicial.setBounds(new Rectangle(16, 28, 62, 16));
			jl_dataInicial.setText("Data inicial");
			jp_dateLimite = new JPanel();
			jp_dateLimite.setLayout(null);
			jp_dateLimite.setBounds(new java.awt.Rectangle(22,16,971,114));
			jp_dateLimite.setBorder(BorderFactory.createTitledBorder(null, "Datas Limitantes", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jp_dateLimite.setBackground(new java.awt.Color(225,230,232));
			jp_dateLimite.add(jl_dataInicial, null);
			jp_dateLimite.add(jl_dataFinal, null);
			jp_dateLimite.add(getJtf_diaInicial(), null);
			jp_dateLimite.add(getJtf_diaFim(), null);
			jp_dateLimite.add(getJcb_mesInicial(), null);
			jp_dateLimite.add(getJcb_mesFinal(), null);
			jp_dateLimite.add(getJb_visualizarAniversariantes(), null);
			jp_dateLimite.add(getJp_numNiver(), null);
			jp_dateLimite.add(jl_baloes, null);
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
			jtf_diaInicial.setBounds(new Rectangle(85, 28, 30, 18));
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
			jtf_diaFim.setBounds(new Rectangle(85, 70, 30, 18));
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
			jcb_mesInicial.setBounds(new Rectangle(120, 28, 135, 20));
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
			jcb_mesFinal.setBounds(new Rectangle(120, 70, 135, 21));
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
			jb_visualizarAniversariantes.setBounds(new Rectangle(335, 70, 185, 23));
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



		DefaultTableModel tableModel = new DefaultTableModel();
		int mesInicial =  jcb_mesInicial.getSelectedIndex();
		int mesFinal =  jcb_mesFinal.getSelectedIndex();
		IntegranteIgreja temp = null;
		LinkedList<IntegranteIgreja> aniverIntig;

		Date dateInicial = null;
		Date dateFinal = null;
		String dataInicial = "";
		String dataFinal = "";

		try {

			if(mesInicial>=1 && mesInicial<=9){
				dataInicial =  jtf_diaInicial.getText()+"/"+"0"+mesInicial+"/"+"2000";
			}else{
				dataInicial =  jtf_diaInicial.getText()+"/"+mesInicial+"/"+"2000";
			}
			if(mesFinal>=1 && mesFinal<=9){
				dataFinal = jtf_diaFim.getText()+"/"+"0"+mesFinal+"/"+"2000";
			}else{
				dataFinal =  jtf_diaFim.getText()+"/"+mesFinal+"/"+"2000";
			}
			dateInicial = new Date(dataInicial);
			dateFinal = new Date(dataFinal);

			Iterator<IntegranteIgreja> integrantesIg = this.facade.getIntegranteIgreja();


			aniverIntig = new LinkedList<IntegranteIgreja>();

			while(integrantesIg.hasNext()){
				temp = integrantesIg.next();
				if((temp.getDataNascimento().getMonth()>= dateInicial.getMonth() && 
						temp.getDataNascimento().getMonth()<= dateFinal.getMonth()) &&
						(temp.getDataNascimento().getDay())>= dateInicial.getDay() && 
						(temp.getDataNascimento().getDay()<= dateFinal.getDay() || temp.getDataNascimento().getMonth()<= (dateFinal.getMonth()-1))){
								aniverIntig.add(temp);
				}

			}


			//tamList = aniverIntig.size();
			tableModel.addColumn("Nº de Registro");
			tableModel.addColumn("Nome");
			tableModel.addColumn("Tipo");
			tableModel.addColumn("Data Nascimento");
			tableModel.addColumn("Estado Civil");
			String []row = new String[5];

			
			jl_quantAniversariantes.setText(String.valueOf(aniverIntig.size()==0?aniverIntig.size():aniverIntig.size()+1));
			
			/*"Rg", "Tipo", "Nome", "Data Nascimento", "Estado Civil"*/
			for (int i = 0; i < aniverIntig.size(); i++) {
				row[0] = aniverIntig.get(i).getRg();
				row[1] = aniverIntig.get(i).getNome();
				row[2] = aniverIntig.get(i).getType().name();
				row[3] = aniverIntig.get(i).getDataNascimento().toString();
				row[4] = aniverIntig.get(i).getEstadoCivil();
				tableModel.addRow(row);
			}

			if(aniverIntig.size()==0){
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
			
			JOptionPane.showMessageDialog(this,e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(this,e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (InvalidDateException e) {
			
			JOptionPane.showMessageDialog(this,e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException e) {
			
			JOptionPane.showMessageDialog(this,e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			
			JOptionPane.showMessageDialog(this,e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
			jp_buttons.setBounds(new Rectangle(474, 573, 515, 74));
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

	/**
	 * This method initializes jp_numNiver	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJp_numNiver() {
		if (jp_numNiver == null) {
			jp_numNiver = new JPanel();
			jp_numNiver.setLayout(null);
			jp_numNiver.setBounds(new Rectangle(335, 15, 266, 42));
			jp_numNiver.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jp_numNiver.setBackground(new Color(225, 230, 232));
			jp_numNiver.add(jl_numAniversariantes, null);
			jp_numNiver.add(jl_quantAniversariantes, null);
		}
		return jp_numNiver;
	}

}
