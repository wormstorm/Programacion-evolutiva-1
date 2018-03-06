import java.util.Random;

public class PoblacionRuleta<T> extends Poblacion<T>{

	public PoblacionRuleta(int tam, String ejercicio, double precision) {
		super(tam, ejercicio, precision);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void seleccion() {
		Cromosoma<T>[] pob_aux = new Cromosoma[_tam];
		Random r = new Random();
		double seleccionado;
		int pos;
		for(int i = 0; i < _tam; i++) {
			seleccionado = r.nextDouble()*_suma_aptitud;
			pos = _tam-1;
			boolean encontrado = false;
			while(pos >= 0 && encontrado) {
				if(seleccionado < _punt_acum[pos])
					encontrado = true;
				else pos--;
			}
			pob_aux[i] = _pob[pos];
		}
		_pob = pob_aux;
	}

}
