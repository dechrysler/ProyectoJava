package chrysler.fingrado.proyecto;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import chrysler.fingrado.proyecto.bases.Pedido;
import chrysler.fingrado.proyecto.importante.Modelo;

public class Controlador implements ChangeListener{
	PanelPrincipal panel;
	Vista vista;
	Modelo modelo;
	
	public Controlador(Vista vista,Modelo modelo) {
		this.vista=vista;
		this.modelo =  modelo;
		anadirPestaniaPrincipal();
		vista.tabbedPane.addChangeListener(this);
		
		    
	}
	public void anadirPestaniaPrincipal() {	
		 panel= new PanelPrincipal(vista,modelo);
		 refrescarLista();
		vista.tabbedPane.addTab("Principal", panel);
		 Timer timer;
		    timer = new Timer();

		    TimerTask task = new TimerTask() {
		        int tic=0;

		        @Override
		        public void run()
		        {
		        refrescarLista();
		        }
		        };
		        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
		    timer.schedule(task,60000 , 30000);
		 
	}
	public void stateChanged(ChangeEvent e) {
			refrescarLista();
	
	}
	public void refrescarLista() {
		panel.listaPedidos.clear();
		for (Pedido pedi : modelo.getPedidosAPreparar()) 
			panel.listaPedidos.addElement(pedi);
		
	}
}
