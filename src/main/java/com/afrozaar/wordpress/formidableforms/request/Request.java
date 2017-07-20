package com.afrozaar.wordpress.formidableforms.request;

import java.util.List;
import java.util.Map;

public abstract class Request extends com.afrozaar.wordpress.wpapi.v2.request.Request {
    public static final String FORMS = "/forms";
    public static final String FORM = "/forms/{id}";
    public static final String FORM_ENTRIES = "/forms/{id}/entries";
    public static final String ENTRIES = "/entries";
    public static final String ENTRY = "/entries/{id}";

    public Request(String uri, Map<String, List<String>> params) {
        super(uri, params);
    }
}
