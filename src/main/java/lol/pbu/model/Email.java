package lol.pbu.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Email(@JsonProperty("Email") String address) {}
