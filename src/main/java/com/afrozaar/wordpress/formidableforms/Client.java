package com.afrozaar.wordpress.formidableforms;

import static com.google.common.collect.ImmutableMap.of;
import static java.lang.String.format;

import com.afrozaar.wordpress.formidableforms.api.Entries;
import com.afrozaar.wordpress.formidableforms.api.Forms;
import com.afrozaar.wordpress.formidableforms.model.Entry;
import com.afrozaar.wordpress.formidableforms.model.Form;
import com.afrozaar.wordpress.formidableforms.request.Request;
import com.afrozaar.wordpress.formidableforms.response.ResponseParser;
import com.afrozaar.wordpress.wpapi.v2.Strings;
import com.afrozaar.wordpress.wpapi.v2.model.Link;
import com.afrozaar.wordpress.wpapi.v2.request.SearchRequest;
import com.afrozaar.wordpress.wpapi.v2.response.PagedResponse;
import com.afrozaar.wordpress.wpapi.v2.util.MavenProperties;
import com.afrozaar.wordpress.wpapi.v2.util.Tuple2;

import com.google.common.base.Preconditions;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;

import com.fasterxml.jackson.databind.JsonNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;
import java.util.function.Predicate;

public class Client extends com.afrozaar.wordpress.wpapi.v2.Client implements Forms, Entries {

    public static String CONTEXT = "/wp-json/frm/v2";

    private static final Logger LOG = LoggerFactory.getLogger(Client.class);
    private static final String META_KEY = "key";
    private static final String META_VALUE = "value";
    private static final String FORCE = "force";
    private static final String CONTEXT_ = "context";
    private static final String REASSIGN = "reassign";
    private static final String VIEW = "view";
    private static final String DATA = "data";
    private static final String VERSION = "version";
    private static final String ARTIFACT_ID = "artifactId";

    private final Predicate<Link> next = link -> Strings.NEXT.equals(link.getRel());
    private final Predicate<Link> previous = link -> Strings.PREV.equals(link.getRel());
    private final Tuple2<String, String> userAgentTuple;

    {
        Properties properties = MavenProperties.getProperties();
        userAgentTuple = Tuple2.of("User-Agent", format("%s/%s", properties.getProperty(ARTIFACT_ID), properties.getProperty(VERSION)));
    }

    public Client(String baseUrl, String username, String password, boolean usePermalinkEndpoint, boolean debug) {
        this(baseUrl, username, password, usePermalinkEndpoint, debug, null);
    }

    public Client(String baseUrl, String username, String password, boolean usePermalinkEndpoint, boolean debug, ClientHttpRequestFactory requestFactory) {
        super(CONTEXT, baseUrl, username, password, usePermalinkEndpoint, debug, requestFactory);
    }

    public <T> List<T> getExhaustiveCollection(String context, Class<T> clazz, Object... forExpand) {
        final Predicate<List<T>> hasMore = collection -> !collection.isEmpty();

        final Function<Map<String, Object>, ResponseEntity<JsonNode>> getWithQueryMap = queryMap ->
                doCustomExchange(context, HttpMethod.GET, JsonNode.class, forExpand(forExpand), queryMap, null, null);

        int page = 1;
        ResponseEntity<JsonNode> exchange = getWithQueryMap.apply(of("page", page));

        final List<T> collector = new ArrayList<>();
        List<T> items;
        while (hasMore.test((items = ResponseParser.fromObjectResponse(exchange.getBody(), clazz)))) {
            collector.addAll(items);
            exchange = getWithQueryMap.apply(of("page", page++));
        }

        return collector;
    }


    @Override
    public <T> PagedResponse<T> search(SearchRequest<T> search) {
        return null;
    }

    @Override
    public List<Entry> getEntries() {
        return getExhaustiveCollection(Request.ENTRIES, Entry.class);
    }

    @Override
    public Entry getEntry(Long id) {
        return null;
    }

    @Override
    public Entry updateEntry(Entry entry) {
        return null;
    }

    @Override
    public Entry deleteEntry(Entry entry) {
        final ResponseEntity<Entry> exchange = doCustomExchange(Request.ENTRIES, HttpMethod.DELETE, Entry.class, forExpand(entry.getId()), null,null, null);
        Preconditions.checkArgument(exchange.getStatusCode().is2xxSuccessful());
        return exchange.getBody();
    }

    @Override
    public List<Entry> getEntries(long formId) {
        final ResponseEntity<Entry[]> exchange = doCustomExchange(Request.FORM_ENTRIES, HttpMethod.GET, Entry[].class, forExpand(formId), null, null, null);
        return Arrays.asList(exchange.getBody());
    }

    @Override
    public List<Form> getForms() {
        return null;
    }

    @Override
    public Form getForm(Long id) {
        return null;
    }

    @Override
    public Form updateForm(Form form) {
        return null;
    }

    @Override
    public Form deleteForm(Form form) {
        return null;
    }

    static Object[] forExpand(Object... values) {
        return values;
    }
}
