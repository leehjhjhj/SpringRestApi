package crudtest.restcrud.repository;

import crudtest.restcrud.domain.Board;

import java.util.List;

public interface BoardRepository {
    void save(Board board);

    Board findById(Long id);

    List<Board> findAll();

    void deleteById(Long id);
}
