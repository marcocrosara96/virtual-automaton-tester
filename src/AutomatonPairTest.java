/**
 * @author Marco Crosara
 */
public class AutomatonPairTest {

    private Automaton A;
    private Automaton A1;
    private BOOL CHECK;

    public AutomatonPairTest(Automaton A, Automaton A1) {
        this.A = A;
        this.A1 = A1;
    }

    public AutomatonPairTest(Automaton A, Automaton A1, BOOL CHECK) {
        this(A, A1);
        this.CHECK = CHECK;
    }

    public Automaton getA() { return A; }
    public Automaton getA1() { return A1; }
    public BOOL getCHECK() { return CHECK; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AutomatonPairTest)) return false;
        AutomatonPairTest pairo = (AutomatonPairTest) o;
        return this.A == pairo.A && this.A1 == pairo.A1;
    }

    @Override
    public String toString() {
        return "{" + A + ", " + A1 + "}";
    }
}