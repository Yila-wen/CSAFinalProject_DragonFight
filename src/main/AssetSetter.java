package main;

import entity.Dragon;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    public void setDragon(){
        gp.dragon[0] = new Dragon(gp);
        gp.dragon[0].worldX = gp.tileSize*44; //48
        gp.dragon[0].worldY = gp.tileSize*16 + (gp.tileSize/8); //19

    }
}
