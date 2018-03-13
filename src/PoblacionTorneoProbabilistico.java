
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos
 */
public class PoblacionTorneoProbabilistico<T> extends Poblacion<T> {

    private double _prob;
    public PoblacionTorneoProbabilistico(int tam, String ejercicio, double precision, double trunk) {
        super(tam, ejercicio, precision);
        _prob = trunk;
    }

    @Override
    public void seleccion() {
        Cromosoma<T>[] padres = new Cromosoma[_tam];
        Cromosoma<T> mejor;
        Random r = new Random();
        int aux;
        double ran;
        for(int i =0; i<_tam; i++){
            do{
                aux = r.nextInt(_tam);
            }while(aux!=i);
            ran = r.nextDouble();
            mejor = (ran<=_prob)?_pob[i]:_pob[aux];
            padres[i] = FactoriaCromosoma.getCromosomaCopia(mejor, _choice, _precision);
        }
        _pob = padres;
    }
    
}
