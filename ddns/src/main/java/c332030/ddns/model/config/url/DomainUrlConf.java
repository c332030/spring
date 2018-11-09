package c332030.ddns.model.config.url;

import c332030.utils.data.model.interfaces.CConf;
import c332030.utils.tools.Tools;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DomainUrlConf implements CConf {
    private static final long serialVersionUID = -7729163228646276899L;

    private String create;
    public static final String CREATE = "create";

    private String list;
    public static final String LIST = "list";

    private String remove;
    public static final String REMOVE = "remove";

    private String info;
    public static final String INFO = "info";

    private String log;
    public static final String LOG = "log";

    private String search;
    public static final String SEARCH = "search";

    private String share;
    public static final String SHARE = "share";

    private String shareList;
    public static final String SHARE_LIST = "shareList";

    private String modify;
    public static final String MODIFY = "modify";

    @Override
    public boolean setProperties(Map<String, Object> confMap) {

        if(null == confMap
                || confMap.isEmpty()
            ) {
            return false;
        }

        create = Tools.dealNull(confMap.get(CREATE));
        list = Tools.dealNull(confMap.get(LIST));
        remove = Tools.dealNull(confMap.get(REMOVE));
        info = Tools.dealNull(confMap.get(INFO));
        log = Tools.dealNull(confMap.get(LOG));
        search = Tools.dealNull(confMap.get(SEARCH));
        share = Tools.dealNull(confMap.get(SHARE));
        shareList = Tools.dealNull(confMap.get(SHARE_LIST));
        modify = Tools.dealNull(confMap.get(MODIFY));

        return true;
    }

    @Override
    public String toString() {
        return "DomainUrlConf{" +
                "create='" + create + '\'' +
                ", list='" + list + '\'' +
                ", remove='" + remove + '\'' +
                ", info='" + info + '\'' +
                ", log='" + log + '\'' +
                ", search='" + search + '\'' +
                ", share='" + share + '\'' +
                ", shareList='" + shareList + '\'' +
                ", modify='" + modify + '\'' +
                '}';
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getRemove() {
        return remove;
    }

    public void setRemove(String remove) {
        this.remove = remove;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getShareList() {
        return shareList;
    }

    public void setShareList(String shareList) {
        this.shareList = shareList;
    }

    public String getModify() {
        return modify;
    }

    public void setModify(String modify) {
        this.modify = modify;
    }
}
