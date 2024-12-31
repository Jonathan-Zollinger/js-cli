package lol.pbu

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
class JustServeCliCommandSpec extends Specification {

    @Shared @AutoCleanup ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)

    def testWithJimmyEmail() {
        when:
        ByteArrayOutputStream baos = new ByteArrayOutputStream()
        System.setOut(new PrintStream(baos))

        String[] args = ['-e', 'jonathan.zollinger+jimmyHook@gmail.com']
        PicocliRunner.run(JustServeCliCommand, ctx, args)

        then:
        noExceptionThrown()

        and:
        !baos.toString().contains("error")
    }
}

