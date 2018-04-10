package cromosoma;
import java.util.Random;

public abstract class Cromosoma<Integer> {
	protected Integer[] _genes;
	protected double[] _fenotipo;
	protected int _longitud;
	protected double[] _const_fenotipo;
	protected int _num_fen;
	
	public double[] fenotipo(){
            return null;
        };
	public double aptitud(){
            return 0;
        };
	protected abstract void generaAleatorio();
	public abstract void mutacion(double prob);
	public abstract void cruce(Cromosoma c2) ;
}
