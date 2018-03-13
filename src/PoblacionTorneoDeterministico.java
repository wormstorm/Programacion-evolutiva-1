
import java.util.Random;


/**
 *
 * @author Carlos
 */
public class PoblacionTorneoDeterministico<T> extends Poblacion<T> {

    
    public PoblacionTorneoDeterministico(int tam, String ejercicio, double precision) {
        super(tam, ejercicio, precision);
    }

    @Override
    public void seleccion() {
        Cromosoma<T>[] padres = new Cromosoma[_tam];
        Cromosoma<T> mejor;
        Random r = new Random();
        int aux;
        for(int i =0; i<_tam; i++){
            do{
                aux = r.nextInt(_tam);
            }while(aux!=i);
            mejor = (_pob[i].aptitud()>_pob[aux].aptitud())?_pob[i]:_pob[aux];
            padres[i] = FactoriaCromosoma.getCromosomaCopia(mejor, _choice, _precision);
        }
        _pob = padres;
    }
    
}
