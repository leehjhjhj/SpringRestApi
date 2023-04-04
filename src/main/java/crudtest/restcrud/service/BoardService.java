package crudtest.restcrud.service;

import crudtest.restcrud.domain.Board;
import crudtest.restcrud.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    @Transactional
    public void save(Board board) {
        boardRepository.save(board);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board findById(Long id) {
        return boardRepository.findById(id);
    }

//    public Board update(Long id, Board board) {
//    }
    @Transactional
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
