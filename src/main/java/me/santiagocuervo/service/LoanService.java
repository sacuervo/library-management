package me.santiagocuervo.service;

import java.util.ArrayList;
import java.util.List;

import me.santiagocuervo.exception.NotFoundException;
import me.santiagocuervo.model.Loan;
import me.santiagocuervo.model.LoanState;

public class LoanService {
    private List<Loan> loans;
    private BookService bookService;
    private UserService userService;

    public LoanService(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
        this.loans = new ArrayList<>();
    }

    public void addLoan(String id, String isbn) {
        var user = userService.getUserById(id);
        var book = bookService.getBookByIsbn(isbn);
        loans.add(new Loan(user, book));
    }

    public void returnBook(String id, String isbn) {
        for (var loan : loans) {
            if (loan.getUser().getId().equals(id) &&
                    loan.getBook().getIsbn().equals(isbn) &&
                    loan.getState().equals(LoanState.STARTED)) {
                loan.setState(LoanState.FINISHED);
                return;
            }
        }

        throw new NotFoundException(
                String.format("No hay un préstamo del libro con ISBN '%s' para el cliente con ID '%s'.", isbn, id));
    }
}
