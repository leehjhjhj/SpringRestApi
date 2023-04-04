package crudtest.restcrud.controller;

import crudtest.restcrud.domain.Board;
import crudtest.restcrud.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void savePost(@RequestBody Board board) {
        boardService.save(board);
    }

    @GetMapping("/{id}")
    public Board getPost(@PathVariable Long id) {
        return boardService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        boardService.delete(id);
    }
}
