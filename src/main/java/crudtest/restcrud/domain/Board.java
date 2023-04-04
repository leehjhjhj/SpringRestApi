package crudtest.restcrud.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;

    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    @Builder
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
        this.createDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
    }
}
