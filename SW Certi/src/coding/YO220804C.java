package coding;

public class YO220804C {
}
/*

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.time.format.DateTimeFormatter;

import java.time.ZonedDateTime;
import java.time.ZoneId;

@RestController
class HealthcheckController {

    @GetMapping(value = "/healthcheck")
    public ResponseEntity<Res> healthcheck(@RequestParam String format) {
        Res res = new Res();

        if ("short".equals(format)) {
            res.setStatus("OK");
            return ResponseEntity.status(HttpStatus.OK).body(res);
        } else if ("full".equals(format)) {
            res.setStatus("OK");
            res.setCurrentTime(ZonedDateTime.now(ZoneId.of("Asia/Seoul")).format( DateTimeFormatter.ISO_INSTANT ));
            return ResponseEntity.status(HttpStatus.OK).body(res);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        }
    }

    @PutMapping(value = "/healthcheck")
    public ResponseEntity healthcheckPut() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("{}");
    }

    @PostMapping(value = "/healthcheck")
    public ResponseEntity healthcheckPost() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("{}");
    }


    @DeleteMapping(value = "/healthcheck")
    public ResponseEntity healthcheckDelete() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("{}");
    }

}

class Res {
    private String status;
    private String currentTime;

    public String getStatus() {return this.status;}
    public void setStatus(String status) {this.status=status;}
    public String getCurrentTime() {return this.currentTime;}
    public void setCurrentTime(String currentTime) {this.currentTime = currentTime;}

}
*/

