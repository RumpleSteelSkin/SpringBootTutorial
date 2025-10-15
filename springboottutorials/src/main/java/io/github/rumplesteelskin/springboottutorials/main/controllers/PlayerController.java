package io.github.rumplesteelskin.springboottutorials.main.controllers;

import io.github.rumplesteelskin.springboottutorials.main.entities.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("player")
public class PlayerController {


    //Basic Response
    @GetMapping("BasicResponse/{id}")
    public Player BasicResponsePlayer(@PathVariable(name = "id") long playerId) {
        return new Player(playerId, "John Doe", 33);
    }


    // Advance Response 1
    @GetMapping("AdvanceResponse1/{id}")
    public ResponseEntity<?> AdvanceResponse1Player(@PathVariable(name = "id") long playerId) {
        Player player = new Player(playerId, "John Doe", 33);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }


    // Advance Response 2
    @GetMapping("AdvanceResponse2/{id}")
    public ResponseEntity<?> AdvanceResponse2Player(@PathVariable(name = "id") long playerId) {
        Player player = new Player(playerId, "John Doe", 33);
        return ResponseEntity.status(HttpStatus.OK).body(player);
    }


    //Advance Response 3
    @GetMapping("AdvanceResponse3/{id}")
    public ResponseEntity<?> AdvanceResponse3Player(@PathVariable(name = "id") long playerId) {
        Player player = new Player(playerId, "John Doe", 33);
        return ResponseEntity.ok().body(player);
    }

    //Advance Response 4
    @GetMapping("AdvanceResponse4/{id}")
    public ResponseEntity<?> AdvanceResponse4Player(@PathVariable(name = "id") long playerId) {
        Player player = new Player(playerId, "John Doe", 33);
        return ResponseEntity.ok(player);
    }

    //Advance Multi Response
    @GetMapping("AdvanceMultiResponse/{id}")
    public ResponseEntity<?> AdvanceMultiResponsePlayer(@PathVariable(name = "id") long playerId) {
        if (playerId < 1) {
            return ResponseEntity.notFound().build();
        }
        Player player = new Player(playerId, "John Doe", 33);
        return ResponseEntity.ok(player);
    }


    //Change Content Type
    @GetMapping("ChangeContentType/{id}")
    public ResponseEntity<?> ChangeContentTypePlayer(@PathVariable(name = "id") long playerId) {
        Player player = new Player(playerId, "John Doe", 33);
        return ResponseEntity.ok().contentType(new MediaType("application", "json", StandardCharsets.UTF_8)).body(player);
    }


}
