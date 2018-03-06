import java.util.Random;

public class PoblacionUniversalEstocastica<T> extends Poblacion<T>{

	public PoblacionUniversalEstocastica(int tam, String ejercicio, double precision) {
		super(tam, ejercicio, precision);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void seleccion() {
		// TODO Auto-generated method stub
		Random r = new Random();
		double aux = r.nextDouble()*_puntuacion[0];
		double c = 1.0/_tam;
		Cromosoma<T>[] aux_pob = new Cromosoma[_tam];
		int j=0;
		for(int i =0;i<_tam;i++) {
			boolean encontrado = false;
			while(j<_tam && !encontrado) {
				if(aux>_punt_acum[j])
					j++;
				else {
					j--;
					aux_pob[i] = _pob[j];
					encontrado = true;
				}
			}
			aux += c;
			if (aux > this._suma_aptitud)
				aux = _suma_aptitud;
		}
		_pob = aux_pob;
	}

}
