package com.afrozaar.wordpress.formidableforms.api;

import com.afrozaar.wordpress.formidableforms.model.Entry;
import com.afrozaar.wordpress.formidableforms.model.Response;

import java.util.List;
import java.util.Map;

public interface Entries {

    List<Entry> getEntries();

    Entry getEntry(long id);

    Response updateEntry(long id, Map<String, String> updatedValues);

    Entry deleteEntry(Entry entry);

}