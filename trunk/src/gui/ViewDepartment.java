package gui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import mem.exception.DepartmentNoRegisteredException;
import mem.exception.InvalidDateException;
import mem.model.departamento.Department;
import mem.model.integrantesIg.IntegranteIgreja;
import facade.Facade;

public class ViewDepartment extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jlDepartamentos = null;
	private JComboBox jcb_departamentos = null;
	private JButton jb_departamentos = null;
	private JScrollPane jsp_infoDepartamentos = null;
	private JTable jt_infoDepartamentos = null;
	private String[] titulosColunas = {"Nº de Registro", "Tipo", "Nome", "Data Nascimento", "Estado Civil"};
	private String[][] initialDados = {{"","","","",""}};
	private JTabbedPane pane = null;
	private Facade facade = null;
	private JPanel jp_botoes = null;
	private JButton jb_fechar = null;
	private JButton b_imprimirLista = null;
	private JPanel jp_numINt = null;
	private JLabel jl_titleNumInt = null;
	private JLabel jl_numInt = null;
	/**
	 * This is the default constructor
	 */
	public ViewDepartment(JTabbedPane parent, Facade facade) {
		super();
		this.pane = parent;
		this.facade = facade;
		
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
	
        jlDepartamentos = new JLabel();
        jlDepartamentos.setText("Departametos");
        jlDepartamentos.setBounds(new java.awt.Rectangle(16,14,81,16));
        this.setLayout(null);
        this.setBounds(new java.awt.Rectangle(0,0,1023,703));
        this.setForeground(java.awt.Color.blue);
        this.setBackground(new java.awt.Color(225,230,232));
        this.add(jlDepartamentos, null);
        this.add(getJcb_departamentos(), null);
        this.add(getJb_departamentos(), null);
        this.add(getJsp_infoDepartamentos(), null);
        this.add(getJp_botoes(), null);
        this.add(getJp_numINt(), null);
	}

	/**
	 * This method initializes jcb_departamentos	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJcb_departamentos() {
		if (jcb_departamentos == null) {
			try {
				jcb_departamentos = new JComboBox(this.facade.getDepartment());
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
			} catch (DepartmentNoRegisteredException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jcb_departamentos.setBounds(new java.awt.Rectangle(104,14,135,18));
		}
		return jcb_departamentos;
	}

	/**
	 * This method initializes jb_departamentos	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_departamentos() {
		if (jb_departamentos == null) {
			jb_departamentos = new JButton();
			jb_departamentos.setBounds(new java.awt.Rectangle(287,14,159,22));
			jb_departamentos.setText("Visualisar");
			jb_departamentos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTableSetModel();
				}
			});
			
		}
		return jb_departamentos;
	}

	
	private void jTableSetModel(){
		String codDep = ((Department)this.jcb_departamentos.getSelectedItem()).getCode();
		List<IntegranteIgreja> list = null;
		int tamList = 0;
		
		DefaultTableModel tableModel = new DefaultTableModel();
		
		try {
			Department department = this.facade.findDepartment(codDep);
			list = department.getComponents();
			tamList = list.size();
			tableModel.addColumn("Nº de Registro");
			tableModel.addColumn("Nome");
			tableModel.addColumn("Tipo");
			tableModel.addColumn("Data Nascimento");
			tableModel.addColumn("Estado Civil");
			
			String []row = new String[5];
			
			
			/*"Rg", "Tipo", "Nome", "Data Nascimento", "Estado Civil"*/
			for (int i = 0; i < tamList; i++) {
				row[0] = list.get(i).getRg();
				row[1] = list.get(i).getNome();
				row[2] = list.get(i).getType().name();
				row[3] = list.get(i).getDataNascimento().toString();
				row[4] = list.get(i).getEstadoCivil();
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
			if(this.jt_infoDepartamentos!=null) this.jt_infoDepartamentos.setModel(tableModel);
			for (int i = 0; i < 5; i++) {
				column = jt_infoDepartamentos.getColumnModel().getColumn(i);
				if (i==1) {
					column.setPreferredWidth(300);
				} else {
					column.setPreferredWidth(0);
				}
			}
			
			jl_numInt.setText(String.valueOf(tamList));
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidDateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DepartmentNoRegisteredException e) {
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
	
	
	
	

	private JScrollPane getJsp_infoDepartamentos() {
		if (jsp_infoDepartamentos == null) {
			jsp_infoDepartamentos = new JScrollPane();
			jsp_infoDepartamentos.setBounds(new java.awt.Rectangle(16,59,992,494));
			jsp_infoDepartamentos.setBackground(new java.awt.Color(225,230,232));
			jsp_infoDepartamentos.setViewportView(getJt_infoDepartamentos());
		}
		return jsp_infoDepartamentos;
	}

	/**
	 * This method initializes jt_infoDepartamentos	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJt_infoDepartamentos() {
		TableColumn column = null;
		
		if (jt_infoDepartamentos == null) {
			jt_infoDepartamentos = new JTable(this.initialDados,titulosColunas);
			jt_infoDepartamentos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
			jt_infoDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (e.getClickCount()>1) {
						System.out.println("pegou");
					}
				}
			});
			for (int i = 0; i < 5; i++) {
				column = jt_infoDepartamentos.getColumnModel().getColumn(i);
				if (i==2) {
					column.setPreferredWidth(300);
				} else {
					column.setPreferredWidth(0);
				}
			}
			
			
		}
		return jt_infoDepartamentos;
	}

	/**
	 * This method initializes jp_botoes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJp_botoes() {
		if (jp_botoes == null) {
			jp_botoes = new JPanel();
			jp_botoes.setLayout(null);
			jp_botoes.setBounds(new java.awt.Rectangle(573,567,434,61));
			jp_botoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jp_botoes.setBackground(new java.awt.Color(225,230,232));
			jp_botoes.add(getJb_fechar(), null);
			jp_botoes.add(getB_imprimirLista(), null);
		}
		return jp_botoes;
	}

	/**
	 * This method initializes jb_fechar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_fechar() {
		if (jb_fechar == null) {
			jb_fechar = new JButton();
			jb_fechar.setBounds(new java.awt.Rectangle(246,19,127,23));
			jb_fechar.setText("Fechar");
			jb_fechar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					close();
				}
			});
		}
		return jb_fechar;
	}
	
	private void close(){
		this.pane.remove(this);
	}

	/**
	 * This method initializes b_imprimirLista	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getB_imprimirLista() {
		if (b_imprimirLista == null) {
			b_imprimirLista = new JButton();
			b_imprimirLista.setBounds(new java.awt.Rectangle(59,18,127,23));
			b_imprimirLista.setText("Imprimir Lista");
		}
		return b_imprimirLista;
	}

	/**
	 * This method initializes jp_numINt	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJp_numINt() {
		if (jp_numINt == null) {
			jl_numInt = new JLabel();
			jl_numInt.setBounds(new java.awt.Rectangle(126,9,22,20));
			jl_numInt.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 18));
			jl_numInt.setText("0");
			jl_titleNumInt = new JLabel();
			jl_titleNumInt.setBounds(new java.awt.Rectangle(14,9,100,16));
			jl_titleNumInt.setText("Nº de Integrantes:");
			jp_numINt = new JPanel();
			jp_numINt.setLayout(null);
			jp_numINt.setBounds(new java.awt.Rectangle(532,8,199,40));
			jp_numINt.setBackground(new java.awt.Color(225,230,232));
			jp_numINt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jp_numINt.add(jl_titleNumInt, null);
			jp_numINt.add(jl_numInt, null);
		}
		return jp_numINt;
	}

}
