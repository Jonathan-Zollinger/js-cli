package lol.pbu;

import io.micronaut.http.HttpResponse;
import jakarta.inject.Inject;
import lol.pbu.model.Email;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "js-cli", description = """
@|fg(69;163;197)                       .xvvvvvvvvvvvvvvvvvx.|@
@|fg(69;163;197)                   fvvvvvvvvvvvvvvvvvvvvvvvvvvvj|@
@|fg(69;163;197)                vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv|@
@|fg(69;163;197)             rvvvvvvvvvvvvvi           ivvvvvvvvvvvvvr|@
@|fg(69;163;197)           vvvvvvvvvvv.                     .vvvvvvvvvvv|@
@|fg(69;163;197)         xvvvvvvvvv                             vvvvvvvvvx|@
@|fg(69;163;197)        vvvvvvvvI                                 ;vvvvvvvv|@
@|fg(69;163;197)      (vvvvvvvi                                     !vvvvvvv||@
@|fg(69;163;197)     vvvvvvvv       -vvvvvvvvv.     .vvvvvvvvv-       vvvvvvvv|@
@|fg(69;163;197)    vvvvvvv_     vvvvvvvvvvvvvvvvfvvvvvvvvvvvvvvvv     +vvvvvvv|@
@|fg(69;163;197)   |vvvvvv:    vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv    :vvvvvv||@
@|fg(69;163;197)   vvvvvv_    vvvvvvvvv-. :rvvvvvvvvvvv/, .-vvvvvvvvv    +vvvvvv|@
@|fg(69;163;197)  vvvvvvv    vvvvvvv.         .vvvvv          .vvvvvvv    vvvvvvv|@
@|fg(69;163;197)  vvvvvv    vvvvvvv             `v.             vvvvvvv    vvvvvv|@
@|fg(69;163;197) rvvvvvv    vvvvvv.                             .vvvvvv    vvvvvvr|@
@|fg(69;163;197) vvvvvv1    vvvvvv                               vvvvvv    1vvvvvv|@
@|fg(69;163;197) vvvvvv'    vvvvvvv                             vvvvvvv     vvvvvv|@
@|fg(69;163;197) vvvvvv'    'vvvvvv.                           .vvvvvv`     vvvvvv|@
@|fg(69;163;197) vvvvvv(     xvvvvvv"                         ^vvvvvvx     (vvvvvv|@
@|fg(69;163;197) fvvvvvv      vvvvvvvn                       xvvvvvvv      vvvvvvf|@
@|fg(69;163;197)  vvvvvv       jvvvvvvv.                   .vvvvvvvj       vvvvvv|@
@|fg(69;163;197)  vvvvvvv        vvvvvvvv.                vvvvvvvv        vvvvvvv|@
@|fg(69;163;197)   vvvvvv1        nvvvvvvvv`           'vvvvvvvvn        1vvvvvv|@
@|fg(69;163;197)   }vvvvvvi         vvvvvvvvvx       xvvvvvvvvv         ivvvvvv[|@
@|fg(69;163;197)    nvvvvvv1          vvvvvvvvvv> >vvvvvvvvvv          1vvvvvvn|@
@|fg(69;163;197)     vvvvvvvv           tvvvvvvvvvvvvvvvvvf           vvvvvvvv|@
@|fg(69;163;197)      {vvvvvvv-           .vvvvvvvvvvvvv.           -vvvvvvv}|@
@|fg(69;163;197)        vvvvvvvv+         -vvvvvvvvvvvvvx         +vvvvvvvv|@
@|fg(69;163;197)         fvvvvvvvvv    .vvvvvvvvvvvvvvvvvvv-    vvvvvvvvvf|@
@|fg(69;163;197)           nvvvvvvvvvvvvvvvvvvvv   vvvvvvvvvvvvvvvvvvvvn|@
@|fg(69;163;197)             |vvvvvvvvvvvvvvv;        vvvvvvvvvvvvvvv||@
@|fg(69;163;197)                vvvvvvvvvvr             ^vvvvvvvvvv|@
@|fg(69;163;197)                   }vvvv                   +vvv}|@
""",
        mixinStandardHelpOptions = true)
public class JustServeCliCommand implements Runnable {

    @Option(names = {"-e", "--email"}, description = "Email address", required = true)
    private String email;

    @Inject
    JustServeClient justServeClient;

    public void run() {
        HttpResponse<String> response = justServeClient.getTempPassword(new Email(email));
        if (response.code() != 200) {
            System.out.println(response.body());
        }else {
            System.out.println("Error: received status code " + response.code());
        }
    }
}
