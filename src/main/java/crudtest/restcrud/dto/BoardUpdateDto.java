package crudtest.restcrud.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class BoardUpdateDto {
    private String title;
    private String content;
}
