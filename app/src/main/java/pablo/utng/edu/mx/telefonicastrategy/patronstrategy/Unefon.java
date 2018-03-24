package pablo.utng.edu.mx.telefonicastrategy.patronstrategy;

/**
 * Created by Mafren Alternativas on 17/02/2018.
 */

public class Unefon implements Telefonica {
    @Override
    public double calcularTerifa(int minutosLocal) {
        return 2*minutosLocal;
    }

    @Override
    public double calcularTarifaLD(int minutosLD) {
        return 2*minutosLD;
    }
}
