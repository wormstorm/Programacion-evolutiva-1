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
public class CromosomaMutacionInsercion extends Cromosoma<Integer>{

    @Override
    public double[] fenotipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double aptitud() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void generaAleatorio() {
        for(int i=0;i<_longitud;i++)
            _genes[i]=i;
        
        Random r = new Random();
        for(int i=_longitud;i>0;i++){
            int posicion = r.nextInt(i);
            int tmp = _genes[i-1];
            _genes[i-1] = _genes[posicion];
            _genes[posicion] = tmp;
            
        }
    }

    @Override
    public void mutacion(double prob) {
        Random r = new Random();
        boolean encontrado = false;
        double d;
        int letra=-1;
        while (!encontrado && letra<=_longitud){
            d = r.nextDouble();
            encontrado =(d<=prob);
            letra++;
        }        
        if (encontrado){
            int posnueva = r.nextInt(_longitud);
            encontrado = false;
            int i=0;
            while (!encontrado && i<_longitud){            
                encontrado=(_genes[i]==letra);
                i += encontrado?0:1;
            }
            if(posnueva<i)
                rotar(posnueva,i);
            else
                rotar(i,posnueva); 
        }
    }

    private void rotar (int inicio, int fin){
        int tmp =_genes[fin];
        for(int i = inicio;i<=fin;i++){
            int tmp2 = _genes[i];
            _genes[i] = tmp;
            tmp = tmp2;
            
        }
    }
    @Override
    public void cruce(Cromosoma c2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
