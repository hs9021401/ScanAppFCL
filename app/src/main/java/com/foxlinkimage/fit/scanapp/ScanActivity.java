package com.foxlinkimage.fit.scanapp;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.foxlinkimage.fit.fcl.DeviceStatusStruct;
import com.foxlinkimage.fit.fcl.FCLCode;
import com.foxlinkimage.fit.fcl.ScanParameterStruct;
import com.foxlinkimage.fit.fcl.VendorCommandStruct;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class ScanActivity extends Activity {
    PreferenceHelper mPreferenceHelper;
    private String strIP, strRootFolder, strRootThumbnailsFolder;
//    private String device_State, device_AdfState;
//    private String strDocumentFormat, strInputSource, strColorMode, strColorSpace, strCcdChannel, strBinaryRendering, strDuplex, strDiscreteResolution;
//    private Boolean bCancelScan;
//    private Boolean bIsScanning;


    private File fileJobFolder;
    private File fileJobFolderThumbnails;
    private final MyHandler handler = new MyHandler(this);

    private final int REQ_CODE = 1122334455;
    private static final int HANDLE_SCAN_MSG_CODE = 11274485;
    private static final int HANDLE_ANIMSTOP_MSG_CODE = 643235;
    private static final int HANDLE_TIMEOUT_MSG_CODE = 478421;

    Socket socket = null;
    static final String SERVER_IP = "192.168.56.1";
    static final int SERVER_PORT = 2345;

    private ImageView imgScanAnim;
    private Button btnCancelScan;
    public static ProgressDialog PDialog;

    private long dwFCLDeviceStatus;

    @Override
    protected void onPostResume() {
        super.onPostResume();

        //get setting value
        initialDefaultValue();

//        bCancelScan = false;
//        bIsScanning = false;
//        doGetStatus();

        //Do FCL Scan Flow
        doFCLScan();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        imgScanAnim = (ImageView) findViewById(R.id.scananim);
        imgScanAnim.setImageDrawable(getResources().getDrawable(R.drawable.scanning));

        btnCancelScan = (Button) findViewById(R.id.cancelscan);
        btnCancelScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                bCancelScan = true;
                PDialog = new ProgressDialog(ScanActivity.this);
                PDialog.setTitle(getResources().getString(R.string.canceling));
                PDialog.setMessage(getResources().getString(R.string.waitmessage));
                PDialog.show();
            }
        });
    }

    private void initialDefaultValue() {
        mPreferenceHelper = new PreferenceHelper(getApplicationContext());
        strIP = mPreferenceHelper.getPreferenceString(PreferenceHelper.key_IP);
        strRootFolder = PreferenceHelper.strDefaultSaveFolderPath;
        strRootThumbnailsFolder = PreferenceHelper.strDefaultSaveFolderThumbnailsPath;
//        strDocumentFormat = mPreferenceHelper.getPreferenceString(PreferenceHelper.key_DOCUMENT_FORMAT);
//        strInputSource = mPreferenceHelper.getPreferenceString(PreferenceHelper.key_INPUT_SOURCE);
//        strColorMode = mPreferenceHelper.getPreferenceString(PreferenceHelper.key_COLOR_MODE);
//        strColorSpace = mPreferenceHelper.getPreferenceString(PreferenceHelper.key_COLOR_SPACE);
//        strCcdChannel = mPreferenceHelper.getPreferenceString(PreferenceHelper.key_CCD_CHANNEL);
//        strBinaryRendering = mPreferenceHelper.getPreferenceString(PreferenceHelper.key_BINARY_RENDERING);
//        strDuplex = mPreferenceHelper.getPreferenceString(PreferenceHelper.key_DUPLEX);
//        strDiscreteResolution = mPreferenceHelper.getPreferenceString(PreferenceHelper.key_DISCRETE_RESOLUTION);
    }


    //Create handler with WeakRederence class to avoid memory leak
    // http://www.androiddesignpatterns.com/2013/01/inner-class-handler-memory-leak.html
    public static class MyHandler extends Handler {
        private final WeakReference<ScanActivity> mActivity;

        public MyHandler(ScanActivity activity) {
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            final ScanActivity activity = mActivity.get();

            if (activity != null) {
                switch (msg.what) {
//                    case HANDLE_SCAN_MSG_CODE:
//                        Bundle data = msg.getData();
//                        String tmp_state = data.getString("state");
//                        String tmp_adfstate = data.getString("adfstate");
//
//                        TextView txt = (TextView) activity.findViewById(R.id.response);
//                        txt.setText("state: " + tmp_state + "\n" + "adfstate: " + tmp_adfstate + "\n");
//
//                        //檢查scanner state, 通過就會做scan
//                        if (activity.device_State.equals("Idle")) {
//                            if (activity.strInputSource.equals("Feeder")) //送紙方式, 檢查是否有放紙進去
//                            {
//                                if (activity.device_AdfState.equals("ScannerAdfEmpty")) {
//                                    Toast.makeText(activity.getApplicationContext(), activity.getString(R.string.nopaperinfeeder), Toast.LENGTH_SHORT).show();
//                                    activity.finish();
//                                } else
//                                    activity.doScan();
//                            } else if (activity.strInputSource.equals("Platen"))  //flatback
//                                activity.doScan();
//                        } else {
//                            Toast.makeText(activity.getApplicationContext(), activity.getString(R.string.devicebusy), Toast.LENGTH_SHORT).show();
//                            activity.finish();
//                        }
//                        break;

                    case HANDLE_ANIMSTOP_MSG_CODE:
                        PDialog.dismiss();
                        break;

                    case HANDLE_TIMEOUT_MSG_CODE:
                        new AlertDialog.Builder(activity)
                                .setTitle("與掃描器連線逾時")
                                .setMessage("即將跳轉設定頁面, 請檢查裝置IP設定")
                                .setPositiveButton(activity.getApplicationContext().getResources().getString(R.string.OK), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent it = new Intent(activity.getApplicationContext(), SettingsActivity.class);
                                        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        activity.getApplicationContext().startActivity(it);
                                    }
                                }).show();
                        break;

                }
            }
        }
    }

    private void doFCLScan() {
        new SendTask().execute();
    }

    public class SendTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                socket = new Socket(SERVER_IP, SERVER_PORT);
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                //1.Send vendor command
                sendVendorCommand(outputStream, FCLCode.FOP_INQUIRY, FCLCode.FCLC_DEVICE_STATUS, 0x00, 0x00);
                dwFCLDeviceStatus = getDeviceStatus();

                //2.Get Deivce Status
                if (dwFCLDeviceStatus == 0x00) {
                    //3.Send vendor command ready to write scan parameter
                    sendVendorCommand(outputStream, FCLCode.FOP_WRITE, FCLCode.FCLC_SCAN_PARAM, 0x01, 0x80);
                    //4.Get device status
                    dwFCLDeviceStatus = getDeviceStatus();
                    if (dwFCLDeviceStatus == 0x00) {
                        //5.Write scan parameter
                        writeScanParam(outputStream);
                        //6.Send vendor command structure to start scan
                        sendVendorCommand(outputStream, FCLCode.FOP_COMMAND, FCLCode.FCLC_START_SCAN, 0x00, 0x00);
                        //7.Get device status
                        dwFCLDeviceStatus = getDeviceStatus();
                        if (dwFCLDeviceStatus == 0x00) {
                            //8.Send vendor command structure to read block image
                            sendVendorCommand(outputStream, FCLCode.FOP_COMMAND, FCLCode.FCLC_BLOCK_IMAGE, 0x00, 0x00);

                            //9.Read device status structure to check command is done
                            dwFCLDeviceStatus = getDeviceStatus();
                            if (dwFCLDeviceStatus == 0x00) {
                                boolean bRecvImgFinished = false;
                                while(!bRecvImgFinished) {
                                    //10-1 Send vendor command structure
                                    sendVendorCommand(outputStream, FCLCode.FOP_READ, FCLCode.FCLC_BLOCK_IMAGE, FCLCode.FCLD_8BITS_IMAGE_N_STATUS, 0x80);
                                    //10-2 Get block image status structure to get image data information. Depend on Block Bytes to read image data. if Error Code=0x1005 -> image tail

                                    //10-3 Read Image Data

                                    bRecvImgFinished = true;
                                }
                            }
                        }
                    }
                }

                socket.close(); //close socket

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(ScanActivity.this, "Finish!!!", Toast.LENGTH_SHORT).show();
        }
    }

    private void writeScanParam(DataOutputStream outputStream) {
        try {
            ScanParameterStruct objScanParameter = new ScanParameterStruct();
            //TODO compose scan parameter
            objScanParameter.dwADF.set(14);
            objScanParameter.byInDataType.set((short)3);
            objScanParameter.byOutDataType.set((short)3);
            objScanParameter.byInPixelBits.set((short)24);
            objScanParameter.byOutPixelBits.set((short)24);
            objScanParameter.dwWidthPixels.set(2550);
            objScanParameter.dwWidthBytes.set(7650);
            objScanParameter.wXresolution.set(300);
            objScanParameter.wYresolution.set(300);
            objScanParameter.ScanWindow.xPos.set(0);
            objScanParameter.ScanWindow.yPos.set(0);
            objScanParameter.ScanWindow.xExtent.set(2550);
            objScanParameter.ScanWindow.yExtent.set(4200);
            objScanParameter.dwPaperWidth.set(0);
            objScanParameter.dwPaperHeight.set(0);
            objScanParameter.wXScaleRatio.set(100);
            objScanParameter.wYScaleRatio.set(100);
            objScanParameter.byScaleRatio.set((short)0);
            objScanParameter.byRotateMode_Bottom.set((short)0);
            objScanParameter.byRotateMode_Top.set((short)0);
            objScanParameter.byChannelDropOut.set((short)0);
            objScanParameter.byCompression.set((short)0);
            objScanParameter.byMPSMode.set((short)0);
            objScanParameter.wImageOutputMode.set(61);
            objScanParameter.dwImageProcess.set(9);
            objScanParameter.byOverScanLines.set((short)0);
            objScanParameter.byGrayFromBuf1.set((short)0);
            objScanParameter.byContrastBrightness.set((short)0);
//            objScanParameter.byHalftoneThreshold.set((short));
            objScanParameter.byThresholdRandomRange.set((short)0);
            objScanParameter.byHalftoneDitherPattern.set((short)0);
            objScanParameter.bySpecialMode.set((short)0);
            objScanParameter.byMiscOptions.set((short)0);
            objScanParameter.byScanToNetwork.set((short)0);
            objScanParameter.bySharpSmooth.set((short)0);
            objScanParameter.byColorTransform.set((short)0);
            objScanParameter.byOutputModeAndCBMode.set((short)0);
            objScanParameter.dwRealLine.set(0);
            objScanParameter.dwImageTest.set(0);
            objScanParameter.EdgeEraseArea.EdgeEraseMode1.set((short)0);
            objScanParameter.EdgeEraseArea.EdgeEraseMode2.set((short)0);
            objScanParameter.EdgeEraseArea.EdgeEraseTopValue.set((short)0);
            objScanParameter.EdgeEraseArea.EdgeEraseBtmValue.set((short)0);
            objScanParameter.EdgeEraseArea.EdgeEraseLeftValue.set((short) 0);
            objScanParameter.EdgeEraseArea.EdgeEraseRightValue.set((short) 0);
            for(int i=0;i<9;i++)
                objScanParameter.dwReserved[i].set(0);

            byte[] byteScanParameter = new byte[128];
            for (int i = 0; i < byteScanParameter.length; i++)
                byteScanParameter[i] = objScanParameter.getByteBuffer().get(i);
            outputStream.write(byteScanParameter);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void sendVendorCommand(DataOutputStream outputStream, byte byOperatipnCode, byte byControlCode, int wDataType, int dwDataLength) {
        try {
            VendorCommandStruct objVendorCommand = new VendorCommandStruct();
            objVendorCommand.VendorID.set(0x220);
            objVendorCommand.OperationCode.set(byOperatipnCode);
            objVendorCommand.ControlCode.set(byControlCode);
            objVendorCommand.DataType.set(wDataType);
            objVendorCommand.DataLength.set(dwDataLength);

            byte[] byteVendorCmd = new byte[16];
            for (int i = 0; i < byteVendorCmd.length; i++)
                byteVendorCmd[i] = objVendorCommand.getByteBuffer().get(i);
            outputStream.write(byteVendorCmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private long getDeviceStatus() throws IOException {  // 0: ready for scan, >0: Error code, -1: socket error
        long iBreak = -1;
        DeviceStatusStruct objDeviceStatus = new DeviceStatusStruct();
        while (!socket.isClosed()) {
            DataInputStream input;
            try {
                input = new DataInputStream(socket.getInputStream());
                byte[] buffer = new byte[input.available()];
                if (buffer.length != 0) {
                    input.read(buffer);

                    ByteBuffer bytebuffer = ByteBuffer.wrap(buffer);
                    bytebuffer.order(ByteOrder.LITTLE_ENDIAN);
                    objDeviceStatus.setByteBuffer(bytebuffer, 0);
                    //取得機器狀態
                    boolean bDeviceReady = objDeviceStatus.wFWInfo.get() == 0x00;
                    long ErrorCode = objDeviceStatus.dwLastErr.get();
                    int SensorStatus = objDeviceStatus.wSensorStatus.get();

                    if (ErrorCode == 0 && bDeviceReady) {
                        Toast.makeText(getApplicationContext(), "Scanner status is ready to scan", Toast.LENGTH_SHORT).show();
                        iBreak = 0;
                        break;
                    } else {
                        Toast.makeText(getApplicationContext(), "Can't scan. Error code: " + String.valueOf(ErrorCode) + ", Sensor status: " + String.valueOf(SensorStatus), Toast.LENGTH_SHORT).show();
                        iBreak = ErrorCode;
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                iBreak = -1;    //Socket connection exception
            }
        }
        return iBreak;
    }

//    private void doGetStatus() {
//        new Thread(runnableGetStatus).start();
//        runScanAnimation();
//    }
//
//    private Runnable runnableGetStatus = new Runnable() {
//        @Override
//        public void run() {
//            try {
//                URL url = new URL("http://" + strIP + "/eSCL/ScannerStatus");
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                conn.setRequestMethod("GET");
//                conn.setConnectTimeout(5000);
//                conn.setReadTimeout(5000);
//                int responseCode = conn.getResponseCode();
//                if (responseCode == 200) {
//                    InputStream is = new BufferedInputStream(conn.getInputStream());
//
//                    XmlPullParser pullParser = Xml.newPullParser();
//                    try {
//                        pullParser.setInput(is, "utf-8");  //設定語系
//                        //利用eventType來判斷目前分析到XML是哪一個部份
//                        int eventType = pullParser.getEventType();
//                        //XmlPullParser.END_DOCUMENT表示已經完成分析XML
//                        while (eventType != XmlPullParser.END_DOCUMENT) {
//                            //XmlPullParser.START_TAG表示目前分析到的是XML的Tag，如<title>
//                            if (eventType == XmlPullParser.START_TAG) {
//                                String name = pullParser.getName();
//                                if (name.equals("State")) {
//                                    device_State = pullParser.nextText();
//                                }
//                                if (name.equals("AdfState")) {
//                                    device_AdfState = pullParser.nextText();
//                                }
//                            }
//                            //分析下一個XML Tag
//                            eventType = pullParser.next();
//                        }
//                    } catch (XmlPullParserException ex) {
//                        Log.d("TAG", ex.getMessage());
//                    }
//                    conn.disconnect();
//
//                    //發送message給Main Thread顯示結果
//                    Message msg = new Message();
//                    Bundle data = new Bundle();
//                    data.putString("state", device_State);
//                    data.putString("adfstate", device_AdfState);
//                    msg.setData(data);
//                    msg.what = HANDLE_SCAN_MSG_CODE;
//                    handler.sendMessage(msg);
//
//                } else {
//                    Log.d("TAG", "Response Code: " + String.valueOf(responseCode));
//                }
//
//            } catch (IOException io) {
//                Log.d("TAG", io.getMessage());
//
//                Message msg = new Message();
//                msg.what = HANDLE_TIMEOUT_MSG_CODE;
//                handler.sendMessage(msg);
//            }
//        }
//    };

    void runScanAnimation() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;

        //過場動畫
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imgScanAnim, "X", -screenWidth, screenWidth);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imgScanAnim, "Y", -screenHeight, screenHeight);
        objectAnimator.setDuration(5000);
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.start();
    }

    private void doScan() {
        String strDate;
        strDate = new SimpleDateFormat("yyyyMMdd", Locale.TAIWAN).format(new Date());
        fileJobFolder = new File(strRootFolder + "/" + strDate);
        fileJobFolderThumbnails = new File(strRootThumbnailsFolder + "/" + strDate);

        if (!fileJobFolder.exists())
            fileJobFolder.mkdirs();

        if (!fileJobFolderThumbnails.exists())
            fileJobFolderThumbnails.mkdirs();

//        PostScanTask postScanTask = new PostScanTask();
//        postScanTask.execute();
    }


//    private class PostScanTask extends AsyncTask<Void, String, Void> {
//        @Override
//        protected void onPreExecute() {
//            Toast.makeText(getApplicationContext(), "Start to scan....", Toast.LENGTH_SHORT).show();
//            bIsScanning = true;
//        }
//
//        @Override
//        protected void onProgressUpdate(String... values) {
//            super.onProgressUpdate(values);
//
//            //            20160603 過場動畫改背景
//            Bitmap bmp = BitmapFactory.decodeFile(values[0]);
//            Drawable drawable = new BitmapDrawable(bmp);
//            imgScanAnim.setImageDrawable(drawable);
//        }
//
//        @Override
//        protected Void doInBackground(Void... strings) {
//            //組合掃描參數
//            StringBuilder xml = new StringBuilder();
//            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//            xml.append("<ScanSettings xmlns=\"http://schemas.hp.com/imaging/escl/2011/05/03\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://schemas.hp.com/imaging/escl/2011/05/03 Scan Schema - 0.26.xsd\">");
//            xml.append("<Version xmlns=\"http://www.pwg.org/schemas/2010/12/sm\">2.6</Version>");
//            xml.append("<MultipickExclusionLength>0</MultipickExclusionLength>");
//            xml.append("<MultipickDetection>false</MultipickDetection>");
//            xml.append("<ScanRegions xmlns=\"http://www.pwg.org/schemas/2010/12/sm\" xmlns:n0=\"http://www.pwg.org/schemas/2010/12/sm\" n0:MustHonor=\"false\">");
//            xml.append("<ScanRegion>");
//            xml.append("<Height>4200</Height>");
//            xml.append("<Width>2550</Width>");
//            xml.append("<XOffset>0</XOffset>");
//            xml.append("<YOffset>0</YOffset>");
//            xml.append("<ContentRegionUnits>escl:ThreeHundredthsOfInches</ContentRegionUnits>");
//            xml.append("</ScanRegion>");
//            xml.append("</ScanRegions>");
//            xml.append("<XResolution>").append(strDiscreteResolution).append("</XResolution>");
//            xml.append("<YResolution>").append(strDiscreteResolution).append("</YResolution>");
//            xml.append("<DocumentFormatExt>").append(strDocumentFormat).append("</DocumentFormatExt>");
//            xml.append("<InputSource xmlns=\"http://www.pwg.org/schemas/2010/12/sm\">").append(strInputSource).append("</InputSource>");
//            xml.append("<ColorMode>").append(strColorMode).append("</ColorMode>");
//            xml.append("<ColorSpace>").append(strColorSpace).append("</ColorSpace>");
//            xml.append("<CcdChannel>").append(strCcdChannel).append("</CcdChannel>");
//            xml.append("<BinaryRendering>").append(strBinaryRendering).append("</BinaryRendering>");
//            xml.append("<Duplex>").append(strDuplex).append("</Duplex>");
//
//            //20150805 add AutoX params
//            boolean bAutoCrop = mPreferenceHelper.getPreferenceBoolean(PreferenceHelper.key_AUTOCROP_ONOFF, false);
//            boolean bBlankPage = mPreferenceHelper.getPreferenceBoolean(PreferenceHelper.key_BLANKPAGE_DETECTION_ONOFF, false);
//            boolean bAutoColor = mPreferenceHelper.getPreferenceBoolean(PreferenceHelper.key_AUTO_COLOR_ONOFF, false);
//
//            if (bAutoCrop) {
//                xml.append("<AutoCrop>").append(bAutoCrop).append("</AutoCrop>");
//                xml.append("<Threshold>").append(mPreferenceHelper.getPreferenceInteger(PreferenceHelper.key_AUTOCROP_THRESHOLD, 128)).append("</Threshold>");
//                xml.append("<AutoExposure>").append(mPreferenceHelper.getPreferenceBoolean(PreferenceHelper.key_AUTOCROP_AUTOEXPOSURE, false)).append("</AutoExposure>");
//            }
//
//            if (bBlankPage) {
//                xml.append("<BlankPageDetection>").append(bBlankPage).append("</BlankPageDetection>");
//                xml.append("<BlankPageSensitivity>").append(mPreferenceHelper.getPreferenceInteger(PreferenceHelper.key_BLANKPAGE_SENSITIVITY, 255)).append("</BlankPageSensitivity>");
//            }
//
//            if (bAutoColor) {
//                xml.append("<ColorMode>scan:AutoColorDetection</ColorMode>");
//                xml.append("<AutoColorDetectionMode>").append(mPreferenceHelper.getPreferenceString(PreferenceHelper.key_AUTO_COLOR_DETECTION_MODE)).append("</AutoColorDetectionMode>");
//                xml.append("<ColorSensitivity>").append(mPreferenceHelper.getPreferenceInteger(PreferenceHelper.key_AUTO_COLOR_SENSITIVITY, 145)).append("</ColorSensitivity>");
//            }
//
//            xml.append("</ScanSettings>");
//
//            try {
//                URL url = new URL("http://" + strIP + "/eSCL/ScanJobs");
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                conn.setRequestMethod("POST");
//                conn.setRequestProperty("Content-Type", "text/xml");
//                conn.setRequestProperty("Content-Length", "" + Integer.toString(xml.toString().getBytes().length));
//                conn.setDoInput(true);
//                conn.setDoOutput(true);
//
//                //send scan xml command
//                DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
//                writer.writeBytes(xml.toString());
//                writer.flush();
//                writer.close();
//
//                //get response code and document location from http header
//                String ret = conn.getResponseMessage();
//                String loc = conn.getHeaderField("Location");
//                Log.d("TAG", ret + ", " + loc);
//                conn.disconnect();
//
//                //delay15秒, 待掃描完畢, 再開始下載圖片
//                Thread.sleep(15000);
//
//                for (; ; ) {
//                    url = new URL("http://" + strIP + loc + "NextDocument");
//                    conn = (HttpURLConnection) url.openConnection();
//                    conn.setRequestMethod("GET");
//                    int responseCode = conn.getResponseCode();
//
//                    if (!bCancelScan) {
//                        if (responseCode == 200) {
//                            InputStream is = new BufferedInputStream(conn.getInputStream());
//                            String timestamp;
//                            timestamp = new SimpleDateFormat("HHmmss", Locale.TAIWAN).format(new Date());
//
//                            String strDataFormat = strDocumentFormat.equals("image/jpeg") ? ".jpg" : ".pdf";    //判斷掃描文件格式
//                            OutputStream output = new FileOutputStream(fileJobFolder.getPath() + "/" + timestamp + strDataFormat);
//                            byte data[] = new byte[1024];
//                            int count;
//                            while ((count = is.read(data)) != -1) {
//                                output.write(data, 0, count);
//                            }
//                            output.flush();
//                            output.close();
//                            is.close();
//                            conn.disconnect();
//
//
//                            if (strDataFormat.equals(".jpg")) {
//                                Bitmap bmp;
//
//                                BitmapFactory.Options option = new BitmapFactory.Options();
//                                option.inJustDecodeBounds = true;   //將inJustDecodeBounds為true時, 並未將圖load進記憶體, 僅取得圖片相關資訊
//                                option.inPreferredConfig = Bitmap.Config.RGB_565;   //ARGB_8888較為耗空間
//                                BitmapFactory.decodeFile(fileJobFolder.getPath() + "/" + timestamp + strDataFormat, option);
//
//                                //依照手機螢幕寬度計算適合的縮圖比例
//                                int iSampleSize;
//                                DisplayMetrics dm = new DisplayMetrics();
//                                getWindowManager().getDefaultDisplay().getMetrics(dm);
//                                iSampleSize = GalleryAdapter.calculateInSampleSize(option, dm.widthPixels / 6);
//
//                                option.inSampleSize = iSampleSize;
//                                option.inJustDecodeBounds = false;  //將inJustDecodeBounds為false時, 之後decodeFile動作就會真正將圖片Load進記憶體
//                                bmp = BitmapFactory.decodeFile(fileJobFolder.getPath() + "/" + timestamp + strDataFormat, option);
//
//
//                                String strOutputtThumbnailsPath = fileJobFolderThumbnails + "/" + timestamp + strDataFormat;
//                                FileOutputStream fos = new FileOutputStream(strOutputtThumbnailsPath);
//                                bmp.compress(Bitmap.CompressFormat.JPEG, 60, fos);  //壓縮40%
//                                fos.close();
//                                publishProgress(strOutputtThumbnailsPath);
//                                Thread.sleep(2000);
//                            }
//                            //TODO: else(strDataFormat.equals(".pdf"))
//                        }
//
//                        if (responseCode == 404) {
//                            Log.d("TAG", "Have no next document. Save done");
//                            break;
//                        }
//                    } else {
//                        Log.d("TAG", "User cancel scan job");
//                        url = new URL("http://" + strIP + loc);
//                        conn = (HttpURLConnection) url.openConnection();
//                        conn.setRequestMethod("DELETE");
//                        responseCode = conn.getResponseCode();
//                        if (responseCode == 200) {
////                            Toast.makeText(getApplicationContext(), "Scan canceled.", Toast.LENGTH_SHORT).show();
//                            conn.disconnect();      // 要記得關掉連線, 否則app會crash =.=
//                        }
//                        break;
//                    }
//                }
//
//            } catch (IOException ex) {
//                Log.d("TAG", ex.getMessage());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            bIsScanning = false;
//            if (!bCancelScan) {
//                Log.d("TAG", "Download finished");
//                Intent it = new Intent(ScanActivity.this, FolderActivity.class);
//                startActivityForResult(it, REQ_CODE);
//                overridePendingTransition(R.animator.fade_in, R.animator.fade_out);
//            } else {
//                //發送message給Main Thread, 告知將動畫停止
//                Message msg = new Message();
//                msg.what = HANDLE_ANIMSTOP_MSG_CODE;
//                handler.sendMessage(msg);
//
//                finish();
//            }
//        }
//    }

    //按下back鍵的動作
//    @Override
//    public void onBackPressed() {
//        if (bIsScanning) {
//            new AlertDialog.Builder(ScanActivity.this)
//                    .setTitle(getResources().getString(R.string.cancelscan))
//                    .setMessage(getResources().getString(R.string.cancelscanconfirm))
//                    .setPositiveButton(getResources().getString(R.string.OK), new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            btnCancelScan.performClick();
//                        }
//                    })
//                    .setNegativeButton(getResources().getString(R.string.NO), new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//
//                        }
//                    }).show();
//        } else
//            finish();
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //當從Folder頁按上一頁按鍵時, 使用finish(), 可直接跳過本頁, 回到主頁
        if (requestCode == REQ_CODE && resultCode == RESULT_CANCELED) {
            finish();
        }
    }
}
