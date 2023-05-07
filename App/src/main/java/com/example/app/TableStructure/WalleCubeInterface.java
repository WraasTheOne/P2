package com.example.app.TableStructure;

public interface WalleCubeInterface
{
    String createWalleCube(String type, String BIDS, int CID);

    String removeWalleCube(int WID);

    String changeCubeMaterial();

    //String changeCenterID();

}
