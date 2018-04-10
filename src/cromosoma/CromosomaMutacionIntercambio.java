/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cromosoma;

import java.util.Random;

/**
 *
 * @author Carlos
 */
public class CromosomaMutacionIntercambio extends Cromosoma<Integer>{

    @Override
    protected void generaAleatorio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mutacion(double prob) {
        Random r = new Random();
        boolean encontrado = false;
        double d;
        int a;
        int b=-1;
        
        while (!encontrado && b<=_longitud){
            d = r.nextDouble();
            encontrado =(d<=prob);
            b++;
        }
        if (encontrado){
            a = r.nextInt(_longitud);        
            int tmp = _genes[a];
            _genes[a] = _genes[b];
            _genes[b]=tmp;
        }
    }

    @Override
    public void cruce(Cromosoma c2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
