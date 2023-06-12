package main;

import entity.Entity;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }

    public void checkTile(Entity e){

        int hitboxLeftWorldX = e.worldX + e.hitbox.x;
        int hitboxRightWorldX = e.worldX + e.hitbox.x + e.hitbox.width;
        int hitboxTopWorldY = e.worldY + e.hitbox.y;
        int hitboxBotWorldY = e.worldY + e.hitbox.y+e.hitbox.height;

        int hitboxLeftCol = hitboxLeftWorldX/gp.TILE_SIZE;
        int hitboxRightCol = hitboxRightWorldX/gp.TILE_SIZE;
        int hitboxTopRow = hitboxTopWorldY/gp.TILE_SIZE;
        int hitboxBotRow = hitboxBotWorldY/gp.TILE_SIZE;

        int tileNum1, tileNum2;

        switch (e.direction){
            case "up":
                hitboxTopRow = (hitboxTopWorldY - e.speed)/gp.TILE_SIZE;
                tileNum1 = gp.tileM.mapTileNum[hitboxTopRow][hitboxLeftCol];
                tileNum2 = gp.tileM.mapTileNum[hitboxTopRow][hitboxRightCol];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    e.collisionOn = true;
                }
                break;
            case "down":
                hitboxBotRow = (hitboxBotWorldY + e.speed)/gp.TILE_SIZE;
                tileNum1 = gp.tileM.mapTileNum[hitboxBotRow][hitboxLeftCol];
                tileNum2 = gp.tileM.mapTileNum[hitboxBotRow][hitboxRightCol];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    e.collisionOn = true;
                }
            break;
            case "left":
                hitboxLeftCol = (hitboxLeftWorldX - e.speed)/gp.TILE_SIZE;
                tileNum1 = gp.tileM.mapTileNum[hitboxTopRow][hitboxLeftCol];
                tileNum2 = gp.tileM.mapTileNum[hitboxBotRow][hitboxLeftCol];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    e.collisionOn = true;
                }
            break;
            case "right":
                hitboxRightCol = (hitboxRightWorldX + e.speed)/gp.TILE_SIZE;
                tileNum1 = gp.tileM.mapTileNum[hitboxTopRow][hitboxRightCol];
                tileNum2 = gp.tileM.mapTileNum[hitboxBotRow][hitboxRightCol];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision){
                    e.collisionOn = true;
                }
            break;
        }

    }

    public boolean checkEntity(Entity e, Entity[] target){
        boolean collision = false;

        if (target[0] != null) {

            e.hitbox.x = e.worldX + e.hitbox.x;
            e.hitbox.y = e.worldY + e.hitbox.y;

            target[0].hitbox.x = target[0].worldX + target[0].hitbox.x;
            target[0].hitbox.y = target[0].worldY + target[0].hitbox.y;

            switch (e.direction) {
                case "up":
                    e.hitbox.y -= e.speed;
                    if (e.hitbox.intersects(target[0].hitbox)) {
                        e.collisionOn = true;
                        collision=true;
                        break;
                    }
                case "down":
                    e.hitbox.y += e.speed;
                    if (e.hitbox.intersects(target[0].hitbox)) {
                        e.collisionOn = true;
                        collision=true;
                        break;
                    }
                case "left":
                    e.hitbox.x -= e.speed;
                    if (e.hitbox.intersects(target[0].hitbox)) {
                        e.collisionOn = true;
                        collision=true;
                        break;
                    }
                case "right":
                    e.hitbox.x += e.speed;
                    if (e.hitbox.intersects(target[0].hitbox)) {
                        e.collisionOn = true;
                        collision=true;
                        break;
                    }

            }
        }
        e.hitbox.x=e.hitboxDefaultX;
        e.hitbox.y=e.hitboxDefaultY;
        assert target[0] != null;
        target[0].hitbox.x=target[0].hitboxDefaultX;
        target[0].hitbox.y=target[0].hitboxDefaultY;

        return collision;
    }

    public boolean checkPlayer(Entity e){
        boolean collision = false;

        e.hitbox.x=e.worldX +e.hitbox.x;
        e.hitbox.y=e.worldY +e.hitbox.y;

        gp.player.hitbox.x = gp.player.worldX + gp.player.hitbox.x;
        gp.player.hitbox.y = gp.player.worldY + gp.player.hitbox.y;

        switch (e.direction) {
            case "up":
                e.hitbox.y -= e.speed;
                if (e.hitbox.intersects(gp.player.hitbox)) {
                    e.collisionOn = true;
                    collision=true;
                    break;
                }
            case "down":
                e.hitbox.y += e.speed;
                if (e.hitbox.intersects(gp.player.hitbox)) {
                    e.collisionOn = true;
                    collision=true;
                    break;
                }
            case "left":
                e.hitbox.x -= e.speed;
                if (e.hitbox.intersects(gp.player.hitbox)) {
                    e.collisionOn = true;
                    collision=true;
                    break;
                }
            case "right":
                e.hitbox.x += e.speed;
                if (e.hitbox.intersects(gp.player.hitbox)) {
                    e.collisionOn = true;
                    collision=true;
                    break;
                }

        }
        e.hitbox.x=e.hitboxDefaultX;
        e.hitbox.y=e.hitboxDefaultY;

        gp.player.hitbox.x=gp.player.hitboxDefaultX;
        gp.player.hitbox.y=gp.player.hitboxDefaultY;

        return collision;


    }

}
