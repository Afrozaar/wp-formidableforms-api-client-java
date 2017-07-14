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
        "item_key",
        "name",
        "ip",
        "meta",
        "form_id",
        "post_id",
        "user_id",
        "parent_item_id",
        "is_draft",
        "updated_by",
        "created_at",
        "updated_at"
})
public class Entry {

    @JsonProperty("id")
    private String id;
    @JsonProperty("item_key")
    private String itemKey;
    @JsonProperty("name")
    private String name;
    @JsonProperty("ip")
    private String ip;
    @JsonProperty("meta")
    private Map<String, String> meta;
    @JsonProperty("form_id")
    private String formId;
    @JsonProperty("post_id")
    private String postId;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("parent_item_id")
    private String parentItemId;
    @JsonProperty("is_draft")
    private String isDraft;
    @JsonProperty("updated_by")
    private String updatedBy;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
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

    @JsonProperty("item_key")
    public String getItemKey() {
        return itemKey;
    }

    @JsonProperty("item_key")
    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    @JsonProperty("meta")
    public Map<String, String> getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(Map<String, String> meta) {
        this.meta = meta;
    }

    @JsonProperty("form_id")
    public String getFormId() {
        return formId;
    }

    @JsonProperty("form_id")
    public void setFormId(String formId) {
        this.formId = formId;
    }

    @JsonProperty("post_id")
    public String getPostId() {
        return postId;
    }

    @JsonProperty("post_id")
    public void setPostId(String postId) {
        this.postId = postId;
    }

    @JsonProperty("user_id")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("parent_item_id")
    public String getParentItemId() {
        return parentItemId;
    }

    @JsonProperty("parent_item_id")
    public void setParentItemId(String parentItemId) {
        this.parentItemId = parentItemId;
    }

    @JsonProperty("is_draft")
    public String getIsDraft() {
        return isDraft;
    }

    @JsonProperty("is_draft")
    public void setIsDraft(String isDraft) {
        this.isDraft = isDraft;
    }

    @JsonProperty("updated_by")
    public String getUpdatedBy() {
        return updatedBy;
    }

    @JsonProperty("updated_by")
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
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