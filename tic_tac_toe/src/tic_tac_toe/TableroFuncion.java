package tic_tac_toe;

import javax.swing.JOptionPane;

/*Esta clase permite hacer la logica del programa
estando independiente del diseño

__________
1 + 2 + 3 |
4 + 5 + 6 |
7 + 8 + 9 |
----------

*/

public class TableroFuncion 
{
    public int array[][] = new int [3][3];
    public int x, y, turno, sumaF, sumaC, sumaD, sumaI;
    public String imagen;
    
    /*Como vamos a hacer uso del diseño para poder ingresar valores a esta clase
      necesitamos usar metodos getter y setter, para que pueda interactuar 
      entre si con los valores*/
    
    public TableroFuncion()
    {
        //Inicializamos los valores de los atributos
        x = 0;
        y = 0;
        turno = 0;
        sumaF = 0;
        sumaC = 0;
        sumaD = 0;
        sumaI = 0;
        imagen = "";
    }

    public int getX() 
    {
        return x;
    }

    public void setX(int x) 
    {
        this.x = x;
    }

    public int getY() 
    {
        return y;
    }

    public void setY(int y) 
    {
        this.y = y;
    }

    public int getTurno() 
    {
        return turno;
    }

    public void setValor(int valor) 
    {
        this.turno = valor;
    }
    
    public void mostrarDatos()
    {
        System.out.println("X es "+x+"\nY es "+y+"\nValor es "+turno);
    }
    
    public String getImage()
    {
        if(turno == 1)
        {
            imagen = "/imagenes/imgX2.png";                               //imagen con path relativo
            return imagen;
        }
        else
        {
            imagen = "/imagenes/imgO2.png";                               //imagen con path relativo
            return imagen;
        }
    }
    
    
    /*Esta seccion es la parte logica del programa, donde se hace la sumatoria del arreglo
    para determinar si gano el turno 1 o 2

    Primero realizamos la insercion de los datos al arreglo.
    Despues una suma vertical y horizontal, despues analizaremos las
    sumas, y veremos los valores en diagonales para determinar como ganó y quien
    ganó.  */
    
    public void insertarDatosArreglo()
    {
        if(turno == 1)
            array[x][y] = 1;                                                    //aqui le indicamos como se guardara el valor en el arreglo
        else
            array[x][y] = 4;                                                    //se usa un 4 para evitar conflicto con la suma de los valores, ya que el 1 solo puede llegar a 3 (porque hay solo 3 casillas)
    }
    
    /*Suma de valores en fila*/
    public int sumaFilas()
    {
        int validacion  = 0;                                                    //es una variable que permite cerrar el bucle del retorno
        
        for(int i = 0; i < 3; i++)                                              // es un 3 debido a que el gato tiene solo 3 casillas 
        {
            sumaF = 0;
            
            for(int j = 0; j < 3; j++)
            {
                sumaF += array[i][j];
            }
            
            if(sumaF == 3)
            {
                validacion = 1;
                JOptionPane.showMessageDialog(null, "Ganó filas el jugador 1");
            }
            
            else if(sumaF == 12)
            {
                validacion = 2;
                JOptionPane.showMessageDialog(null, "Ganó filas el jugador 2");
            }
        }
        
        return validacion;
    }
    
    public int sumaColumnas()
    {
        int validacion = 0;
        
        for(int j = 0; j < 3; j++)
        {
            sumaC = 0;
            for(int i = 0; i < 3; i++)
            {
                sumaC += array[i][j];
            }
            
            if(sumaC == 3)
            {
                validacion = 1;
                JOptionPane.showMessageDialog(null, "Ganó el jugador 1");
            }
            
            else if(sumaC == 12)
            {
               validacion = 2;
               JOptionPane.showMessageDialog(null, "Ganó el jugador 2");
            }
        }
        
        return validacion;
    }
    
    public int sumaDiag()
    {
        int validacion = 0;
        
        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                if(i == j)                                                      //teniendo en consideracion que en una tabla, la diagonal es el mismo numero en si  [0][0], [1][1], etc, quiere decir que si i es igual a j, se formara la diagonal de la tabla y se realizara la suma formando la \
                {
                    sumaD += array[i][j]; // esta es la diagonal \
                }
                if((i+j) == array.length-1)                                     //En sentido contrario, nuestro arreglo va de | 0 | 1 | 2 |, lo cual el 2 esta en la posicion [3] y la fila es la [0], entonces si se suman da como resultado 3, y como la tabla va de 0 a 2, se evalua el tamaño del arreglo y se resta una unidad, para despues comparar que sea el mismo valor, formando la /
                {
                    sumaI += array[i][j]; //esta es la diagonal /
                }
            }
            
            if(sumaD == 3 || sumaI == 3)
            {
                validacion = 1;
                JOptionPane.showMessageDialog(null, "Ganó el jugador 1");
            }

            else if(sumaD == 12 || sumaI == 12)
            {
               validacion = 2;
               JOptionPane.showMessageDialog(null, "Ganó el jugador 2");
            }
        }
        
        sumaD = 0;                                                              //Retorna el valor de la sumaD a 0 para que puedan seguir jugando sin cerrar el programa.
        sumaI = 0;
        return validacion;
    }
    
    public void resetearArreglo()                                               //Este metodo permite que podamos resetear a 0 los valores del arreglo bidimensional
    {
        for(int i = 0; i<3; i++)
            for(int j = 0; j < 3; j++)
                array[i][j] = 0;
        
        System.out.println("Se reseteo el arreglo");
    }

}
