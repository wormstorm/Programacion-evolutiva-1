package cromosoma;
import java.util.Random;

public abstract class Cromosoma<T> {
	protected T[] _genes;
	protected double[] _fenotipo;
	protected int _longitud;
	protected double[] _const_fenotipo;
	protected int _num_fen;
	
	public abstract double[] fenotipo();
	public abstract double aptitud();
	protected abstract void generaAleatorio();
	public abstract void mutacion(double prob);
	public void cruce(Cromosoma c2) {
		Random r = new Random();
		T aux;
		for(int i= r.nextInt(_longitud-1); i < _longitud; i++) {
			aux = this._genes[i];
			this._genes[i]= (T) c2._genes[i];
			_genes[i] = aux;
		}
		c2.fenotipo();
		fenotipo();
	}
}
