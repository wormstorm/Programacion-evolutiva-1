package cromosoma;

public class CromosomaF4 extends CromosomaBool{

	public CromosomaF4(double precision) {
		super(precision,2, new double[]{20.0, 20.0});
	}
	public CromosomaF4(CromosomaBool copia, double precision) {
		super(copia, precision);
		// TODO Auto-generated constructor stub
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
				auxiliar += (_genes[j])? acumul*_const_fenotipo[i]:0;
				acumul*=2;
			}
			_fenotipo[i] = auxiliar-10;
		}
		return _fenotipo;
	}

	@Override
	public double aptitud() {
		// TODO Auto-generated method stub
		return -(Funciones.F4(_fenotipo));
	}

}
