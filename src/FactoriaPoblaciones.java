
public class FactoriaPoblaciones {
	public static Poblacion getPoblacion(String choice,int tam, String ejercicio, double precision, double trunk) {
		switch(choice) {
		case("RULETA"):
			return new PoblacionRuleta(tam, ejercicio,precision);
		case("UNIVERSAL"):{
			return new PoblacionUniversalEstocastica(tam, ejercicio, precision);
		}
                case("TRUNCAMIENTO"):{
                        return new PoblacionTruncamiento(tam, ejercicio, precision,trunk);
                }
                case("TORNEO DETERMINISTA"):{
                        return new PoblacionTruncamiento(tam, ejercicio, precision,trunk);
                }
                case("TORNEO PROBABILISTA"):{
                        return new PoblacionTruncamiento(tam, ejercicio, precision,trunk);
                }
		default:
			return new PoblacionRuleta(tam, ejercicio,precision);
		}
	}
}
