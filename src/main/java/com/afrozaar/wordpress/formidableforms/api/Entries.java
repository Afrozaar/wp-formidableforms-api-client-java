package com.afrozaar.wordpress.formidableforms.api;

import com.afrozaar.wordpress.formidableforms.model.Entry;

import java.util.List;

public interface Entries {

    List<Entry> getEntries();

    Entry getEntry(Long id);

    Entry updateEntry(Entry entry);

    Entry deleteEntry(Entry entry);

}