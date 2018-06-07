package application.com.service;

import java.util.Stack;
import cadex.*;

public class CadexEngine {

    static {
        try {
            System.loadLibrary("CadExCore");
            System.loadLibrary("CadExJT");
            System.loadLibrary("CadExSTEP");
            System.loadLibrary("CadExSTL");

//            System.loadLibrary("CadExACIS");
//            System.loadLibrary("CadExBRep");
//            System.loadLibrary("CadExCore");
//            System.loadLibrary("CadExIGES");
//            System.loadLibrary("CadExIGESXDE");
//            System.loadLibrary("CadExJT");
//            System.loadLibrary("CadExMesh");
//            System.loadLibrary("CadExOBJ");
//            System.loadLibrary("CadExPara");
//            System.loadLibrary("CadExRhino");
//            System.loadLibrary("CadExSTEP");
//            System.loadLibrary("CadExSTEPXDE");
//            System.loadLibrary("CadExSTL");
//            System.loadLibrary("CadExView");
//            System.loadLibrary("CadExVRML");
//            System.loadLibrary("CadExX3D");
//            System.loadLibrary("CadExXDE");
//            System.loadLibrary("freeimage");
//            System.loadLibrary("freetype");
//            System.loadLibrary("nglib");
//            //System.loadLibrary("QOQuickLib");
//            System.loadLibrary("salome");
//            System.loadLibrary("tbb");
//            System.loadLibrary("tbbmalloc");
//            System.loadLibrary("TKBO");
//            System.loadLibrary("TKBool");
//            System.loadLibrary("TKBRep");
//            System.loadLibrary("TKCAF");
//            System.loadLibrary("TKCDF");
//            System.loadLibrary("TKernel");
//            System.loadLibrary("TKG2d");
//            System.loadLibrary("TKG3d");
//            System.loadLibrary("TKGeomAlgo");
//            System.loadLibrary("TKGeomBase");
//            System.loadLibrary("TKHLR");
//            System.loadLibrary("TKIGES");
//            System.loadLibrary("TKLCAF");
//            System.loadLibrary("TKMath");
//            System.loadLibrary("TKMesh");
//            System.loadLibrary("TKOpenGl");
//            System.loadLibrary("TKPrim");
//            System.loadLibrary("TKService");
//            System.loadLibrary("TKShHealing");
//            System.loadLibrary("TKSTEP");
//            System.loadLibrary("TKSTEP209");
//            System.loadLibrary("TKSTEPAttr");
//            System.loadLibrary("TKSTEPBase");
//            System.loadLibrary("TKTopAlgo");
//            System.loadLibrary("TKV3d");
//            System.loadLibrary("TKVCAF");
//            System.loadLibrary("TKXCAF");
//            System.loadLibrary("TKXDEIGES");
//            System.loadLibrary("TKXDESTEP");
//            System.loadLibrary("TKXSBase");


        } catch (UnsatisfiedLinkError e) {
            System.err.println("Native code library failed to load.\n" + e);
            System.exit(1);
        }
    }

    public void compute(String aSource){
        String theKey =
                "@CUSTOMER=EVAL @CUSTOMER_APP=EVAL @PRODUCT=ANY @OS=ANY @CONFIGURATION=ANY @VERSI" +
                        "ON=ANY @UPGRADE_EXPIRATION=20180628 @USE_EXPIRATION=20180628 @VENDOR=http://www." +
                        "cadexchanger.com @WARNING=This license key may not be disclosed to any third par" +
                        "ty without prior written permission from vendor. QUBHSKTLNHZPGTDPQFRSIDPNV4PQBLV" +
                        "Z48AW20HR08LS68XRM7EUX34X7HOGQ2K1CBZY05M5ALVB9I7I0YWBOYJI188AB7U0MYOBDWEJGGF3HJ0" +
                        "VHIL6MIIJY1DA5ZIDSTFRYSIP317078YAKUL03KMVPOB6WEH8NCQE72MVJSL1A4BVQVGPHRDW8U2FE1A" +
                        "742URCR42Z3PKR624I4PCEJJFNMVWI43JVNTTCIKJ2FARE62GKY8D2A1JP85SG7G6JUEDANF9A6PG51B" +
                        "G9Y8D2A1561TKJNTAV7GTA28VOF5TUY6593LBQ54FJUVS5JME8P857VDOO8F9N47H3OVANYHW0XOYW10" +
                        "82F87CQWQDZXFGPBJ708TDVFNZINO06AI0EJWAA6HBUIGA68KFBFANE4ZH6G2EIQZ4BCH6AHKRGB93FC" +
                        "ZQBUMVQA1YUZ3QPCJC1KVVFB42ZXKQXDI4LL9XL84WZHDKW0JM2BJSTLSOE15G66RMHVSIIHU06V4LUK" +
                        "X738O5U92UIF6PYQPAO4Q3T98PECI6O924L327RCTNAPN2R9EBEQ9CFBPVIFKLTN3AEE9714QH15UVO6" +
                        "TFUD1EV8QFB7KQ8BBK37T2580TB0TOYR6C2D74TC6699R0NAB9KS60SC6SLFSMU0TM16VJ4572J5JIR3" +
                        "053GW577VAPVF7UWRBSM6VYNZZPLJFM37F0V26M16FW36XYC652I7H8B4JIUMN1BE59O8E7EGCPKYD2U";


        // activate the license
        if (!LicenseManager.Activate (theKey)) {
            System.out.println ("Failed to activate CAD Exchanger license.");
            return;
        }
        //ModelData_Model aModel = new ModelData_Model();
        //String aSource = "M:\\Documents\\GradeMyDrawing\\Requirements\\STEP Comparison\\Sample STEP Files\\StudentExample2ApplicationProtocol_214.stp";
//     if (!Import (aSource, aModel)) {
//         System.out.println ("Failed to read the file " + aSource);
//         return;
//     }

        ModelData_Model aModel = new ModelData_Model();
        System.out.println ("Conversion started...");
        STEP_Reader aReader = new STEP_Reader();
        if (!aReader.ReadFile (new Base_UTF16String (aSource)) || !aReader.Transfer (aModel)) {
            System.out.println ("Failed to read the file " + aSource);
            return;
        }

        boolean aDisplayProperty = true;
        boolean aDisplayColor    = true;
        boolean aDisplayBRepData = true;
        boolean aDisplayPolyData = true;
        ModelAlgo_BRepMesherParameters aParameters = new ModelAlgo_BRepMesherParameters (
                ModelAlgo_BRepMesherParameters.Granularity.Fine);
        double d = ModelAlgo_ValidationProperty.ComputeVolume(aModel);
        double s = ModelAlgo_ValidationProperty.ComputeSurfaceArea(aModel);
        System.out.println("Calculated Volume : "+d);
        System.out.println("Calculated Surface Area : "+s);
    }

}
