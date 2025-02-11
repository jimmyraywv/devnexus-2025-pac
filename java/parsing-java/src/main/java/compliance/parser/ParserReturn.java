package compliance.parser;

import java.util.Map;
import java.util.Objects;

/**
 * ParserReturn
 *
 * @author jimmyray
 * @version 1.0
 *
 * Contains JSON and Map<String, Object> from Jackson object mapper
 */

public class ParserReturn {

    public ParserReturn(Map<String, Object> map, String json) {
        this.map = map;
        this.json = json;
    }

    private Map<String, Object> map;
    private String json;


    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    @Override
    public String toString() {
        return "ParserReturn{" +
                "map=" + map +
                ", json='" + json + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ParserReturn that = (ParserReturn) o;
        return Objects.equals(map, that.map) && Objects.equals(json, that.json);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map, json);
    }
}
