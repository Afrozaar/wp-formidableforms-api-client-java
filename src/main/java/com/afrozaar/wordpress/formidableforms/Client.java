package com.afrozaar.wordpress.formidableforms;

import static java.lang.String.format;

import com.afrozaar.wordpress.formidableforms.api.Entries;
import com.afrozaar.wordpress.formidableforms.api.Forms;
import com.afrozaar.wordpress.formidableforms.model.Entry;
import com.afrozaar.wordpress.formidableforms.model.Form;
import com.afrozaar.wordpress.wpapi.v2.*;
import com.afrozaar.wordpress.wpapi.v2.model.Link;
import com.afrozaar.wordpress.wpapi.v2.model.Post;
import com.afrozaar.wordpress.wpapi.v2.request.Request;
import com.afrozaar.wordpress.wpapi.v2.request.SearchRequest;
import com.afrozaar.wordpress.wpapi.v2.response.PagedResponse;
import com.afrozaar.wordpress.wpapi.v2.util.MavenProperties;
import com.afrozaar.wordpress.wpapi.v2.util.Tuple2;

import com.google.common.base.Preconditions;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.transform.Source;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;
import java.util.function.Predicate;

public class Client implements Forms, Entries {

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

    private final RestTemplate restTemplate;
    private final Predicate<Link> next = link -> Strings.NEXT.equals(link.getRel());
    private final Predicate<Link> previous = link -> Strings.PREV.equals(link.getRel());
    private final Tuple2<String, String> userAgentTuple;

    public final String baseUrl;
    private final String username;
    private final String password;
    private final boolean debug;
    public final boolean permalinkEndpoint;

    {
        Properties properties = MavenProperties.getProperties();
        userAgentTuple = Tuple2.of("User-Agent", format("%s/%s", properties.getProperty(ARTIFACT_ID), properties.getProperty(VERSION)));
    }

    public Client(String baseUrl, String username, String password, boolean usePermalinkEndpoint, boolean debug) {
        this(baseUrl, username, password, usePermalinkEndpoint, debug, null);
    }

    public Client(String baseUrl, String username, String password, boolean usePermalinkEndpoint, boolean debug, ClientHttpRequestFactory requestFactory) {
        this.baseUrl = baseUrl;
        this.username = username;
        this.password = password;
        this.debug = debug;
        this.permalinkEndpoint = usePermalinkEndpoint;

        final ObjectMapper emptyArrayAsNullObjectMapper = Jackson2ObjectMapperBuilder.json().featuresToEnable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT).build();

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new ByteArrayHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter());
        messageConverters.add(new ResourceHttpMessageConverter());
        messageConverters.add(new SourceHttpMessageConverter<Source>());
        messageConverters.add(new AllEncompassingFormHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter(emptyArrayAsNullObjectMapper));
        //messageConverters.add(new MappingJackson2HttpMessageConverter());
        restTemplate = new RestTemplate(messageConverters);

        if(requestFactory != null){;
            restTemplate.setRequestFactory(requestFactory);
        }

    }

    @Override
    public <T> PagedResponse<T> getPagedResponse(String context, Class<T> typeRef, String... expandParams) {
        return null;
    }

    @Override
    public <T> PagedResponse<T> getPagedResponse(URI uri, Class<T> typeRef) {
        return null;
    }

    @Override
    public <T> PagedResponse<T> traverse(PagedResponse<T> response, Function<PagedResponse<?>, String> direction) {
        return null;
    }

    @Override
    public <T> PagedResponse<T> search(SearchRequest<T> search) {
        return null;
    }

    @Override
    public List<Entry> getEntries() {
        return null;
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
        final ResponseEntity<Entry> exchange = doExchange1(Request.POST, HttpMethod.DELETE, Entry.class, forExpand(entry.getId()), null, null);
        Preconditions.checkArgument(exchange.getStatusCode().is2xxSuccessful());
        return exchange.getBody();
    }

    @Override
    public List<Entry> getEntries(long formId) {
        return null;
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
}
