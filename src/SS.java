/**
 * @author Marco Crosara
 */
public class SS {

    public static Automaton method(Automaton A, Interval I1, Interval I2){
        Automaton Ass = new Automaton();
        for(String s : A) {
            for (int i : I1.getInterval()) {
                for (int j : I2.getInterval()) {
                    try {
                        //System.out.println(s + ".substring(" + i + " ," + j +")");
                        if(j >= s.length()) j = s.length();
                        Ass.addString(s.substring(i ,j));
                    }catch (Exception e){}
                }
            }
        }
        return Ass;
    }
}
