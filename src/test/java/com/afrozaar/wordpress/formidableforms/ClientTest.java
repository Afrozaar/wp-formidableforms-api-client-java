package com.afrozaar.wordpress.formidableforms;

import static java.lang.String.format;

import com.afrozaar.wordpress.formidableforms.model.Entry;
import com.afrozaar.wordpress.wpapi.v2.config.ClientConfig;

import com.google.common.base.MoreObjects;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

/**
 * @author johan
 */
public class ClientTest {

    @Test
    public void testEntry() {

        String baseUrl = "http://localhost";
        String username = "";
        String password = "";
        Client client = new Client(baseUrl, username, password, true, true);

        Entry entry = new Entry();
        entry.setId("109");
        client.deleteEntry(entry);
    }

    private static ClientConfig resolveConfig() {
        try {
            Resource userResource = new ClassPathResource(format("/config/%s-test.yaml", InetAddress.getLocalHost().getHostName()));
            Resource resourceToUse = userResource.exists() ? userResource : new ClassPathResource("/config/docker-test.yaml");
            return ClientConfig.load(resourceToUse);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Can not run tests without a configuration. Please ensure you have a valid configuration in ${project}/src/test/resources/config/<hostname>-test.yaml");
        }
    }

    @Ignore
    @Test
    public void test() {

        final ClientConfig config= resolveConfig();
        final ClientConfig.Wordpress wc = config.getWordpress();

        Client client = new Client(wc.getBaseUrl(), wc.getUsername(), wc.getPassword(), false, true);

        final List<Entry> entries = client.getEntries();

        System.out.println("entries = " + entries.size());

    }

    String configToString(ClientConfig config) {
        final ClientConfig.Wordpress wordpress = config.getWordpress();
        return MoreObjects.toStringHelper(config)
                .add("debug", config.isDebug())
                .add("wordpress", ToStringBuilder.reflectionToString(wordpress)).toString();
    }
}