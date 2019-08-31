package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class JogoForcaGui extends JPanel {
	private JTextField tfLetra;

	/**
	 * Create the panel.
	 */
	public JogoForcaGui() {
		setLayout(null);
		
		JLabel lblJogoFaForca = new JLabel("JOGO DA FORCA");
		lblJogoFaForca.setBounds(169, 12, 115, 15);
		add(lblJogoFaForca);
		
		JLabel lblTentativasRestantes = new JLabel("Boneco:");
		lblTentativasRestantes.setBounds(12, 39, 66, 15);
		add(lblTentativasRestantes);
		
		JLabel lblBocecoTexto = new JLabel();
		lblBocecoTexto.setVerticalAlignment(SwingConstants.TOP);
		lblBocecoTexto.setBounds(76, 39, 374, 57);
		add(lblBocecoTexto);
		
		JLabel lblPalavra1 = new JLabel();
		lblPalavra1.setBounds(169, 108, 115, 15);
		add(lblPalavra1);
		
		JLabel lblPalavra2 = new JLabel();
		lblPalavra2.setBounds(169, 129, 95, 15);
		add(lblPalavra2);
		
		JLabel lblPalavra3 = new JLabel();
		lblPalavra3.setBounds(169, 156, 95, 15);
		add(lblPalavra3);
		
		tfLetra = new JTextField();
		tfLetra.setBounds(130, 206, 34, 19);
		add(tfLetra);
		tfLetra.setColumns(10);
		
		JButton btnTentarLetra = new JButton("Tentar letra");
		btnTentarLetra.setBounds(169, 203, 148, 25);
		add(btnTentarLetra);

	}
}
