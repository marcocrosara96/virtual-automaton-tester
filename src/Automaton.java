import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Automaton implements Iterable<String>{

    private Set<String> strings= new HashSet<>();

    public Automaton(String ... ss){
        for(String s: ss){
            addString(s);
        }
    }

    public void addString(String s){
        strings.add(s);
    }

    @Override
    public String toString(){
        if (strings.size() == 0)
            return "{}";

        String result = "{";
        for(String s: strings){
            if(!s.equals(""))
                result += s + ", ";
            else
                result += "ε, ";
        }
        return result.substring(0,result.length()-2) + "}";
    }

    public boolean contains(String s){
        return strings.contains(s);
    }

    public int size(){
        return strings.size();
    }


    public boolean isEmpty(){
        if(strings.size() == 0)
            return true;
        return false;
    }

    public void print(){
        System.out.println(toString());
    }

    public void copy(Automaton original){
        for(String s: original){
            addString(s);
        }
    }

    public Automaton getLongestString(){
        String longest = null;

        for(String s: strings)
            if(longest == null || s.length() > longest.length())
                longest = s;

        if(longest != null)
            return new Automaton(longest);
        else
            return null;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Automaton)) return false;
        return strings.equals(((Automaton)o).strings);
    }

    public boolean removeString(String s){
        return strings.remove(s);
    }

    @Override
    public Iterator<String> iterator() {
        return strings.iterator();
    }
}
