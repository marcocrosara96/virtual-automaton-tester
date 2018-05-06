import java.util.HashSet;
import java.util.Set;

/**
 * @author Marco Crosara
 */
public class BOOL {
    boolean true_ = false;
    boolean false_ = false;

    public BOOL(boolean value){
        if(value == true)
            true_ = true;
        else
            false_ = true;
    }

    public BOOL(boolean value1, boolean value2){
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
        if (!(o instanceof BOOL)) return false;
        BOOL pairo = (BOOL) o;
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
