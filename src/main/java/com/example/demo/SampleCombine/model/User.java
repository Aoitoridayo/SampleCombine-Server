package com.example.demo.SampleCombine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class User {
    @JsonProperty("sid")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private HashMap<String, Memo> memos;

    public User(String id, String name, HashMap<String, Memo> memos) {
        this.id = id;
        this.name = name;
        this.memos = memos;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Collection<Memo> getMemos() {
        return memos.values();
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Memo createMemo(String title, String description) {
        Memo memo = new Memo();
        UUID uuid = UUID.randomUUID();
        memo.setId(uuid.toString());
        memo.setTitle(title);
        memo.setDescription(description);
        memos.put(memo.getId(), memo);
        return memo;
    }
    public void deleteMemo(String id) {
        memos.remove(id);
    }
}
