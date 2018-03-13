
/**
 *
 * @author Carlos
 */
public class PoblacionTruncamiento<T> extends Poblacion<T> {

    private double _trunck;
    public PoblacionTruncamiento(int tam, String ejercicio, double precision, double trunk) {
        super(tam, ejercicio, precision);
        _trunck =trunk;
    }

    @Override
    public void seleccion() {
        double puntu = 0;
        int indice_mejores = 0;
        Cromosoma<T>[] padres = new Cromosoma[pobDistintas];
        
        for(int i = 0; i<_tam;i++){
            if(_pob[i].aptitud() > puntu) {
		padres[indice_mejores] = _pob[i];
                    indice_mejores++;
		else {
                    indice_mejores = buscarMenor(pobDistintas, padres);
                    puntu = padres[indice_mejores].aptitud();	
		}
            }
        }
        int j=0;
        for(int i = 0; i<_tam;i++){
            _pob[i] = FactoriaCromosoma.getCromosomaCopia(padres[j], _choice, _precision);
        }
        
    }
    
}

