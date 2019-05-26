package chrysler.fingrado.proyecto;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import chrysler.fingrado.proyecto.bases.Pedido;
import chrysler.fingrado.proyecto.bases.Plato;
import chrysler.fingrado.proyecto.importante.Modelo;

public class PanelPedido extends JPanel implements ActionListener,ListSelectionListener {
	Pedido pedido;
	JLabel nPedido;
	Modelo modelo;
	Vista vista;
	JButton btnHecho;
	JList list;
	JList list_1 ;
	JCheckBox chckbxPreparado;
	public int count=0;
	DefaultListModel<Plato>platos;
	DefaultListModel<String>strings;
	public PanelPedido(Pedido pedido,Modelo modelo,Vista vista) {
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 344, 153);
		add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		nPedido = new JLabel("");
		nPedido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nPedido.setBounds(390, 15, 48, 46);
		add(nPedido);
		
		JLabel lblNumeroPedido = new JLabel("Numero Pedido");
		lblNumeroPedido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumeroPedido.setBounds(259, 20, 214, 35);
		add(lblNumeroPedido);
		
		
		chckbxPreparado = new JCheckBox("Preparado");
		chckbxPreparado.setFont(new Font("Tahoma", Font.PLAIN, 17));
		chckbxPreparado.setBounds(10, 261, 114, 35);
		add(chckbxPreparado);
		btnHecho= new JButton("Hecho");
		btnHecho.setBounds(304, 337, 155, 46);
		add(btnHecho);
		this.pedido=pedido;
		nPedido.setText(""+pedido.getId());
		platos =new DefaultListModel();
		list.setModel(platos);
		this.modelo = modelo;
		this.vista= vista;
		int i=0;
		for(Plato plato: pedido.getPlatos()) {
				platos.addElement(plato);
		}
		btnHecho.addActionListener(this);
		btnHecho.setActionCommand("Hecho");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(419, 87, 252, 162);
		add(scrollPane_1);
		
		list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		strings = new DefaultListModel();
		list_1.setModel(strings);
		JLabel lblDescripcion = new JLabel("Ingredientes");
		lblDescripcion.setBounds(495, 49, 155, 28);
		add(lblDescripcion);
		list.addListSelectionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Hecho")
		{
		if(chckbxPreparado.isSelected()) {
			pedido.setPreparado(true);
			modelo.pedidoPreparado(pedido);
			}
			vista.tabbedPane.remove(this);
		}
	}
	public void valueChanged(ListSelectionEvent arg0) {
		if(count==0) {
			if(list.getSelectedIndex()==-1)
				return;
			strings.clear();
			Plato plat =(Plato)list.getSelectedValue();
			String[]var = plat.getDescripcion().split(",");
			for(String ingrediente : var)
			strings.addElement(ingrediente);
			count++;
		}
		
		else
			count=0;
		}
	}

