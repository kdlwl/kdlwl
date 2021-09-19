
import org.junit.Test;


import org.junit.Test;
import paper_check.file.FileInput;
import paper_check.SimHash_;
import java.math.BigInteger;
import java.math.BigInteger;

public class mainTest {
    String origin="D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\orig.txt";
    String[] s={
            "D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\orig_0.8_add.txt",
            "D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\orig_0.8_del.txt",
            "D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\orig_0.8_dis_1.txt",
            "D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\orig_0.8_dis_10.txt",
            "D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\orig_0.8_dis_15.txt"};

    @org.junit.Test
    public void addTest(){
        FileInput fileInput = new FileInput();
        SimHash_ hash1 = new SimHash_(fileInput.readString(origin), 64);
        hash1.subByDistance(hash1, 3);
        SimHash_ hash2 = new SimHash_(fileInput.readString(s[0]), 64);
        hash2.subByDistance(hash2, 3);
        double distance = hash1.getDistance(hash1.getStrSimHash(),hash2.getStrSimHash());
        System.out.println("orig_0.8_add.txt与原文相似度为："+(100-distance*100/128)+"%");
    }

    @org.junit.Test
    public void delTest(){
        FileInput fileInput = new FileInput();
        SimHash_ hash1 = new SimHash_(fileInput.readString(origin), 64);
        hash1.subByDistance(hash1, 3);
        SimHash_ hash2 = new SimHash_(fileInput.readString(s[1]), 64);
        hash2.subByDistance(hash2, 3);
        double distance = hash1.getDistance(hash1.getStrSimHash(),hash2.getStrSimHash());
        System.out.println("orig_0.8_del.txt与原文相似度为："+(100-distance*100/128)+"%");
    }

    @org.junit.Test
    public void dis_1Test(){
        FileInput fileInput = new FileInput();
        SimHash_ hash1 = new SimHash_(fileInput.readString(origin), 64);
        hash1.subByDistance(hash1, 3);
        SimHash_ hash2 = new SimHash_(fileInput.readString(s[2]), 64);
        hash2.subByDistance(hash2, 3);
        double distance = hash1.getDistance(hash1.getStrSimHash(),hash2.getStrSimHash());
        System.out.println("orig_0.8_dis_1.txt与原文相似度为："+(100-distance*100/128)+"%");
    }

    @org.junit.Test
    public void dis_10Test(){
        FileInput fileInput = new FileInput();
        SimHash_ hash1 = new SimHash_(fileInput.readString(origin), 64);
        hash1.subByDistance(hash1, 3);
        SimHash_ hash2 = new SimHash_(fileInput.readString(s[3]), 64);
        hash2.subByDistance(hash2, 3);
        double distance = hash1.getDistance(hash1.getStrSimHash(),hash2.getStrSimHash());
        System.out.println("orig_0.8_dis_10.txt与原文相似度为："+(100-distance*100/128)+"%");
    }

    @org.junit.Test
    public void dis_15Test(){
        FileInput fileInput = new FileInput();
        SimHash_ hash1 = new SimHash_(fileInput.readString(origin), 64);
        hash1.subByDistance(hash1, 3);
        SimHash_ hash2 = new SimHash_(fileInput.readString(s[4]), 64);
        hash2.subByDistance(hash2, 3);
        double distance = hash1.getDistance(hash1.getStrSimHash(),hash2.getStrSimHash());
        System.out.println("orig_0.8_dis_15.txt与原文相似度为："+(100-distance*100/128)+"%");
    }

    @org.junit.Test
   public void FileNotFoundException(){
        FileInput fileInput = new FileInput();
        SimHash_ hash1 = new SimHash_(fileInput.readString(origin), 64);
        hash1.subByDistance(hash1, 3);
        SimHash_ hash2 = new SimHash_(fileInput.readString("D:\\1.txt"), 64);
        hash2.subByDistance(hash2, 3);
        double distance = hash1.getDistance(hash1.getStrSimHash(),hash2.getStrSimHash());
        System.out.println("该文章与原文相似度为："+(100-distance*100/128)+"%");
    }
}


