import org.junit.Test;
import paper_check.file.TxtIOUtils;
import paper_check.SimHash_;


public class mainppc_test {
    @Test
    public void origAndAllTest(){
        String[] str = new String[6];
        str[0] = TxtIOUtils.readTxt("D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\orig.txt");
        str[1] = TxtIOUtils.readTxt("D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\orig_0.8_add.txt");
        str[2] = TxtIOUtils.readTxt("D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\orig_0.8_del.txt");
        str[3] = TxtIOUtils.readTxt("D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\orig_0.8_dis_1.txt");
        str[4] = TxtIOUtils.readTxt("D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\orig_0.8_dis_10.txt");
        str[5] = TxtIOUtils.readTxt("D:\\Download\\java_idea\\ppcheck\\src\\main\\resources\\测试文本2\\orig_0.8_dis_15.txt");
       // String ansFileName = "D:/test/ansAll.txt";
        for(int i = 1; i <= 5; i++){
            SimHash_ hash1 = new SimHash_(str[0], 64);
            hash1.subByDistance(hash1, 3);
            SimHash_ hash2 = new SimHash_(str[i], 64);
            hash2.subByDistance(hash2, 3);
            double distance = hash1.getDistance(hash1.strSimHash, hash2.strSimHash);
            distance = 100 - distance * 100 / 128;
            //TxtIOUtils.writeTxt(ans, ansFileName);
            System.out.println("相似度为："+distance+"%\n");
        }
    }
}
