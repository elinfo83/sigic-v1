package gui.mains;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import mem.exception.InvalidDateException;
import mem.interfaces.IMainFrame;
import mem.model.integrantesIg.IntegranteIgreja;
import mem.model.integrantesIg.IntegrantesIgrejaTypes;
import mem.model.relatorio.RelatorioIntegrantesIgreja;
import util.ConstantsSystem;

import com.lowagie.text.DocumentException;

import facade.Facade;
import gui.Aniversariantes;
import gui.ProcurarMembro;
import gui.RegisterUser;
import gui.TelaInicial;
import gui.ViewDepartment;

public class MainUserAdm extends JFrame implements IMainFrame{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar menuprincipal = null;
	private JMenu jm_cadastros = null;
	private JMenu jm_visualizar = null;
	private JTabbedPane jTabbedPane = null;
	private JMenu jm_departamentos = null;
	private JMenuItem jm_jovens = null;
	private Facade facade;
	private JMenu jm_Arquivo = null;
	private JMenuItem jmi_sair = null;
	private JMenu jm_ajuda = null;
	private JMenuItem jmi_viewDepartments = null;
	private JMenuItem jmi_aniversariantes = null;
	private JMenuItem jmi_diretoria = null;
	private JMenuItem jmi_integrantesIgreja = null;
	private JMenuItem jmi_help = null;
	private JMenuItem jmi_Config = null;
	private JMenuItem jmi_gerarRelatorioGeral = null;
	private JMenuItem jmi_user = null;
	/**
	 * This is the default constructor
	 */
	public MainUserAdm() {
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
			jmi_viewDepartments.setIcon(new ImageIcon(ConstantsSystem.PATH_IMAGES+"buscar.png"));
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
			jmi_aniversariantes.setIcon(new ImageIcon(ConstantsSystem.PATH_IMAGES+"buscar.png"));
			jmi_aniversariantes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					addTab(new Aniversariantes(getFacade(),getJTabbedPane()),"Aniversariantes do Período");
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
			jmi_diretoria.setIcon(new ImageIcon(ConstantsSystem.PATH_IMAGES+"buscar.png"));
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
			jmi_integrantesIgreja.setIcon(new ImageIcon(ConstantsSystem.PATH_IMAGES+"buscar.png"));
			jmi_integrantesIgreja.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					addTab(new ProcurarMembro(getFacade(),getJTabbedPane()),"Procurar Integrante Igreja");
				}
			});
		}
		return jmi_integrantesIgreja;
	}

	/**
	 * This method initializes jmi_help	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJmi_help() {
		if (jmi_help == null) {
			jmi_help = new JMenuItem();
			jmi_help.setText("Suporte");
			jmi_help.setIcon(new ImageIcon(ConstantsSystem.PATH_IMAGES + "help.png"));
		}
		return jmi_help;
	}

	/**
	 * This method initializes jmi_Config	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJmi_Config() {
		if (jmi_Config == null) {
			jmi_Config = new JMenuItem();
			jmi_Config.setText("Configurações");
			jmi_Config.setIcon(new ImageIcon(ConstantsSystem.PATH_IMAGES + "config.png"));
		}
		return jmi_Config;
	}

	/**
	 * This method initializes jmi_gerarRelatorioGeral	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJmi_gerarRelatorioGeral() {
		if (jmi_gerarRelatorioGeral == null) {
			jmi_gerarRelatorioGeral = new JMenuItem();
			jmi_gerarRelatorioGeral.setText("Exportar Relatorio Geral");
			jmi_gerarRelatorioGeral.setIcon(new ImageIcon("D:/workspace/sigic-v1.1/imagens/exportar.png"));
			jmi_gerarRelatorioGeral.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					gerarRelatorioGeral();
				}
			});
		}
		return jmi_gerarRelatorioGeral;
	}

	private void gerarRelatorioGeral(){

		try {
			Iterator<IntegranteIgreja> iterator = this.facade.getIntegranteIgreja();
			LinkedList<IntegranteIgreja> list = new LinkedList<IntegranteIgreja>();
			LinkedList<IntegranteIgreja> temp = new LinkedList<IntegranteIgreja>();
			IntegranteIgreja integranteIgreja;
			while(iterator.hasNext()){
				integranteIgreja = iterator.next();
				if(integranteIgreja.getType().name().equals(IntegrantesIgrejaTypes.MEMBRO.name())){
					list.add(integranteIgreja);

				}else{
					temp.add(integranteIgreja);
				}
			}
			
			list.addAll(temp);

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
			fileChooser.setDialogTitle("Selecionar Pasta");
			fileChooser.showSaveDialog(null);
			File file = fileChooser.getSelectedFile();
			String path = "";

			if (file.isDirectory()) {
				System.out.println("passou");
				path = file.getAbsolutePath();
			}



			RelatorioIntegrantesIgreja relatorioIntegrantesIgreja = new RelatorioIntegrantesIgreja(
					"Relatório de Membros e Congregados da ICB em São Lourenço da Mata/PE",path+"\\relatorio.pdf");
			relatorioIntegrantesIgreja.preencheTabela(list.iterator());
			
			JOptionPane.showMessageDialog(this, "Relatorio gerado em " + path, "", JOptionPane.INFORMATION_MESSAGE);

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
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.facade = new Facade();
		
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("D:/workspace/sigic-v1.1/imagens/logop4.png"));
		this.setBackground(new Color(225, 230, 232));
		this.setBounds(new java.awt.Rectangle(0,0,1036,750));
		this.setJMenuBar(getMenuprincipal());
		this.setContentPane(getJContentPane());
		this.setTitle("SISTEMA INTEGRADO DE GERENCIAMENTO DA ICB em São Lourenço da Mata");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
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
			jm_cadastros.add(getJmi_user());
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

	private void addTab(JPanel jPanel, String text){
		this.jTabbedPane.addTab(text, null, jPanel, null);
		this.jTabbedPane.setSelectedComponent(jPanel);
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
			jm_jovens.setText("Créditos");
			jm_jovens.setIcon(new ImageIcon(ConstantsSystem.PATH_IMAGES+"info.png"));
			jm_jovens.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jm_jovens;
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
			jm_Arquivo.add(getJmi_gerarRelatorioGeral());
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
			jmi_sair.setIcon(new ImageIcon(ConstantsSystem.PATH_IMAGES+"sair.png"));
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
			jm_ajuda.add(getJmi_help());
			jm_ajuda.add(getJmi_Config());

		}
		return jm_ajuda;
	}

	/**
	 * This method initializes jmi_user	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJmi_user() {
		if (jmi_user == null) {
			final JFrame frame = this;
			jmi_user = new JMenuItem();
			jmi_user.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					RegisterUser registerUser = new RegisterUser(frame);
					registerUser.setVisible(true);
				}
			});
		}
		return jmi_user;
	}
}  //  @jve:decl-index=0:visual-constraint="226,0"
