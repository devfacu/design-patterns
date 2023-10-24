package main.facudev.org.factorymethodrebuilt;

import main.facudev.org.factorymethodrebuilt.entity.BigUFOEnemyShip;
import main.facudev.org.factorymethodrebuilt.entity.EnemyShip;
import main.facudev.org.factorymethodrebuilt.entity.RocketEnemyShip;
import main.facudev.org.factorymethodrebuilt.entity.UFOEnemyShip;

public class EnemyShipFactory {

    public EnemyShip makeEnemyShip(String shipType) {

        EnemyShip newShip = null;

        if (shipType.equals("U")) {
            return new UFOEnemyShip();
        } else if (shipType.equals("R")) {
            return new RocketEnemyShip();
        } else if (shipType.equals("B")) {
            return new BigUFOEnemyShip();
        } else return null;
    }

}
