/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PantallaPrincipal;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import puntoA.Mixto;
import puntoA.Multiplicativo;
import puntoB.PuntoB;
import puntoC.PuntoC;

/**
 *
 * @author Cristian Rojas
 */
public class Menu extends JFrame implements ActionListener{
    JMenuBar menubar1;
    JMenu punto1;
    JMenuItem mixto,multiplicativo,salir,punto2,punto3,acerca;
    JLabel texto;
    Container contenpane;
    JPanel panelPrincipal;
    
    public Menu() {
        super("Simulacion TP1 - Grupo G");
        setBounds(100, 100 , 600, 500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        menubar1 = new JMenuBar();
        
        /* PUNTO 1 */
        punto1 = new JMenu("Punto1 ↓");
        punto1.setPreferredSize(new Dimension(150, 30));
        punto1.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        
        /* PUNTO 2 */
        punto2 = new JMenuItem("Punto2");
        punto2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        
        /* PUNTO 3 */
        punto3 =  new JMenuItem("Punto3");
        punto3.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        
        /* TITULOS MENU PUNTO 1 */
        mixto =  new JMenuItem("Metodo congruencial mixto");
        multiplicativo = new JMenuItem("Metodo congruencial multiplicativo");
        
        /* BOTON SALIR */
        salir = new JMenuItem("Salir");
        salir.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        salir.setActionCommand("clickSalir");
        salir.addActionListener(this);
        
        /* ACCIONES PUNTOS */
        mixto.setActionCommand("clickMixto");
        mixto.addActionListener(this);
        multiplicativo.setActionCommand("clickMultiplicativo");
        multiplicativo.addActionListener(this);
        punto2.setActionCommand("clickPunto2");
        punto2.addActionListener(this);
        punto3.setActionCommand("clickPunto3");
        punto3.addActionListener(this);
        
        /* AGREGAR BOTONES A BARRA DE MENUS */
        punto1.add(mixto);
        punto1.add(multiplicativo);
        menubar1.add(punto1);
        menubar1.add(punto2);
        menubar1.add(punto3);
        menubar1.add(salir);
        this.setJMenuBar(menubar1);
        texto = new JLabel("<html><body><br>Haga click en el punto que desea ejecutar"
                + "<br><br>"
                + "Integrantes: <br>"
                + "<br>&nbsp;&nbsp;&nbsp;&nbsp;> Bordon, Maria Eliana - Legajo: 71336 <br>"
                + "<br>&nbsp;&nbsp;&nbsp;&nbsp;> Rojas Orosco, Cristian Jesus - Legajo: 72723 <br></body></html>");
        panelPrincipal= new JPanel();
        
        contenpane= getContentPane();
	panelPrincipal.setBackground(Color.LIGHT_GRAY);
        contenpane.add(panelPrincipal);
        panelPrincipal.add(texto);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent evt){
                if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del Sistema?","ADVERTENCIA",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {                   
                System.exit(0);
            }               
        }});
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (null!=evento.getActionCommand())switch (evento.getActionCommand()) {
            case "clickSalir":{
                if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del Sistema?","ADVERTENCIA",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
                    System.exit(0);
                }   
                break;
            }
            case "clickMixto":{
                panelPrincipal.removeAll();
                Mixto a = new Mixto();
                a.setVisible(true);
                this.setVisible(false);
                break;
            }
            case "clickMultiplicativo":{
                Multiplicativo a = new Multiplicativo();
                a.setVisible(true);
                this.setVisible(false);
                break;
            }
            case "clickPunto2":{
                PuntoB b = new PuntoB();
                b.setVisible(true);
                this.setVisible(false);
                break;
            }
            case "clickPunto3":{
                PuntoC c = new PuntoC();
                c.setVisible(true);
                this.setVisible(false);
                break;
            }
            default:
                break;
        }
    }
}
