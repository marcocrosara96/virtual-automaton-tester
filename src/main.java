/**
 * @author Marco Crosara
 */
public class main {

    public static void main(String[] args) {
        printLogo();
        /*Automaton A = new Automaton("panda","anda");
        A.print();
        Automaton A1 = new Automaton("nda","a");
        A1.print();*/

        //System.out.println(SS.method(new Automaton("adnap", "adn", "a"), new Interval(0,0), new Interval(3,3)));

        EW.testEW(false);
        //EW.testEW(true);
    }

    public static void printLogo(){
        String s = Colors.ANSI_CYAN;
        s += "    _  _   _ _____ ___  __  __   _ _____ ___  _  _   ___ ___ __  __ _   _ _      _ _____ ___  ___ \n";
        s += "   /_\\| | | |_   _/ _ \\|  \\/  | /_\\_   _/ _ \\| \\| | / __|_ _|  \\/  | | | | |    /_\\_   _/ _ \\| _ \\\n";
        s += "  / _ \\ |_| | | || (_) | |\\/| |/ _ \\| || (_) | .` | \\__ \\| || |\\/| | |_| | |__ / _ \\| || (_) |   /\n";
        s += " /_/ \\_\\___/  |_| \\___/|_|  |_/_/ \\_\\_| \\___/|_|\\_| |___/___|_|  |_|\\___/|____/_/ \\_\\_| \\___/|_|_\\\n";
        s += Colors.ANSI_RESET;
        System.out.println(s);
    }
}


