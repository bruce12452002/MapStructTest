package bean;

import java.util.List;

public class Eee {
    private int id;
    private String name;
    List<String> idNames;

    public Eee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIdNames() {
        return idNames;
    }

    public void setIdNames(List<String> idNames) {
        this.idNames = idNames;
    }
}
