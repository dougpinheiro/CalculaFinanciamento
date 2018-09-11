package dougpinheiro;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Calculadora extends JFrame implements MouseListener{

	private double valor_financiado;
	private double juros;
	private double parcela;
	private double meses;
	private JTextField tf_valor_financiado;
	private JTextField tf_juros;
	private JTextField tf_parcela;
	private JTextField tf_meses;
	private JButton btnCalcula;
	
	public Calculadora() {
		super();
		this.setAlwaysOnTop(true);
		this.setTitle("Calculadora");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationByPlatform(true);
		this.setLayout(new GridLayout(5,2));
	}
	
	
	public void initUI(){
		this.add(new JLabel("Valor Financiado"));
		this.tf_valor_financiado = new JTextField();
		this.add(this.tf_valor_financiado);		
		this.add(new JLabel("Juros (% a.m) Ex.: 1,13"));
		this.tf_juros = new JTextField();
		this.add(this.tf_juros);
		
		this.add(new JLabel("Meses"));
		this.tf_meses = new JTextField();
		this.add(this.tf_meses);
		
		this.add(new JLabel("Parcela"));
		this.tf_parcela = new JTextField();
		this.tf_parcela.setEditable(false);
		this.tf_parcela.setForeground(Color.red);
		
		this.add(this.tf_parcela);
		
		this.btnCalcula = new JButton("Calcular");
		this.btnCalcula.addMouseListener(this);
		this.add(this.btnCalcula);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	public void calcula(String valor,String juros, String meses){
		if(valor.equalsIgnoreCase("") || juros.equalsIgnoreCase("") || meses.equalsIgnoreCase("")){
			JOptionPane.showMessageDialog(this, "Você precisa informar os valores corretamente!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
		}else{
			valor = valor.replace(",", ".");
			this.valor_financiado = Double.valueOf(valor);
			juros = juros.replace(",", ".");
			this.juros = Double.valueOf(juros);
			this.meses = Double.valueOf(meses);
			DecimalFormat df = new DecimalFormat("0.00");
			
			this.parcela = this.valor_financiado/((Math.pow((this.juros/100)+1, this.meses)-1)/(Math.pow((this.juros/100)+1, this.meses)*(this.juros/100)));
			this.tf_parcela.setText("R$ "+df.format(this.parcela));
		}
		
	}
	
	public static void main(String[] args) {
		Calculadora calc = new Calculadora();
		calc.initUI();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		this.calcula(this.tf_valor_financiado.getText(), this.tf_juros.getText(), this.tf_meses.getText());
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
