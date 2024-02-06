package com.ghostAPI.app.config;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name = "response")
public class ResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int status;
    private String body;

    @ElementCollection
    @CollectionTable(name = "response_headers", joinColumns = @JoinColumn(name = "response_id"))
    @MapKeyColumn(name = "header_key")
    @Column(name = "header_value")
    private Map<String, String> headers;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "id=" + id +
                ", status=" + status +
                ", body='" + body + '\'' +
                ", headers=" + headers +
                '}';
    }
}
