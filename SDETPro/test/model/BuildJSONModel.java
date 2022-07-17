package test.model;

import com.google.gson.Gson;

public class BuildJSONModel {

    public static String parseJSONtoString(PostBody postBody) {
        if (postBody == null) {
            throw new IllegalArgumentException("POST body can't be null");
        }
        return new Gson().toJson(postBody);
    }
}
