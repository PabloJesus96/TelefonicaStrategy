package pablo.utng.edu.mx.telefonicastrategy.patronSingleton;

import java.util.Random;

/**
 * Created by Mafren Alternativas on 24/02/2018.
 */

public class MensajeSingleton {
    private static MensajeSingleton instance; //instancia unca
    private String mensaje;

    private MensajeSingleton(){
        String[] mensajes={"Hola bebe", "Hola Amo", "Se va aser o no se va aser :)"};
        Random r1 = new Random();
        int x = 0;
        x= r1.nextInt(mensajes.length);
        mensaje = mensajes[x];
    }

    public static MensajeSingleton getInstance(){
        if(instance==null){
            instance = new MensajeSingleton();
        }
        return instance;
    }

    public String getMensaje(){
        return mensaje;
    }
}
