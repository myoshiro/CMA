
import java.util.Comparator;


public class ExpCompNome implements Comparator <Experimento> {

    public int compare(Experimento e1, Experimento e2) {
        return e1.nomeDoResponsavel.compareTo(e2.nomeDoResponsavel);}

}
