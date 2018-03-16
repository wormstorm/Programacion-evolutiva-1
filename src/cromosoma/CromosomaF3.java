package cromosoma;

public class CromosomaF3 extends CromosomaBool{

	public CromosomaF3(double precision) {
		super(precision,2, new double[]{15.1, 1.7});
	}
	
	public CromosomaF3(CromosomaBool copia, double precision) {
		super(copia, precision);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double aptitud() {
		// TODO Auto-generated method stub
		return Funciones.F3(_fenotipo);
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
			_fenotipo[i] = (i==0)?auxiliar-3:auxiliar+4.1;
		}
		return _fenotipo;
	}
}
