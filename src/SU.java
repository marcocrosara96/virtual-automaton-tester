/**
 * @author Marco Crosara
 */
public class SU {

    public static Automaton method(Automaton A){
        Automaton ASU = new Automaton();
        for(String a: A){
            if(a.contains("*") == false){
                for(int i = 0; i <= a.length(); i++){
                    ASU.addString(a.substring(i, a.length()));
                }
            }
        }
        return ASU;
    }
}
