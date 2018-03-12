import java.util.Random;

public class PoblacionUniversalEstocastica<T> extends Poblacion<T>{

	public PoblacionUniversalEstocastica(int tam, String ejercicio, double precision) {
		super(tam, ejercicio, precision);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void seleccion() {
            
            Random r = new Random();
            double dist = 1.0/_tam;
            double marca = r.nextDouble() * dist;
            marca = marca + dist*(_tam-1);
            
            int j=_tam-1;
            Cromosoma<T>[] pob_aux = new Cromosoma[_tam];
            boolean ent = false;
            for (int i = _tam-1; i>=0; i--){
                ent = false;
                while (j>=0 && !ent){
                    
                    if (_punt_acum[j]/_suma_aptitud <= marca){
                        if (j == 0 || _punt_acum[j-1]/_suma_aptitud <= marca){
                            pob_aux[i] = _pob[j];
                            marca = marca-dist;
                            ent = true;
                            j++;
                        }
                    }
                    j--;
                    if (i==0 && !ent && j==-1)
                        pob_aux[0] = _pob[0];
                }
                                
            }
            
            _pob = pob_aux;
	}

}
