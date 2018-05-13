/**
 * @author Marco Crosara
 */
public class BoolSet {
    boolean true_ = false;
    boolean false_ = false;

    public BoolSet(boolean value){
        if(value == true)
            true_ = true;
        else
            false_ = true;
    }

    public BoolSet(boolean value1, boolean value2){
        if(value1 == true)
            true_ = true;
        else
            false_ = true;
        if(value2 == true)
            true_ = true;
        else
            false_ = true;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BoolSet)) return false;
        BoolSet pairo = (BoolSet) o;
        return this.true_ == pairo.true_ && this.false_ == pairo.false_;
    }

    @Override
    public String toString() {
        if (true_ == true && false_ == true)
            return "{true, false}";
        if (true_ == true)
            return "{true}";
        if (false_ == true)
            return "{false}";
        return null;
    }
}
