package com.foxlinkimage.fit.fcl;

/**
 * Created by Alex on 2015/8/18.
 */
public class FCLCode {
    //FCL Operation Code
    public final static byte FOP_WRITE = 0x2A;
    public final static byte FOP_READ = 0x28;
    public final static byte FOP_COMMAND = 0x14;
    public final static byte FOP_INQUIRY = 0x12;

    //FCL Control Code
    public final static byte FCLC_CAPABILITIES = 1;
    public final static byte FCLC_DEVICE_STATUS = 2;
    public final static byte FCLC_LINE_IMAGE = 3;
    public final static byte FCLC_BLOCK_IMAGE = 4;
    public final static byte FCLC_START_SCAN = 5;
    public final static byte FCLC_STOP_SCAN = 6;
    public final static byte FCLC_ABORT_SCAN = 7;
    public final static byte FCLC_FW_CODE = 8;
    public final static byte FCLC_SCAN_PARAM = 9;
    public final static byte FCLC_TEST_OPTIONS = 10;
    public final static byte FCLC_DEBUG_OPTIONS = 11;
    public final static byte FCLC_GAMMA_TABLE = 12;
    public final static byte FCLC_RGB_MATRIX = 13;
    public final static byte FCLC_CONVOLUTION = 14;
    public final static byte FCLC_CALIB_PARAM = 15;     // R/W
    public final static byte FCLC_NVRAM = 16;
    public final static byte FCLC_MOTOR_SETTING = 17;
    public final static byte FCLC_MOTOR_MOVE = 18;
    public final static byte FCLC_SHADING_DATA = 19;
    public final static byte FCLC_LAMP_STATE = 20;
    public final static byte FCLC_REFRESH_SETTING = 21;
    public final static byte FCLC_PICK_MEDIA = 22;
    public final static byte FCLC_EJECT_MEDIA = 23;
    public final static byte FCLC_LOOP_PAPER_FEED = 24;
    public final static byte FCLC_STOP_PAPER_FEED = 25;
    public final static byte FCLC_DIAGNOSIS_MODE = 26;
    public final static byte FCLC_FACTORY_SHADING = 27;
    public final static byte FCLC_SHADING_REFRESH = 28;
    public final static byte FCLC_NVRAM_REFRESH = 29;
    public final static byte FCLC_DECELERATE = 30;     // R/W
    public final static byte FCLC_CALIB_IMG_LINE_GAIN = 31;     // Read Only
    public final static byte FCLC_CALIB_IMG_LINE_OFFSET = 32;     // Read Only
    public final static byte FCLC_CALIB_IMG_PIXEL_GAIN = 33;     // Read Only
    public final static byte FCLC_CALIB_IMG_PIXEL_OFFSET = 34;     // Read Only
    public final static byte FCLC_CALIB_IMG_PWM = 35;     // Read Only
    public final static byte FCLC_CALIB_IMG_LOW_FREQUENCY = 36;     // Read Only
    public final static byte FCLC_PANEL_LCD_STRING = 37;     // Write Only
    public final static byte FCLC_COLORDROP_TABLE = 38;
    public final static byte FCLC_Q_TABLE = 39;
    public final static byte FCLC_CALIB_DATA_PIXEL_GAIN = 40;     // Read Only
    public final static byte FCLC_CHECKUSBSPEED = 41;
    public final static byte FCLC_SPI_TEST = 42;
    public final static byte FCLC_LVDS_TEST = 43;
    // FCLC_FPGA_RESET                 = 44;
    public final static byte FCLC_TUNE_AFE = 45;
    public final static byte FCLC_FLEXRISC = 46;     // FW use
    // FCLC_PAGESTEP                   = 47;     // No use
    public final static byte FCLC_DEBUG = 48;
    public final static byte FCLC_SET_LCM_STRING = 49;
    // FCLC_DB_CLEAR                   = 51;
    // FCLC_FLASH                      = 52;     // 80530OP++ // no use
    public final static byte FCLC_MOTOR_FREE_RUN = 53;     // 80530OP++
    public final static byte FCLC_ULTRASONICDATA = 54;
    public final static byte FCLC_NVRAM_FIT = 55;
    // FCLC_DRAM                       = 56;     // no use
    public final static byte FCLC_PAUSE_SCAN = 57;     // 80804Bon++
    public final static byte FCLC_DITHER = 58;     // 80804Bon++
    // FCLC_URGEN_SENSOR               = 59;     // FW use
    // FCLC_PAGEEND_INFO               = 60;     // FW use
    public final static byte FCLC_PERFORMANCE = 61;
    public final static byte FCLC_PM36_TEST = 62;
    public final static byte FCLC_EJECT_MEDIA_2 = 63;     // 81013OP++
    // FCLC_MOTOR_PARA                 = 64;     // FW use
    // FCLC_CALIBRATION                = 65;     // no use
    public final static byte FCLC_GRAY_TABLE = 66;
    public final static byte FCLC_TWAIN_OPEN = 67;
    public final static byte FCLC_TWAIN_CLOSE = 68;
    // FCLC_SLAVE_REGDMADONE           = 69;     // FW use
    // FCLC_SLAVE_STARTDOCAL           = 70;     // FW use
    public final static byte FCLC_HARDWARE_LOGGING = 71;
    // FCLC_JOBUI                      = 72;     // FW use
    public final static byte FCLC_RETURN_MEDIA = 73;
    public final static byte FCLC_RDC_TESTDATA = 74;     // 90504OP++
    public final static byte FCLC_GAMMA_SETTING = 75;
    public final static byte FCLC_ERASE_RUNTIME_NVRAM = 76;
    public final static byte FCLC_PEI_TEST = 77;
    public final static byte FCLC_PANEL_PROFILE = 78;
    public final static byte FCLC_CLEAR_DATAFS = 79;
    public final static byte FCLC_MULTIPICK = 80;
    public final static byte FCLC_SCALING_SKEW = 81;
    public final static byte FCLC_CALIB_IMG_PIXEL_GAIN_GRAY = 82;
    public final static byte FCLC_USB_CONNECT = 83;
    public final static byte FCLC_CLEAR_BUTTON_STATUS = 84;
    public final static byte FCLC_GET_CALIB_STATUS = 85;     // GET CALIBRATION STATUS
    public final static byte FCLC_MOTOR_JOB_SET_TUNING = 86;
    public final static byte FCLC_MOTOR_JOB_GET_TUNING = 87;
    public final static byte FCLC_MOTOR_JOB_SET_TABLE = 88;
    public final static byte FCLC_MOTOR_JOB_GET_TABLE = 89;
    public final static byte FCLC_SPECIAL_PARTITION = 90;
    public final static byte FCLC_NO_SHADINGTABLE = 91;
    public final static byte FCLC_MAC_ADDRESS = 92;
    public final static byte FCLC_SPECIFIC_FILES = 93;
    public final static byte FCLC_END = 94;     // No Used. Just keep it in the end.


    // From FW portion
    public final static int FCLE_END_OF_SIDE = 0x1005;    // Page end
    public final static int FCLE_END_OF_SIDE_AND_NO_PAPER = 0x1006;    // Job end (Archer FW internal usage)
    public final static int FCLE_FW_SCN_MIS_FEED = 0x2001;    // No pick
    public final static int FCLE_FW_SCN_PAPER_JAM1 = 0x2002;    // USL(PP) jam
    public final static int FCLE_FW_SCN_PAPER_JAM2 = 0x2003;    // SL jam
    public final static int FCLE_FW_SCN_MULTI_PICK = 0x2004;
    public final static int FCLE_FW_SCN_REMOVE_PAPER_OR_CARD = 0x2005;
    public final static int FCLE_FW_SCN_CUT_OUTOF_PAPERLENGTH = 0x2006;    // Crop area over page length
    public final static int FCLE_FW_SCN_PAPER_TOO_LONG = 0x2007;
    public final static int FCLE_FW_SCN_PAPER_TOO_SHORT = 0x2008;
    public final static int FCLE_FW_SCN_HATCH_OPEN = 0x2009;
    public final static int FCLE_FW_ERR_ODD_AFE_SETTING = 0x200A;    // BTM
    public final static int FCLE_FW_ERR_EVEN_AFE_SETTING = 0x200B;    // TOP
    public final static int FCLE_FW_ERR_FPGA_SETTING = 0x200C;
    public final static int FCLE_FW_ERR_FPGA_NOOUTPUT = 0x200D;    // Source no output
    public final static int FCLE_FW_ERR_NO_PAPER = 0x200E;
    public final static int FCLE_FW_ERR_LAMP_FAIL = 0x200F;
    public final static int FCLE_FW_ERR_CALIBRATION_FAIL = 0x2010;
    public final static int FCLE_FW_ERR_PAGE_INFO = 0x2011;
    public final static int FCLE_FW_FIT_EG_TIMEOUT_ERROR = 0x3000;
    public final static int FCLE_FW_FIT_EG_PAUSE_NO_RELEASE_ERROR = 0x3001;
    public final static int FCLE_FW_FIT_EG_PAGEINFO_ERROR = 0x3002;
    public final static int FCLE_FW_FIT_EG_AFE_INPUT_BUF_OVERFLOW_ERROR = 0x3003;
    public final static int FCLE_FW_FIT_EG_SCAN_STAGE_OVERLAP_ERROR = 0x3004;
    public final static int FCLE_FW_FIT_EG_MOTOR_CASE_ERROR = 0x3100;
    public final static int FCLE_FW_FIT_EG_MOTOR_CASE_END = 0x31FF;
    public final static int FCLE_FW_SCN_UI_CANCEL_SCAN = 0x4001;    // Panel
    public final static int FCLE_FW_SCN_ABORT_SCAN = 0x4002;    // Software
    public final static int FCLE_FW_SCN_MEMORY_FULL = 0x4003;    // Allocate memory fail
    public final static int FCLE_FW_SCN_USB_DISCONNNECT = 0x4004;    // FW internal usage
    public final static int FCLE_FW_PM36_ERR = 0x4005;
    public final static int FCLE_FW_PM36_ERR_NO_INPUTDONE = 0x4015;
    public final static int FCLE_FW_PM36_ERR_NO_PAGEDONE = 0x4025;
    public final static int FCLE_FW_PM36IF_ERR_NO_PAGEDONE = 0x4035;
    public final static int FCLE_FW_PM36_ERR_NO_JPEGENDFLAG = 0x4045;
    public final static int FCLE_FW_PM36_ERR_PASSTHROUGH = 0x4055;
    public final static int FCLE_FW_PM36_ERR_EXTSRAM = 0x4065;
    public final static int FCLE_FW_PM36_ERR_ENCODEDDATA = 0x4075;
    public final static int FCLE_FW_ERR_LVDS0_PLL_LOCK = 0x5001;
    public final static int FCLE_FW_ERR_LVDS1_PLL_LOCK = 0x5002;
    public final static int FCLE_FW_ERR_SPI0_PLL_LOCK = 0x5003;
    public final static int FCLE_FW_ERR_SPI1_PLL_LOCK = 0x5004;
    public final static int FCLE_FW_ERR_BTM_LED_DUTY = 0x5005;
    public final static int FCLE_FW_ERR_TOP_LED_DUTY = 0x5006;
    public final static int FCLE_FW_ERR_BTM_LED_CCD = 0x5007;
    public final static int FCLE_FW_ERR_TOP_LED_CCD = 0x5008;
    public final static int FCLE_FW_ERR_BAND_DONE = 0x5009;
    public final static int FCLE_FW_WRONG_VENDOR_CMD = 0x6001;    // Command Code
    public final static int FCLE_FW_ERROR_PARAM_SIZE = 0x6002;    // Data length mismatch data size
    public final static int FCLE_FW_NOT_SUPPORT_DTQ = 0x6003;
    public final static int FCLE_FW_SCN_JOB_ADD_SCAN = 0x6004;
    public final static int FCLE_FW_DOWN_PANELFW_ERR = 0x6005;
    public final static int FCLE_FW_MOUNT_JFFS2_ERR = 0x600E;
    public final static int FCLE_FW_BURN_FW_ERR = 0x7001;
    public final static int FCLE_FW_FLASH_PROTECTED = 0x7002;
    //  FCLE_FW_PEI_ERR                                = 0x8001;
    // Just for DD portion
    public final static int FCLE_FW_SCN_LISR_ERROR = 0x110;
    public final static int FCLE_FW_CMD_UNKNOWN = 0x201;
    public final static int FCLE_FW_UNKNOWN = 0x202;
    public final static int FCLE_USB_INVALID_HANDLE = 0x261;
    public final static int FCLE_USB_TIMEOUT = 0x262;
    public final static int FCLE_USB_BULK_IN_ERR = 0x263;
    public final static int FCLE_USB_BULK_OUT_ERR = 0x264;
    public final static int FCLE_USB_CONTROL_ERR = 0x265;
    public final static int FCLE_USB_INTERRUPT_ERR = 0x266;
    public final static int FCLE_USB_OVERLAPPED_FAILED = 0x267;
    public final static int FCLE_USB_FUNC_FALSE_AND_NOT_IO_PENDING = 0x268;
    public final static int FCLE_WRONG_BULK_SIZE = 0x2A1;


    //Sensor Status Code
    public final static int SENSOR_HATCH = 0x0001;    //  0
    public final static int SENSOR_PL = 0x0002;    //  1
    public final static int SENSOR_PP = 0x0004;    //  2
    public final static int SENSOR_SL = 0x0008;    //  3
    public final static int SENSOR_PW = 0x0010;    //  4
    public final static int SENSOR_IP = 0x0010;    //  4
    public final static int SENSOR_IP_STALL = 0x0100;    //  8
    public final static int SENSOR_PICKUP = 0x0200;    //  9
    public final static int SENSOR_PICKUP_HOME = 0x0400;    // 10
    public final static int SENSOR_PRNU = 0x0800;    // 11
    public final static int SENSOR_VIRTUAL = 0x8000;     // 15


    //FCL Data Type
//    // for FCLC_CAPABILITIES
//    FCLD_CAP_STARBUCK                      = 0x01,
//    // for FCLC_DEVICE_STATUS
//    FCLD_STATUS_STARBUCK                   = 0x01,
//    FCLD_STATUS_LASTERR,
//    FCLD_STATUS_SENSOR,
//    // for FCLC_LINE_IMAGE & FCLC_BLOCK_IMAGE
//    FCLD_8BITS_IMAGE                       = 0x01,
    public final static int FCLD_8BITS_IMAGE_N_STATUS              = 0x02;
//    FCLD_8BITS_IMAGE_RAW                   = 0x03,
//    FCLD_16BITS_IMAGE                      = 0x11,
//    FCLD_16BITS_IMAGE_N_STATUS             = 0x12,
//    FCLD_16BITS_IMAGE_RAW                  = 0x13,
//    FCLD_REG_SCANDMADONE                   = 0x20,
//    // for FCLC_FW_CODE
//    FCLD_FW_LLBOOT                         = 0x01,
//    FCLD_FW_UBOOT                          = 0x02,
//    FCLD_FW_KERNEL                         = 0x03,
//    FCLD_FW_ROOTFS                         = 0x04,
//    FCLD_FW_PROGRAM                        = 0x05,
//    FCLD_FW_PANEL                          = 0x06,
//    FCLD_FW_MOTOR_DRV                      = 0x10,
//    FCLD_FW_SOURCE_DRV                     = 0x11,
//    FCLD_FW_LOWPOWER_DRV                   = 0x12,
//    FCLD_FW_PACKAGE                        = 0x100,
//    FCLD_FW_BRN                            = 0x101,
//    FCLD_FW_SPIFLASH                       = 0x102,
//    // Archer
//    FCLD_FW_ARCHER_BOOTSTRAP               = 0x00,
//    FCLD_FW_ARCHER_ARMBOOT                 = 0x01,
//    FCLD_FW_ARCHER_ZIMAGE                  = 0x02,
//    FCLD_FW_ARCHER_ROOTFS                  = 0x03,
//    FCLD_FW_ARCHER_ALLFLASH                = 0x04,     // == FCLD_FW_PACKAGE
//    FCLD_FW_ARCHER_SELF_DEFINE             = 0x05,
//    FCLD_FW_ARCHER_MCU                     = 0x06,     // == FCLD_FW_PANEL
//    FCLD_FW_ARCHER_DATAFS                  = 0x07,
//    FCLD_FW_ARCHER_MINI6410                = 0x08,
//    FCLD_FW_ARCHER_FPGA                    = 0x09,
//    // for FCLC_SCAN_PARAM
//    FCLD_SCPARAM_WIA                       = 0x01,
//    FCLD_SCPARAM_AUTO_X                    = 0x02,
//    // for FCLC_TEST_OPTIONS
//    FCLD_TEST_STARBUCK                     = 0x01,
//    // for FCLC_DEBUG_OPTIONS
//    FCLD_DEBUG_STARBUCK                    = 0x01,
//    // for FCLC_GAMMA_TABLE
//    FCLD_16x8_GAMMA_RGB                    = 0x01,
//    FCLD_16x8_GAMMA_R                      = 0x02,
//    FCLD_16x8_GAMMA_G                      = 0x03,
//    FCLD_16x8_GAMMA_B                      = 0x04,
//    FCLD_16x8_GAMMA_GRAY                   = 0x05,
//    FCLD_16x8_GAMMA_RGB_BTM                = 0x06,
//    FCLD_16x8_GAMMA_RGB_TOP                = 0x07,
//    FCLD_8x8_GAMMA_RGB                     = 0x11,
//    FCLD_8x8_GAMMA_R                       = 0x12,
//    FCLD_8x8_GAMMA_G                       = 0x13,
//    FCLD_8x8_GAMMA_B                       = 0x14,
//    FCLD_8x8_GAMMA_GRAY                    = 0x15,
//    FCLD_8x8_GAMMA_RGB_BTM                 = 0x16,
//    FCLD_8x8_GAMMA_RGB_TOP                 = 0x17,
//    FCLD_16x16_GAMMA_RGB                   = 0x21,
//    FCLD_16x16_GAMMA_R                     = 0x22,
//    FCLD_16x16_GAMMA_G                     = 0x23,
//    FCLD_16x16_GAMMA_B                     = 0x24,
//    FCLD_16x16_GAMMA_GRAY                  = 0x25,
//    FCLD_16x16_GAMMA_RGB_BTM               = 0x26,
//    FCLD_16x16_GAMMA_RGB_TOP               = 0x27,
//    FCLD_8x1024_GAMMA_RGB                  = 0x31,
//    FCLD_8x1024_GAMMA_R                    = 0x32,
//    FCLD_8x1024_GAMMA_G                    = 0x33,
//    FCLD_8x1024_GAMMA_B                    = 0x34,
//    FCLD_8x1024_GAMMA_GRAY                 = 0x35,
//    FCLD_8x1024_GAMMA_RGB_BTM              = 0x36,
//    FCLD_8x1024_GAMMA_RGB_TOP              = 0x37,
//    // for FCLC_RGB_MATRIX
//    FCLD_MATRIX_3x3                        = 0x01,
//    // for FCLC_CONVOLUTION
//    FCLD_CONVOLUTION_STARBUCK              = 0x01,
//    FCLD_CONVOLUTION_R                     = 0x02,
//    FCLD_CONVOLUTION_G                     = 0x03,
//    FCLD_CONVOLUTION_B                     = 0x04,
//    // for FCLC_FACTORY_SHADING
//    FCLD_FSHADING_PWM                      = 0x0010,
//    FCLD_FSHADING_300_BTM                  = 0x0100,
//    FCLD_FSHADING_600_BTM                  = 0x0101,
//    FCLD_FSHADING_300_TOP                  = 0x1000,
//    FCLD_FSHADING_600_TOP                  = 0x1001,
//    FCLD_FSHADING_300_DUPLEX               = 0x1100,
//    FCLD_FSHADING_600_DUPLEX               = 0x1101,
//    FCLD_FSHADING_300_DUPLEX_K             = 0x1102,
//    FCLD_FSHADING_600_DUPLEX_K             = 0x1104,
//    // for FCLC_CALIB_PARAM
//    // for FCLC_CALIB_IMG_LINE_GAIN
//    // for FCLC_CALIB_IMG_LINE_OFFSET
//    // for FCLC_CALIB_IMG_PIXEL_GAIN
//    // for FCLC_CALIB_IMG_PIXEL_OFFSET
//    // for FCLC_CALIB_IMG_PWM
//    // for FCLC_CALIB_IMG_LOW_FREQUENCY
//    FCLD_CALIB_STARBUCK                    = 0x01,
//    FCLD_CALIB_THREE_SIDE                  = 0x02,
//    FCLD_CALIB_1200C                       = 0x11,
//    FCLD_CALIB_1200C_BTM                   = 0x12,
//    FCLD_CALIB_1200C_TOP                   = 0x13,
//    FCLD_CALIB_1200G                       = 0x14,
//    FCLD_CALIB_1200G_BTM                   = 0x15,
//    FCLD_CALIB_1200G_TOP                   = 0x16,
//    FCLD_CALIB_600C                        = 0x21,
//    FCLD_CALIB_600C_BTM                    = 0x22,
//    FCLD_CALIB_600C_TOP                    = 0x23,
//    FCLD_CALIB_600G                        = 0x24,
//    FCLD_CALIB_600G_BTM                    = 0x25,
//    FCLD_CALIB_600G_TOP                    = 0x26,
//    FCLD_CALIB_300C                        = 0x31,
//    FCLD_CALIB_300C_BTM                    = 0x32,
//    FCLD_CALIB_300C_TOP                    = 0x33,
//    FCLD_CALIB_300G                        = 0x34,
//    FCLD_CALIB_300G_BTM                    = 0x35,
//    FCLD_CALIB_300G_TOP                    = 0x36,
//    FCLD_CALIB_200C                        = 0x41,
//    FCLD_CALIB_200C_BTM                    = 0x42,
//    FCLD_CALIB_200C_TOP                    = 0x43,
//    FCLD_CALIB_200G                        = 0x44,
//    FCLD_CALIB_200G_BTM                    = 0x45,
//    FCLD_CALIB_200G_TOP                    = 0x46,
//    FCLD_CALIB_150C                        = 0x51,
//    FCLD_CALIB_150C_BTM                    = 0x52,
//    FCLD_CALIB_150C_TOP                    = 0x53,
//    FCLD_CALIB_150G                        = 0x54,
//    FCLD_CALIB_150G_BTM                    = 0x55,
//    FCLD_CALIB_150G_TOP                    = 0x56,
//    // for FCLC_DECELERATE
//    FCLD_DECEL_RATE                        = 0x01,    // N/A
//    FCLD_DECEL_1200C                       = 0x11,
//    FCLD_DECEL_1200G                       = 0x12,
//    FCLD_DECEL_600C                        = 0x21,
//    FCLD_DECEL_600G                        = 0x22,
//    FCLD_DECEL_300C                        = 0x31,
//    FCLD_DECEL_300G                        = 0x32,
//    FCLD_DECEL_200C                        = 0x41,
//    FCLD_DECEL_200G                        = 0x42,
//    FCLD_DECEL_150C                        = 0x51,
//    FCLD_DECEL_150G                        = 0x52,
//    // for FCLC_NVRAM
//    FCLD_NVRAM_STARBUCK                    = 0x01,
//    FCLD_NVRAM_SB_OFFSET0                  = 0x1000,
//    // 0x1001 ~~ 0x118F
//    FCLD_NVRAM_SB_OFFSET400                = 0x1190,
//    // for FCLC_MOTOR_SETTING
//    FCLD_MOTOR_CURVE                       = 0x01,
//    FCLD_MOTOR_DESCRIP,
//    FCLD_MOTOR_CURVE2,
//    FCLD_MOTOR_DESCRIP2,
//    FCLD_MOTOR_START1,
//    FCLD_MOTOR_STOP1,
//    FCLD_MOTOR_STATUS1,
//    FCLD_MOTOR_CHANGE_SPEED1,
//    FCLD_MOTOR_START2,
//    FCLD_MOTOR_STOP2,
//    FCLD_MOTOR_STATUS2,
//    FCLD_MOTOR_CHANGE_SPEED2,
//    // for FCLC_MOTOR_MOVE
//    FCLD_MOVE_SL_ON_OFFSET                 = 0x01,
//    FCLD_MOVE_SL_OFF_OFFSET,
//    FCLD_MOVE_PP_ON_OFFSET,
//    FCLD_MOVE_PP_OFF_OFFSET,
//    // for FCLC_SHADING_DATA
//    FCLD_SHADING_DATA_4800_TOP             = 0x01,
//    FCLD_SHADING_DATA_4800_BOTTOM          = 0x02,
//    FCLD_SHADING_DATA_4800_DUPLEX          = 0x03,
//    FCLD_SHADING_DATA_1200_TOP             = 0x11,
//    FCLD_SHADING_DATA_1200_BOTTOM          = 0x12,
//    FCLD_SHADING_DATA_1200_DUPLEX          = 0x13,
//    FCLD_SHADING_DATA_600_TOP              = 0x21,
//    FCLD_SHADING_DATA_600_BOTTOM           = 0x22,
//    FCLD_SHADING_DATA_600_DUPLEX           = 0x23,
//    FCLD_SHADING_DATA_300_TOP              = 0x31,
//    FCLD_SHADING_DATA_300_BOTTOM           = 0x32,
//    FCLD_SHADING_DATA_300_DUPLEX           = 0x33,
//    FCLD_SHADING_DATA_200_TOP              = 0x41,
//    FCLD_SHADING_DATA_200_BOTTOM           = 0x42,
//    FCLD_SHADING_DATA_200_DUPLEX           = 0x43,
//    FCLD_SHADING_DATA_150_TOP              = 0x51,
//    FCLD_SHADING_DATA_150_BOTTOM           = 0x52,
//    FCLD_SHADING_DATA_150_DUPLEX           = 0x53,
//    FCLD_SHADING_MASTER_FLASH              = 0xA1,
//    FCLD_SHADING_MASTER_DRAM               = 0xA2,
//    FCLD_SHADING_SLAVE_FLASH               = 0xB1,
//    FCLD_SHADING_SLAVE_DRAM                = 0xB2,
//    FCLD_SHADING_BTM_FLASH                 = 0xC1,
//    FCLD_SHADING_BTM_DRAM                  = 0xC2,
//    FCLD_SHADING_WHITE_RATIO               = 0xD1,
//    // for FCLC_LAMP_STATE
//    FCLD_LAMP_TURN_ON                      = 0x01,
//    FCLD_LAMP_OFF_TIMER                    = 0x02,
//    FCLD_LAMP_OFF_TIMER_DISABLE            = 0x03,
//    FCLD_LAMP_STATE                        = 0x04,
//    FCLD_AUTO_OFF_TIMER                    = 0x05,
//    FCLD_AUTO_OFF_TIMER_DISABLE            = 0x06,
//    // for FCLC_DIAGNOSIS_MODE
//    FCLD_DEFAULT_SIDEEDGE                  = 0x01,
//    // for FCLC_PANEL_LCD_STRING                      // Write Only
//    FCLD_PANEL_STARBUCK                    = 0x01,    // 5 BYTES
//    // BYTE 0 : fixed 0xFA
//    //          0xFA : USB FW --> Panel FW
//    //          0xFB : USB FW <-- Panel FW
//    // BYTE 1 : 0x01  [Display Type]
//    //          0x01 : Fixed Display
//    //          0x02 : Flashing
//    // BYTE 2 : 0x00 ~ 0x63 (99) [LCD Count]
//    // BYTE 3 : BYTE1+BYTE2 [CheckSum]
//    // BYTE 4 : fixed 0xFD [Ending]
//    // for FCLC_FPGA_TEST
//    FCLD_FPGA_DEFAULT_VALUE_TEST           = 0x01,
//    FCLD_FPGA_REG_RW_TEST                  = 0x02,
//    FCLD_FPGA_DRAM_RW_TEST                 = 0x03,
//    FCLD_FPGA_SPI_RW_TEST                  = 0x04,
//    FCLD_FPGA_BIST_LVDS_MODE_1             = 0x05,
//    FCLD_FPGA_BIST_LVDS_MODE_2             = 0x06,
//    FCLD_FPGA_BIST_LVDS_MODE_3             = 0x07,
//    FCLD_FPGA_BIST_DRAM_MODE_1             = 0x08,
//    FCLD_FPGA_BIST_DRAM_MODE_2             = 0x09,
//    FCLD_FPGA_BIST_DRAM_MODE_3             = 0x0A,
//    FCLD_FPGA_DEFAULT_VALUE_TEST_SLAVE     = 0x11,
//    FCLD_FPGA_REG_RW_TEST_SLAVE            = 0x12,
//    FCLD_FPGA_DRAM_RW_TEST_SLAVE           = 0x13,
//    FCLD_FPGA_SPI_RW_TEST_SLAVE            = 0x14,
//    FCLD_FPGA_BIST_LVDS_MODE_1_SLAVE       = 0x15,
//    FCLD_FPGA_BIST_LVDS_MODE_2_SLAVE       = 0x16,
//    FCLD_FPGA_BIST_LVDS_MODE_3_SLAVE       = 0x17,
//    FCLD_FPGA_BIST_DRAM_MODE_1_SLAVE       = 0x18,
//    FCLD_FPGA_BIST_DRAM_MODE_2_SLAVE       = 0x19,
//    FCLD_FPGA_BIST_DRAM_MODE_3_SLAVE       = 0x1A,
//    FCLD_FPGA_OUTPUT_TEST_600C_16          = 0x21,
//    FCLD_FPGA_OUTPUT_TEST_300C_10,
//    FCLD_FPGA_OUTPUT_TEST_400C_10,
//    FCLD_FPGA_OUTPUT_TEST_600C_10,
//    FCLD_FPGA_OUTPUT_TEST_200C_10,
//    FCLD_FPGA_OUTPUT_TEST_600C_16_SLAVE    = 0x31,
//    FCLD_FPGA_OUTPUT_TEST_300C_10_SLAVE,
//    FCLD_FPGA_OUTPUT_TEST_400C_10_SLAVE,
//    FCLD_FPGA_OUTPUT_TEST_600C_10_SLAVE,
//    FCLD_FPGA_OUTPUT_TEST_200C_10_SLAVE,
//    // for FCLC_FPGA
//    FCLD_FPGA_CODE_MASTER                  = 0x01,
//    FCLD_FPGA_CODE_SLAVE                   = 0x02,
//    FCLD_FPGA_CODE_BOTH                    = 0x03,
//    FCLD_FPGA_MODULE_MASTER                = 0x11,
//    FCLD_FPGA_MODULE_SLAVE                 = 0x12,
//    FCLD_FPGA_MODULE_BOTH                  = 0x13,
//    // for FCLC_DEBUG
//    FCLD_DEBUG_DATA                        = 0x00,
//    FCLD_DEBUG_SCANSRC                     = 0x01,
//    FCLD_DEBUG_USBSTR                      = 0x02,
//    // for FCLC_SET_LCM_STRING
//    FCLD_LCM_PROFILE                       = 0x01,
//    FCLD_LCM_CGRAM                         = 0x02,
//    FCLD_LCM_PROFILEMASK                   = 0x03,
//    FCLD_LCM_DEFAULTPROFILE                = 0x04,
//    FCLD_LCM_PROFILEMASK_NVRAM             = 0x05,
//    FCLD_LCM_GET_PROFILE_INDEX             = 0x06,
//    FCLD_LCM_SETLANGUAGE                   = 0x07,   // 1 byte setting data.
//    FCLD_LCM_COPY_COUNT                    = 0x08,
//    // for FCLC_FLASH
//    FCLD_FLASH_4M_BOOT                     =  0,
//    FCLD_FLASH_4M_PRGM                     =  9,
//    FCLD_FLASH_4M_NVRAM_HP                 = 19,
//    FCLD_FLASH_4M_NVRAM_FIT                = 20,
//    FCLD_FLASH_4M_MTR_PARAM                = 21,
//    FCLD_FLASH_4M_SHADING                  = 22,
//    FCLD_FLASH_4M_SHADING_SLAVE            = 23,
//    FCLD_FLASH_4M_NVRAM_HP_BK              = 24,
//    FCLD_FLASH_4M_NVRAM_FIT_BK             = 25,
//    FCLD_FLASH_4M_MTR_PARAM_BK             = 26,
//    FCLD_FLASH_4M_SHADING_BK               = 27,
//    FCLD_FLASH_4M_SHADING_SLAVE_BK         = 28,
//    FCLD_FLASH_2M_BOOT                     =  0,
//    FCLD_FLASH_2M_PRGM                     =  5,
//    FCLD_FLASH_2M_NVRAM_HP                 = 15,
//    FCLD_FLASH_2M_NVRAM_FIT                = 16,
//    FCLD_FLASH_2M_MTR_PARAM                = 17,
//    FCLD_FLASH_2M_SHADING                  = 18,
//    FCLD_FLASH_2M_SHADING_SLAVE            = 19,
//    FCLD_FLASH_2M_NVRAM_HP_BK              = 20,
//    FCLD_FLASH_2M_NVRAM_FIT_BK             = 21,
//    FCLD_FLASH_2M_MTR_PARAM_BK             = 22,
//    FCLD_FLASH_2M_SHADING_BK               = 23,
//    FCLD_FLASH_2M_SHADING_SLAVE_BK         = 24,
//
//    // for FCLC_MOTOR_FREE_RUN
//    FCLD_MOTOR_ESPRESSO                    = 0x01,
//
//    // for FCLC_LOOP_PAPER_FEED
//    FCLD_FEED_SPEED_CASE                   = 0x01,
//    FCLD_FEED_GAPSENSOR_CASE               = 0x02,
//
//    FCLD_FEED_SPEED_SF_300                 = 0x01,
//    FCLD_FEED_SPEED_SF_300_FAST            = 0x02,
//    FCLD_FEED_SPEED_SF_600                 = 0x03,
//    FCLD_FEED_SPEED_FB_300                 = 0x04,
//    FCLD_FEED_SPEED_FB_600                 = 0x05,
//    FCLD_FEED_SPEED_FB_1200                = 0x06,
//
//    // for FCLC_ULTRASONICDATA
//    FCLD_ULTRASONIC_THRESHOLD              = 0x01,
//    FCLD_ULTRASONIC_TEST_MODE              = 0x02,
//    FCLD_ULTRASONIC_MULTIPICK              = 0x02,
//    FCLD_ULTRASONIC_TEST_DATA              = 0x03,
//    FCLD_ULTRASONIC_PAPER_EXIST            = 0x04,
//    FCLD_ULTRASONIC_STATUS                 = 0x05,
//    FCLD_ULTRASONIC_TURN_ON                = 0x06,
//    FCLD_ULTRASONIC_TURN_OFF               = 0x07,
//    FCLD_ULTRASONIC_EXIST_VALUE            = 0x08,
//    FCLD_ULTRASONIC_LEAVE_VALUE            = 0x09,
//    FCLD_ULTRASONIC_STATIC_VALUE           = 0x10,
//    FCLD_GAPSENSOR_TEST_DATA               = 0x0A,
//    FCLD_GAPSENSOR_THRESHOLD               = 0x0B,
//    FCLD_GAPSENSOR_STATIC_VALUE            = 0x0C,
//    // for FCLC_NVRAM_FIT
//    FCLD_NVRAM_FIT_START_POS               = 0x00,
//    FCLD_NVRAM_FIT_SCAN_EDGE_300           = 0x0100,
//    FCLD_NVRAM_FIT_CROP_INFO_300,
//    FCLD_NVRAM_FIT_SHADINGCHART_EDGE,
//    FCLD_NVRAM_FIT_BG_SEGMENT_INFO,
//    FCLD_NVRAM_FIT_CALIB_PARAM_300,
//    FCLD_NVRAM_FIT_CALIB_PARAM_600,
//    FCLD_NVRAM_FIT_SCAN_EDGE_600,
//    FCLD_NVRAM_FIT_CROP_INFO_600,
//    FCLD_NVRAM_FIT_SCAN_EDGE_300_FB,
//    // for FCLC_DITHER
//    FCLD_DITHER_ED                         = 0x01,
//    FCLD_DITHER_8x8                        = 0x02,
//    FCLD_DITHER_16x16                      = 0x03,
//    FCLD_DITHER_32x32                      = 0x04,
//    FCLD_DITHER_64x64                      = 0x05,
//    FCLD_DITHER_128x128                    = 0x06,
//    // for FCLC_PAGEEND_INFO
//    FCLD_PAGE_START                        = 0x00,
//    FCLD_PAGE_END                          = 0x01,
//    FCLD_TOTAL_END                         = 0x02,
//    FCLD_LOG_ORDER_SYNC                    = 0x03,
//    // for FCLC_PERFORMANCE
//    FCLD_MASTER_BAND_SIZE                  = 0x01,
//    FCLD_SLAVE_BAND_SIZE                   = 0x02,
//    FCLD_MASTER_PAGE_SIZE                  = 0x03,
//    FCLD_SLAVE_PAGE_SIZE                   = 0x04,
//    FCLD_MASTER_BAND_DATA                  = 0x11,
//    FCLD_SLAVE_BAND_DATA                   = 0x12,
//    FCLD_MASTER_PAGE_DATA                  = 0x13,
//    FCLD_SLAVE_PAGE_DATA                   = 0x14,
//    // for FCLC_PM36_TEST
//    FCLD_MASTER_PM36_REG                   = 0x01,
//    FCLD_MASTER_EXTSRAM                    = 0x02,
//    FCLD_MASTER_PM36_PASSTHROUGH           = 0x03,
//    FCLD_MASTER_PM36_COMPRESS              = 0x04,
//    FCLD_SLAVE_PM36_REG                    = 0x11,
//    FCLD_SLAVE_EXTSRAM                     = 0x12,
//    FCLD_SLAVE_PM36_PASSTHROUGH            = 0x13,
//    FCLD_SLAVE_PM36_COMPRESS               = 0x14,
//    // for FCLC_GRAY_TABLE
//    FCLD_GRAY_TABLE_TOP                    = 0x01,
//    FCLD_GRAY_TABLE_BTM                    = 0x02,
//    //FCLC_SLAVE_STARTDOCAL
//    FCLD_SLAVE_CONTINUE_DOCAL              = 0x01,
//    FCLD_SLAVE_NOT_CONTINUE_CAL            = 0x02,
//    FCLD_SLAVE_CONTINUE_SCAN               = 0x11,
//    FCLD_SLAVE_NOT_CONTINUE_SCAN           = 0x12,
//    // for FCLC_HARDWARE_LOGGING
//    FCLD_HARDWARE_LOGGING_STATUS           = 0x01,
//    FCLD_HARDWARE_LOGGING_COUNT            = 0x02,     //Get Hardware log counts
//    FCLD_HARDWARE_LOGGING_DATA             = 0x03,     //Get Hardware log Data
//    // for FCLC_RDC_TESTDATA
//    FCLD_RDC_DATA_MASTER                   = 0x01,
//    FCLD_RDC_DATA_SLAVE                    = 0x02,
//    // for FCLC_CLEAR_DATAFS
//    FCLD_DATAFS_EDGE                       = 0x01,
//    FCLD_DATAFS_NVRAM                      = 0x02,
//    FCLD_DATAFS_LINE_GAIN_OFFSET           = 0x03,
//    FCLD_DATAFS_SHADING                    = 0x04,
//    FCLD_DATAFS_ULTRASONIC                 = 0x05,
//    // for FCLC_MULTIPICK
//    FCLD_MULTIPICK_IGNORE                  = 0x01,
//    // for FCLC_MAC_ADDRESS
//    FCLD_MAC_ADDRESS_LAN                   = 0x00,
//    FCLD_MAC_ADDRESS_WIFI,
//    FCLD_END                               = 0xFF // Useless, just keep it in the end.
}
