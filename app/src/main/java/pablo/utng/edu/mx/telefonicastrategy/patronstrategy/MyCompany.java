package pablo.utng.edu.mx.telefonicastrategy.patronstrategy;

/**
 * Created by Mafren Alternativas on 17/02/2018.
 */

public class MyCompany implements Telefonica {
    @Override
    public double calcularTerifa(int minutosLocal) {
        return 0.5*minutosLocal;
    }

    @Override
    public double calcularTarifaLD(int minutosLD) {
        return 1.5*minutosLD;
    }
}
