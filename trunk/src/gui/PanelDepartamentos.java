package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import mem.exception.DepartmentAlreadyRegisteredException;
import mem.exception.DepartmentNoRegisteredException;
import mem.exception.InvalidDateException;
import mem.model.departamento.Department;
import mem.model.documentos.DescricaoDepartamento;
import util.Date;
import facade.Facade;

public class PanelDepartamentos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jl_nomeDep = null;
	private JTextField jtf_nomeDep = null;
	private JLabel jl_siglaDep = null;
	private JTextField jtf_siglaDep = null;
	private JPanel jp_buttons = null;
	private JButton jb_alterar = null;
	private JButton jb_cancelar = null;
	private JButton jb_confirmar = null;
	private Facade facade;
	private JLabel jl_dataCriacao = null;
	private JTextField jtf_diaCriacao = null;
	private JTextField jtf_anoCriacao = null;
	private JComboBox jcb_mesCriacao = null;
	private JLabel jl_barra = null;
	private JLabel jl_barra1 = null;
	private JTabbedPane pane;
	private JScrollPane jsp_histDep = null;
	private JTextArea jta_histDep = null;
	/**
	 * This is the default constructor
	 */
	public PanelDepartamentos(Facade facade, JTabbedPane tab) {
		super();
		this.facade = facade;
		this.pane = tab;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jl_barra1 = new JLabel();
		jl_barra1.setBounds(new Rectangle(271, 103, 13, 17));
		jl_barra1.setText("/");
		jl_barra = new JLabel();
		jl_barra.setBounds(new Rectangle(143, 103, 10, 16));
		jl_barra.setText("/");
		jl_dataCriacao = new JLabel();
		jl_dataCriacao.setBounds(new Rectangle(16, 103, 73, 16));
		jl_dataCriacao.setText("Data Criação");
		jl_siglaDep = new JLabel();
		jl_siglaDep.setBounds(new Rectangle(16, 59, 133, 22));
		jl_siglaDep.setText("Sigla do Departamento");
		jl_nomeDep = new JLabel();
		jl_nomeDep.setBounds(new Rectangle(16, 16, 139, 23));
		jl_nomeDep.setText("Nome do Departamento");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 1023, 703));
		this.setBackground(new Color(225, 230, 232));
		this.add(jl_nomeDep, null);
		this.add(getJtf_nomeDep(), null);
		this.add(jl_siglaDep, null);
		this.add(getJtf_siglaDep(), null);
		this.add(getJp_buttons(), null);
		this.add(jl_dataCriacao, null);
		this.add(getJtf_diaCriacao(), null);
		this.add(getJtf_anoCriacao(), null);
		this.add(getJcb_mesCriacao(), null);
		this.add(jl_barra, null);
		this.add(jl_barra1, null);
		this.add(getJsp_histDep(), null);
	}

	/**
	 * This method initializes jtf_nomeDep	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_nomeDep() {
		if (jtf_nomeDep == null) {
			jtf_nomeDep = new JTextField();
			jtf_nomeDep.setBounds(new Rectangle(155, 16, 469, 18));
		}
		return jtf_nomeDep;
	}

	/**
	 * This method initializes jtf_siglaDep	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_siglaDep() {
		if (jtf_siglaDep == null) {
			jtf_siglaDep = new JTextField();
			jtf_siglaDep.setBounds(new Rectangle(152, 59, 97, 18));
		}
		return jtf_siglaDep;
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
			jp_buttons.setBounds(new Rectangle(501, 601, 511, 62));
			jp_buttons.setBackground(new Color(225, 230, 232));
			jp_buttons.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jp_buttons.add(getJb_alterar(), null);
			jp_buttons.add(getJb_cancelar(), null);
			jp_buttons.add(getJb_confirmar(), null);
		}
		return jp_buttons;
	}

	/**
	 * This method initializes jb_alterar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_alterar() {
		if (jb_alterar == null) {
			jb_alterar = new JButton();
			jb_alterar.setBounds(new Rectangle(20, 21, 143, 23));
			jb_alterar.setText("Alterar");
		}
		return jb_alterar;
	}

	/**
	 * This method initializes jb_cancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_cancelar() {
		if (jb_cancelar == null) {
			jb_cancelar = new JButton();
			jb_cancelar.setBounds(new Rectangle(183, 21, 143, 23));
			jb_cancelar.setText("Cancelar");
			jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					close();
				}
			});
		}
		return jb_cancelar;
	}

	private void close() {
		this.pane.remove(this);
	}
	/**
	 * This method initializes jb_confirmar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_confirmar() {
		if (jb_confirmar == null) {
			jb_confirmar = new JButton();
			jb_confirmar.setBounds(new Rectangle(346, 21, 143, 23));
			jb_confirmar.setText("Confirmar");
			jb_confirmar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cadastrar();
				}
			});
		}
		return jb_confirmar;
	}

	private void cadastrar() {
		String nomeDep = "";
		String siglaDep = "";
		String diaCriacao = "";
		int mesCriacao = 1;
		String anoCriacao = "";
		Department dep = null;
		String desDep = "";
		
		nomeDep = jtf_nomeDep.getText();
		siglaDep = jtf_siglaDep.getText();
		diaCriacao = jtf_diaCriacao.getText();
		mesCriacao = jcb_mesCriacao.getSelectedIndex();
		anoCriacao = jtf_anoCriacao.getText();
		String mesCriacaoText = "";
		desDep = this.jta_histDep.getText();
		DescricaoDepartamento descricaoDepartamento = null;
		
		Date date = null;
			
			try {
				if(mesCriacao>=1 || mesCriacao<=9){
					mesCriacaoText = "0"+mesCriacao; 
				}else{
					mesCriacaoText = String.valueOf(mesCriacao);
				}
				date = new Date(diaCriacao+"/"+mesCriacaoText+"/"+anoCriacao);
				descricaoDepartamento = new DescricaoDepartamento(desDep,nomeDep);
				dep = new Department(siglaDep,null,date,nomeDep,descricaoDepartamento);
				this.facade.cadastrar(dep);
				JOptionPane.showMessageDialog(this, "Cargo Cadastrado com Sucesso!");
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			} catch (DepartmentAlreadyRegisteredException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, e.getMessage());
			} catch (InvalidDateException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, e.getMessage());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DepartmentNoRegisteredException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	

	/**
	 * This method initializes jtf_diaCriacao	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_diaCriacao() {
		if (jtf_diaCriacao == null) {
			jtf_diaCriacao = new JTextField();
			jtf_diaCriacao.setBounds(new java.awt.Rectangle(109,103,30,18));
		}
		return jtf_diaCriacao;
	}

	/**
	 * This method initializes jtf_anoCriacao	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_anoCriacao() {
		if (jtf_anoCriacao == null) {
			jtf_anoCriacao = new JTextField();
			jtf_anoCriacao.setBounds(new Rectangle(286, 103, 83, 18));
		}
		return jtf_anoCriacao;
	}

	/**
	 * This method initializes jcb_mesCriacao	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJcb_mesCriacao() {
		if (jcb_mesCriacao == null) {
			jcb_mesCriacao = new JComboBox(LoadComboBoxs.preencheComboMeses());
			jcb_mesCriacao.setBounds(new Rectangle(153, 103, 111, 19));
		}
		return jcb_mesCriacao;
	}

	/**
	 * This method initializes jsp_histDep	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJsp_histDep() {
		if (jsp_histDep == null) {
			jsp_histDep = new JScrollPane();
			jsp_histDep.setBounds(new Rectangle(16, 161, 991, 359));
			jsp_histDep.setBorder(BorderFactory.createTitledBorder(null, "Histórico", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jsp_histDep.setViewportView(getJta_histDep());
			jsp_histDep.setBackground(new Color(225, 230, 232));
		}
		return jsp_histDep;
	}

	/**
	 * This method initializes jta_histDep	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJta_histDep() {
		if (jta_histDep == null) {
			jta_histDep = new JTextArea();
		}
		return jta_histDep;
	}
}  
