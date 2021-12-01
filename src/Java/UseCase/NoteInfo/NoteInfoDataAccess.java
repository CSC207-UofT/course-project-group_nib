package Java.UseCase.NoteInfo;

public interface NoteInfoDataAccess {
    // TODO: implement this interface
    void create(String title, String username, String category, String content, String[] strings, String[] comment, double rate);
    void delete();
    void edit();
}
