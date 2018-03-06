
public class FactoriaCromosoma {
	public static Cromosoma getCromosoma(String choice, double precision) {
		switch(choice) {
		case("EJ1"):
			return new CromosomaF1(precision);
		default:
			return new CromosomaF1(precision);
		}
	}
	public static Cromosoma getCromosomaCopia(Cromosoma c, String choice, double precision) {
		switch(choice) {
		case("EJ1"):
			return new CromosomaF1((CromosomaF1) c,precision);
		default:
			return new CromosomaF1(precision);
		}
	}
}
