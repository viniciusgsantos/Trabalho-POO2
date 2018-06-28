package br.ufsc.cco.telas;

import java.awt.Dimension;
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
	
	private JLabel lGoogle;
	private JLabel lBB;
	private JLabel lSAN;
	private JLabel lPetr;
	private JLabel lVale;
	
	private JLabel lClose;
	private JLabel lSMA;
	private JLabel lSit;
	
	private JLabel lCloseGoogle;
	private JLabel lCloseBB;
	private JLabel lCloseSAN;
	private JLabel lClosePetr;
	private JLabel lCloseVale;
	
	private JLabel lSMAGoogle;
	private JLabel lSMABB;
	private JLabel lSMASAN;
	private JLabel lSMAPetr;
	private JLabel lSMAVale;
	
	private JLabel lSitGoogle;
	private JLabel lSitBB;
	private JLabel lSitSAN;
	private JLabel lSitPetr;
	private JLabel lSitVale;
	
	private JButton jbMonitorar;
	
	public TelaPrincipal(String titulo) {
		super(titulo);
		setLayout(null);
		setSize(620, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lGoogle = new JLabel("Google:");
		lBB = new JLabel("BB:");
		lSAN = new JLabel("Santander:");
		lPetr = new JLabel("Petrobras:");
		lVale = new JLabel("Vale:");
	
		lClose = new JLabel("close:");
		lSMA = new JLabel("SMA:");
		lSit = new JLabel("Situação:");
		
		lCloseGoogle = new JLabel();
		lCloseBB = new JLabel();
		lCloseSAN = new JLabel();
		lClosePetr = new JLabel();
		lCloseVale = new JLabel();
		
		lSMAGoogle = new JLabel();
		lSMABB = new JLabel();
		lSMASAN = new JLabel();
		lSMAPetr = new JLabel();
		lSMAVale = new JLabel();
		
		lSitGoogle = new JLabel();
		lSitBB = new JLabel();
		lSitSAN = new JLabel();
		lSitPetr = new JLabel();
		lSitVale = new JLabel();
		
		jbMonitorar = new JButton("Monitorar/Pausar");
		
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
		
		jbMonitorar.addActionListener(this);
		
		Insets insets = getInsets();
		//Ativos
		Dimension size = lGoogle.getPreferredSize();
		lGoogle.setBounds(insets.left + 50, insets.top + 75, size.width, size.height);
		
		size = lBB.getPreferredSize();
		lBB.setBounds(insets.left + 50, insets.top + 100, size.width, size.height);
		
		size = lSAN.getPreferredSize();
		lSAN.setBounds(insets.left + 50, insets.top + 125, size.width, size.height);
		
		size = lPetr.getPreferredSize();
		lPetr.setBounds(insets.left + 50, insets.top + 150, size.width, size.height);
		
		size = lVale.getPreferredSize();
		lVale.setBounds(insets.left + 50, insets.top + 175, size.width, size.height);
		
		//Close
		size = lClose.getPreferredSize();
		lClose.setBounds(insets.left + 200, insets.top + 50, size.width, size.height);
		
		//SMA
		size = lSMA.getPreferredSize();
		lSMA.setBounds(insets.left + 350, insets.top + 50, size.width, size.height);
		
		//Situação
		size = lSit.getPreferredSize();
		lSit.setBounds(insets.left + 500, insets.top + 50, size.width, size.height);
		
		//Close de Ativos
		size = lCloseGoogle.getPreferredSize();
		lCloseGoogle.setBounds(insets.left + 200, insets.top + 75, size.width, size.height);
		
		size = lCloseBB.getPreferredSize();
		lCloseBB.setBounds(insets.left + 200, insets.top + 100, size.width, size.height);
		
		size = lCloseSAN.getPreferredSize();
		lCloseSAN.setBounds(insets.left + 200, insets.top + 125, size.width, size.height);
		
		size = lClosePetr.getPreferredSize();
		lClosePetr.setBounds(insets.left + 200, insets.top + 150, size.width, size.height);
		
		size = lCloseVale.getPreferredSize();
		lCloseVale.setBounds(insets.left + 200, insets.top + 175, size.width, size.height);
		
		//SMA de Ativos
		size = lSMAGoogle.getPreferredSize();
		lSMAGoogle.setBounds(insets.left + 350, insets.top + 75, size.width, size.height);
		
		size = lSMABB.getPreferredSize();
		lSMABB.setBounds(insets.left + 350, insets.top + 100, size.width, size.height);
		
		size = lSMASAN.getPreferredSize();
		lSMASAN.setBounds(insets.left + 350, insets.top + 125, size.width, size.height);
		
		size = lSMAPetr.getPreferredSize();
		lSMAPetr.setBounds(insets.left + 350, insets.top + 150, size.width, size.height);
		
		size = lSMAVale.getPreferredSize();
		lSMAVale.setBounds(insets.left + 350, insets.top + 175, size.width, size.height);
		
		//Situacão de Ativos
		size = lSitGoogle.getPreferredSize();
		lSitGoogle.setBounds(insets.left + 500, insets.top + 75, size.width, size.height);
		
		size = lSitBB.getPreferredSize();
		lSitBB.setBounds(insets.left + 500, insets.top + 100, size.width, size.height);
		
		size = lSitSAN.getPreferredSize();
		lSitSAN.setBounds(insets.left + 500, insets.top + 125, size.width, size.height);
		
		size = lSitPetr.getPreferredSize();
		lSitPetr.setBounds(insets.left + 500, insets.top + 150, size.width, size.height);
		
		size = lSitVale.getPreferredSize();
		lSitVale.setBounds(insets.left + 500, insets.top + 175, size.width, size.height);
		
		//Botão
		size = jbMonitorar.getPreferredSize();
		jbMonitorar.setBounds(insets.left + 225, insets.top + 225, size.width, size.height + 30);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbMonitorar) {
			System.out.println("teste");
		}
		
	}
	
}
