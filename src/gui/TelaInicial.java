package gui;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaInicial extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jl_logo = null;

	/**
	 * This is the default constructor
	 */
	public TelaInicial() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        jl_logo = new JLabel();
        jl_logo.setBounds(new java.awt.Rectangle(174,13,688,598));
        jl_logo.setIcon(new ImageIcon("D:/Projeto SIGIC/sigicslm/imagens/logo.jpg"));
        jl_logo.setBackground(new java.awt.Color(225,230,232));
        jl_logo.setText("");
        this.setLayout(null);
        this.setBounds(new java.awt.Rectangle(0,0,1023,703));
        this.setBackground(new java.awt.Color(215,237,246));
        this.add(jl_logo, null);
	}

}
