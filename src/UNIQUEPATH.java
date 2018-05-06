/**
 * @author Marco Crosara
 */
public class UNIQUEPATH {
    public static boolean method(Automaton A) {
        Automaton Atemp = new Automaton();
        for (String s: A) {
            boolean insert = true;
            boolean replace = false;
            String replace_with = null;
            for(String t: Atemp) {
                if(s.length() < t.length() && t.substring(0, s.length()).equals(s))
                    insert = false;
                if(t.length() < s.length() && s.substring(0, t.length()).equals(t)) {
                    replace = true;
                    replace_with = t;
                }
            }
            if(replace == true){
                Atemp.removeString(replace_with);
                Atemp.addString(s);
                //System.out.println(replace_with + " replaced with " + s);
            }
            else if(insert == true) {
                Atemp.addString(s);
                //System.out.println(s + " added");
            }
        }

        if(Atemp.size() <= 1) // {"a"}
            return true;
        else
            return false;
    }

    public static boolean methodWithReverse(Automaton A) {
        Automaton Atemp = new Automaton();
        for (String s: A) {
            boolean insert = true;
            boolean replace = false;
            String replace_with = null;
            for(String t: Atemp) {
                if(t.length()-s.length() > 0 && t.substring(t.length()-s.length(), t.length()).equals(s))
                    insert = false;
                if(s.length()-t.length() > 0 && s.substring(s.length()-t.length(), s.length()).equals(t)) {
                    replace = true;
                    replace_with = t;
                }
            }
            if(replace == true){
                Atemp.removeString(replace_with);
                Atemp.addString(s);
                //System.out.println(replace_with + " replaced with " + s);
            }
            else if(insert == true) {
                Atemp.addString(s);
                //System.out.println(s + " added");
            }
        }

        if(Atemp.size() <= 1) // {"a"}
            return true;
        else
            return false;
    }
}
