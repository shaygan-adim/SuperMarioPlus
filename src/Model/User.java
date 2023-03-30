package Model;

import Loading.UserLoader;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    // Fields
    private String username;
    private String password;
    private int coin;
    private int highscore = 0;
    private Level[] levels;
    private HeroName[] ownedHeroes;
    private HeroName activeHero;

    // Constructor
    public User(String username,String password,int coin,Level[] levels,HeroName[] ownedHeroes,HeroName activeHero){
        this.username = username;
        this.password = password;
        this.coin = coin;
        this.levels = levels;
        this.ownedHeroes = ownedHeroes;
        this.activeHero = activeHero;

        try {
            this.save();
        } catch (IOException e) {}
        try {
            UserLoader.loadUsers();
        } catch (IOException e) {}



    }

    // Methods
    public void save() throws IOException {
        Gson gson = new Gson();
        try (FileReader fileReader = new FileReader("src/Loading/Users/UsersData.json")) {
            // Convert the JSON string to a list of objects
            User[] users = gson.fromJson(fileReader, User[].class);
            List<User> userList = new ArrayList<>();
            if (users!=null){
                for (User user : users){
                    if (!(user.username.equals(this.username))){
                        userList.add(user);
                    }
                }
            }
            userList.add(this);
            String jsonString = gson.toJson(userList);
            try (FileWriter fileWriter = new FileWriter("src/Loading/Users/UsersData.json")) {
                fileWriter.write(jsonString);
            }
        }
    }

    // Getters
    public String getUsername() {return username;}
    public String getPassword() {return password;}
    public int getCoin() {return coin;}
    public int getHighscore() {return highscore;}
    public Level[] getLevels() {return levels;}
    public HeroName[] getOwnedHeroes() {return ownedHeroes;}
    public HeroName getActiveHero() {return activeHero;}

    // Setters
    public void setCoin(int coin) {this.coin = coin;}
    public void setHighscore(int highscore) {this.highscore = highscore;}
    public void setLevels(Level[] levels) {this.levels = levels;}
    public void setOwnedHeroes(HeroName[] ownedHeroes) {this.ownedHeroes = ownedHeroes;}
    public void setActiveHero(HeroName activeHero) {this.activeHero = activeHero;}
}
