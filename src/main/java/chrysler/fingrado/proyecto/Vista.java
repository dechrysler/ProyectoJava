package chrysler.fingrado.proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class Vista extends JFrame {

	private JPanel contentPane;
	JTabbedPane tabbedPane ;
	
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 518);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 46, 811, 420);
		contentPane.add(tabbedPane);
		
		JLabel lblListadoDePedidos = new JLabel("Listado de pedidos");
		lblListadoDePedidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblListadoDePedidos.setBackground(Color.GRAY);
		lblListadoDePedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDePedidos.setBounds(305, 0, 215, 25);
		contentPane.add(lblListadoDePedidos);
	
		this.setVisible(true);
		this.setResizable(false);
	}
}
