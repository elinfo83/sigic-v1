package gui.login;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import util.ConstantsSystem;

import mem.exception.UsuarioNoRegisteredException;
import mem.model.usuarios.Usuario;
import facade.Facade;
import gui.mains.MainUserModify;
import gui.mains.MainUsersViewer;
import java.awt.Toolkit;

public class LoginSigic extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jl_logo = null;
	private JPanel jp_butons = null;
	private JLabel jl_user = null;
	private JLabel jl_senha = null;
	private JTextField jtf_user = null;
	private JPasswordField jpf_senha = null;
	private JButton jb_confirmar = null;
	private JButton jb_cancelar = null;
	private Facade facade;  //  @jve:decl-index=0:
	private LookAndFeelInfo[] looks;
	/**
	 * This is the default constructor
	 */
	public LoginSigic() {
		super();
		initialize();
	}

	static{
		try {
			Class.forName(ConstantsSystem.JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		
		LoginSigic loginSigic = new LoginSigic();
		loginSigic.setLocationRelativeTo(null);
		loginSigic.setVisible(true);
		
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.looks = UIManager.getInstalledLookAndFeels();
		try {
			UIManager.setLookAndFeel(looks[3].getClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,e.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,e.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,e.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,e.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
		}
		SwingUtilities.updateComponentTreeUI(this);
		this.setSize(569, 431);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("D:/workspace ganymede/sigic-v1.1/imagens/logop4.png"));
		
		this.setContentPane(getJContentPane());
		this.setTitle("Sistema de Gerenciamento da ICB em São Lourenço da Mata");
		this.setResizable(false);
	}

	public Facade getFacade(){
		if(this.facade==null){
			this.facade = new Facade();
			return this.facade;
		}

		return this.facade;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jl_logo = new JLabel();
			jl_logo.setBounds(new Rectangle(1, -5, 559, 304));
			jl_logo.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jl_logo.setIcon(new ImageIcon("D:/workspace ganymede/sigic-v1.1/imagens/logo2.jpg"));
			jl_logo.setText("");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jl_logo, null);
			jContentPane.add(getJp_butons(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jp_butons	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJp_butons() {
		if (jp_butons == null) {
			jl_senha = new JLabel();
			jl_senha.setBounds(new Rectangle(51, 58, 39, 16));
			jl_senha.setText("Senha:");
			jl_user = new JLabel();
			jl_user.setBounds(new Rectangle(51, 21, 47, 16));
			jl_user.setText("Usuário:");
			jp_butons = new JPanel();
			jp_butons.setLayout(null);
			jp_butons.setBounds(new Rectangle(1, 299, 559, 95));
			jp_butons.setBorder(BorderFactory.createLineBorder(new Color(39, 107, 193), 5));
			jp_butons.add(jl_user, null);
			jp_butons.add(jl_senha, null);
			jp_butons.add(getJtf_user(), null);
			jp_butons.add(getJpf_senha(), null);
			jp_butons.add(getJb_confirmar(), null);
			jp_butons.add(getJb_cancelar(), null);
		}
		return jp_butons;
	}

	/**
	 * This method initializes jtf_user	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtf_user() {
		if (jtf_user == null) {
			jtf_user = new JTextField();
			jtf_user.setBounds(new Rectangle(115, 21, 157, 21));
			
		}
		return jtf_user;
	}

	/**
	 * This method initializes jpf_senha	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJpf_senha() {
		if (jpf_senha == null) {
			jpf_senha = new JPasswordField();
			jpf_senha.setBounds(new Rectangle(116, 58, 155, 21));
		}
		return jpf_senha;
	}

	
	
	
	/**
	 * This method initializes jb_confirmar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_confirmar() {
		if (jb_confirmar == null) {
			jb_confirmar = new JButton();
			jb_confirmar.setBounds(new Rectangle(316, 21, 142, 20));
			jb_confirmar.setText("Confirmar");
			jb_confirmar.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e) {
					confirmar();
				}
			});
		}
		return jb_confirmar;
	}

	@SuppressWarnings("deprecation")
	private JFrame confirmar(){

		try {
			String usuario = this.jtf_user.getText();
			String senha = this.jpf_senha.getText();
			Usuario user = this.getFacade().findUsuario(usuario);

			if(user.getSenha().equals(senha)){
				fechar();
				return this.factoryGui(user.getNivel());
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,e.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,e.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
		} catch (UsuarioNoRegisteredException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,e.getMessage(), "Atenção", JOptionPane.PLAIN_MESSAGE);
		}
		return null;
	}
	
	/*factoryMethod para a construção de Gui*/
	private JFrame factoryGui(int nivel){

		if(nivel == 1){
			return new MainUserModify();
		}else{
			return new MainUsersViewer();
		}
	}

	/**
	 * This method initializes jb_cancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_cancelar() {
		if (jb_cancelar == null) {
			jb_cancelar = new JButton();
			jb_cancelar.setBounds(new Rectangle(317, 58, 142, 20));
			jb_cancelar.setText("Cancelar");
			jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					fechar();
				}
			});
		}
		return jb_cancelar;
	}

	private void fechar(){
		this.dispose();
	}

}  //  @jve:decl-index=0:visual-constraint="222,6"


