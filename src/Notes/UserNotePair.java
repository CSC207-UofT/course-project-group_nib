package Notes;
import Entity.CategoryA;
import Entity.Notes;
import UseCase.User;

import java.util.ArrayList;

public class UserNotePair {
    /* We use Builder Pattern to construct this complex object called UserNotePair, so that each user can be paired
    * with their actions on notes.*/
    //required parameters
    private User user;
    //optional parameters
    private ArrayList<Notes> created;
    private ArrayList<Notes> edited;
    private ArrayList<Notes> commented;
    private ArrayList<Notes> rated;

    private UserNotePair(Builder builder){
        this.user = builder.user;
        this.created = builder.created;
        this.edited = builder.edited;
        this.commented = builder.commented;
        this.rated = builder.rated;
    }

    @Override
    public String toString(){
        return "User: " + this.user + "\n"
                + "Created Notes: " + this.created + "\n"
                + "Edited Notes: " + this.edited + "\n"
                + "Commented Notes: " + this.commented + "\n"
                + "Rated Notes: " + this.rated + "\n";
    }

    public static class Builder{
        //required parameters
        private User user;
        //optional parameters
        private ArrayList<Notes> created;
        private ArrayList<Notes> edited;
        private ArrayList<Notes> commented;
        private ArrayList<Notes> rated;


        public Builder(User user){
            //required parameters
        }

        public Builder getCreated(ArrayList<Notes> created){
            //optional parameters
            return this;
        }

        public Builder getEdited(ArrayList<Notes> edited){
            return this;
        }

        public Builder getCommented(ArrayList<Notes> commented){
            return this;
        }

        public Builder getRated(ArrayList<Notes> rated){
            return this;
        }

        public Builder setEditable(boolean isEditable){
            return this;
        }

        public UserNotePair build(){
            return new UserNotePair(this);
        }
    }


    }