
import java.util.Comparator;

public class ExpCompVolume implements Comparator <Experimento>{

    public int compare(Experimento e1, Experimento e2) {
        if (e1.volume < e2.volume) return -1;
        else if (e1.volume == e2.volume) return 0;
        else return 1;
    }

}
