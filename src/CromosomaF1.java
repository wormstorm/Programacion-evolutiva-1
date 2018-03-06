import java.util.Random;

public class CromosomaF1 extends Cromosoma<Boolean>{

	
	
	public CromosomaF1(double precision) {
		super((int) (Math.ceil(Math.log(1+(32/precision))/Math.log(2))));
		_genes = new Boolean[_longitud];
		generaAleatorio();
		_const_fenotipo = 32/(Math.pow(2,_longitud)-1);
		fenotipo();
	}
	
	public CromosomaF1(CromosomaF1 copia, double precision) {
		super((int) (Math.ceil(Math.log(1+(32/precision))/Math.log(2))));
		_genes = new Boolean[_longitud];
		System.arraycopy(copia._genes, 0, _genes, 0, _longitud);
		_fenotipo = copia._fenotipo;
		_const_fenotipo = 32/(Math.pow(2,_longitud)-1);
	}
	
	@Override
	public double fenotipo() {
		// TODO Auto-generated method stub
		double auxiliar = 0;
		int acumul = 1;
		for(int i = _longitud-1; i >=0; i--) {
			auxiliar += (_genes[i])? acumul*_const_fenotipo:0;
			acumul*=2;
		}
		_fenotipo = auxiliar;
		return _fenotipo;
	}

	@Override
	public double aptitud() {
		// TODO Auto-generated method stub
		return  20 + Math.E - 20*(Math.pow(Math.E,-0.2*_fenotipo)) - Math.pow(Math.E, Math.cos(Math.PI*2*_fenotipo));
	}
	@Override
	protected void generaAleatorio() {
		// TODO Auto-generated method stub
		Random r = new Random();
		for(int i = 0; i < _longitud;i++)
			_genes[i] = r.nextBoolean();
	}
	
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
