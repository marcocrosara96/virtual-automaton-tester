import java.util.ArrayList;
import java.util.List;

/**
 * @author Marco Crosara
 */
public class Interval{

    private int i;
    private int j;

    public Interval(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() { return i; }
    public int getJ() { return j; }

    @Override
    public int hashCode() { return new Integer(i).hashCode() ^ new Integer(j).hashCode(); }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Interval)) return false;
        Interval pairo = (Interval) o;
        return this.i == pairo.i && this.j == pairo.j;
    }

    @Override
    public String toString() {
        if(i == -1)
            return "[" + i + ", +∞]";

        return "[" + i + ", " + j + "]";
    }

    public ArrayList<Integer> getInterval(){
        ArrayList<Integer> interval = new ArrayList<>();
        for (int k = i; k<=j; k++)
            interval.add(k);
        return interval;
    }

    public static Interval ssIntDiff(Interval I1, Interval I2){
        int min = I1.getJ() - I2.getJ();
        if(min < 0)
            return new Interval(0, min);
        return new Interval(min, min);
    }
}