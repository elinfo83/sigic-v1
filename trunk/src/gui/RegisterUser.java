package gui;

import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class RegisterUser extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jp_user = null;
	private JLabel jl_user = null;
	private JLabel jl_pass = null;
	private JLabel jl_nivel = null;
	private JTextField jtf_user = null;
	private JTextField jtf_pass = null;
	private JComboBox jcb_categoria = null;
	private JPanel jp_buttons = null;
	private JButton jb_sair = null;
	private JButton jb_cadastrar = null;
	private JButton jb_atualizar = null;
	private JButton jb_procurar = null;
	private JButton jb_remover = null;

	/**
	 * @param owner
	 */
	public RegisterUser(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(418, 293);
		this.setTitle("Usuários");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJp_user(), null);
			jContentPane.add(getJp_buttons(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jp_user	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJp_user() {
		if (jp_user == null) {
			jl_nivel = new JLabel();
			jl_nivel.setBounds(new Rectangle(16, 104, 58, 16));
			jl_nivel.setText("Categoria:");
			jl_pass = new JLabel();
			jl_pass.setBounds(new Rectangle(16, 64, 39, 16));
			jl_pass.setText("Senha:");
			jl_user = new JLabel();
			jl_user.setBounds(new Rectangle(16, 24, 47, 16));
			jl_user.setText("Usuário:");
			jp_user = new JPanel();
			jp_user.setLayout(null);
			jp_user.setBounds(new Rectangle(5, 7, 391, 147));
			jp_user.setBorder(BorderFactory.createTitledBorder(null, "Dados Usuários", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jp_user.add(jl_user, null);
			jp_user.add(jl_pass, null);
			jp_user.add(jl_nivel, null);
			jp_user.add(getJtf_user(), null);
			jp_user.add(getJtf_pass(), null);
			jp_user.add(getJcb_categoria(), null);
		}
		return jp_user;
	}

	/**
	 * This method initializes jtf_user	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_user() {
		if (jtf_user == null) {
			jtf_user = new JTextField();
			jtf_user.setBounds(new Rectangle(81, 23, 143, 18));
		}
		return jtf_user;
	}

	/**
	 * This method initializes jtf_pass	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_pass() {
		if (jtf_pass == null) {
			jtf_pass = new JTextField();
			jtf_pass.setBounds(new Rectangle(81, 64, 143, 18));
		}
		return jtf_pass;
	}

	/**
	 * This method initializes jcb_categoria	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJcb_categoria() {
		if (jcb_categoria == null) {
			jcb_categoria = new JComboBox();
			jcb_categoria.setBounds(new Rectangle(81, 106, 143, 19));
		}
		return jcb_categoria;
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
			jp_buttons.setBounds(new Rectangle(5, 161, 391, 87));
			jp_buttons.setBorder(BorderFactory.createTitledBorder(null, "Opções", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jp_buttons.add(getJb_sair(), null);
			jp_buttons.add(getJb_cadastrar(), null);
			jp_buttons.add(getJb_atualizar(), null);
			jp_buttons.add(getJb_procurar(), null);
			jp_buttons.add(getJb_remover(), null);
		}
		return jp_buttons;
	}

	/**
	 * This method initializes jb_sair	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_sair() {
		if (jb_sair == null) {
			jb_sair = new JButton();
			jb_sair.setBounds(new Rectangle(222, 56, 92, 18));
			jb_sair.setText("Sair");
		}
		return jb_sair;
	}

	/**
	 * This method initializes jb_cadastrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_cadastrar() {
		if (jb_cadastrar == null) {
			jb_cadastrar = new JButton();
			jb_cadastrar.setBounds(new Rectangle(21, 23, 101, 18));
			jb_cadastrar.setText("Cadastrar");
		}
		return jb_cadastrar;
	}

	/**
	 * This method initializes jb_atualizar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_atualizar() {
		if (jb_atualizar == null) {
			jb_atualizar = new JButton();
			jb_atualizar.setBounds(new Rectangle(260, 23, 92, 18));
			jb_atualizar.setText("Atualizar");
		}
		return jb_atualizar;
	}

	/**
	 * This method initializes jb_procurar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_procurar() {
		if (jb_procurar == null) {
			jb_procurar = new JButton();
			jb_procurar.setBounds(new Rectangle(143, 23, 96, 18));
			jb_procurar.setText("Procurar");
		}
		return jb_procurar;
	}

	/**
	 * This method initializes jb_remover	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_remover() {
		if (jb_remover == null) {
			jb_remover = new JButton();
			jb_remover.setBounds(new Rectangle(59, 56, 104, 18));
			jb_remover.setText("Remover");
		}
		return jb_remover;
	}

}  //  @jve:decl-index=0:visual-constraint="329,89"
