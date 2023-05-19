package actividad1relojes;

import static actividad1relojes.RelojCol.Hora;
import java.util.Calendar;
import java.util.concurrent.Semaphore;

public class Relojes {

    public static void main(String[] args) {
        Semaphore S1 = new Semaphore(1);
        RelojArg RA = new RelojArg(S1);
        RelojCol RC = new RelojCol(S1);
        RelojEsp RE =  new RelojEsp(S1);
        
        RA.start();
        RC.start();
        RE.start();
    }
    
}
