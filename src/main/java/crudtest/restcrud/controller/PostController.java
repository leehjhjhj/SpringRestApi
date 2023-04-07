package crudtest.restcrud.controller;

import crudtest.restcrud.domain.Board;
import crudtest.restcrud.dto.BoardUpdateDto;
import crudtest.restcrud.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {
    private final BoardService boardService;

    @GetMapping("")
    public List<Board> getPosts() {
        return boardService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Board> savePost(@RequestBody Board board) {
        boardService.save(board);
        return ResponseEntity.status(HttpStatus.CREATED).body(board);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Board> getPost(@PathVariable Long id) {
        Optional<Board> board = boardService.findById(id);
        return board.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        boardService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Board> update(@PathVariable Long id, @RequestBody BoardUpdateDto updateDto) {
        Board updateBoard = boardService.update(id, updateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(updateBoard);
    }
}
