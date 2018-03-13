
public class AGenetico {
	private Poblacion _poblacion;
	private int _num_max_gen;
	private int _gen_actual;
	private double _prob_cruce;
	private double _prob_mut;
	private double _tolerancia;
	private double _mejor;
	private double _mejorf;
	
	public AGenetico(int max_gen, double cruce, double mut, double tol, int tam, String seleccion, String ejercicio, double trunk)  {
		_num_max_gen = max_gen;
		_gen_actual = 0;
		_prob_cruce = cruce;
		_prob_mut = mut;
		_tolerancia = tol;
		_poblacion = FactoriaPoblaciones.getPoblacion(seleccion, tam, ejercicio , _tolerancia, trunk);
	}
	
	public void ejecutaAG() {
		_mejor = _poblacion.getMejorApt();
		_mejorf = _poblacion.getMejorFen();
		while(_gen_actual < _num_max_gen) {
			System.out.println(_mejorf+" :"+_mejor +" -> "+_poblacion.getMejorFen() + "  :" + _poblacion.getMejorApt());
			_poblacion.seleccion();
			_poblacion.cruce(_prob_cruce);
			_poblacion.mutacion(_prob_mut);
			if(_mejor < _poblacion.getMejorApt()) { 
				_mejor = _poblacion.getMejorApt();
				_mejorf = _poblacion.getMejorFen();
			}
			_gen_actual++;
		}
		System.out.println(_mejorf+" :"+_mejor +" -> "+_poblacion.getMejorFen() + "  :" + _poblacion.getMejorApt());
	}
}
