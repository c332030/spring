package c332030.ddns.model;

import c332030.utils.data.model.interfaces.C;
import org.springframework.stereotype.Component;

@Component
public class Dnspod implements C {
    private static final long serialVersionUID = -1829450379163411972L;



    @Override
    public boolean isEmpty() {
        return false;
    }
}
