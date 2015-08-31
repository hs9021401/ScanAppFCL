package com.foxlinkimage.fit.fcl;

import java.nio.ByteOrder;

import javolution.io.Struct;

/**
 * Created by Alex on 2015/8/17.
 */
public class VendorCommandStruct extends Struct {
    public final Unsigned32 VendorID = new Unsigned32();
    public final Unsigned8 OperationCode = new Unsigned8();
    public final Unsigned8 Res0 = new Unsigned8();
    public final Unsigned8 ControlCode = new Unsigned8();
    public final Unsigned8 Res1 = new Unsigned8();
    public final Unsigned16 DataType = new Unsigned16();
    public final Unsigned16 Res2 = new Unsigned16();
    public final Unsigned32 DataLength = new Unsigned32();

    @Override
    public ByteOrder byteOrder() {
        return ByteOrder.LITTLE_ENDIAN;
    }
}
