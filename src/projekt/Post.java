/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import projekt.helpers.Database;

/**
 *
 * @author albin
 */
public class Post {
    
    private int postID;
    private int userID;
    private String title;
    private String description;
    private int typeID;
    
    public Post(int id){
        this.postID = id;
        createPost();
    }
    
    private void createPost(){
        
        try{
            this.userID = Integer.parseInt(Database.fetchSingle("Select userID from Post where USERID = " + postID));
            this.title = Database.fetchSingle("Select title form Post where PostID = " + postID);
            this.description = Database.fetchSingle("Select descripton from Post where PostID = " + postID);
            this.typeID = Integer.parseInt(Database.fetchSingle("Select typeID form Post where PostID = " + postID));
            
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }
     
}
