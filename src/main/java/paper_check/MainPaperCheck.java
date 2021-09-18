package paper_check;
import paper_check.file.TxtIOUtils;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;


public class MainPaperCheck {
    public static void main(String[] args) {
        String origin = TxtIOUtils.readTxt(args[0]);
        // 从命令行输入的路径名读取对应的文件，将文件的内容转化为对应的字符串
        String s1 = TxtIOUtils.readTxt(args[1]);
        String resultFileName = args[2];
        String str1 = "orig.txt";
        File tempFile = new File(args[1].trim());
        String str2 = tempFile.getName();

   /* String[] s={
            "D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\orig_0.8_add.txt",
            "D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\orig_0.8_del.txt",
            "D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\orig_0.8_dis_1.txt",
            "D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\orig_0.8_dis_10.txt",
            "D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\orig_0.8_dis_15.txt"};

    */
        SimHash_ hash1 = new SimHash_(origin, 64);
        hash1.subByDistance(hash1, 3);
        SimHash_ hash2 = new SimHash_(s1, 64);
        hash2.subByDistance(hash2, 3);
        double distance = hash1.getDistance(hash1.strSimHash, hash2.strSimHash);
        distance = 100 - distance * 100 / 128;
        DecimalFormat df = new DecimalFormat("0.00");
        //System.out.println("该文章与原文相似度为："+df.format(distance)+"%");
        TxtIOUtils.writeTxt(distance, str1, str2, resultFileName);//double result, String orig1, String orig2, String location
        System.exit(0);
    
    }
}