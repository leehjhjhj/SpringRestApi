package crudtest.restcrud.service;

import crudtest.restcrud.domain.Board;
import crudtest.restcrud.dto.BoardUpdateDto;
import crudtest.restcrud.repository.BoardRepository;
import crudtest.restcrud.repository.BoardRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;
import java.time.LocalDateTime;
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

    public Optional<Board> findById(Long id) {
        return Optional.ofNullable(boardRepository.findById(id));
    }
    @Transactional
    public Board update(Long id, BoardUpdateDto updateDto) {
        Board board = boardRepository.findById(id);
        board.setTitle(updateDto.getContent());
        board.setContent(updateDto.getContent());
        board.setModifiedDate(LocalDateTime.now());
        return board;
    }

    @Transactional
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
