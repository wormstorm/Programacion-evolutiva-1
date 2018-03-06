
public class FactoriaPoblaciones {
	public static Poblacion getPoblacion(String choice,int tam, String ejercicio, double precision) {
		switch(choice) {
		case("RULETA"):
			return new PoblacionRuleta(tam, ejercicio,precision);
		case("UNIVERSAL"):{
			return new PoblacionUniversalEstocastica(tam, ejercicio, precision);
		}
		default:
			return new PoblacionRuleta(tam, ejercicio,precision);
		}
	}
}
