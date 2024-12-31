package lol.pbu

import io.micronaut.http.HttpResponse
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class JustServeClientSpec extends Specification {

    @Inject
    JustServeClient justServeClient

    def "PostTempPassword"() {
        when:
        HttpResponse<String> response = justServeClient.getTempPassword("jonathan.zollinger+jimmyHook@gmail.com")

        then:
        noExceptionThrown()

        and:
        response.code() == 200
    }
}
