package br.ufsc.cco.telas;

import br.ufsc.cco.controle.ControladorPrincipal;
import br.ufsc.cco.objects.Situacao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JLabel lTitulo;
	private final JLabel lMonitoramento;

	private final JLabel lGoogle;
	private final JLabel lBB;
	private final JLabel lSAN;
	private final JLabel lPetr;
	private final JLabel lVale;

	private final JLabel lClose;
	private final JLabel lSMA;
	private final JLabel lSit;

	private final JLabel lCloseGoogle;
	private final JLabel lCloseBB;
	private final JLabel lCloseSAN;
	private final JLabel lClosePetr;
	private final JLabel lCloseVale;

	private final JLabel lSMAGoogle;
	private final JLabel lSMABB;
	private final JLabel lSMASAN;
	private final JLabel lSMAPetr;
	private final JLabel lSMAVale;

	private final JLabel lSitGoogle;
	private final JLabel lSitBB;
	private final JLabel lSitSAN;
	private final JLabel lSitPetr;
	private final JLabel lSitVale;

	private final JButton jbMonitorar;

	public TelaPrincipal() {
		super("Mini Bloomberg™");
		setLayout(null);
		setBackground(Color.BLACK);
		setSize(620, 320);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		lTitulo = new JLabel("Mini Bloomberg™");
		lMonitoramento = new JLabel("Monitoramento desligado");

		lGoogle = new JLabel("Google:");
		lBB = new JLabel("Banco do Brasil:");
		lSAN = new JLabel("Santander:");
		lPetr = new JLabel("Petrobras:");
		lVale = new JLabel("Vale:");

		lClose = new JLabel("Fechamento:");
		lSMA = new JLabel("SMA:");
		lSit = new JLabel("Situação:");

		lCloseGoogle = new JLabel("USD 0000,00");
		lCloseBB = new JLabel("BRL 0000,00");
		lCloseSAN = new JLabel("BRL 0000,00");
		lClosePetr = new JLabel("BRL 0000,00");
		lCloseVale = new JLabel("BRL 0000,00");

		lSMAGoogle = new JLabel("USD 0000,00");
		lSMABB = new JLabel("BRL 0000,00");
		lSMASAN = new JLabel("BRL 0000,00");
		lSMAPetr = new JLabel("BRL 0000,00");
		lSMAVale = new JLabel("BRL 0000,00");

		lSitGoogle = new JLabel(Situacao.AGUARDANDO.mensagem);
		lSitBB = new JLabel(Situacao.AGUARDANDO.mensagem);
		lSitSAN = new JLabel(Situacao.AGUARDANDO.mensagem);
		lSitPetr = new JLabel(Situacao.AGUARDANDO.mensagem);
		lSitVale = new JLabel(Situacao.AGUARDANDO.mensagem);

		jbMonitorar = new JButton("Monitorar / Pausar");

		add(lTitulo);
		add(lMonitoramento);

		add(lGoogle);
		add(lBB);
		add(lSAN);
		add(lPetr);
		add(lVale);

		add(lCloseGoogle);
		add(lCloseBB);
		add(lCloseSAN);
		add(lClosePetr);
		add(lCloseVale);

		add(lSMAGoogle);
		add(lSMABB);
		add(lSMASAN);
		add(lSMAPetr);
		add(lSMAVale);

		add(lSitGoogle);
		add(lSitBB);
		add(lSitSAN);
		add(lSitPetr);
		add(lSitVale);

		add(lClose);
		add(lSMA);
		add(lSit);

		add(jbMonitorar);

		lTitulo.setForeground(Color.ORANGE);
		lTitulo.setFont(new Font(null, Font.PLAIN, 20));

		lMonitoramento.setForeground(Color.ORANGE);
		lMonitoramento.setFont(new Font(null, Font.PLAIN, 15));

		lGoogle.setForeground(Color.ORANGE);
		lBB.setForeground(Color.ORANGE);
		lSAN.setForeground(Color.ORANGE);
		lPetr.setForeground(Color.ORANGE);
		lVale.setForeground(Color.ORANGE);

		lClose.setForeground(Color.ORANGE);
		lSMA.setForeground(Color.ORANGE);
		lSit.setForeground(Color.ORANGE);

		lSMAGoogle.setForeground(Color.LIGHT_GRAY);
		lSMABB.setForeground(Color.LIGHT_GRAY);
		lSMAPetr.setForeground(Color.LIGHT_GRAY);
		lSMASAN.setForeground(Color.LIGHT_GRAY);
		lSMAVale.setForeground(Color.LIGHT_GRAY);

		lSitGoogle.setForeground(Color.LIGHT_GRAY);
		lSitBB.setForeground(Color.LIGHT_GRAY);
		lSitSAN.setForeground(Color.LIGHT_GRAY);
		lSitPetr.setForeground(Color.LIGHT_GRAY);
		lSitVale.setForeground(Color.LIGHT_GRAY);

		jbMonitorar.addActionListener(this);

		Insets insets = getInsets();
		// Ativos
		Dimension size = lTitulo.getPreferredSize();
		lTitulo.setBounds(insets.left + 230, insets.top + 15, size.width,
				size.height);

		size = lGoogle.getPreferredSize();
		lGoogle.setBounds(insets.left + 50, insets.top + 75, size.width,
				size.height);

		size = lBB.getPreferredSize();
		lBB.setBounds(insets.left + 50, insets.top + 100, size.width,
				size.height);

		size = lSAN.getPreferredSize();
		lSAN.setBounds(insets.left + 50, insets.top + 125, size.width,
				size.height);

		size = lPetr.getPreferredSize();
		lPetr.setBounds(insets.left + 50, insets.top + 150, size.width,
				size.height);

		size = lVale.getPreferredSize();
		lVale.setBounds(insets.left + 50, insets.top + 175, size.width,
				size.height);

		// Close
		size = lClose.getPreferredSize();
		lClose.setBounds(insets.left + 200, insets.top + 50, size.width,
				size.height);

		// SMA
		size = lSMA.getPreferredSize();
		lSMA.setBounds(insets.left + 350, insets.top + 50, size.width,
				size.height);

		// Situação
		size = lSit.getPreferredSize();
		lSit.setBounds(insets.left + 500, insets.top + 50, size.width,
				size.height);

		// Close de Ativos
		size = lCloseGoogle.getPreferredSize();
		lCloseGoogle.setBounds(insets.left + 200, insets.top + 75, size.width,
				size.height);

		size = lCloseBB.getPreferredSize();
		lCloseBB.setBounds(insets.left + 200, insets.top + 100, size.width,
				size.height);

		size = lCloseSAN.getPreferredSize();
		lCloseSAN.setBounds(insets.left + 200, insets.top + 125, size.width,
				size.height);

		size = lClosePetr.getPreferredSize();
		lClosePetr.setBounds(insets.left + 200, insets.top + 150, size.width,
				size.height);

		size = lCloseVale.getPreferredSize();
		lCloseVale.setBounds(insets.left + 200, insets.top + 175, size.width,
				size.height);

		// SMA de Ativos
		size = lSMAGoogle.getPreferredSize();
		lSMAGoogle.setBounds(insets.left + 350, insets.top + 75, size.width,
				size.height);

		size = lSMABB.getPreferredSize();
		lSMABB.setBounds(insets.left + 350, insets.top + 100, size.width,
				size.height);

		size = lSMASAN.getPreferredSize();
		lSMASAN.setBounds(insets.left + 350, insets.top + 125, size.width,
				size.height);

		size = lSMAPetr.getPreferredSize();
		lSMAPetr.setBounds(insets.left + 350, insets.top + 150, size.width,
				size.height);

		size = lSMAVale.getPreferredSize();
		lSMAVale.setBounds(insets.left + 350, insets.top + 175, size.width,
				size.height);

		// Situacão de Ativos
		size = lSitGoogle.getPreferredSize();
		lSitGoogle.setBounds(insets.left + 500, insets.top + 75, size.width + 20,
				size.height);

		size = lSitBB.getPreferredSize();
		lSitBB.setBounds(insets.left + 500, insets.top + 100, size.width + 20,
				size.height);

		size = lSitSAN.getPreferredSize();
		lSitSAN.setBounds(insets.left + 500, insets.top + 125, size.width + 20,
				size.height);

		size = lSitPetr.getPreferredSize();
		lSitPetr.setBounds(insets.left + 500, insets.top + 150, size.width + 20,
				size.height);

		size = lSitVale.getPreferredSize();
		lSitVale.setBounds(insets.left + 500, insets.top + 175, size.width + 20,
				size.height);

		size = lMonitoramento.getPreferredSize();
		lMonitoramento.setBounds(insets.left + 50, insets.top + 240,
				size.width + 100, size.height);

		// Botão
		size = jbMonitorar.getPreferredSize();
		jbMonitorar.setBounds(insets.left + 430, insets.top + 225, size.width,
				size.height + 30);

	}

	public JLabel getLMonitoramento() {
		return lMonitoramento;
	}

	public JLabel getlCloseGoogle() {
		return lCloseGoogle;
	}

	public JLabel getlCloseBB() {
		return lCloseBB;
	}

	public JLabel getlCloseSAN() {
		return lCloseSAN;
	}

	public JLabel getlClosePetr() {
		return lClosePetr;
	}

	public JLabel getlCloseVale() {
		return lCloseVale;
	}

	public JLabel getlSMAGoogle() {
		return lSMAGoogle;
	}

	public JLabel getlSMABB() {
		return lSMABB;
	}

	public JLabel getlSMASAN() {
		return lSMASAN;
	}

	public JLabel getlSMAPetr() {
		return lSMAPetr;
	}

	public JLabel getlSMAVale() {
		return lSMAVale;
	}

	public JLabel getlSitGoogle() {
		return lSitGoogle;
	}

	public JLabel getlSitBB() {
		return lSitBB;
	}

	public JLabel getlSitSAN() {
		return lSitSAN;
	}

	public JLabel getlSitPetr() {
		return lSitPetr;
	}

	public JLabel getlSitVale() {
		return lSitVale;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbMonitorar) {
			ControladorPrincipal.getInstance().monitorar();
		}
	}

}
