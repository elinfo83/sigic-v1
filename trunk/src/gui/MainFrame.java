package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import facade.Facade;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar menuprincipal = null;
	private JMenu jm_cadastros = null;
	private JMenu jm_visualizar = null;
	private UIManager.LookAndFeelInfo looks[];
	private JMenuItem jmi_membros = null;
	private JMenuItem jmi_departamentos = null;
	private JTabbedPane jTabbedPane = null;
	private JMenu jm_departamentos = null;
	private JMenuItem jm_jovens = null;
	private JMenuItem jMenuItem = null;
	private Facade facade;
	private JMenu jm_Arquivo = null;
	private JMenuItem jmi_sair = null;
	private JMenu jm_ajuda = null;
	private JMenuItem jmi_viewDepartments = null;
	private JMenuItem jmi_aniversariantes = null;
	private JMenuItem jmi_diretoria = null;
	private JMenuItem jmi_integrantesIgreja = null;
	/**
	 * This is the default constructor
	 */
	public MainFrame() {
		super();
		initialize();
	}
	
	/**
	 * This method initializes jm_viewDepartments	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJm_viewDepartments() {
		if (jmi_viewDepartments == null) {
			jmi_viewDepartments = new JMenuItem();
			jmi_viewDepartments.setText("Departamentos");
			jmi_viewDepartments.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					addTab(new ViewDepartment(getJTabbedPane(),getFacade()), "Visualizar Departamentos");
				}
			});
		}
		return jmi_viewDepartments;
	}

	/**
	 * This method initializes jmi_aniversariantes	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJmi_aniversariantes() {
		if (jmi_aniversariantes == null) {
			jmi_aniversariantes = new JMenuItem();
			jmi_aniversariantes.setText("Aniversariantes");
			jmi_aniversariantes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					addTab(new Aniversariantes(getFacade(),getJTabbedPane()),"Procurar Integrante Igreja");
				}
			});
		}
		return jmi_aniversariantes;
	}

	/**
	 * This method initializes jmi_diretoria	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJmi_diretoria() {
		if (jmi_diretoria == null) {
			jmi_diretoria = new JMenuItem();
			jmi_diretoria.setText("Diretorias");
		}
		return jmi_diretoria;
	}

	/**
	 * This method initializes jmi_integrantesIgreja	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJmi_integrantesIgreja() {
		if (jmi_integrantesIgreja == null) {
			jmi_integrantesIgreja = new JMenuItem();
			jmi_integrantesIgreja.setText("Integrantes Igreja");
			jmi_integrantesIgreja.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					addTab(new ProcurarMembro(getFacade(),getJTabbedPane()),"Procurar Integrante Igreja");
				}
			});
		}
		return jmi_integrantesIgreja;
	}

	public static void main(String[] args) {
		MainFrame main = new MainFrame();
		main.setVisible(true);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.facade = new Facade();
		this.looks = UIManager.getInstalledLookAndFeels();
		try {
			UIManager.setLookAndFeel(looks[3].getClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);
		this.setResizable(false);
		this.setBackground(new Color(225, 230, 232));
		this.setBounds(new java.awt.Rectangle(0,0,1036,750));
		this.setJMenuBar(getMenuprincipal());
		this.setContentPane(getJContentPane());
		this.setTitle("SISTEMA INTEGRADO DE GERENCIAMENTO DA ICB em São Lourenço da Mata");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private Facade getFacade(){
		if(this.facade==null){
			this.facade = new Facade();
		}
		return this.facade;
	}
	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(225, 230, 232));
			jContentPane.add(getJTabbedPane(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes menuprincipal	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getMenuprincipal() {
		if (menuprincipal == null) {
			menuprincipal = new JMenuBar();
			menuprincipal.add(getJm_Arquivo());
			menuprincipal.add(getJm_cadastros());
			menuprincipal.add(getJm_visualizar());
			menuprincipal.add(getJm_departamentos());
			menuprincipal.add(getJm_ajuda());
		}
		return menuprincipal;
	}

	/**
	 * This method initializes jm_cadastros	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJm_cadastros() {
		if (jm_cadastros == null) {
			jm_cadastros = new JMenu();
			jm_cadastros.setName("");
			jm_cadastros.setFont(new Font("Dialog", Font.BOLD, 12));
			jm_cadastros.setText("Cadastros");
			jm_cadastros.add(getJmi_membros());
			jm_cadastros.add(getJMenuItem());
			jm_cadastros.add(getJmi_departamentos());
		}
		return jm_cadastros;
	}

	/**
	 * This method initializes jm_visualizar	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJm_visualizar() {
		if (jm_visualizar == null) {
			jm_visualizar = new JMenu();
			jm_visualizar.setText("Consultar");
			jm_visualizar.setFont(new Font("Dialog", Font.BOLD, 12));
			jm_visualizar.add(getJmi_integrantesIgreja());
			jm_visualizar.add(getJm_viewDepartments());
			jm_visualizar.add(getJmi_aniversariantes());
			jm_visualizar.add(getJmi_diretoria());
		}
		return jm_visualizar;
	}

	/**
	 * This method initializes jmi_membros	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJmi_membros() {
		if (jmi_membros == null) {
			jmi_membros = new JMenuItem();
			jmi_membros.setText("Membros");
			jmi_membros.setToolTipText("cadastra membros");
			jmi_membros.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					addTab(new PanelIntegrantesIgreja(getFacade(),getJTabbedPane()),"Cadastrar Membro");
				}
			});
		}
		return jmi_membros;
	}

	private void addTab(JPanel jPanel, String text){
		this.jTabbedPane.addTab(text, null, jPanel, null);
		this.jTabbedPane.setSelectedComponent(jPanel);
	}
	/**
	 * This method initializes jmi_departamentos	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJmi_departamentos() {
		if (jmi_departamentos == null) {
			jmi_departamentos = new JMenuItem();
			jmi_departamentos.setText("Departamentos");
			jmi_departamentos.setToolTipText("cadastra departamentos");
			jmi_departamentos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					addTab(new PanelDepartamentos(getFacade(),getJTabbedPane()), "Cadastrar Deoartamento");
				}
			});
		}
		return jmi_departamentos;
	}

	/**
	 * This method initializes jTabbedPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			TelaInicial inicial = new TelaInicial();
			inicial.setBackground(java.awt.Color.white);
			jTabbedPane = new JTabbedPane();
			jTabbedPane.setBounds(new java.awt.Rectangle(4,3,1023,703));
			jTabbedPane.setBackground(new Color(225, 230, 232));
			jTabbedPane.setTabPlacement(JTabbedPane.TOP);
			jTabbedPane.addTab("Tela Inicial", null, inicial, null);
			jTabbedPane.setSelectedComponent(inicial);
			
		}
		return jTabbedPane;
	}

	/**
	 * This method initializes jm_departamentos	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJm_departamentos() {
		if (jm_departamentos == null) {
			jm_departamentos = new JMenu();
			jm_departamentos.setText("Sobre");
			jm_departamentos.setFont(new Font("Dialog", Font.BOLD, 12));
			jm_departamentos.add(getJm_jovens());
		}
		return jm_departamentos;
	}

	/**
	 * This method initializes jm_jovens	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJm_jovens() {
		if (jm_jovens == null) {
			jm_jovens = new JMenuItem();
		}
		return jm_jovens;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
			jMenuItem.setText("Cargos");
			jMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					addTab(new PanelCargos(getFacade(),getJTabbedPane()),"Cadastrar Cargo");
				}
			});
		}
		return jMenuItem;
	}

	/**
	 * This method initializes jm_Arquivo	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJm_Arquivo() {
		if (jm_Arquivo == null) {
			jm_Arquivo = new JMenu();
			jm_Arquivo.setText("Arquivo");
			jm_Arquivo.setFont(new Font("Dialog", Font.BOLD, 12));
			jm_Arquivo.add(getJmi_sair());
		}
		return jm_Arquivo;
	}

	/**
	 * This method initializes jmi_sair	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJmi_sair() {
		if (jmi_sair == null) {
			jmi_sair = new JMenuItem();
			jmi_sair.setText("Sair");
			jmi_sair.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					closed();
				}

				
			});
		}
		return jmi_sair;
	}

	private void closed() {
		this.dispose();
		
	}

	/**
	 * This method initializes jm_ajuda	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJm_ajuda() {
		if (jm_ajuda == null) {
			jm_ajuda = new JMenu();
			jm_ajuda.setText("Ajuda");
			jm_ajuda.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12));
		}
		return jm_ajuda;
	}
}  //  @jve:decl-index=0:visual-constraint="226,0"
