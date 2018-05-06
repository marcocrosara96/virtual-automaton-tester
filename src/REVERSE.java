/**
 * @author Marco Crosara
 */
public class REVERSE {
    public static Automaton method(Automaton A) {
        Automaton Arev = new Automaton();
        for(String s: A){
            Arev.addString(new StringBuilder(s).reverse().toString());
        }
        return Arev;
    }
}
