package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;

import co.edu.unbosque.model.CiclistaDTO;
import co.edu.unbosque.model.persistence.FileHandler;

public class PanelSimulacion extends MainPanel implements ActionListener {
	
	private JPanel pnlDerecha;
	private JPanel pnlInferior;
	private JPanel pnlIzquierda;
	private JButton btnIniciarSimulacion;
	private JLabel lblCiclistas;
	private JTextField jtCiclistas;
	private JLabel lblCiclistaImg;
	private JProgressBar jpSimulacion;
	private Timer timer;
	private final int MAX_VAL = 100;
	private int numCiclistas = 0;
	private int posicionInicial = 200;
	private ArrayList<CiclistaDTO> corredores;
	private PanelAdministrador mainPanel;
	
	public PanelSimulacion(PanelAdministrador panelAdministrador) {
		this.setProperties(
				FileHandler.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/login.properties"));
		mainPanel = panelAdministrador;
		setLayout(null);
		initComponents();
	}

	private void initComponents()
	{
		removeAll();
		jpSimulacion = new JProgressBar();
		corredores = new ArrayList<>();
		removeAll();
		iniciarPanelIzquierdo();
		iniciarPanelInferior();
		iniciarPanelDerecha();
		aplicarFuncionesValidacion();
	}
	
	public void aplicarFuncionesValidacion() {
		numeros(jtCiclistas);
	}
	
	public void iniciarPanelIzquierdo() {
		if (pnlIzquierda != null)
		{
			pnlIzquierda.removeAll();
			numCiclistas = Integer.parseInt(jtCiclistas.getText());
			
			if (corredores.size() > 0) {
				for (int i = 1; i <= numCiclistas; i++) {
					CiclistaDTO cicl = corredores.get(i-1);
					String medalla = i > 3 ? "" : "puesto" + i + ".png";
					pnlIzquierda.add(crearLabelWithName(cicl.getNombre(), cicl.getNombre(), new Rectangle(20, posicionInicial, 250, 35), medalla));
					pnlIzquierda.add(crearLabel(cicl.getNombre(), String.format("%.2f", cicl.getTiempoAcumuladoMin()), 120, posicionInicial));
					posicionInicial+=50;
				}
			} else {
				for (int i = 1; i <= numCiclistas; i++) {
					CiclistaDTO cicl =  new CiclistaDTO(i, 0, 0, "", "","");
					cicl.setNombre("Ciclista " + i);
					corredores.add(cicl);
					pnlIzquierda.add(crearLabel("lblCiclista" + i, cicl.getNombre(), 20, posicionInicial));
					pnlIzquierda.add(crearLabel(cicl.getNombre(), String.format("%.2f", cicl.getTiempoAcumuladoMin()), 120, posicionInicial));
					posicionInicial+=50;
				}
			}
			posicionInicial = 200;

		}
			
		else
			pnlIzquierda = new JPanel();
	
		pnlIzquierda.setBounds(Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlizquierda.alto")));
		pnlIzquierda.setLayout(null);
		pnlIzquierda.setBackground(new Color(205, 161, 98));

		add(pnlIzquierda);			
		
		pnlIzquierda.repaint();
		pnlIzquierda.validate();	
	}
	
	public void iniciarPanelInferior() {
		pnlInferior = new JPanel();
		pnlInferior.setBounds(Integer.parseInt(this.getProperties().getProperty("panelRol.pnlinferior.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlinferior.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlinferior.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlinferior.alto")));
		pnlInferior.setLayout(null);
		
		btnIniciarSimulacion = this.crearBoton("Simular", 290, 0, "");

		pnlInferior.add(btnIniciarSimulacion);
		pnlInferior.setBackground(new Color(245, 227, 187));
		
		add(pnlInferior);
	}
	
	private void iniciarPanelDerecha()
	{
		if (pnlDerecha != null)
			pnlDerecha.removeAll();
		else
			pnlDerecha = new JPanel();
		
		pnlDerecha.setBounds(Integer.parseInt(this.getProperties().getProperty("panelRol.pnlderecha.horizontal")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlderecha.vertical")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlderecha.ancho")),
				Integer.parseInt(this.getProperties().getProperty("panelRol.pnlderecha.alto")));
		pnlDerecha.setLayout(null);
		
		lblCiclistas = this.crearLabel("lblSimulacionCiclistas.titulo", 70, 100);
		jtCiclistas = this.crearTextField("lblSimulacionCiclistas.titulo","", 70, 130);
		pnlDerecha.add(lblCiclistas);
		pnlDerecha.add(jtCiclistas);

		lblCiclistaImg = crearLabel("Gif Ciclista", new Rectangle(225, 320, 250, 30) , "ciclista.gif");
		pnlDerecha.add(lblCiclistaImg);
		
		jpSimulacion = crearProgressBar(new Rectangle(225, 520, 250, 30));
		pnlDerecha.add(jpSimulacion);		
		pnlDerecha.setBackground(new Color(245, 227, 187));

		add(pnlDerecha);
		pnlDerecha.repaint();
		pnlDerecha.validate();
	}
	
	private class UpdateBarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Random random = new Random();
			double tiempo = 0;
			for (CiclistaDTO ciclista : corredores) {
				tiempo = ciclista.getTiempoAcumuladoMin() + random.nextDouble(50);
				ciclista.setTiempoAcumuladoMin(tiempo);
				
				for (Component jt : pnlIzquierda.getComponents()) {
		            if (jt instanceof JLabel) {
		                JLabel text = (JLabel) jt;
		                if (text.getName().equals(ciclista.getNombre()))
		                	text.setText(" " + String.format("%.2f", tiempo));
		            }
		        }
			}
			try {
				Thread.sleep(400);
				
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			int val = jpSimulacion.getValue();
			
			if (val >= MAX_VAL) {
				timer.stop();
				JOptionPane.showMessageDialog(getRootPane(), "Finalizo la carrera.");
				jpSimulacion.setValue(0);
				Collections.sort(corredores, new Comparator<CiclistaDTO>() {
					@Override
					public int compare(CiclistaDTO p1, CiclistaDTO p2) {
						return String.valueOf(p2.getTiempoAcumuladoMin()).compareTo(String.valueOf(p1.getTiempoAcumuladoMin()));
					}
				});
				iniciarPanelIzquierdo();
				return;
			}
			jpSimulacion.setValue(++val);
		}
	}

	private void iniciarCarrera() 
	{
		corredores = new ArrayList<>();
		iniciarPanelIzquierdo();		
		timer = new Timer(50, new UpdateBarListener());
		timer.start();

	}
	
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "simular":
			iniciarCarrera();
			break;
		}
	}
}
