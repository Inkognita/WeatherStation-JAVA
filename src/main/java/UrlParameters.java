import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class UrlParameters {
    private HashMap<String, String> parameters;

    public UrlParameters() {
        parameters = new HashMap<String, String>();
    }

    public void setParameter(String key, String value) {
        parameters.put(key, value);
    }

    public void removeParameter(String key){
        if(contains(key)){
            parameters.remove(key);
        }
    }
    public Boolean contains(String key) {
        return parameters.containsKey(key);
    }

    public String getValue(String key) {
        return parameters.get(key);
    }

    public String encode() {
        String res = "";
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            try {
                String encodedKey = URLEncoder.encode(parameter.getKey(), "UTF-8");
                String encodedValue = URLEncoder.encode(parameter.getValue(), "UTF-8");
                res += String.format("&%s=%s", encodedKey, encodedValue);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (res.length() > 0) {
            return res.substring(1);
        }
        return "";
    }
}
