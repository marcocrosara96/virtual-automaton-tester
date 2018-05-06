/**
 * @author Marco Crosara
 */
public class INTERSECT {

    public static Automaton method(Automaton A1 , Automaton A2){
        Automaton AI = new Automaton();
        for(String a:A1){
            if(A2.contains(a))
                AI.addString(a);
        }
        return AI;
    }
}
