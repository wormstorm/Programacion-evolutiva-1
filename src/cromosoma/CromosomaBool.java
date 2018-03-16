package cromosoma;
import java.util.Random;

abstract public class CromosomaBool extends Cromosoma<Boolean>{

	public CromosomaBool() {}
	public CromosomaBool(double precision, int num_fen, double[] intervalo) {
		_longitud = 0;
		for(int i = 0; i < num_fen;i++) {
			_longitud +=(int)(Math.ceil(Math.log(1+(intervalo[i]/precision))/Math.log(2)));
		}
		_genes = new Boolean[_longitud];
		_num_fen = num_fen;
		_const_fenotipo = new double[_num_fen];
		generaAleatorio();
		for(int i = 0; i < num_fen; i++) {
			_const_fenotipo[i] = intervalo[i]/(Math.pow(2,(_longitud/_num_fen))-1);
		}
		_fenotipo = new double[_num_fen];
		fenotipo();
	}

	public CromosomaBool(CromosomaBool copia, double precision) {
		_longitud = copia._longitud;
		_num_fen = copia._num_fen;
		_genes = new Boolean[_longitud];
		_fenotipo = new double[_num_fen];
		_const_fenotipo = new double[_num_fen];
		System.arraycopy(copia._genes, 0, _genes, 0, _longitud);
		System.arraycopy(copia._fenotipo, 0, _fenotipo, 0, _num_fen);
		System.arraycopy(copia._const_fenotipo, 0, _const_fenotipo, 0, _num_fen);
	}


	@Override
	protected void generaAleatorio() {
		// TODO Auto-generated method stub
		Random r = new Random();
		for(int i = 0; i < _longitud;i++)
			_genes[i] = r.nextBoolean();
	}
	@Override
	public void mutacion(double prob) {
		Random r = new Random();
		boolean cambiado = false;
		for(int i = 0; i < _longitud; i++)
			if(r.nextDouble() < prob) {
				_genes[i] = !_genes[i];
				cambiado = true;
			}
		if(cambiado) fenotipo();
	}
}