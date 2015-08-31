package com.foxlinkimage.fit.fcl;

import java.nio.ByteOrder;

import javolution.io.Struct;

/**
 * Created by Alex on 2015/8/17.
 */
public class DeviceStatusStruct extends Struct {
    public final Unsigned32 dwLastErr = new Unsigned32();
    public final Unsigned16 wFWInfo = new Unsigned16();
    public final Unsigned8 byFlowStatus = new Unsigned8();
    public final Unsigned8 byID = new Unsigned8();

    public final Unsigned16 wSensorStatus = new Unsigned16();
    public final Unsigned8 byPercentage = new Unsigned8();
    public final Unsigned8 byPlatform = new Unsigned8();
    public final Unsigned8 byReserve[] =  array(new Unsigned8[2]);
    public final Unsigned8 byASICVersion = new Unsigned8();
    public final Unsigned8 byButtonStatus = new Unsigned8();
    public final Unsigned8 byFWDebug[] = array(new Unsigned8[16]);

    @Override
    public ByteOrder byteOrder() {
        return ByteOrder.LITTLE_ENDIAN;
    }
}
