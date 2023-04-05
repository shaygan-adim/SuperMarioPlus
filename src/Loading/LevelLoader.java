package Loading;

import Model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

abstract public class LevelLoader {
    // Methods
    private static Object[] readFile(File file){
        Object[] objects = null;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            objects = new Object[7];
            String line;
            String[] splitedLine;
            int time = Integer.valueOf(br.readLine());
            int coinsNumber = Integer.valueOf(br.readLine());
            String[] info = br.readLine().split(" ");
            int[] endY = new int[]{Integer.valueOf(info[0]),Integer.valueOf(info[1])};
            int floorsNumber = Integer.valueOf(br.readLine());
            Floor[] floors = new Floor[floorsNumber];
            for (int i = 0 ; i<floorsNumber ; i++){
                line = br.readLine();
                splitedLine = line.split(" ");
                floors[i] = new Floor(new int[]{Integer.valueOf(splitedLine[0]),Integer.valueOf(splitedLine[1])},Integer.valueOf(splitedLine[2]),Integer.valueOf(splitedLine[3]));
            }
            int blocksNumber = Integer.valueOf(br.readLine());
            Block[] blocks = new Block[blocksNumber];
            for (int i = 0 ; i<blocksNumber ; i++){
                line = br.readLine();
                splitedLine = line.split(",");
                Item item = null;
                int margin = 0;
                if (line.charAt(0)=='C'){
                    item = new Coin(null);
                    margin++;
                }
                blocks[i] = new Block(new int[]{Integer.valueOf(splitedLine[0].substring(1+margin)),Integer.valueOf(splitedLine[1].substring(0,splitedLine[1].length()-1))},item);
            }
            int pipesNumber = Integer.valueOf(br.readLine());
            Pipe[] pipes = new Pipe[pipesNumber];
            List<Enemy> enemyList = new ArrayList<>();
            for (int i = 0 ; i<pipesNumber ; i++){
                line = br.readLine();
                splitedLine = line.split(" ");
                Plant plant = null;
                int margin = 0;
                if (line.charAt(0)=='P'){
                    plant = new Plant(1,null,3);
                    enemyList.add(plant);
                    margin++;
                }
                pipes[i] = new Pipe(new int[]{Integer.valueOf(splitedLine[0].substring(margin)),Integer.valueOf(splitedLine[1])},plant);
                if (plant!=null) plant.setPipe(pipes[i]);
            }
            br.close();
            fr.close();
            objects[0] = blocks;
            objects[1] = floors;
            objects[2] = pipes;
            objects[3] = enemyList.toArray(new Enemy[0]);
            objects[4] = Integer.valueOf(coinsNumber);
            objects[5] = endY;
            objects[6] = Integer.valueOf(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objects;
    }
    public static Part newL1P1 (Hero[] heroes){
        File file = new File("src/Loading/Levels/L1P1.txt");
        Object[] objects = readFile(file);
        return new Part(0,(Block[]) objects[0],(Floor[]) objects[1],(Pipe[]) objects[2],(Enemy[]) objects[3],heroes,(Integer) objects[4],(int[]) objects[5],(Integer) objects[6]);
    }
    public static Part newL1P2 (Hero[] heroes){
        File file = new File("src/Loading/Levels/L1P2.txt");
        Object[] objects = readFile(file);
        return new Part(1,(Block[]) objects[0],(Floor[]) objects[1],(Pipe[]) objects[2],(Enemy[]) objects[3],heroes,(Integer) objects[4],(int[]) objects[5],(Integer) objects[6]);
    }
}
