package c332030.ddns.dnspod;

import c332030.ddns.model.Record;
import c332030.ddns.model.config.url.RecordUrlConf;
import c332030.utils.data.model.interfaces.C;
import c332030.utils.tools.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService implements C {
    private static final long serialVersionUID = -4028049720311010918L;

    @Autowired
    private RecordUrlConf recordUrlConf;

    @Autowired
    private DnspodService dnspodService;

    public Record[] getRecords() {
        return null;
    }

    public boolean updateRecordIP(String recordName, String ip) {
        if(Tools.isEmpty(recordName)
                || Tools.isEmpty(ip)
            ) {
            return false;
        }

        Record[] records = getRecords();
        if(null == records
                || 0 < records.length
            ) {
            return false;
        }

        Record[] recordsUpdate = new Record[records.length];

        int i = 0;
        for(Record record: records) {
            if(recordName.equals(record.getName())) {

                record.setValue(ip);
                recordsUpdate[i++] = record;
            }
        }

        return updateRecord(recordsUpdate);
    }

    /**
     * 批量更新记录
     * @param records
     * @return
     */
    public boolean updateRecord(Record[] records) {
        if(Tools.isEmpty(records)) {
            return false;
        }

        for(Record record: records) {
            if(!updateRecord(record)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 更新记录
     * @param record
     * @return
     */
    public boolean updateRecord(Record record) {
        return null != record
                && !record.isEmpty();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
