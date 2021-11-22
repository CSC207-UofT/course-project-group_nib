package Controller;

import Data.UserInfoAccess;
import Entity.Note.Notes;
import UseCase.NoteCreation;
import UserInterface.InterfaceEntity.NoteCreateForm;

import java.util.Scanner;

public class MainPageController {
    private final String username;

    public MainPageController(String username) {
        this.username = username;
    }

    public Notes createNote(NoteCreateForm form) {
        NoteCreation noteCreation = new NoteCreation();
        Notes note = noteCreation.createNote(
                form.getCategory(),
                form.getTitle(),
                form.getDate(),
                form.getContent(),
                form.getReferences(),
                form.isEditable(),
                form.isReferable(),
                form.isCommentable()
        );
        return note;
    }
}
