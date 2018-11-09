package c332030.ddns.dnspod;

import c332030.ddns.model.Domain;
import c332030.ddns.model.config.url.DomainUrlConf;
import c332030.utils.data.model.interfaces.C;
import c332030.utils.tools.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainService implements C {
    private static final long serialVersionUID = 2993446732777496380L;

    @Autowired
    private DnspodService dnspodService;

    @Autowired
    private DomainUrlConf domainUrlConf;

    /**
     * 获取域名信息
     * @param domainStr
     * @return
     */
    public Domain getDomainInfo(String domainStr) {
        if(Tools.isEmpty(domainStr)) {
            return null;
        }

        String url = domainUrlConf.getList();

        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
