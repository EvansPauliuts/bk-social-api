package com.evansdev.book.book;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
@Tag(name = "Book")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Integer> saveBook(
            @RequestBody @Valid BookRequest bookRequest,
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(bookService.save(bookRequest, connectedUser));
    }

}
