package Java.Controller;

import Java.Data.UserInfoAccess;
import Entity.Note.Notes;
import Java.UseCase.NoteCreation;
import Java.UserInterface.InterfaceEntity.NoteCreateForm;

import java.util.Scanner;

public class MainPageController {

    public MainPageController(String username) {
    }

    public Notes createNote(NoteCreateForm form) {
        NoteCreation noteCreation = new NoteCreation();
        return noteCreation.createNote(
                form.getCategory(),
                form.getTitle(),
                form.getDate(),
                form.getContent(),
                form.getReferences(),
                form.isEditable(),
                form.isReferable(),
                form.isCommentable()
        );
    }
}
