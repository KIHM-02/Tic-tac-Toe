package tic_tac_toe;

//Este es el diseño del tablero del programa

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public final class Tablero extends JFrame
{
    
    private boolean juego;
    public TableroFuncion funcion;                                              //Instancia a la clase de tableroFuncion
    public Turnos turnos;
    private int ganador;                                                        //determina el ganador de la partida
    
    public Tablero()
    {
              
        this.setTitle("Tic Tac Toe");
        this.setSize(465, 500);                                                 //Este es el tamaño de la ventana en pixeles, siempre debe ir en el constructor porque si no, no aparece ventana visible
        this.setLocationRelativeTo(null);                                       //este linea sirve para poder posicionar las ventanas al centro de la pantalla, pero despues la vamos a sustituir por la que debe ser
        this.setVisible(true);
        this.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        initComponents();
        colocarObjetosPanel();
        colocarObjetosPanelBase();
        
        juego = false;
        funcion = new TableroFuncion();
        turnos = new Turnos();
        ganador = 0;                                                            
        deshabilitarBotones();
    }
    
    public void initComponents()
    {
        panel = new javax.swing.JPanel();                                       //Es necesario instanciar la clase para evitar un null pointer exception en el programa    
        panelBase = new javax.swing.JPanel();
        lblTurnos = new javax.swing.JLabel();
        lblCreador = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        btnPos0 = new javax.swing.JButton();
        btnPos1 = new javax.swing.JButton();
        btnPos2 = new javax.swing.JButton();
        btnPos3 = new javax.swing.JButton();
        btnPos4 = new javax.swing.JButton();
        btnPos5 = new javax.swing.JButton();
        btnPos6 = new javax.swing.JButton();
        btnPos7 = new javax.swing.JButton();
        btnPos8 = new javax.swing.JButton();
        
        btnStart.addActionListener((ActionEvent e) -> {                         //esta seccion de aqui, permite que los botones o cualquier objeto, tenga un "escucha" para poder realizar acciones dentro del programa
                                                                                //Como en este caso, los botones son los que rellenan el arreglo bidimensional al presionarse, deberan de tener un metodo de escucha para que realice esa acción.
                iniciarJuego();
                //turno = 1;                                                    //Aqui en lugar de hacer un turno dentro de esta clase, se llama al constructor de la clase turnos
                turnos.setTurno(0);
            } 
        ); 
        
        btnPos0.addActionListener(((e) -> {
                llenarPosicion(0, 0, turnos.getTurno());                        //x, y, valor (se hace la llamada al metodo de esta clase)
                funcion.insertarDatosArreglo();
                funcion.mostrarDatos();
                btnPos0.setIcon(new ImageIcon(getClass().getResource(funcion.getImage())));
                btnPos0.setEnabled(false);                                      //desactiva el boton del juego
                
                verificarGanador();
            }
        ));
        
        btnPos1.addActionListener(((e) -> {
                llenarPosicion(0, 1, turnos.getTurno());
                funcion.insertarDatosArreglo();
                funcion.mostrarDatos();
                btnPos1.setIcon(new ImageIcon(getClass().getResource(funcion.getImage())));
                btnPos1.setEnabled(false);
                
                verificarGanador();
            }
        ));
        
        btnPos2.addActionListener(((e) -> {
                llenarPosicion(0, 2, turnos.getTurno());
                funcion.insertarDatosArreglo();
                funcion.mostrarDatos();
                btnPos2.setIcon(new ImageIcon(getClass().getResource(funcion.getImage())));
                btnPos2.setEnabled(false);
                
                verificarGanador();
            }
        ));
        
        btnPos3.addActionListener(((e) -> {
                llenarPosicion(1, 0, turnos.getTurno());
                funcion.insertarDatosArreglo();
                funcion.mostrarDatos();
                btnPos3.setIcon(new ImageIcon(getClass().getResource(funcion.getImage())));
                btnPos3.setEnabled(false);
                
                verificarGanador();
            }
        ));
        
        btnPos4.addActionListener(((e) -> {
                llenarPosicion(1, 1, turnos.getTurno());
                funcion.insertarDatosArreglo();
                funcion.mostrarDatos();
                btnPos4.setIcon(new ImageIcon(getClass().getResource(funcion.getImage())));
                btnPos4.setEnabled(false);
                
                verificarGanador();
            }
        ));
        
        btnPos5.addActionListener(((e) -> {
                llenarPosicion(1, 2, turnos.getTurno());
                funcion.insertarDatosArreglo();
                funcion.mostrarDatos();
                btnPos5.setIcon(new ImageIcon(getClass().getResource(funcion.getImage())));
                btnPos5.setEnabled(false);
                
                verificarGanador();
            }
        ));
        
        btnPos6.addActionListener(((e) -> {
                llenarPosicion(2, 0, turnos.getTurno());
                funcion.insertarDatosArreglo();
                funcion.mostrarDatos();
                btnPos6.setIcon(new ImageIcon(getClass().getResource(funcion.getImage())));
                btnPos6.setEnabled(false);
                
                verificarGanador();
            }
        ));
        
        btnPos7.addActionListener(((e) -> {
                llenarPosicion(2, 1, turnos.getTurno());
                funcion.insertarDatosArreglo();
                funcion.mostrarDatos();
                btnPos7.setIcon(new ImageIcon(getClass().getResource(funcion.getImage())));
                btnPos7.setEnabled(false);
                
                verificarGanador();
            }
        ));
        
        btnPos8.addActionListener(((e) -> {
                llenarPosicion(2, 2, turnos.getTurno());
                funcion.insertarDatosArreglo();
                funcion.mostrarDatos();
                btnPos8.setIcon(new ImageIcon(getClass().getResource(funcion.getImage())));
                btnPos8.setEnabled(false);
                
                verificarGanador();
            }
        ));
        
        
        this.getContentPane().add(panel);                                       //Esta parte del codigo, permite que agreguemos el panel a nuestra interfaz, para asi poder agregar componentes en ella
        panel.setBackground(new Color(9, 28, 77));
        panel.setLayout(null);
        
        panelBase.setBackground(Color.BLACK);                                   //Este panel, es donde se veran ubicados los botones del tablero del juego, es necesario declararlo para indicarle el tipo de layout que tendrá. 
        panelBase.setLayout(null);
    }
    
    public void colocarObjetosPanel()
    {
        //Seccion paneles
        panel.add(panelBase);
        panelBase.setBounds(31, 45, 387, 332);                                  //Este es una funcion que permite colocar en el frame el objeto, es x, y, width, height
        
        //Seccion labeles
        panel.add(lblTurnos);
        lblTurnos.setBounds(15, 15, 88, 17);
        lblTurnos.setText("Turno: numero");
        lblTurnos.setForeground(Color.WHITE); 
        
        panel.add(lblCreador);
        lblCreador.setBounds(14, 430, 205, 14);
        lblCreador.setText("Nombre creador: Kevin Isaac Huerta");
        lblCreador.setForeground(Color.WHITE); 

        //Seccion botones
        panel.add(btnStart);
        btnStart.setBounds(162, 390, 125, 28);
        btnStart.setBackground(new Color(217, 217, 217));
        btnStart.setText("START");
    }
    
    public void colocarObjetosPanelBase()
    {
        
        //Primera fila | 0| 1 | 2 |
        panelBase.add(btnPos0);
        btnPos0.setBounds(0, 0, 125, 107);
        btnPos0.setBackground(new Color(217, 217, 217));
        
        panelBase.add(btnPos1);
        btnPos1.setBounds(130, 0, 125, 107);
        btnPos1.setBackground(new Color(217, 217, 217));
        
        panelBase.add(btnPos2);
        btnPos2.setBounds(260, 0, 125, 107);
        btnPos2.setBackground(new Color(217, 217, 217));
        
        //Segunda fila | 3 | 4 | 5 |
        
        panelBase.add(btnPos3);
        btnPos3.setBounds(0, 112, 125, 107);
        btnPos3.setBackground(new Color(217, 217, 217));
        
        panelBase.add(btnPos4);
        btnPos4.setBounds(130, 112, 125, 107);
        btnPos4.setBackground(new Color(217, 217, 217));
        
        panelBase.add(btnPos5);
        btnPos5.setBounds(260, 112, 125, 107);
        btnPos5.setBackground(new Color(217, 217, 217));
        
        //Tercera fila | 6 | 7 | 8 |
        
        panelBase.add(btnPos6);
        btnPos6.setBounds(0, 224, 125, 107);
        btnPos6.setBackground(new Color(217, 217, 217));
        
        panelBase.add(btnPos7);
        btnPos7.setBounds(130, 224, 125, 107);
        btnPos7.setBackground(new Color(217, 217, 217));
        
        panelBase.add(btnPos8);
        btnPos8.setBounds(260, 224, 125, 107);
        btnPos8.setBackground(new Color(217, 217, 217));
    }
    
    public void deshabilitarBotones()
    {
        btnPos0.setVisible(false);
        btnPos1.setVisible(false);
        btnPos2.setVisible(false);
        btnPos3.setVisible(false);
        btnPos4.setVisible(false);
        btnPos5.setVisible(false);
        btnPos6.setVisible(false);
        btnPos7.setVisible(false);
        btnPos8.setVisible(false);
        
        btnPos0.setEnabled(false);
        btnPos1.setEnabled(false);
        btnPos2.setEnabled(false);
        btnPos3.setEnabled(false);
        btnPos4.setEnabled(false);
        btnPos5.setEnabled(false);
        btnPos6.setEnabled(false);
        btnPos7.setEnabled(false);
        btnPos8.setEnabled(false);
        
        btnPos0.setIcon(new ImageIcon(getClass().getResource("")));             //esto es para desactivar las imagenes del boton
        btnPos1.setIcon(new ImageIcon(getClass().getResource("")));
        btnPos2.setIcon(new ImageIcon(getClass().getResource("")));
        btnPos3.setIcon(new ImageIcon(getClass().getResource("")));
        btnPos4.setIcon(new ImageIcon(getClass().getResource("")));
        btnPos5.setIcon(new ImageIcon(getClass().getResource("")));
        btnPos6.setIcon(new ImageIcon(getClass().getResource("")));
        btnPos7.setIcon(new ImageIcon(getClass().getResource("")));
        btnPos8.setIcon(new ImageIcon(getClass().getResource("")));
        
        lblTurnos.setText("Turno : Turno");                                     //resetea el texto del label
    }
    
    public void habilitarBotones()
    {
        btnPos0.setVisible(true);
        btnPos1.setVisible(true);
        btnPos2.setVisible(true);
        btnPos3.setVisible(true);
        btnPos4.setVisible(true);
        btnPos5.setVisible(true);
        btnPos6.setVisible(true);
        btnPos7.setVisible(true);
        btnPos8.setVisible(true);
        
        btnPos0.setEnabled(true);
        btnPos1.setEnabled(true);
        btnPos2.setEnabled(true);
        btnPos3.setEnabled(true);
        btnPos4.setEnabled(true);
        btnPos5.setEnabled(true);
        btnPos6.setEnabled(true);
        btnPos7.setEnabled(true);
        btnPos8.setEnabled(true);
        
    }
    
    private void iniciarJuego()                                                 //La logica de este metodo  consiste en que cada que inicia la clase, el juego esta deshabilitado, para poder habilitarlo, se necesita dar a START y viceversa
    {
        if(juego == false)
        {
            habilitarBotones();
            btnStart.setText("END");
            juego = true;
        }
        
        else
        {
            deshabilitarBotones();
            funcion.resetearArreglo();
            btnStart.setText("START");
            juego = false;
        }
    }
    
    private void llenarPosicion(int valorX, int valorY, int turno)              //Este metodo sirve para hacer la insercion de datos en el arreglo de la clase de TableroFuncion, para evitar tener codigo repetido 
    {
        lblTurnos.setText("Turno : "+String.valueOf(turno));
        funcion.setX(valorX);
        funcion.setY(valorY);
        funcion.setValor(turno);                                                //este es el turno del metodo
        //System.out.println(funcion.getImage());       
    }
    
    private void verificarGanador()
    {  
        ganador = funcion.sumaFilas();
        
        if(ganador != 0)
        {
            deshabilitarBotones();
            funcion.resetearArreglo();
            btnStart.setText("GAME OVER");
        }
        else
        {
            ganador = funcion.sumaColumnas();
        }
        
        switch(ganador)
        {
            case 0: 
                diagonales();
                break;
            
            case 1:
                deshabilitarBotones();
                funcion.resetearArreglo();
                btnStart.setText("GAME OVER");
                break;
                
            case 2:
                deshabilitarBotones();
                funcion.resetearArreglo();
                btnStart.setText("GAME OVER");
                break; 
        }
            
    }
    
    private void diagonales()                                                   //este metodo sirve para calcular las diagonales en caso de que haya ganado asi alguien
    {
        ganador = funcion.sumaDiag();
        
        if(ganador != 0)
        {
            deshabilitarBotones();
            funcion.resetearArreglo();
            btnStart.setText("GAME OVER");
        }
        else
        {
            System.out.println("No hay ganador de momento");
        }
    }
    
    /*Declaracion de componentes necesarios para la ventana
    como los componentes que vamos a usar son parte de la libreria de 
    javax swing, necesitamos instanciarlos aqui para poder usarlos 
    y asi no hacer uso de codigo basura*/
    
    JPanel panel;
    JPanel panelBase;
    JLabel lblTurnos;
    JLabel lblCreador;
    JButton btnStart;
    JButton btnPos0;
    JButton btnPos1;
    JButton btnPos2;
    JButton btnPos3;
    JButton btnPos4;
    JButton btnPos5;
    JButton btnPos6;
    JButton btnPos7;
    JButton btnPos8;   
}
