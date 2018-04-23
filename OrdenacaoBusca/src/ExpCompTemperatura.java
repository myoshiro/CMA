import java.util.*;

public class ExpCompTemperatura implements Comparator <Experimento> {

    public int compare(Experimento e1, Experimento e2) {
        if (e1.temperatura < e2.temperatura) return -1;
        else if (e1.temperatura == e2.temperatura) return 0;
        else return 1;
       
     }

}