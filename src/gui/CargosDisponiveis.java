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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import mem.exception.InvalidDateException;
import mem.model.cargo.Cargo;
import facade.Facade;

public class CargosDisponiveis extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JComboBox jcb_cargos = null;
	private JLabel cargos = null;
	private JPanel jp_buttons = null;
	private JButton jb_confirmar = null;
	private JButton jb_fechar = null;
	private JPanel cargosOcupados = null;
	private Facade facade;
	
	/**
	 * @param owner
	 */
	public CargosDisponiveis(PanelIntegrantesIgreja cargos, Facade facade) {
		super();
		this.facade = facade;
		initialize();
		this.cargosOcupados = cargos;
	}
	
	public CargosDisponiveis(ProcurarMembro cargos, Facade facade) {
		super();
		this.facade = facade;
		initialize();
		this.cargosOcupados = cargos;
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(460, 161);
		this.setContentPane(getJContentPane());
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			cargos = new JLabel();
			cargos.setBounds(new Rectangle(8, 22, 109, 16));
			cargos.setText("Cargos Disponíveis");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJcb_cargos(), null);
			jContentPane.add(cargos, null);
			jContentPane.add(getJp_buttons(), null);
		}
		return jContentPane;
	}
	
	/**
	 * This method initializes jcb_cargos	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJcb_cargos() {
		if (jcb_cargos == null) {
			LoadComboBoxs comboBoxs = new LoadComboBoxs(this.facade);
			try {
				jcb_cargos = new JComboBox(comboBoxs.preencheComboCargos());
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Exceção", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Exceção", JOptionPane.INFORMATION_MESSAGE);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidDateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			jcb_cargos.setBounds(new Rectangle(125, 23, 266, 17));
		}
		return jcb_cargos;
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
			jp_buttons.setBounds(new Rectangle(146, 63, 283, 47));
			jp_buttons.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jp_buttons.add(getJb_confirmar(), null);
			jp_buttons.add(getJb_fechar(), null);
		}
		return jp_buttons;
	}
	
	/**
	 * This method initializes jb_confirmar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJb_confirmar() {
		if (jb_confirmar == null) {
			jb_confirmar = new JButton();
			jb_confirmar.setBounds(new Rectangle(152, 13, 106, 19));
			jb_confirmar.setText("Adicionar");
			jb_confirmar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					addCargo();
				}
			});
		}
		return jb_confirmar;
	}
	
	private void addCargo(){
		if (cargosOcupados instanceof PanelIntegrantesIgreja) {
			if(!((PanelIntegrantesIgreja)this.cargosOcupados).getCargos().contains((Cargo)jcb_cargos.getSelectedItem())){
				((PanelIntegrantesIgreja)this.cargosOcupados).getCargos().add((Cargo)jcb_cargos.getSelectedItem());
				
			}else{
				JOptionPane.showMessageDialog(this, null);
			}	
		}else if(cargosOcupados instanceof ProcurarMembro){
			if(!((ProcurarMembro)this.cargosOcupados).getCargos().contains((Cargo)jcb_cargos.getSelectedItem())){
				((ProcurarMembro)this.cargosOcupados).getCargos().add((Cargo)jcb_cargos.getSelectedItem());
				((ProcurarMembro)this.cargosOcupados).updateJlistCargos();
			}else{
				JOptionPane.showMessageDialog(this, null);
			}	
		}
		
	}


/**
 * This method initializes jb_fechar	
 * 	
 * @return javax.swing.JButton	
 */
private JButton getJb_fechar() {
	if (jb_fechar == null) {
		jb_fechar = new JButton();
		jb_fechar.setBounds(new Rectangle(23, 13, 106, 19));
		jb_fechar.setText("Fechar");
		jb_fechar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				fechar();
			}
		});
	}
	return jb_fechar;
}

private void fechar(){
	
	this.dispose();
}

}  //  @jve:decl-index=0:visual-constraint="10,10"
