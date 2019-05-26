package chrysler.fingrado.proyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import chrysler.fingrado.proyecto.bases.Pedido;
import chrysler.fingrado.proyecto.importante.Modelo;

public class PanelPrincipal extends JPanel implements ListSelectionListener {
	Vista vista;
	int count=0;
	Modelo modelo;
	public DefaultListModel<Pedido> listaPedidos;
	JList list;
	public PanelPrincipal(Vista vista,Modelo modelo) {
		
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 739, 226);
		add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		listaPedidos = new DefaultListModel<Pedido>();
		list.setModel(listaPedidos);
		JLabel lblPedidosPorHacer = new JLabel("Pedidos Por Hacer:");
		lblPedidosPorHacer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPedidosPorHacer.setForeground(new Color(0, 0, 0));
		lblPedidosPorHacer.setBounds(10, 38, 229, 46);
		add(lblPedidosPorHacer);
		this.vista=vista;
		list.addListSelectionListener(this);
		this.modelo=modelo;
	}
	public void valueChanged(ListSelectionEvent arg0) {
		if(count==0) {
		if(list.getSelectedIndex()==-1)
			return;
		Pedido ped = (Pedido) list.getSelectedValue();
		PanelPedido panel = null;
		panel = new PanelPedido(ped,modelo,vista);
		vista.tabbedPane.addTab("Pedido:"+ped.getId(), panel);
		count++;
	}
	
	else
		count=0;
	}
	}
