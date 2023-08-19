package Terminal.terminale.Controller;

import Terminal.terminale.Custom.AppData;
import Terminal.terminale.Custom.ResponceMsg;
import Terminal.terminale.TerminalServ.Implements.implement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/terminal")
public class AppController {
    @Autowired
    private implement serverService;

    @GetMapping("/list")
    public ResponseEntity<ResponceMsg> getServers() throws InterruptedException {
        return ResponseEntity.ok(
                ResponceMsg.builder()
                        .timeStamp(now())
                        .data(of("terminals", serverService.list(5)))
                        .message("Terminals retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<ResponceMsg> saveServer(@RequestBody @Valid AppData terminal) {
        return ResponseEntity.ok(
                ResponceMsg.builder()
                        .timeStamp(now())
                        .data(of("Terminal", serverService.Create(terminal)))
                        .message("terminal created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponceMsg> deleteServer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                ResponceMsg.builder()
                        .timeStamp(now())
                        .data(of("deleted", serverService.delete(id)))
                        .message("Server deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
