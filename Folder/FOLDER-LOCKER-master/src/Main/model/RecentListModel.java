package Main.model;

import java.io.Serializable;
import java.util.List;

public class RecentListModel implements Serializable {
    private  static  final long serialVersionUID=2L;
    List<String>recentlist;
    public RecentListModel(){

    }

    public RecentListModel(List<String> recentlist) {
        this.recentlist = recentlist;
    }

    public List<String> getRecentlist() {
        return recentlist;
    }

    public void setRecentlist(List<String> recentlist) {
        this.recentlist = recentlist;
    }
}
