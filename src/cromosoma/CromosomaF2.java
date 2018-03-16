package cromosoma;

public class CromosomaF2 extends CromosomaBool{

	public CromosomaF2(double precision) {
		super(precision,2, new double[] {1024, 1024});
	}
	
	public CromosomaF2(CromosomaF2 copia, double precision) {
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
				auxiliar += (_genes[j])? acumul*_const_fenotipo[i]:0;
				acumul*=2;
			}
			_fenotipo[i] = auxiliar-512;
		}
		return _fenotipo;
	}

	@Override
	public double aptitud() {
		// TODO Auto-generated method stub
		return -(Funciones.F2(_fenotipo));
	}
}
