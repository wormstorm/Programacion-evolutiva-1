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
public class CromosomaMutacionInversion extends Cromosoma<Integer>{

    @Override
    protected void generaAleatorio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mutacion(double prob) {
        Random r = new Random();
        double d;
        boolean encontrado = false;
        int i=0;
        while(!encontrado && i <_longitud){
            d = r.nextDouble();
            encontrado= (d<=prob);
            i += encontrado?0:1;
        }
        if (encontrado){
            int j = r.nextInt(_longitud);
            if(i>j)
                rotar(j,i);
            else
                rotar(i,j);
        }
    }

    private void rotar(int ini, int fin){
        int sub[] = new int[ini-fin+1];
        for(int i=ini;i<=fin;i++){
            sub[fin-1] = _genes[i];
        }
        for (int i =0;i<sub.length;i++){
            _genes[i+ini] =sub[i];
        }
    }
    @Override
    public void cruce(Cromosoma c2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
