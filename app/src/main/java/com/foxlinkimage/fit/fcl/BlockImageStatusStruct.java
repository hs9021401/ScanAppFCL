package com.foxlinkimage.fit.fcl;

import java.nio.ByteOrder;

import javolution.io.Struct;

/**
 * Created by Alex on 2015/8/17.
 */
public class BlockImageStatusStruct extends Struct {
    public final Unsigned32 dwLastErr = new Unsigned32();
    public final Unsigned16 wFWInfo = new Unsigned16();
    public final Unsigned8 byFlowStatus = new Unsigned8();
    public final Unsigned8 byID = new Unsigned8();
    public final Unsigned16 wSensorStatus = new Unsigned16();
    public final Unsigned8 byPageCountCase = new Unsigned8();
    public final Unsigned8 byBlockLineCase = new Unsigned8();
    public final Unsigned16 wPageCount = new Unsigned16();
    public final Unsigned8 byASICVersion = new Unsigned8();
    public final Unsigned8 byReserved = new Unsigned8();
    public final Unsigned32 dwPageTotalLines = new Unsigned32();
    public final Unsigned32 dwPageLinePixels = new Unsigned32();
    public final Unsigned32 dwLineTotalBytes = new Unsigned32();
    public final Unsigned32 dwLineRealBytes = new Unsigned32();
    public final Unsigned32 dwBlockBytes = new Unsigned32();
    public final Unsigned32 dwLastBlockEffBytes = new Unsigned32();
    public final Unsigned32 dwReserved[] = array(new Unsigned32[2]);
    public final Unsigned8 byOutputColorMode = new Unsigned8();
    public final Unsigned8 byDetectColorMode = new Unsigned8();
    public final Unsigned8 byAutoThreshold = new Unsigned8();
    public final Unsigned8 byOrientation = new Unsigned8();
    public final Unsigned32 dwSkewAngle = new Unsigned32();
    public final Unsigned16 wAutoXAnalyses = new Unsigned16();
    public final Unsigned8 byReserved2[] = array(new Unsigned8[6]);


    @Override
    public ByteOrder byteOrder() {
        return ByteOrder.LITTLE_ENDIAN;
    }
}
