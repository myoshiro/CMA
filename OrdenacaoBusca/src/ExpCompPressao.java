import java.util.*;
public class ExpCompPressao implements Comparator <Experimento> {

    public int compare(Experimento e1, Experimento e2) {
        if (e1.pressao < e2.pressao) return -1;
        else if (e1.pressao == e2.pressao) return 0;
        else return 1;
    }

}
