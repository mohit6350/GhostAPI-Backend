package com.ghostAPI.app.config;

import jakarta.persistence.*;

@Entity
public class WireMockStubEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", length = 1048576000)
    private String jsonBody;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJsonBody() {
        return jsonBody;
    }

    public void setJsonBody(String jsonBody) {
        this.jsonBody = jsonBody;
    }

    @Override
    public String toString() {
        return "WireMockStubEntity{" +
                "id=" + id +
                ", jsonBody='" + jsonBody + '\'' +
                '}';
    }
}
