package cromosoma;

public class CromosomaF1 extends CromosomaBool{

	public CromosomaF1(double precision) {
		super(precision,1,new double[]{32.0});
	}

	public CromosomaF1(CromosomaF1 copia, double precision) {
		super(copia,precision);
	}

	@Override
	public double[] fenotipo() {
		// TODO Auto-generated method stub
		double auxiliar;
		int acumul;
		for(int i = 0; i < _num_fen; i++) {
			auxiliar = 0;
			acumul = 1;
			for(int j = _longitud-(_longitud/_num_fen)*i-1;j>=_longitud-(_longitud/_num_fen)*(i+1);j--) {
				auxiliar += (_genes[j])? acumul*_const_fenotipo[0]:0;
				acumul*=2;
			}
			_fenotipo[i] = auxiliar;
		}
		return _fenotipo;
	}
	
	@Override
	public double aptitud() {
		// TODO Auto-generated method stub
		return Funciones.F1(_fenotipo);
	}
}