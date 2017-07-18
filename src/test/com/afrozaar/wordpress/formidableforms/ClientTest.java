package com.afrozaar.wordpress.formidableforms;

import com.afrozaar.wordpress.formidableforms.model.Entry;

import org.junit.Test;

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
}