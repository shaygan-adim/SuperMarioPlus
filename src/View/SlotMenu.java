package View;

import Loading.ImageLoader;
import Loading.LevelLoader;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SlotMenu extends MainFrame{
    // Fields
    private final User user;

    // Constructor
    protected SlotMenu(User user) {
        super(500, 625, ImageLoader.getProfileMenuImage());
        this.user = user;
        initComponents();
    }

    // Methods
    @Override
    void initComponents() {
        // Initializing and configuring components
        JLabel slot1Label = new JLabel();
        JLabel slot2Label = new JLabel();
        JLabel slot3Label = new JLabel();
        JButton slot1Button1 = new JButton("New Game");
        JButton slot1Button2 = new JButton("Continue");
        JButton slot2Button1 = new JButton("New Game");
        JButton slot2Button2 = new JButton("Continue");
        JButton slot3Button1 = new JButton("New Game");
        JButton slot3Button2 = new JButton("Continue");
        JButton backButton = new JButton("Back");

        slot1Button1.setFocusPainted(false);
        slot1Button2.setFocusPainted(false);
        slot2Button1.setFocusPainted(false);
        slot2Button2.setFocusPainted(false);
        slot3Button1.setFocusPainted(false);
        slot3Button2.setFocusPainted(false);
        backButton.setFocusPainted(false);

        if (this.user.getPartNames()[0]==null){
            slot1Label.setText("Slot 1 : Empty");
            slot1Button2.setEnabled(false);
        }
        else{
            if (this.user.getPartNames()[0]== PartName.L1P1){
                slot1Label.setText("Slot 1 : 1-1");
            }
            if (this.user.getPartNames()[0]== PartName.L1P2){
                slot1Label.setText("Slot 1 : 1-2");
            }
        }
        if (this.user.getPartNames()[1]==null){
            slot2Label.setText("Slot 2 : Empty");
            slot2Button2.setEnabled(false);
        }
        else{
            if (this.user.getPartNames()[1]== PartName.L1P1){
                slot2Label.setText("Slot 2 : 1-1");
            }
            if (this.user.getPartNames()[1]== PartName.L1P2){
                slot2Label.setText("Slot 2 : 1-2");
            }
        }
        if (this.user.getPartNames()[2]==null){
            slot3Label.setText("Slot 3 : Empty");
            slot3Button2.setEnabled(false);
        }
        else{
            if (this.user.getPartNames()[2]== PartName.L1P1){
                slot3Label.setText("Slot 3 : 1-1");
            }
            if (this.user.getPartNames()[2]== PartName.L1P2){
                slot3Label.setText("Slot 3 : 1-2");
            }
        }

        slot1Label.setFont(new Font("Ink Free",Font.BOLD,25));
        slot2Label.setFont(new Font("Ink Free",Font.BOLD,25));
        slot3Label.setFont(new Font("Ink Free",Font.BOLD,25));
        slot1Button1.setFont(new Font("Forte",Font.PLAIN,12));
        slot1Button2.setFont(new Font("Forte",Font.PLAIN,12));
        slot2Button1.setFont(new Font("Forte",Font.PLAIN,12));
        slot2Button2.setFont(new Font("Forte",Font.PLAIN,12));
        slot3Button1.setFont(new Font("Forte",Font.PLAIN,12));
        slot3Button2.setFont(new Font("Forte",Font.PLAIN,12));
        backButton.setFont(new Font("Forte",Font.PLAIN,12));

        // Setting listeners
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainPage(user);
                SlotMenu.super.dispose();
            }
        });
        slot1Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hero[] heroes = new Hero[1];
                if (user.getActiveHero()==HeroName.MARIO){
                    heroes[0] = new Mario(3);
                }
                Level level = new Level(new Part[]{LevelLoader.newL1P1(heroes),LevelLoader.newL1P2(heroes)},0);
                user.setActiveSlot(1);
                user.setPart1(null);
                try {
                    user.save();
                } catch (IOException ex) {}
                new Game(level,user);
                SlotMenu.super.dispose();
            }
        });
        slot1Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hero[] heroes = new Hero[1];
                if (user.getActiveHero()==HeroName.MARIO){
                    heroes[0] = new Mario(user.getPartHeart()[0]);
                    heroes[0].setScore(user.getPartScore()[0]);
                }
                Level level = new Level(new Part[]{LevelLoader.newL1P1(heroes),LevelLoader.newL1P2(heroes)},0);
                if (user.getPartNames()[0]==PartName.L1P1){
                    level.setActivePart(level.getParts()[0]);
                }
                if (user.getPartNames()[0]==PartName.L1P2){
                    level.setActivePart(level.getParts()[1]);
                }

                new Game(level,user);
                SlotMenu.super.dispose();
            }
        });
        slot2Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hero[] heroes = new Hero[1];
                if (user.getActiveHero()==HeroName.MARIO){
                    heroes[0] = new Mario(3);
                }
                Level level = new Level(new Part[]{LevelLoader.newL1P1(heroes),LevelLoader.newL1P2(heroes)},0);
                user.setActiveSlot(2);
                user.setPart2(null);
                try {
                    user.save();
                } catch (IOException ex) {}
                new Game(level,user);
                SlotMenu.super.dispose();
            }
        });
        slot2Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hero[] heroes = new Hero[1];
                if (user.getActiveHero()==HeroName.MARIO){
                    heroes[0] = new Mario(user.getPartHeart()[1]);
                    heroes[0].setScore(user.getPartScore()[1]);
                }
                Level level = new Level(new Part[]{LevelLoader.newL1P1(heroes),LevelLoader.newL1P2(heroes)},0);
                if (user.getPartNames()[1]==PartName.L1P1){
                    level.setActivePart(level.getParts()[0]);
                }
                if (user.getPartNames()[1]==PartName.L1P2){
                    level.setActivePart(level.getParts()[1]);
                }

                new Game(level,user);
                SlotMenu.super.dispose();
            }
        });
        slot3Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hero[] heroes = new Hero[1];
                if (user.getActiveHero()==HeroName.MARIO){
                    heroes[0] = new Mario(3);
                }
                Level level = new Level(new Part[]{LevelLoader.newL1P1(heroes),LevelLoader.newL1P2(heroes)},0);
                user.setActiveSlot(3);
                user.setPart3(null);
                try {
                    user.save();
                } catch (IOException ex) {}
                new Game(level,user);
                SlotMenu.super.dispose();
            }
        });
        slot3Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hero[] heroes = new Hero[1];
                if (user.getActiveHero()==HeroName.MARIO){
                    heroes[0] = new Mario(user.getPartHeart()[2]);
                    heroes[0].setScore(user.getPartScore()[2]);
                }
                Level level = new Level(new Part[]{LevelLoader.newL1P1(heroes),LevelLoader.newL1P2(heroes)},0);
                if (user.getPartNames()[2]==PartName.L1P1){
                    level.setActivePart(level.getParts()[0]);
                }
                if (user.getPartNames()[2]==PartName.L1P2){
                    level.setActivePart(level.getParts()[1]);
                }

                new Game(level,user);
                SlotMenu.super.dispose();
            }
        });

        // Adding components to the panel and setting the locations
        super.mainPanel.add(slot1Label);
        super.mainPanel.add(slot2Label);
        super.mainPanel.add(slot3Label);
        super.mainPanel.add(slot1Button1);
        super.mainPanel.add(slot1Button2);
        super.mainPanel.add(slot2Button1);
        super.mainPanel.add(slot2Button2);
        super.mainPanel.add(slot3Button1);
        super.mainPanel.add(slot3Button2);
        super.mainPanel.add(backButton);

        slot1Label.setBounds(100,100,200,50);
        slot2Label.setBounds(100,200,200,50);
        slot3Label.setBounds(100,300,200,50);
        slot1Button1.setBounds(300,90,100,30);
        slot1Button2.setBounds(310,130,80,30);
        slot2Button1.setBounds(300,190,100,30);
        slot2Button2.setBounds(310,230,80,30);
        slot3Button1.setBounds(300,290,100,30);
        slot3Button2.setBounds(310,330,80,30);
        backButton.setBounds(200,400,80,30);
    }
}
