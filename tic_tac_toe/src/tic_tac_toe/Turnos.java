package tic_tac_toe;

public class Turnos 
{
    public int turno;
    
    public Turnos()                                                             //Metodo constructor
    {
        turno = 0;
    }
    
    public int getTurno()
    {
        switch (turno)                                                          //El metodo getTurno, sirve para poder retornar el numero de turno que se encuentra en el sistema
        {                                                                       //Funciona de manera que al hacerle la llamada a la clase por el boton "start" de Tablero, este le manda el
            case 0:                                                             //le manda el valor de 0 por el metodo setTurno, el cual se incrementa en 1 inmediatamente, tras volverse a 
                turno = 1;                                                      //dar clic en otro boton, se incrementa en 1, llegando al 2, para lo cual posteriormente se regresa a 0 y vuelve a hacer su ciclo
                break;
            case 1:
                ++turno;
                break;
            case 2:
                turno = 1;
                break;
        }
        return turno;
    }
    
    public void setTurno(int turno)
    {
        this.turno = turno;
    }
   
}
