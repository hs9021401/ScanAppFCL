package com.foxlinkimage.fit.fcl;
import java.nio.ByteOrder;

import javolution.io.Struct;

//Total size: 128 bytes

public class ScanParameterStruct extends Struct {
    public final Unsigned32 dwADF = new Unsigned32();
    public final Unsigned8 byInDataType = new Unsigned8();
    public final Unsigned8 byOutDataType = new Unsigned8();
    public final Unsigned8 byInPixelBits = new Unsigned8();
    public final Unsigned8 byOutPixelBits = new Unsigned8();
    public final Unsigned32 dwWidthPixels = new Unsigned32();
    public final Unsigned32 dwWidthBytes = new Unsigned32();
    public final Unsigned16 wXresolution = new Unsigned16();
    public final Unsigned16 wYresolution = new Unsigned16();
    public final SCANWINDOW ScanWindow = new SCANWINDOW();
    public final Unsigned32 dwPaperWidth = new Unsigned32();
    public final Unsigned32 dwPaperHeight = new Unsigned32();
    public final Unsigned16 wXScaleRatio = new Unsigned16();
    public final Unsigned16 wYScaleRatio = new Unsigned16();
    public final Unsigned8 byScaleRatio = new Unsigned8();
    public final Unsigned8 byRotateMode_Bottom = new Unsigned8();
    public final Unsigned8 byRotateMode_Top = new Unsigned8();
    public final Unsigned8 byChannelDropOut = new Unsigned8();
    public final Unsigned8 byCompression = new Unsigned8();
    public final Unsigned8 byMPSMode = new Unsigned8();
    public final Unsigned16 wImageOutputMode = new Unsigned16();
    public final Unsigned32 dwImageProcess = new Unsigned32();
    public final Unsigned8 byOverScanLines = new Unsigned8();
    public final Unsigned8 byGrayFromBuf1 = new Unsigned8();
    public final Unsigned8 byContrastBrightness = new Unsigned8();
    public final Unsigned8 byHalftoneThreshold = new Unsigned8();
    public final Unsigned8 byThresholdRandomRange = new Unsigned8();
    public final Unsigned8 byHalftoneDitherPattern = new Unsigned8();
    public final Unsigned8 bySpecialMode = new Unsigned8();
    public final Unsigned8 byMiscOptions = new Unsigned8();
    public final Unsigned8 byScanToNetwork = new Unsigned8();
    public final Unsigned8 bySharpSmooth = new Unsigned8();
    public final Unsigned8 byColorTransform = new Unsigned8();
    public final Unsigned8 byOutputModeAndCBMode = new Unsigned8();
    public final Unsigned32 dwRealLine = new Unsigned32();
    public final Unsigned32 dwImageTest = new Unsigned32();
    public final EDGEERASEAREA EdgeEraseArea = new EDGEERASEAREA();
    public final Unsigned32 dwReserved[] = array(new Unsigned32[9]);

    @Override
    public ByteOrder byteOrder() {
        return ByteOrder.LITTLE_ENDIAN;
    }

    public class SCANWINDOW extends Struct
    {
        public final Unsigned32 xPos = new Unsigned32();
        public final Unsigned32 yPos = new Unsigned32();
        public final Unsigned32 xExtent = new Unsigned32();
        public final Unsigned32 yExtent = new Unsigned32();
    }

    public class EDGEERASEAREA extends Struct
    {
        public final Unsigned16 EdgeEraseMode1 = new Unsigned16();
        public final Unsigned16 EdgeEraseMode2 = new Unsigned16();
        public final Unsigned16 EdgeEraseTopValue = new Unsigned16();
        public final Unsigned16 EdgeEraseBtmValue = new Unsigned16();
        public final Unsigned16 EdgeEraseLeftValue = new Unsigned16();
        public final Unsigned16 EdgeEraseRightValue = new Unsigned16();
    }
}
