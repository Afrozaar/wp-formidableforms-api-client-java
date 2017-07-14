package com.afrozaar.wordpress.formidableforms.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "form_key",
        "name",
        "description",
        "parent_form_id",
        "logged_in",
        "is_template",
        "created_at",
        "link",
        "_links"
})
public class Form {

    @JsonProperty("id")
    private String id;
    @JsonProperty("form_key")
    private String formKey;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("parent_form_id")
    private String parentFormId;
    @JsonProperty("logged_in")
    private String loggedIn;
    @JsonProperty("is_template")
    private String isTemplate;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("link")
    private String link;
    @JsonProperty("_links")
    private Links links;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("form_key")
    public String getFormKey() {
        return formKey;
    }

    @JsonProperty("form_key")
    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("parent_form_id")
    public String getParentFormId() {
        return parentFormId;
    }

    @JsonProperty("parent_form_id")
    public void setParentFormId(String parentFormId) {
        this.parentFormId = parentFormId;
    }

    @JsonProperty("logged_in")
    public String getLoggedIn() {
        return loggedIn;
    }

    @JsonProperty("logged_in")
    public void setLoggedIn(String loggedIn) {
        this.loggedIn = loggedIn;
    }

    @JsonProperty("is_template")
    public String getIsTemplate() {
        return isTemplate;
    }

    @JsonProperty("is_template")
    public void setIsTemplate(String isTemplate) {
        this.isTemplate = isTemplate;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("_links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("_links")
    public void setLinks(Links links) {
        this.links = links;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}