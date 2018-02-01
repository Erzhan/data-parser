package kz.kaznu.parser.models;

/**
 * Created by yerzhan.khibatkhanuly on 2/1/18.
 */
public class Company {

    private String _id;
    private String domain;
    private String name;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
