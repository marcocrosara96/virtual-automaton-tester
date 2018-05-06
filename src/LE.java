/**
 * @author Marco Crosara
 */
public class LE {

    public static Interval method(Automaton a){

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        boolean lessinfinity = false;

        for(String s: a) {
            if (s.contains("*"))//emulo il + infinito
                lessinfinity = true;
            if(s.length() < min)
                min = s.length();
            if(s.length() > max)
                max = s.length();
        }

        if(lessinfinity == true)
            return new Interval(min ,-1);

        return new Interval(min ,max);
    }
}
