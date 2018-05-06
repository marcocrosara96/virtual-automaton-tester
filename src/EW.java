import javax.xml.transform.Result;
import java.util.ArrayList;

/**
 * @author Marco Crosara
 */
public class EW {

    private static boolean debugstatus = false;

    public static BOOL method(Automaton A, Automaton A1, boolean DEBUG){
        if(DEBUG == true) debugstatus = true;
        else debugstatus = false;
        echo("---- START EW DEBUG ----");

        Interval A1_length = LE.method(A1);
        if(A1_length.equals(new Interval(0,0)))
            return new BOOL(true);
        if(A1_length.getJ() == -1)
            return new BOOL(false);
        Interval A_length = LE.method(A);
        if(A_length.getJ() == -1)
            return new BOOL(true, false);
        if(A1_length.equals(new Interval(0,0)) || INTERSECT.method(A1, SU.method(A)).isEmpty())
            return new BOOL(false);
        echo("UNIQUEPATH.method(Reverse.method(" + A1 + ")) --> "+ UNIQUEPATH.method(A1));
        if(UNIQUEPATH.method(REVERSE.method(A1))){
            echo("B = SS.method(" + REVERSE.method(A) + ", " + new Interval(0 ,0) +", " + new Interval(A1_length.getJ(), A1_length.getJ()) + ") ---> " + SS.method(A, new Interval(0 ,0), new Interval(A1_length.getJ(), A1_length.getJ())));
            Automaton B = SS.method(REVERSE.method(A), new Interval(0 ,0), new Interval(A1_length.getJ(), A1_length.getJ()));
            echo("C = REVERSE.method(" + A1 + ".getLongestString())---> " + REVERSE.method(A1.getLongestString()));
            Automaton C = REVERSE.method(A1.getLongestString());
            echo(B + ".equals(" + C + ") ---> " + B.equals(C));
            if(B.equals(C)) {
                return new BOOL(true);
            }
        }

        echo("---- END EW DEBUG ----");

        return new BOOL(true, false);
    }

    public static BOOL method(Automaton A, Automaton A1){
        return method(A, A1, false);
    }

    public static void echo(String s){
        if(debugstatus == true)
            System.out.println(s);
    }

    public static void testEW(boolean DEBUG){
        System.out.println("_____________________________ START TEST EW _____________________________");
        boolean allcheckpassed = true;
        for(AutomatonPairTest a: getTests()){
            BOOL result = EW.method(a.getA(), a.getA1(), DEBUG);

            String COLOR = Colors.ANSI_RED;
            if(result.equals(a.getCHECK()))
                COLOR = Colors.ANSI_GREEN;
            else
                allcheckpassed = false;

            System.out.println(COLOR + "A:" + a.getA() + "  A1: " + a.getA1() +
                    "--> result: " + result + " - aspected: " + a.getCHECK() + Colors.ANSI_RESET);
        }

        if (allcheckpassed == true)
            System.out.println(Colors.ANSI_GREEN + "\n>>>>>>>>>> ALL CHECKS PASSED! <<<<<<<<<<\n" + Colors.ANSI_RESET);
        else
            System.out.println(Colors.ANSI_RED + "\n>>>>>>>>>> SOME ERRORS <<<<<<<<<<\n" + Colors.ANSI_RESET);

        System.out.println("______________________________ END TEST EW ______________________________");
    }

    public static ArrayList<AutomatonPairTest> getTests(){
        ArrayList<AutomatonPairTest> list = new ArrayList<>();
        Automaton A; Automaton A1; BOOL CHECK;

        // TEST
        A = new Automaton("panda", "nda", "a");
        A1 = new Automaton("nda", "a");
        CHECK = new BOOL(true, false);
        list.add(new AutomatonPairTest(A, A1, CHECK));
        // TEST
        A = new Automaton("panda", "anda");
        A1 = new Automaton("nda", "a");
        CHECK = new BOOL(true);
        list.add(new AutomatonPairTest(A, A1, CHECK));
        // TEST
        A = new Automaton("panda", "anda", "orda");
        A1 = new Automaton("nda", "a");
        CHECK = new BOOL(true, false);
        list.add(new AutomatonPairTest(A, A1, CHECK));
        // TEST
        A = new Automaton("panda", "koala");
        A1 = new Automaton("nda", "ala");
        CHECK = new BOOL(true, false);
        list.add(new AutomatonPairTest(A, A1, CHECK));
        // TEST
        A = new Automaton("panda", "anda", "nda");
        A1 = new Automaton("nda");
        CHECK = new BOOL(true);
        list.add(new AutomatonPairTest(A, A1, CHECK));
        // TEST
        A = new Automaton("panda", "pand", "nd");
        A1 = new Automaton("panda");
        CHECK = new BOOL(true, false);
        list.add(new AutomatonPairTest(A, A1, CHECK));
        // TEST
        A = new Automaton("panda", "pand", "nd");
        A1 = new Automaton("panda", "anda", "da");
        CHECK = new BOOL(true, false);
        list.add(new AutomatonPairTest(A, A1, CHECK));
        // TEST
        A = new Automaton("panda", "pand", "nd");
        A1 = new Automaton("panda", "pand", "nd", "d");
        CHECK = new BOOL(true, false);
        list.add(new AutomatonPairTest(A, A1, CHECK));
        A = new Automaton("panda", "panda", "panda");
        A1 = new Automaton("panda");
        CHECK = new BOOL(true);
        list.add(new AutomatonPairTest(A, A1, CHECK));
        A = new Automaton("panda", "panda", "pandapanda");
        A1 = new Automaton("panda");
        CHECK = new BOOL(true);
        list.add(new AutomatonPairTest(A, A1, CHECK));
        A = new Automaton("panda", "panda", "pandapanda");
        A1 = new Automaton("pandapanda");
        CHECK = new BOOL(true, false);
        list.add(new AutomatonPairTest(A, A1, CHECK));
        A = new Automaton("panda", "panda", "pandapanda");
        A1 = new Automaton("pandaprtretanda");
        CHECK = new BOOL(false);
        list.add(new AutomatonPairTest(A, A1, CHECK));

        return list;
    }
}
