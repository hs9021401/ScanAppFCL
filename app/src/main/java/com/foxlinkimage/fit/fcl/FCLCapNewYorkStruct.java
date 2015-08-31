package com.foxlinkimage.fit.fcl;

import java.nio.ByteOrder;

import javolution.io.Struct;

/**
 * Created by Alex on 2015/8/17.
 */
public class FCLCapNewYorkStruct extends Struct{

    @Override
    public ByteOrder byteOrder() {
        return ByteOrder.LITTLE_ENDIAN;
    }
}
