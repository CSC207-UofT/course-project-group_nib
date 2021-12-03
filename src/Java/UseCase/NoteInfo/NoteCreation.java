package Java.UseCase.NoteInfo;

import Java.Entity.Note.Notes;

import java.util.ArrayList;

public class NoteCreation extends NoteInfoManipulation {
    private Notes note;
    private String username;
    private ArrayList<String> note_info;
    // private NoteInfoDataAccess api;

    public NoteCreation(NoteInfoDataAccess api, ArrayList<String> note_info, String username) {
        super(api);
        this.note_info = note_info;
        this.username = username;

    }


    @Override
    public boolean ChangeNote() {
        // TODO: Create a new note
        this.note = new Notes();

        note.setCategory(note_info.get(1));
        note.setAuthor(note_info.get(0));
        note.setTitle(note_info.get(2));
        note.setDate(note_info.get(3));
        note.setContent(note_info.get(4));
        note.setReference(note_info.get(5));

        String title = note.getTitle();
        String author = note.getAuthor();
        String category = note.getCategory();
        String content = note.getContent();
        String[] comment = note.getComment();
        String reference = note.getReference();
        double rate = note.getUser_rate();
        String date = note.toString();

        String[] s = new String[6];
        s[0] = author;
        s[1] = category;
        s[2] = title;
        s[3] = date;
        s[4] = content;
        s[5] = reference;

        boolean isSuccess = api.create(s);

        return isSuccess;
    }







    //    public Notes createNote(String category, String title, String date, String content, String references, boolean editable, boolean referable, boolean commentable) {
//
//        // Create objects based on the note type
//        Notes note = new NotesFactory().getNote(category);
//
//        note.setCategory(category);
//        note.setTitle(title);
//        note.setCreated_date(date);
//        note.setContent(new StringBuilder(content));
//        note.setReference(references);
//        note.setEditable(editable);
//        note.setReferable(referable);
//        note.setCommentable(commentable);
//
//        return note;
//    }
}
