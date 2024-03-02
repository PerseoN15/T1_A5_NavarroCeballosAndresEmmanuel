import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import static java.awt.Font.PLAIN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Temperaturas extends JFrame{
	GridBagConstraints gbc= new GridBagConstraints();
	GridBagLayout gbl= new GridBagLayout();
	JLabel a,txtResultado,Convertir;
	JTextArea txtGrados;
	JComboBox<String> combTemp,combTemp2;
	String temps[] = {"C", "F", "K", "R"};
	 String g,g2;
	public Temperaturas() {
		getContentPane().setLayout(gbl); 
        setTitle("Conversoor temperaturas"); 
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       
		JLabel1(Convertir,"convetir: ",0,0,1,1);
		txtGrados = new JTextArea("0.0");
		localizacion(txtGrados,1,0,1,1);
       add(txtGrados); //A�ado el JLabel al JFrame
       
        combTemp =new JComboBox<>();
		combTemp.addItem("selesciona una opc.");
		combTemp.addItem("C");
		combTemp.addItem("F");
		combTemp.addItem("K");
		combTemp.addItem("R");
		localizacion(combTemp,2,0,1,1);
		add(combTemp); //A�ado el JLabel al JFrame

		
		JLabel1(a,"A: ",0,2,1,1);
		combTemp2 =new JComboBox<>();
		combTemp2.addItem("selesciona una opc.");
		combTemp2.addItem("C");
		combTemp2.addItem("F");
		combTemp2.addItem("K");
		combTemp2.addItem("R");
		localizacion(combTemp2,1,2,1,1);
        add(combTemp2); 
        
        txtResultado = new JLabel("= "); 
		txtResultado.setHorizontalAlignment(SwingConstants.RIGHT); 
		localizacion(txtResultado,2,2,1,1);
       add(txtResultado);
		eventoOperacion();
		
		setVisible(true);
	}//constructor
	
	public void localizacion(Component c,int x, int y, int w, int h) {
		gbc.gridx=x;
		gbc.gridy=y;
		gbc.gridwidth=w;
		gbc.gridheight=h;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbl.setConstraints(c, gbc);
	}
	public void JLabel1(JLabel c,String txt,int x, int y, int w, int h) {
		c = new JLabel(txt); 
		c.setHorizontalAlignment(SwingConstants.RIGHT); 
		localizacion(c,x,y,w,h);
        add(c); 
	}
	
	
	 public void eventoOperacion(){
		
		 combTemp.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					g=combTemp.getSelectedItem().toString();
					try {
						llamadas(g,g2);
					} catch (Exception e2) {
						System.out.println("c");
					}
				}
			});
		 combTemp2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					g2=combTemp2.getSelectedItem().toString();
					try {
						llamadas(g,g2);
					} catch (Exception e2) {
						System.out.println("Solo numeros");
					}
					
				}
			});
	    }
	 public void llamadas(String g,String g2) {
		 if(g=="C") {
			 if(g2=="C") {
					txtResultado.setText(txtGrados.getText());
				}
			if(g2=="F") {
				txtResultado.setText(""+ConvertirTemp.convTemCAF(txtGrados.getText() ));
			}
			if(g2=="K") {
				txtResultado.setText(""+ConvertirTemp.convTemCAK(txtGrados.getText() ));
			}
			if(g2=="R") {
				txtResultado.setText(""+ConvertirTemp.convTemCAR(txtGrados.getText() ));
			}
		 }
		 if(g=="F") {
			 if(g2=="C") {
				 	txtResultado.setText(""+ConvertirTemp.convTemFAC(txtGrados.getText() ));
				}
				if(g2=="F") {
					txtResultado.setText(txtGrados.getText());
				}
				if(g2=="K") {
					txtResultado.setText(""+ConvertirTemp.convTemFAK(txtGrados.getText() ));
				}
				if(g2=="R") {
					txtResultado.setText(""+ConvertirTemp.convTemFAR(txtGrados.getText() ));
				}
			 }
		 if(g=="K") {
			 if(g2=="C") {
					txtResultado.setText(""+ConvertirTemp.convTemKAC(txtGrados.getText() ));
				}
				if(g2=="F") {
					txtResultado.setText(""+ConvertirTemp.convTemKAF(txtGrados.getText() ));
				}
				if(g2=="K") {
					txtResultado.setText(txtGrados.getText());
				}
				if(g2=="R") {
					txtResultado.setText(""+ConvertirTemp.convTemKAR(txtGrados.getText() ));
				}
			 }
		 if(g=="R") {
			 if(g2=="C") {
				 txtResultado.setText(""+ConvertirTemp.convTemRAC(txtGrados.getText() ));
				}
				if(g2=="F") {
					txtResultado.setText(""+ConvertirTemp.convTemRAF(txtGrados.getText() ));
				}
				if(g2=="K") {
					txtResultado.setText(""+ConvertirTemp.convTemRAK(txtGrados.getText() ));
				}
				if(g2=="R") {
					txtResultado.setText(txtGrados.getText());
				}
			 }
	 }
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Temperaturas();
			}
		});

	}

}
