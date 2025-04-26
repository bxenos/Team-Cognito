public class User {
    //instance variables
    String name;
    String school;
    
    /**
     * constructor to make user
     */
    public User(String name, String school) {
        this.name = name;
        this.school = school;


    }

    /**
     * getter for user's name
     * 
     * @returns User's name
     */
    public String getName() {
        return name;
    }

    /**
     * getter for user's school
     * 
     * @returns User's school
     */
    public String getSchool() {
        return school;
    }

    /**
     * Adds a new class to the users schedule
     */
    public void addNewClass() {
        //DO SOMETHING
    }
 }