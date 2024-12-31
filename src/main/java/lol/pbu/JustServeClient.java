package lol.pbu;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.client.annotation.Client;

@Client(id = "justServe")
@Header(name = "Authorization", value = "Bearer ${justserve.key}")
@Header(name = "Content-Type", value = "application/json")
interface JustServeClient {

    @Post("/users/hash")
    @Produces(MediaType.APPLICATION_JSON)
    HttpResponse<String> postTempPassword(@JsonProperty("Email") String email);
}
