package pablo.utng.edu.mx.telefonicastrategy.patronstrategy;

/**
 * Created by Mafren Alternativas on 24/02/2018.
 */

public class Movistar implements Telefonica {
    @Override
    public double calcularTerifa(int minutosLocal) {
        return 4*minutosLocal;
    }

    @Override
    public double calcularTarifaLD(int minutosLD) {
        return 6*minutosLD;
    }
}
