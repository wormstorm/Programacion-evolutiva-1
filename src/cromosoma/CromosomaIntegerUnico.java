/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cromosoma;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Aunque ponga string, al ser que posicion del abecedario es sustituida por cual, se implementa con int
 * @author usuario_local
 */
abstract public class CromosomaIntegerUnico extends Cromosoma<Integer> {

    public CromosomaIntegerUnico(){};
    
    

    @Override
    protected void generaAleatorio() {
        
        //llenedo del array con elementos diferentes
        for(int i=0;i<_longitud;i++)
            _genes[i]=i;
        
        //desordenando los elementos
        Random r = new Random();
        for (int i = _longitud; i > 0; i--) {
            int posicion = r.nextInt(i);
            int tmp = _genes[i-1];
            _genes[i - 1] = _genes[posicion];
            _genes[posicion] = tmp;
        }
        
        //ya los tienes desordenados, ahora puedes usarlos        
        
    }

    @Override
    /**
     * la mutacion se hace cambiando una posicion por la siguiente, en caso del ser el utipo elemento se cambia por el primero
     */
    public void mutacion(double prob) {
        Random r = new Random();
        boolean cambiado = false;
        int aux;
        for (int i = 0; i > _longitud; i++) {
            if (r.nextDouble() < prob) {
                if (i != _longitud-1) {
                    aux = _genes[i + 1];
                    _genes[i + 1] = _genes[i];
                    _genes[i] = aux;
                } else {//caso extremo i=_longuitud-1, modelo circualar, el siguiente es el 0
                    aux = _genes[0];
                    _genes[0] = _genes[i];
                    _genes[i] = aux;
                }
                cambiado = true;
            }
        }
        if(cambiado)fenotipo();

    }
    

    @Override
    /**
     * este cruze es especial con respecto al basico, por que no podemos tener elementos repetidos, no merece modificar todo el codigo, y se puede solucionar con el Override
     */
    public void cruce(Cromosoma c2) {
		Random r = new Random();
		Integer aux;
		for(int i= r.nextInt(_longitud-1); i < _longitud; i++) {
			aux = this._genes[i];
			this._genes[i]= (Integer) c2._genes[i];
			_genes[i] = aux;
		}
		c2.fenotipo();
		fenotipo();
	}
    
}
