package c332030.ddns.model.config.url;

import c332030.utils.data.model.interfaces.CConf;
import c332030.utils.tools.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DnspodUrlConf implements CConf {

    private static final long serialVersionUID = -2928761261521013524L;

    private String version;
    public static final String VERSION = "version";

    @Autowired
    private UserUrlConf user;
    public static final String USER = "user";

    @Autowired
    private DomainUrlConf domain;
    public static final String DOMAIN = "domain";

    @Autowired
    private RecordUrlConf record;
    public static final String RECORD = "record";

    @Override
    public boolean setProperties(Map<String, Object> confMap) {
        if(null == confMap
                || confMap.isEmpty()
            ) {
            return false;
        }

        version = Tools.dealNull(confMap.get(VERSION));

        boolean notFailure = true;

        if(null != user) {

            Object obj = confMap.get(USER);
            if(!(obj instanceof Map)
                    || !user.setProperties((Map<String, Object>)obj)
                ) {
                notFailure = false;
            }
        }

        if(null != domain) {

            Object obj = confMap.get(DOMAIN);
            if(!(obj instanceof Map)
                    || !domain.setProperties((Map<String, Object>)obj)
                ) {
                notFailure = false;
            }
        }

        if(null != record) {

            Object obj = confMap.get(RECORD);
            if(!(obj instanceof Map)
                    || !record.setProperties((Map<String, Object>)obj)
                ) {
                notFailure = false;
            }
        }

        return notFailure;

    }

    @Override
    public String toString() {
        return "DnspodUrlConf{" +
                "version='" + version + '\'' +
                ", user=" + user +
                ", domain=" + domain +
                ", record=" + record +
                '}';
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    public UserUrlConf getUser() {
        return user;
    }
    public void setUser(UserUrlConf user) {
        this.user = user;
    }

    public DomainUrlConf getDomain() {
        return domain;
    }
    public void setDomain(DomainUrlConf domain) {
        this.domain = domain;
    }

    public RecordUrlConf getRecord() {
        return record;
    }
    public void setRecord(RecordUrlConf record) {
        this.record = record;
    }
}
