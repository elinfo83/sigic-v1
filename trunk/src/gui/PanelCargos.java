package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import mem.exception.CargoAlreadyRegistredException;
import mem.exception.InvalidDateException;
import mem.model.cargo.Cargo;
import mem.model.documentos.Minuta;
import facade.Facade;

public class PanelCargos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jl_nomeCargo = null;
	private JTextField jtf_nomeCargo = null;
	private JScrollPane jsp_minuta = null;
	private JTextArea jta_minuta = null;
	private JPanel jp_button = null;
	private JButton jb_fechar = null;
	private JButton jb_confirmar = null;
	private JButton jb_alterar = null;
	private Facade facade;
	private JTabbedPane parent;
	/**
	 * This is the default constructor
	 */
	public PanelCargos(Facade facade, JTabbedPane parent) {
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
		
		jl_nomeCargo = new JLabel();
		jl_nomeCargo.setBounds(new Rectangle(15, 15, 89, 20));
		jl_nomeCargo.setText("Nome do Cargo");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 1023, 703));
		this.setBackground(new Color(225, 230, 232));
		this.setBackground(new Color(225, 230, 232));
		this.add(jl_nomeCargo, null);
		this.add(getJtf_nomeCargo(), null);
		this.add(getJsp_minuta(), null);
		this.add(getJp_button(), null);
	}

	/**
	 * This method initializes jtf_nomeCargo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_nomeCargo() {
		if (jtf_nomeCargo == null) {
			jtf_nomeCargo = new JTextField();
			jtf_nomeCargo.setBounds(new Rectangle(108, 15, 290, 18));
		}
		return jtf_nomeCargo;
	}

	/**
	 * This method initializes jsp_minuta	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJsp_minuta() {
		if (jsp_minuta == null) {
			jsp_minuta = new JScrollPane();
			jsp_minuta.setBounds(new Rectangle(15, 56, 991, 513));
			jsp_minuta.setBorder(BorderFactory.createTitledBorder(null, "Minuta", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jsp_minuta.setViewportView(getJta_minuta());
			jsp_minuta.setBackground(new Color(225, 230, 232));
		}
		return jsp_minuta;
	}

	/**
	 * This method initializes jta_minuta	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJta_minuta() {
		if (jta_minuta == null) {
			jta_minuta = new JTextArea();
			jta_minuta.setColumns(30);
		}
		return jta_minuta;
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
			jp_button.setBounds(new java.awt.Rectangle(499,579,511,62));
			jp_button.setBackground(new Color(225, 230, 232));
			jp_button.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jp_button.add(getJb_fechar(), null);
			jp_button.add(getJb_confirmar(), null);
			jp_button.add(getJb_alterar(), null);
		}
		return jp_button;
	}

	/**
	 * This method initializes jb_fechar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_fechar() {
		if (jb_fechar == null) {
			jb_fechar = new JButton();
			jb_fechar.setBounds(new Rectangle(361, 23, 143, 23));
			jb_fechar.setText("Confirmar");
			jb_fechar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cadastrar();
				}
			});
		}
		return jb_fechar;
	}

	private void cadastrar(){
		
		Cargo cargo =  new Cargo();
		Minuta doc = null;
		String nome = jtf_nomeCargo.getText();
		String minuta = jta_minuta.getText();
		try {
			if(nome.equals("") || minuta.equals("")){
				
			}else{
				cargo.setNome(nome);
				doc = new Minuta(minuta,nome);
				cargo.setMinuta(doc);
				this.facade.cadastrar(cargo);
				JOptionPane.showMessageDialog(this,"Cargo Cadastrado com Sucesso!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
			}
			
		} catch (CargoAlreadyRegistredException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,e.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,e.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,e.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
		} catch (InvalidDateException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,e.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,e.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,e.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
		}
	}
	/**
	 * This method initializes jb_confirmar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_confirmar() {
		if (jb_confirmar == null) {
			jb_confirmar = new JButton();
			jb_confirmar.setBounds(new Rectangle(193, 23, 143, 23));
			jb_confirmar.setText("Cancelar");
			jb_confirmar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					closeAba();
				}
			});
		}
		return jb_confirmar;
	}

	/**
	 * This method initializes jb_alterar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	
	private void closeAba(){
		parent.remove(this);
	}
	
	private JButton getJb_alterar() {
		if (jb_alterar == null) {
			jb_alterar = new JButton();
			jb_alterar.setBounds(new Rectangle(25, 23, 143, 23));
			jb_alterar.setText("Alterar");
		}
		return jb_alterar;
	}

}
