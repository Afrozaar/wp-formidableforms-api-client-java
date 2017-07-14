package com.afrozaar.wordpress.formidableforms.api;

import com.afrozaar.wordpress.formidableforms.model.Entry;
import com.afrozaar.wordpress.formidableforms.model.Form;

import java.util.List;

public interface Forms {

    List<Entry> getEntries(long formId);

    List<Form> getForms();

    Form getForm(Long id);

    Form updateForm(Form form);

    Form deleteForm(Form form);

}